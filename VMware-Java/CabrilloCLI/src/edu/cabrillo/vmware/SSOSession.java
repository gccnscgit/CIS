package edu.cabrillo.vmware;

import com.vmware.connection.SsoConnection;
import com.vmware.connection.helpers.GetMOREF;
import com.vmware.connection.helpers.WaitForValues;

public class SSOSession extends SsoConnection {

	//private static final String x_sso_server = "https://vcentre.cis.cabrillo.edu:7444/ims/STSService/vlab.local";
	private static final String x_sso_server = "https://vcentre.cis.cabrillo.edu/sts/STSService/vlab.local";	

	private SSOSession() {
		
	}
	
	private static SSOSession _instance = null; 
	
	public static SSOSession get() {
		if (_instance == null) {
			_instance = new SSOSession();
		}
		return _instance; 
	}
	
	public GetMOREF getHelper() {
		return new GetMOREF(this); 
	}
	
	public WaitForValues getWaiter() {
		return new WaitForValues(this);
	}
	
	@Override
    public String getDefaultSsoUrl() {
		return x_sso_server;
    }
}