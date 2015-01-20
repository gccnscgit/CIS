package edu.cabrillo.vmware;

import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;

import com.vmware.vim25.InvalidLocaleFaultMsg;
import com.vmware.vim25.InvalidLoginFaultMsg;
import com.vmware.vim25.InvalidPropertyFaultMsg;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFaultFaultMsg;

public class Path {

	public static class PathNotFoundException extends Exception {
		private static final long serialVersionUID = 1L;
		private String part; 
		PathNotFoundException(String p) {
			part = p;
		}
		public void printStackTrace() {
			System.out.println("Path part: " + part);
			super.printStackTrace();
		}
	}
	
	public static ManagedObjectReference getDatacenter(String name) throws RuntimeFaultFaultMsg, InvalidPropertyFaultMsg, InvalidLocaleFaultMsg, InvalidLoginFaultMsg, DatatypeConfigurationException, PathNotFoundException {
		Map<String, ManagedObjectReference> objs = SSOSession.get().getHelper().inFolderByType(SSOSession.get().getServiceContent().getRootFolder(), "Datacenter");
		if (objs.containsKey(name)) {
			return objs.get(name);
		}else{
			throw new PathNotFoundException(name);
		}
	}
	
	public static ManagedObjectReference getFolder(String name, ManagedObjectReference parent) throws RuntimeFaultFaultMsg, InvalidPropertyFaultMsg, InvalidLocaleFaultMsg, InvalidLoginFaultMsg, DatatypeConfigurationException, PathNotFoundException {
		Map<String, ManagedObjectReference> objs = SSOSession.get().getHelper().inFolderByType(parent, "Folder");
		if (objs.containsKey(name)) {
			return objs.get(name);
		}else{
			throw new PathNotFoundException(name);
		}
	}

	public static ManagedObjectReference getVm(String name, ManagedObjectReference parent) throws RuntimeFaultFaultMsg, InvalidPropertyFaultMsg, InvalidLocaleFaultMsg, InvalidLoginFaultMsg, DatatypeConfigurationException, PathNotFoundException {
		Map<String, ManagedObjectReference> objs = SSOSession.get().getHelper().inFolderByType(parent, "VirtualMachine");
		if (objs.containsKey(name)) {
			return objs.get(name);
		}else{
			throw new PathNotFoundException(name);
		}
	}
	
	public static ManagedObjectReference getEntity(String name, ManagedObjectReference parent) throws RuntimeFaultFaultMsg, InvalidPropertyFaultMsg, InvalidLocaleFaultMsg, InvalidLoginFaultMsg, DatatypeConfigurationException, PathNotFoundException {
		Map<String, ManagedObjectReference> objs = SSOSession.get().getHelper().inFolderByType(parent, "ManagedEntity");
		if (objs.containsKey(name)) {
			return objs.get(name);
		}else{
			throw new PathNotFoundException(name);
		}
	}

	public static ManagedObjectReference pathToVm(String path) throws PathNotFoundException, RuntimeFaultFaultMsg, InvalidPropertyFaultMsg, InvalidLocaleFaultMsg, InvalidLoginFaultMsg, DatatypeConfigurationException {
		String[] parts = path.split("/");
		if (parts.length < 2) {
			throw new PathNotFoundException(path);
		}
		ManagedObjectReference rval = getDatacenter(parts[0]);
		for (int i=1; i<parts.length-1; i++) {
			rval = getFolder(parts[i], rval);
		}
		rval = getVm(parts[parts.length-1], rval);
		return rval; 		
	}
	
	public static ManagedObjectReference pathToEntity(String path) throws PathNotFoundException, RuntimeFaultFaultMsg, InvalidPropertyFaultMsg, InvalidLocaleFaultMsg, InvalidLoginFaultMsg, DatatypeConfigurationException {
		String[] parts = path.split("/");
		if (parts.length < 2) {
			throw new PathNotFoundException(path);
		}
		ManagedObjectReference rval = getDatacenter(parts[0]);
		for (int i=1; i<parts.length-1; i++) {
			rval = getFolder(parts[i], rval);
		}
		rval = getEntity(parts[parts.length-1], rval);
		return rval; 		
	}

	public static ManagedObjectReference pathToFolder(String path) throws PathNotFoundException, RuntimeFaultFaultMsg, InvalidPropertyFaultMsg, InvalidLocaleFaultMsg, InvalidLoginFaultMsg, DatatypeConfigurationException {
		String[] parts = path.split("/");
		if (parts.length < 2) {
			throw new PathNotFoundException(path);
		}
		ManagedObjectReference rval = getDatacenter(parts[0]);
		for (int i=1; i<parts.length; i++) {
			rval = getFolder(parts[i], rval);
		}
		return rval;
	}
	
	public static String dirname(String path) throws PathNotFoundException {
		String[] parts = path.split("/");
		if (parts.length < 2) {
			throw new PathNotFoundException(path);
		}
		String rpath = ""; 
		rpath += parts[0];
		for (int i=1; i<parts.length-1; i++) {
			rpath += "/" + parts[i];
		}
		return rpath;
	}
	
	public static String filename(String path) throws PathNotFoundException {
		String[] parts = path.split("/");
		if (parts.length < 2) {
			throw new PathNotFoundException(path);
		}
		return parts[parts.length-1];		
	}

}
