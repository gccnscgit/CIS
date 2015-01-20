package edu.cabrillo.vmware;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.MessageContext;

import org.oasis_open.docs.ws_sx.ws_trust._200512.LifetimeType;
import org.oasis_open.docs.ws_sx.ws_trust._200512.RenewingType;
import org.oasis_open.docs.ws_sx.ws_trust._200512.RequestSecurityTokenType;
import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_utility_1_0.AttributedDateTime;
import org.w3c.dom.Element;

import com.rsa.names._2009._12.product.riat.wsdl.STSService;
import com.rsa.names._2009._12.product.riat.wsdl.STSServicePortType;
import com.vmware.connection.helpers.Connection;
import com.vmware.connection.helpers.GetMOREF;
import com.vmware.sso.client.soaphandlers.HeaderHandlerResolver;
import com.vmware.sso.client.soaphandlers.SamlTokenExtractionHandler;
import com.vmware.sso.client.soaphandlers.SamlTokenHandler;
import com.vmware.sso.client.soaphandlers.TimeStampHandler;
import com.vmware.sso.client.soaphandlers.UserCredentialHandler;
import com.vmware.sso.client.soaphandlers.WsSecuritySignatureAssertionHandler;
import com.vmware.sso.client.utils.Utils;
import com.vmware.vim25.InvalidLocaleFaultMsg;
import com.vmware.vim25.InvalidLoginFaultMsg;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFaultFaultMsg;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.UserSession;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;
import com.vmware.vsphere.soaphandlers.HeaderCookieExtractionHandler;
import com.vmware.vsphere.soaphandlers.HeaderCookieHandler;

public class SSOSession implements Connection {

	private static final String x_sso_server = "https://vcenter.cis.cabrillo.edu:7444/ims/STSService";
	private static final String x_vsp_server = "https://vcenter.cis.cabrillo.edu/sdk";

	private VimPortType vimPort;
	private ManagedObjectReference SVC_INST_REF = new ManagedObjectReference();
	private GetMOREF thisIsFucked = null;
	private VimService vimService = new VimService();
	private ServiceContent serviceContent;
    private UserSession userSession;
    @SuppressWarnings("rawtypes")
	private Map headers;
    private String username;
    private String password; 
    
	private HandlerResolver defaultHandler = vimService.getHandlerResolver();
	private boolean isConnected = false;

	private SSOSession() {
		Utils.trustAllHttpsCertificates();
	}

	private static SSOSession instance; 
	public static SSOSession get() {
		if (instance == null) 
			instance = new SSOSession();
		return instance;
	}

	public void login(String un, String pw) {
		if (isConnected) 
			return;
		
		username = un; 
		password = pw; 
		
		try {
			loginUsingSAMLToken(getToken(), x_vsp_server, null, null);
		} catch (RuntimeFaultFaultMsg | InvalidLocaleFaultMsg | InvalidLoginFaultMsg | DatatypeConfigurationException e) {
			// Switch for an unchecked exception... ugh.
			throw new RuntimeException(e);
		}
	}
	
	private Element getToken() throws DatatypeConfigurationException {

		/* Instantiating the STSService */
		STSService stsService = new STSService();

		/*
		 * Instantiating the HeaderHandlerResolver. This is required to provide
		 * the capability of modifying the SOAP headers and the SOAP message in
		 * general for various requests via the different handlers. For
		 * different kinds of requests to SSO server one needs to follow the
		 * WS-Trust guidelines to provide the required SOAP message structure.
		 */
		HeaderHandlerResolver headerResolver = new HeaderHandlerResolver();

		/*
		 * For this specific case we need the following header elements wrapped
		 * in the security tag.
		 * 
		 * 1. Timestamp containing the request's creation and expiry time
		 * 
		 * 2. UsernameToken containing the username/password
		 */

		/* Adding the Timestamp via TimeStampHandler */
		headerResolver.addHandler(new TimeStampHandler());

		/* Adding the UsernameToken via UserCredentialHandler */
		UserCredentialHandler ucHandler = new UserCredentialHandler(username, password);
		SamlTokenExtractionHandler sbHandler = new SamlTokenExtractionHandler();
		headerResolver.addHandler(ucHandler);
		headerResolver.addHandler(sbHandler);

		/*
		 * Set the handlerResolver for the STSService to the
		 * HeaderHandlerResolver created above
		 */
		stsService.setHandlerResolver(headerResolver);

		/*
		 * Retrieve the STSServicePort from the STSServicePortType object Note:
		 * All the required handlerResolvers need to be set in the
		 * STSServicePortType object before you retrieve the STSService instance
		 */
		STSServicePortType stsPort = stsService.getSTSServicePort();

		/*
		 * Construct the SOAP body for the request. RequestSecurityTokenType is
		 * the parameter type that is passed to the "acquire" method. However,
		 * based on what kind of token (bearer or holder-of-key type) and by
		 * what means (aka username/password, certificate, or existing token) we
		 * want to acquire the token, different elements need to be populated
		 */
		RequestSecurityTokenType tokenType = new RequestSecurityTokenType();

		/*
		 * For this request we need at least the following element in the
		 * RequestSecurityTokenType set
		 * 
		 * 1. Lifetime - represented by LifetimeType which specifies the
		 * lifetime for the token to be issued
		 * 
		 * 2. Tokentype - "urn:oasis:names:tc:SAML:2.0:assertion", which is the
		 * class that models the requested token
		 * 
		 * 3. RequestType -
		 * "http://docs.oasis-open.org/ws-sx/ws-trust/200512/Issue", as we want
		 * to get a token issued
		 * 
		 * 4. KeyType -
		 * "http://docs.oasis-open.org/ws-sx/ws-trust/200512/Bearer",
		 * representing the kind of key the token will have. There are two
		 * options namely bearer and holder-of-key
		 * 
		 * 5. SignatureAlgorithm -
		 * "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256", representing the
		 * algorithm used for generating signature
		 * 
		 * 6. Renewing - represented by the RenewingType which specifies whether
		 * the token is renewable or not
		 */
		LifetimeType lifetime = new LifetimeType();

		DatatypeFactory dtFactory = DatatypeFactory.newInstance();
		GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
		XMLGregorianCalendar xmlCalendar = dtFactory.newXMLGregorianCalendar(cal);
		AttributedDateTime created = new AttributedDateTime();
		created.setValue(xmlCalendar.toXMLFormat());

		AttributedDateTime expires = new AttributedDateTime();
		xmlCalendar.add(dtFactory.newDuration(600));
		expires.setValue(xmlCalendar.toXMLFormat());

		lifetime.setCreated(created);
		lifetime.setExpires(expires);

		tokenType.setTokenType("urn:oasis:names:tc:SAML:2.0:assertion");
		tokenType.setRequestType("http://docs.oasis-open.org/ws-sx/ws-trust/200512/Issue");
		tokenType.setLifetime(lifetime);
		tokenType.setKeyType("http://docs.oasis-open.org/ws-sx/ws-trust/200512/Bearer");
		tokenType.setSignatureAlgorithm("http://www.w3.org/2001/04/xmldsig-more#rsa-sha256");

		RenewingType renewing = new RenewingType();
		renewing.setAllow(Boolean.FALSE);
		renewing.setOK(Boolean.FALSE); // WS-Trust Profile: MUST be set to false
		tokenType.setRenewing(renewing);

		/* Set the endpoint address for the request */
		Map<String, Object> reqContext = ((BindingProvider) stsPort).getRequestContext();
		reqContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, x_sso_server);

		/*
		 * Invoke the "issue" method on the STSService object to acquire the
		 * token from SSO Server
		 */
		stsPort.issue(tokenType);

		// SamlTokenExtractionHandler will now contain the raw SAML token for
		// further consumption
		return sbHandler.getToken();
	}	

	/**
	 * This method invokes the loginByToken method for authentication. Once this
	 * method is called the established session is authenticated and operations
	 * can be performed on the connected vCenter server
	 * 
	 * @param token
	 *           {@link Element} representing the SAML token that needs to be
	 *           used for the authentication
	 * @param vcServerUrl
	 *           The vCenter server url that needs to be connected
	 * @param privateKey
	 *           {@link PrivateKey} of the user. Only required when using HoK
	 *           token to login
	 * @param publicCert
	 *           {@link X509Certificate} certificate of the user. Only required
	 *           when using HoK token to login
	 * @return String authenticated session cookie used by the connection
	 * @throws RuntimeFaultFaultMsg
	 * @throws InvalidLocaleFaultMsg
	 * @throws InvalidLoginFaultMsg
	 */
	private String loginUsingSAMLToken(Element token, String vcServerUrl, PrivateKey privateKey, X509Certificate publicCert)
			throws RuntimeFaultFaultMsg, InvalidLocaleFaultMsg, InvalidLoginFaultMsg 
			{

		// Setting up the configuration for ignoring the SSL certificates
		HostnameVerifier hv = new HostnameVerifier() {
			@Override
			public boolean verify(String urlHostName, SSLSession session) {
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(hv);

		// The process we are going to follow is described below:
		// 1. Retrieve the ServiceContent
		// 2. Extract the session cookie that is established in the previous
		// call to the server.
		// 3. Set up the required HandlerResolver chain as per the type of the
		// token passed.
		// 4. Invoke the LoginByToken method
		// 5. Clear the HandlerResolver chain setup in the step 3 as that is
		// required only one time for the invocation of the LoginByToken method
		// 6. Inject the session cookie back into the request once before making
		// another call to the server.
		// 7. Authentication complete. Proceed with rest of the API calls that
		// are required for your functionality

		vimService = new VimService();
		// Step 1 Retrieve the service content
		SVC_INST_REF.setType("ServiceInstance");
		SVC_INST_REF.setValue("ServiceInstance");

		// Injecting the HeaderCookieExtractionHandler, to be able to extract
		// the session cookie for now and use it later
		HeaderCookieExtractionHandler cookieExtractor =
				new HeaderCookieExtractionHandler();
		{
			HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
			handlerResolver.addHandler(cookieExtractor);
			vimService.setHandlerResolver(handlerResolver);
		}
		vimPort = vimService.getVimPort();

		Map<String, Object> ctxt =
				((BindingProvider) vimPort).getRequestContext();
		ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, vcServerUrl);
		ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);

		serviceContent = vimPort.retrieveServiceContent(SVC_INST_REF);
		String cookie = cookieExtractor.getCookie();
		//System.out.println("Cookie extracted is " + cookie);

		//System.out.println("Step 2 Invoking the loginByToken method");
		if (Utils.isHoKToken(token)) {
			validateSessionUsingHoKToken(token, vcServerUrl, cookie, privateKey,
					publicCert);
		} else {
			validateSessionUsingBearerToken(token, vcServerUrl, cookie);
		}

		return cookie;
	}

	private void validateSessionUsingBearerToken(Element token, String vcServerUrl, String cookie) throws InvalidLocaleFaultMsg, InvalidLoginFaultMsg, RuntimeFaultFaultMsg {
		HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
		handlerResolver.addHandler(new TimeStampHandler());
		handlerResolver.addHandler(new SamlTokenHandler(token));
		handlerResolver.addHandler(new HeaderCookieHandler(cookie));
		vimService.setHandlerResolver(handlerResolver);
		vimPort = vimService.getVimPort();

		Map<String, Object> ctxt = ((BindingProvider) vimPort).getRequestContext();
		ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, vcServerUrl);
		ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
		
		userSession = vimPort.loginByToken(serviceContent.getSessionManager(), null);
        headers = (Map) ((BindingProvider) vimPort).getResponseContext().get(
                MessageContext.HTTP_RESPONSE_HEADERS);

		isConnected = true;
		clearHandlerResolver(vcServerUrl, cookie);
	}

	private void validateSessionUsingHoKToken(Element token, String vcServerUrl, String cookie, PrivateKey privateKey, X509Certificate publicCert) throws InvalidLocaleFaultMsg, InvalidLoginFaultMsg, RuntimeFaultFaultMsg {
		HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
		handlerResolver.addHandler(new TimeStampHandler());
		handlerResolver.addHandler(new SamlTokenHandler(token));
		handlerResolver.addHandler(new HeaderCookieHandler(cookie));
		handlerResolver.addHandler(new WsSecuritySignatureAssertionHandler(privateKey, publicCert, Utils.getNodeProperty(token, "ID")));
		vimService.setHandlerResolver(handlerResolver);
		vimPort = vimService.getVimPort();

		Map<String, Object> ctxt = ((BindingProvider) vimPort).getRequestContext();
		ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, vcServerUrl);
		ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);

        userSession = vimPort.loginByToken(serviceContent.getSessionManager(), null);
        headers = (Map) ((BindingProvider) vimPort).getResponseContext().get(
                MessageContext.HTTP_RESPONSE_HEADERS);

		isConnected = true;
		clearHandlerResolver(vcServerUrl, cookie);
	}

	private void clearHandlerResolver(String vcServerUrl, String cookie) {
		// After login we do not need this handler thus reverting to the
		// original one
		vimService.setHandlerResolver(defaultHandler);
		vimPort = vimService.getVimPort();
		// Set the validated session cookie and set it in the header for once,
		// JAXWS will maintain that cookie for all the subsequent requests
		{
			Map<String, Object> ctxt =
					((BindingProvider) vimPort).getRequestContext();
			ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, vcServerUrl);
			ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
			// One time setting of the cookie
			@SuppressWarnings("unchecked")
			Map<String, List<String>> headers =
			(Map<String, List<String>>) ctxt
			.get(MessageContext.HTTP_REQUEST_HEADERS);
			if (headers == null) {
				headers = new HashMap<String, List<String>>();
			}
			headers.put("Cookie", Arrays.asList(cookie));
			ctxt.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		}
	}

	@Override
	public void logout() {
		if (isConnected) {
			try {
				vimPort.logout(serviceContent.getSessionManager());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		isConnected = false;
	}

	@Override
	public VimService getVimService() {
		return vimService;
	}

	@Override
	public VimPortType getVimPort() {
		return vimPort;
	}

	@Override
	public ServiceContent getServiceContent() {
		return serviceContent;
	}

	@Override
	public UserSession getUserSession() {
		return userSession;
	}

	@Override
	public Map getHeaders() {
		return headers;
	}

	@Override
	public ManagedObjectReference getServiceInstanceReference() {
		return SVC_INST_REF;
	}
	
	@Override
	public boolean isConnected() {
		return isConnected;
	}
	
	@Override
	public GetMOREF getHelper() {
		if (thisIsFucked == null) {
			thisIsFucked = new GetMOREF();
		}
		return thisIsFucked;
	}

}
