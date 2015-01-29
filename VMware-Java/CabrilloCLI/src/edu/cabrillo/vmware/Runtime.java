package edu.cabrillo.vmware;

import java.util.Map;
import java.util.Stack;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.soap.SOAPFaultException;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.vmware.connection.helpers.GetMOREF;
import com.vmware.vim25.AlreadyExistsFaultMsg;
import com.vmware.vim25.ConcurrentAccessFaultMsg;
import com.vmware.vim25.CustomizationFaultFaultMsg;
import com.vmware.vim25.DuplicateNameFaultMsg;
import com.vmware.vim25.FileFaultFaultMsg;
import com.vmware.vim25.HostConfigFaultFaultMsg;
import com.vmware.vim25.InsufficientResourcesFaultFaultMsg;
import com.vmware.vim25.InvalidCollectorVersionFaultMsg;
import com.vmware.vim25.InvalidDatastoreFaultMsg;
import com.vmware.vim25.InvalidFolderFaultMsg;
import com.vmware.vim25.InvalidLocaleFaultMsg;
import com.vmware.vim25.InvalidLoginFaultMsg;
import com.vmware.vim25.InvalidNameFaultMsg;
import com.vmware.vim25.InvalidPropertyFaultMsg;
import com.vmware.vim25.InvalidStateFaultMsg;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.MigrationFaultFaultMsg;
import com.vmware.vim25.NotFoundFaultMsg;
import com.vmware.vim25.ResourceInUseFaultMsg;
import com.vmware.vim25.RuntimeFaultFaultMsg;
import com.vmware.vim25.TaskInProgressFaultMsg;
import com.vmware.vim25.TimedoutFaultMsg;
import com.vmware.vim25.VmConfigFaultFaultMsg;

import edu.cabrillo.vmware.Path.PathNotFoundException;
import edu.cabrillo.vmware.parsers.CLIBaseListener;
import edu.cabrillo.vmware.parsers.CLILexer;
import edu.cabrillo.vmware.parsers.CLIParser.AddnetContext;
import edu.cabrillo.vmware.parsers.CLIParser.CreateContext;
import edu.cabrillo.vmware.parsers.CLIParser.DeleteContext;
import edu.cabrillo.vmware.parsers.CLIParser.DelnetContext;
import edu.cabrillo.vmware.parsers.CLIParser.LinkedcloneContext;
import edu.cabrillo.vmware.parsers.CLIParser.MigrateContext;
import edu.cabrillo.vmware.parsers.CLIParser.MkdirContext;
import edu.cabrillo.vmware.parsers.CLIParser.MoveContext;
import edu.cabrillo.vmware.parsers.CLIParser.RenameContext;
import edu.cabrillo.vmware.parsers.CLIParser.VrlContext;

public class Runtime extends CLIBaseListener {

	private Stack<Object> programStack = new Stack<Object>(); 	
	private GetMOREF objectHelper = new GetMOREF();

	public static class VRL { 
		enum Type { 
			UNKNOWN, VM, FOLDER, ENTITY, SNAPSHOT, PORTGROUP, DATASTORE
		}
		public Stack<Object> parts = new Stack<Object>();
		public Type type = Type.UNKNOWN;
		public ManagedObjectReference popMOR() {
			return (ManagedObjectReference) parts.pop();
		}
		public String popString() {
			return (String) parts.pop();
		}

	}

	private ManagedObjectReference findByTypeName(ManagedObjectReference parent, String type, String name) throws RuntimeFaultFaultMsg, InvalidPropertyFaultMsg {
		Map<String, ManagedObjectReference> objs;
		objs = objectHelper.inFolderByType(parent, type);
		if (!objs.containsKey(name)) {
			throw new RuntimeException("Cannot find " + type + ": " + name);
		}
		return objs.get(name);
	}

	@Override
	public void exitVrl(@NotNull VrlContext ctx) {
		// Find the reference 

		try {
			// trim quotes
			String s = ctx.getChild(2).toString().substring(1);
			s = s.substring(0, s.length()-1);
			String[] path = s.split("/");	

			if (path.length < 1) {
				throw new RuntimeException("Invalid short path");
			}

			ManagedObjectReference item = null;;	
			VRL v = new VRL();

			if ("folder".equals(ctx.getChild(0).toString())) {
				v.type = VRL.Type.FOLDER;
				item = findByTypeName(SSOSession.get().getServiceContent().getRootFolder(), "Datacenter", path[0]);
				for (int i=1; i<path.length; i++) {
					item = findByTypeName(item, "Folder", path[i]);
				}
				v.parts.push(item);
			}else if ("vm".equals(ctx.getChild(0).toString())) {
				v.type = VRL.Type.VM;
				item = findByTypeName(SSOSession.get().getServiceContent().getRootFolder(), "Datacenter", path[0]);
				for (int i=1; i<path.length-1; i++) {
					item = findByTypeName(item, "Folder", path[i]);
				}
				v.parts.push(findByTypeName(item, "VirtualMachine", path[path.length-1]));
			}else if ("entity".equals(ctx.getChild(0).toString())) {
				v.type = VRL.Type.ENTITY;
				item = findByTypeName(SSOSession.get().getServiceContent().getRootFolder(), "Datacenter", path[0]);
				for (int i=1; i<path.length-1; i++) {
					item = findByTypeName(item, "Folder", path[i]);
				}
				v.parts.push(findByTypeName(item, "ManagedEntity", path[path.length-1]));
			}else if ("snapshot".equals(ctx.getChild(0).toString())) {
				v.type = VRL.Type.SNAPSHOT;
				item = findByTypeName(SSOSession.get().getServiceContent().getRootFolder(), "Datacenter", path[0]);
				for (int i=1; i<path.length-2; i++) {
					item = findByTypeName(item, "Folder", path[i]);
				}
				ManagedObjectReference vm = findByTypeName(item, "VirtualMachine", path[path.length-2]);
				ManagedObjectReference snap = Actions.getSnapshotReference(vm, path[path.length-1]);
				v.parts.push(vm);
				v.parts.push(snap);
			}else if ("portgroup".equals(ctx.getChild(0).toString())) {
				// portgroup looks like portgroup://host/vswitch/name/vlan
				v.type = VRL.Type.PORTGROUP;
				if (path.length != 4) {
					throw new RuntimeException("Invalid port group VRL");
				}
				v.parts.push(path[0]);
				v.parts.push(path[1]);
				v.parts.push(path[2]);
				v.parts.push(path[3]);
			}else if ("datastore".equals(ctx.getChild(0).toString())) {
				v.type = VRL.Type.DATASTORE; 
				item = findByTypeName(SSOSession.get().getServiceContent().getRootFolder(), "Datacenter", path[0]);
				v.parts.push(findByTypeName(item, "Datastore", path[1]));
			}
			programStack.push(v);

		} catch (SOAPFaultException | RuntimeFaultFaultMsg | InvalidPropertyFaultMsg | InvalidLocaleFaultMsg | InvalidLoginFaultMsg | DatatypeConfigurationException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void visitTerminal(@NotNull TerminalNode node) {
		if (node.getSymbol().getType() == CLILexer.STRING) {
			// trim quotes
			String s = node.toString().substring(1);
			s = s.substring(0, s.length()-1);
			programStack.push(s);
		}
	}

	@Override
	public void exitRename(@NotNull RenameContext ctx) {
		String  dest = (String) programStack.pop();
		VRL src = (VRL) programStack.pop();
		try {
			Actions.rename(src.popMOR(), dest);
		} catch (SOAPFaultException | InvalidPropertyFaultMsg | RuntimeFaultFaultMsg
				| DuplicateNameFaultMsg | InvalidCollectorVersionFaultMsg
				| InvalidLocaleFaultMsg | InvalidLoginFaultMsg
				| DatatypeConfigurationException | PathNotFoundException | InvalidNameFaultMsg e) {
			throw new RuntimeException("Error during move", e);
		}
	}

	@Override
	public void exitMove(@NotNull MoveContext ctx) {
		VRL dest = (VRL) programStack.pop();
		VRL src = (VRL) programStack.pop();
		if (dest.type != VRL.Type.FOLDER) {
			throw new RuntimeException("The target of a move must be a folder.");
		}
		try {
			Actions.move(src.popMOR(), dest.popMOR());
		} catch (SOAPFaultException | InvalidPropertyFaultMsg | RuntimeFaultFaultMsg
				| DuplicateNameFaultMsg | InvalidFolderFaultMsg
				| InvalidStateFaultMsg | InvalidCollectorVersionFaultMsg
				| InvalidLocaleFaultMsg | InvalidLoginFaultMsg
				| DatatypeConfigurationException | PathNotFoundException e) {
			throw new RuntimeException("Error during move", e);
		}
	}

	@Override
	public void exitLinkedclone(@NotNull LinkedcloneContext ctx) {
		VRL dest = (VRL) programStack.pop();
		VRL source = (VRL) programStack.pop();

		if (dest.type != VRL.Type.FOLDER) {
			throw new RuntimeException("Destination must be a folder");
		}
		if (source.type != VRL.Type.SNAPSHOT) {
			throw new RuntimeException("Source must be a snapshot");
		}

		ManagedObjectReference d = dest.popMOR();
		ManagedObjectReference sn = source.popMOR();
		ManagedObjectReference sr = source.popMOR();
		try {
			Actions.LinkedClone(sr, sn, d);
		} catch (SOAPFaultException | CustomizationFaultFaultMsg | FileFaultFaultMsg
				| InsufficientResourcesFaultFaultMsg | InvalidDatastoreFaultMsg
				| InvalidStateFaultMsg | MigrationFaultFaultMsg
				| RuntimeFaultFaultMsg | TaskInProgressFaultMsg
				| VmConfigFaultFaultMsg | InvalidLocaleFaultMsg
				| InvalidLoginFaultMsg | DatatypeConfigurationException
				| PathNotFoundException | InvalidPropertyFaultMsg
				| InvalidCollectorVersionFaultMsg | DuplicateNameFaultMsg
				| InvalidFolderFaultMsg | InvalidNameFaultMsg e) {
			throw new RuntimeException("Error while making linked clone", e);
		}
	}

	@Override
	public void exitMkdir(@NotNull MkdirContext ctx) {
		String name = (String) programStack.pop();
		ManagedObjectReference parent = ((VRL) programStack.pop()).popMOR();
		try {
			Actions.mkdir(parent, name);
		} catch (SOAPFaultException | InvalidPropertyFaultMsg | RuntimeFaultFaultMsg
				| DuplicateNameFaultMsg 
				| InvalidCollectorVersionFaultMsg
				| InvalidLocaleFaultMsg | InvalidLoginFaultMsg
				| DatatypeConfigurationException | InvalidNameFaultMsg e) {
			throw new RuntimeException("Error during move", e);
		}
	}

	@Override
	public void exitDelete(@NotNull DeleteContext ctx) {
		VRL item = (VRL) programStack.pop();
		try {
			if (item.type == VRL.Type.PORTGROUP) {
				/*String vlan =*/ item.popString();
				String name = item.popString();
				/*String vswitch =*/ item.popString();
				String host = item.popString();
				Actions.removePortGroup(name, host);
			}else{
				throw new RuntimeException("Delete is to dangerous on anything other than port groups.");
			}		
		} catch (SOAPFaultException | InvalidPropertyFaultMsg | RuntimeFaultFaultMsg 
				| HostConfigFaultFaultMsg | NotFoundFaultMsg | ResourceInUseFaultMsg e) {
			throw new RuntimeException("Error during delete", e);
		}
	}

	@Override
	public void exitCreate(@NotNull CreateContext ctx) {
		VRL item = (VRL) programStack.pop();
		try {
			if (item.type == VRL.Type.PORTGROUP) {
				int vlan = Integer.parseInt(item.popString());
				String name = item.popString();
				String vswitch = item.popString();
				String host = item.popString();				
				Actions.addPortGroup(name, vswitch, host, vlan);
			}else{
				throw new RuntimeException("I can only create port groups.");
			}		
		} catch (SOAPFaultException | InvalidPropertyFaultMsg | RuntimeFaultFaultMsg 
				| HostConfigFaultFaultMsg | NotFoundFaultMsg | AlreadyExistsFaultMsg e) {
			throw new RuntimeException("Error during create", e);
		}
	}
	
	@Override
	public void exitAddnet(@NotNull AddnetContext ctx) {
		String net = (String) programStack.pop();
		VRL item = (VRL) programStack.pop();
		try {
			Actions.addNetwork(item.popMOR(), net);
		} catch (SOAPFaultException | InvalidPropertyFaultMsg | RuntimeFaultFaultMsg | ConcurrentAccessFaultMsg | DuplicateNameFaultMsg | FileFaultFaultMsg | InsufficientResourcesFaultFaultMsg | InvalidDatastoreFaultMsg | InvalidNameFaultMsg | InvalidStateFaultMsg | TaskInProgressFaultMsg | VmConfigFaultFaultMsg | InvalidCollectorVersionFaultMsg e) {
			throw new RuntimeException("Error during addnet", e);
		}
	}

	@Override
	public void exitDelnet(@NotNull DelnetContext ctx) {
		String adapter = (String) programStack.pop();
		VRL item = (VRL) programStack.pop();
		try {
			Actions.delNetwork(item.popMOR(), adapter);
		} catch (SOAPFaultException | InvalidPropertyFaultMsg | RuntimeFaultFaultMsg | ConcurrentAccessFaultMsg | DuplicateNameFaultMsg | FileFaultFaultMsg | InsufficientResourcesFaultFaultMsg | InvalidDatastoreFaultMsg | InvalidNameFaultMsg | InvalidStateFaultMsg | TaskInProgressFaultMsg | VmConfigFaultFaultMsg | InvalidCollectorVersionFaultMsg e) {
			throw new RuntimeException("Error during addnet", e);
		}
	}
	
	@Override
	public void exitMigrate(@NotNull MigrateContext ctx) {
		VRL datastore = (VRL) programStack.pop();
		VRL vm = (VRL) programStack.pop();
		try {
			Actions.migrateDS(vm.popMOR(), datastore.popMOR());
		} catch (SOAPFaultException | RuntimeFaultFaultMsg | InvalidCollectorVersionFaultMsg
				| FileFaultFaultMsg | InsufficientResourcesFaultFaultMsg
				| InvalidDatastoreFaultMsg | InvalidStateFaultMsg
				| MigrationFaultFaultMsg | TimedoutFaultMsg
				| VmConfigFaultFaultMsg e) {
			throw new RuntimeException("Error during migrate", e);
		}
		
	}
}
