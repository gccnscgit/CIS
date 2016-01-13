package edu.cabrillo.vmware;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;

import com.vmware.connection.helpers.GetMOREF;
import com.vmware.connection.helpers.WaitForValues;
import com.vmware.vim25.AlreadyExistsFaultMsg;
import com.vmware.vim25.ArrayOfManagedObjectReference;
import com.vmware.vim25.ArrayOfVirtualDevice;
import com.vmware.vim25.ConcurrentAccessFaultMsg;
import com.vmware.vim25.CustomizationFaultFaultMsg;
import com.vmware.vim25.DatastoreSummary;
import com.vmware.vim25.DuplicateNameFaultMsg;
import com.vmware.vim25.FileFaultFaultMsg;
import com.vmware.vim25.HostConfigFaultFaultMsg;
import com.vmware.vim25.HostConfigManager;
import com.vmware.vim25.HostNetworkPolicy;
import com.vmware.vim25.HostPortGroupSpec;
import com.vmware.vim25.InsufficientResourcesFaultFaultMsg;
import com.vmware.vim25.InvalidCollectorVersionFaultMsg;
import com.vmware.vim25.InvalidDatastoreFaultMsg;
import com.vmware.vim25.InvalidFolderFaultMsg;
import com.vmware.vim25.InvalidLocaleFaultMsg;
import com.vmware.vim25.InvalidLoginFaultMsg;
import com.vmware.vim25.InvalidNameFaultMsg;
import com.vmware.vim25.InvalidPropertyFaultMsg;
import com.vmware.vim25.InvalidStateFaultMsg;
import com.vmware.vim25.LocalizedMethodFault;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.MigrationFaultFaultMsg;
import com.vmware.vim25.NotFoundFaultMsg;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.ResourceInUseFaultMsg;
import com.vmware.vim25.RuntimeFaultFaultMsg;
import com.vmware.vim25.SelectionSpec;
import com.vmware.vim25.TaskInProgressFaultMsg;
import com.vmware.vim25.TaskInfoState;
import com.vmware.vim25.TimedoutFaultMsg;
import com.vmware.vim25.ToolsUnavailableFaultMsg;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.VimFaultFaultMsg;
import com.vmware.vim25.VirtualDevice;
import com.vmware.vim25.VirtualDeviceConfigSpec;
import com.vmware.vim25.VirtualDeviceConfigSpecOperation;
import com.vmware.vim25.VirtualDisk;
import com.vmware.vim25.VirtualDiskFlatVer1BackingInfo;
import com.vmware.vim25.VirtualDiskFlatVer2BackingInfo;
import com.vmware.vim25.VirtualDiskRawDiskMappingVer1BackingInfo;
import com.vmware.vim25.VirtualDiskSparseVer1BackingInfo;
import com.vmware.vim25.VirtualDiskSparseVer2BackingInfo;
import com.vmware.vim25.VirtualE1000;
import com.vmware.vim25.VirtualE1000E;
import com.vmware.vim25.VirtualEthernetCard;
import com.vmware.vim25.VirtualEthernetCardNetworkBackingInfo;
import com.vmware.vim25.VirtualHardware;
import com.vmware.vim25.VirtualMachineCloneSpec;
import com.vmware.vim25.VirtualMachineConfigSpec;
import com.vmware.vim25.VirtualMachineMovePriority;
import com.vmware.vim25.VirtualMachineRelocateDiskMoveOptions;
import com.vmware.vim25.VirtualMachineRelocateSpec;
import com.vmware.vim25.VirtualMachineRelocateSpecDiskLocator;
import com.vmware.vim25.VirtualMachineSnapshotInfo;
import com.vmware.vim25.VirtualMachineSnapshotTree;
import com.vmware.vim25.VirtualVmxnet3;
import com.vmware.vim25.VmConfigFaultFaultMsg;

import edu.cabrillo.vmware.Path.PathNotFoundException;

public class Actions {

	private static void waitForTask(ManagedObjectReference task) throws RuntimeFaultFaultMsg, InvalidCollectorVersionFaultMsg {
		WaitForValues waiter = SSOSession.get().getWaiter();

		// info has a property - state for state of the task
		Object[] result;
		try {
			result = waiter.wait(task, new String[]{"info.state", "info.error"},
					new String[]{"state"}, new Object[][]{new Object[]{
							TaskInfoState.SUCCESS, TaskInfoState.ERROR}});
			if (result[0].equals(TaskInfoState.SUCCESS)) {
				return;
			}
			if (result[1] instanceof LocalizedMethodFault) {
				throw new RuntimeException(((LocalizedMethodFault) result[1]).getLocalizedMessage());
			}
		} catch (InvalidPropertyFaultMsg e) {
			System.out.println("BUG: InvalidPropertyFaultMsg thrown. Why?");
			return;
		}

		throw new RuntimeException("Action did not succeed.");
	}

	private static ManagedObjectReference traverseSnapshotInTree(List<VirtualMachineSnapshotTree> snapTree, String findName) {
		ManagedObjectReference snapmor = null;
		if (snapTree == null) {
			return snapmor;
		}
		for (int i = 0; i < snapTree.size() && snapmor == null; i++) {
			VirtualMachineSnapshotTree node = snapTree.get(i);
			if (findName != null && node.getName().equals(findName)) {
				snapmor = node.getSnapshot();
			} else {
				List<VirtualMachineSnapshotTree> childTree =
						node.getChildSnapshotList();
				snapmor = traverseSnapshotInTree(childTree, findName);
			}
		}
		return snapmor;
	}

	public static ManagedObjectReference getSnapshotReference(ManagedObjectReference vmmor, String snapName) throws RuntimeFaultFaultMsg, InvalidPropertyFaultMsg, InvalidLocaleFaultMsg, InvalidLoginFaultMsg, DatatypeConfigurationException 
	{
		VirtualMachineSnapshotInfo snapInfo =
				(VirtualMachineSnapshotInfo) SSOSession.get().getHelper().entityProps(vmmor,
						new String[]{"snapshot"}).get("snapshot");
		ManagedObjectReference snapmor = null;
		if (snapInfo != null) {
			List<VirtualMachineSnapshotTree> listvmsst = snapInfo.getRootSnapshotList();
			List<VirtualMachineSnapshotTree> snapTree = listvmsst;
			snapmor = traverseSnapshotInTree(snapTree, snapName);
		}
		return snapmor;
	}

	private static ArrayList<Integer> getIndependenetVirtualDiskKeys(
			ManagedObjectReference vmMOR) throws InvalidPropertyFaultMsg,
			RuntimeFaultFaultMsg, InvalidLocaleFaultMsg, InvalidLoginFaultMsg, DatatypeConfigurationException {
		ArrayList<Integer> independenetVirtualDiskKeys = new ArrayList<Integer>();
		VirtualHardware hw =
				(VirtualHardware) SSOSession.get().getHelper().entityProps(vmMOR,
						new String[]{"config.hardware"}).get("config.hardware");
		List<VirtualDevice> listvd = hw.getDevice();
		for (VirtualDevice vDisk : listvd) {
			if (vDisk instanceof VirtualDisk) {
				String diskMode = "";
				if (vDisk.getBacking() instanceof VirtualDiskFlatVer1BackingInfo) {
					diskMode =
							((VirtualDiskFlatVer1BackingInfo) vDisk.getBacking())
							.getDiskMode();
				} else if (vDisk.getBacking() instanceof VirtualDiskFlatVer2BackingInfo) {
					diskMode =
							((VirtualDiskFlatVer2BackingInfo) vDisk.getBacking())
							.getDiskMode();
				} else if (vDisk.getBacking() instanceof VirtualDiskRawDiskMappingVer1BackingInfo) {
					diskMode =
							((VirtualDiskRawDiskMappingVer1BackingInfo) vDisk
									.getBacking()).getDiskMode();
				} else if (vDisk.getBacking() instanceof VirtualDiskSparseVer1BackingInfo) {
					diskMode =
							((VirtualDiskSparseVer1BackingInfo) vDisk.getBacking())
							.getDiskMode();
				} else if (vDisk.getBacking() instanceof VirtualDiskSparseVer2BackingInfo) {
					diskMode =
							((VirtualDiskSparseVer2BackingInfo) vDisk.getBacking())
							.getDiskMode();
				}
				if (diskMode.indexOf("independent") != -1) {
					independenetVirtualDiskKeys.add(vDisk.getKey());
				}
			}
		}
		return independenetVirtualDiskKeys;
	}

	public static void LinkedClone(ManagedObjectReference source, ManagedObjectReference snapshot, ManagedObjectReference dest) 
			throws CustomizationFaultFaultMsg, FileFaultFaultMsg, InsufficientResourcesFaultFaultMsg, InvalidDatastoreFaultMsg, InvalidStateFaultMsg, MigrationFaultFaultMsg, RuntimeFaultFaultMsg, TaskInProgressFaultMsg, VmConfigFaultFaultMsg, InvalidLocaleFaultMsg, InvalidLoginFaultMsg, DatatypeConfigurationException, PathNotFoundException, InvalidPropertyFaultMsg, InvalidCollectorVersionFaultMsg, DuplicateNameFaultMsg, InvalidFolderFaultMsg, InvalidNameFaultMsg {

		SSOSession ses = SSOSession.get();
		GetMOREF getMOREFs = ses.getHelper();

		// Get the name of the source
		String sourcename= (String) getMOREFs.entityProps(source, new String[]{"name"}).get("name"); 

		ArrayList<Integer> independentVirtualDiskKeys = getIndependenetVirtualDiskKeys(source);
		VirtualMachineRelocateSpec rSpec = new VirtualMachineRelocateSpec();
		if (independentVirtualDiskKeys.size() > 0) {
			List<ManagedObjectReference> ds = ((ArrayOfManagedObjectReference) getMOREFs.entityProps(source, new String[]{"datastore"}).get("datastore")).getManagedObjectReference();
			List<VirtualMachineRelocateSpecDiskLocator> diskLocator = new ArrayList<VirtualMachineRelocateSpecDiskLocator>();
			for (Integer iDiskKey : independentVirtualDiskKeys) {
				VirtualMachineRelocateSpecDiskLocator diskloc = new VirtualMachineRelocateSpecDiskLocator();
				diskloc.setDatastore(ds.get(0));
				diskloc.setDiskMoveType(VirtualMachineRelocateDiskMoveOptions.MOVE_ALL_DISK_BACKINGS_AND_DISALLOW_SHARING.value());
				diskloc.setDiskId(iDiskKey);
				diskLocator.add(diskloc);
			}
			rSpec.setDiskMoveType(VirtualMachineRelocateDiskMoveOptions.CREATE_NEW_CHILD_DISK_BACKING.value());
			rSpec.getDisk().addAll(diskLocator);
		} else {
			rSpec.setDiskMoveType(VirtualMachineRelocateDiskMoveOptions.CREATE_NEW_CHILD_DISK_BACKING.value());	
		}
		VirtualMachineCloneSpec cloneSpec = new VirtualMachineCloneSpec();
		cloneSpec.setPowerOn(false);
		cloneSpec.setTemplate(false);
		cloneSpec.setLocation(rSpec);
		cloneSpec.setSnapshot(snapshot);

		waitForTask(ses.getVimPort().cloneVMTask(source, dest, sourcename, cloneSpec));
	}

	public static void move(ManagedObjectReference source, ManagedObjectReference dest) throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg, DuplicateNameFaultMsg, InvalidFolderFaultMsg, InvalidStateFaultMsg, InvalidCollectorVersionFaultMsg, InvalidLocaleFaultMsg, InvalidLoginFaultMsg, DatatypeConfigurationException, PathNotFoundException {
		SSOSession ses = SSOSession.get();
		waitForTask(ses.getVimPort().moveIntoFolderTask(dest, Arrays.asList(source)));		
	}

	public static void rename(ManagedObjectReference from, String to) throws DuplicateNameFaultMsg, RuntimeFaultFaultMsg, InvalidNameFaultMsg, InvalidPropertyFaultMsg, InvalidCollectorVersionFaultMsg, InvalidLocaleFaultMsg, InvalidLoginFaultMsg, DatatypeConfigurationException, PathNotFoundException {
		SSOSession ses = SSOSession.get();
		waitForTask(ses.getVimPort().renameTask(from, to));
	}

	public static void delete(ManagedObjectReference item) throws RuntimeFaultFaultMsg, InvalidLocaleFaultMsg, InvalidLoginFaultMsg, DatatypeConfigurationException, InvalidPropertyFaultMsg, InvalidCollectorVersionFaultMsg, VimFaultFaultMsg {
		throw new RuntimeException("Delete is too dangerous to use right now!");
		//SSOSession ses = SSOSession.get();
		//waitForTask(ses.getVimPort().destroyTask(item));
	}

	public static void mkdir(ManagedObjectReference parent, String name) throws RuntimeFaultFaultMsg, InvalidLocaleFaultMsg, InvalidLoginFaultMsg, DatatypeConfigurationException, InvalidPropertyFaultMsg, InvalidCollectorVersionFaultMsg, DuplicateNameFaultMsg, InvalidNameFaultMsg {
		SSOSession ses = SSOSession.get();
		waitForTask(ses.getVimPort().createFolder(parent, name));
	}

	public static void addPortGroup(String name, String vswitch, String host, int vlan) 
			throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg, AlreadyExistsFaultMsg, HostConfigFaultFaultMsg, NotFoundFaultMsg {
		SSOSession ses = SSOSession.get();
		GetMOREF helper = ses.getHelper();
		Map<String, ManagedObjectReference> hostList =
				helper.inFolderByType(ses.getServiceContent().getRootFolder(),
						"HostSystem");
		ManagedObjectReference hostmor = hostList.get(host);
		if (hostmor != null) {
			HostConfigManager configMgr =
					(HostConfigManager) helper.entityProps(hostmor,
							new String[]{"configManager"}).get("configManager");
			ManagedObjectReference nwSystem = configMgr.getNetworkSystem();

			HostPortGroupSpec portgrp = new HostPortGroupSpec();
			portgrp.setName(name);
			portgrp.setVswitchName(vswitch);
			portgrp.setPolicy(new HostNetworkPolicy());
			portgrp.setVlanId(vlan);

			ses.getVimPort().addPortGroup(nwSystem, portgrp);
		} else {
			System.out.println("Host not found");
		}
	}

	public static void removePortGroup(String name, String host)
			throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg, HostConfigFaultFaultMsg, NotFoundFaultMsg, ResourceInUseFaultMsg {
		SSOSession ses = SSOSession.get();
		GetMOREF helper = ses.getHelper();
		Map<String, ManagedObjectReference> hostList =
				helper.inFolderByType(ses.getServiceContent().getRootFolder(),
						"HostSystem");
		ManagedObjectReference hostmor = hostList.get(host);
		if (hostmor == null) {
			throw new RuntimeException("No host by that name: " + host);
		}
		HostConfigManager configMgr = (HostConfigManager) helper.entityProps(hostmor,
				new String[]{"configManager"}).get("configManager");
		ses.getVimPort().removePortGroup(configMgr.getNetworkSystem(), name);

	}

	private static VirtualEthernetCard cardForName(ManagedObjectReference vm, String name) throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {
		SSOSession ses = SSOSession.get();
		List<VirtualDevice> listvd = ((ArrayOfVirtualDevice) ses.getHelper().entityProps(vm,
				new String[]{"config.hardware.device"}).get(
						"config.hardware.device")).getVirtualDevice();		
		for (VirtualDevice device : listvd) {
			if (device instanceof VirtualEthernetCard) {
				if (name.equalsIgnoreCase(device.getDeviceInfo().getLabel()))
					return (VirtualEthernetCard) device;
			}
		}
		return null;
	}

	public static void delNetwork(ManagedObjectReference vm, String adapter) throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg, InvalidCollectorVersionFaultMsg, ConcurrentAccessFaultMsg, DuplicateNameFaultMsg, FileFaultFaultMsg, InsufficientResourcesFaultFaultMsg, InvalidDatastoreFaultMsg, InvalidNameFaultMsg, InvalidStateFaultMsg, TaskInProgressFaultMsg, VmConfigFaultFaultMsg {
		SSOSession ses = SSOSession.get();
		VirtualDeviceConfigSpec nicSpec = new VirtualDeviceConfigSpec();
		nicSpec.setOperation(VirtualDeviceConfigSpecOperation.REMOVE);
		nicSpec.setDevice(cardForName(vm, adapter));
		List<VirtualDeviceConfigSpec> nicSpecArray = new ArrayList<VirtualDeviceConfigSpec>();
		nicSpecArray.add(nicSpec);
		VirtualMachineConfigSpec vmConfigSpec = new VirtualMachineConfigSpec();
		vmConfigSpec.getDeviceChange().addAll(nicSpecArray);
		waitForTask(ses.getVimPort().reconfigVMTask(vm, vmConfigSpec));
	}

	public static void addNetwork(ManagedObjectReference vm, String connection, String mac, String type) throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg, ConcurrentAccessFaultMsg, DuplicateNameFaultMsg, FileFaultFaultMsg, InsufficientResourcesFaultFaultMsg, InvalidDatastoreFaultMsg, InvalidNameFaultMsg, InvalidStateFaultMsg, TaskInProgressFaultMsg, VmConfigFaultFaultMsg, InvalidCollectorVersionFaultMsg {
		SSOSession ses = SSOSession.get();
		VirtualDeviceConfigSpec nicSpec = new VirtualDeviceConfigSpec();
		nicSpec.setOperation(VirtualDeviceConfigSpecOperation.ADD);

		VirtualEthernetCard nic;
		if ("E1000E".equals(type)) {
			nic = new VirtualE1000E();			
		}else if ("E1000".equals(type)) {
			nic = new VirtualE1000();
		}else{
			nic = new VirtualVmxnet3();			
		}
		
		VirtualEthernetCardNetworkBackingInfo nicBacking = new VirtualEthernetCardNetworkBackingInfo();
		nicBacking.setDeviceName(connection);
		
		if (mac == null) {
			nic.setAddressType("generated");
		}else{
			nic.setAddressType("manual");
			nic.setMacAddress(mac);
		}
		
		nic.setBacking(nicBacking);
		nic.setKey(-1);
		nicSpec.setDevice(nic);
		List<VirtualDeviceConfigSpec> nicSpecArray = new ArrayList<VirtualDeviceConfigSpec>();
		nicSpecArray.add(nicSpec);
		VirtualMachineConfigSpec vmConfigSpec = new VirtualMachineConfigSpec();
		vmConfigSpec.getDeviceChange().addAll(nicSpecArray);
		waitForTask(ses.getVimPort().reconfigVMTask(vm, vmConfigSpec));
	}


	public static void migrateDS(ManagedObjectReference vm, ManagedObjectReference datastore) throws RuntimeFaultFaultMsg, InvalidCollectorVersionFaultMsg, FileFaultFaultMsg, InsufficientResourcesFaultFaultMsg, InvalidDatastoreFaultMsg, InvalidStateFaultMsg, MigrationFaultFaultMsg, TimedoutFaultMsg, VmConfigFaultFaultMsg {
		SSOSession ses = SSOSession.get();
		VirtualMachineRelocateSpec relSpec = new VirtualMachineRelocateSpec();
		relSpec.setDatastore(datastore);
		waitForTask(ses.getVimPort().relocateVMTask(vm, relSpec, VirtualMachineMovePriority.DEFAULT_PRIORITY));	
	}
	
    public static void powerOnVM(ManagedObjectReference vm) throws RuntimeFaultFaultMsg, InvalidCollectorVersionFaultMsg, FileFaultFaultMsg, InsufficientResourcesFaultFaultMsg, InvalidStateFaultMsg, TaskInProgressFaultMsg, VmConfigFaultFaultMsg {
		SSOSession ses = SSOSession.get();
		waitForTask(ses.getVimPort().powerOnVMTask(vm, null));
    }

    public static void powerOffVM(ManagedObjectReference vm) throws RuntimeFaultFaultMsg, InvalidCollectorVersionFaultMsg, InvalidStateFaultMsg, TaskInProgressFaultMsg {
		SSOSession ses = SSOSession.get();
		waitForTask(ses.getVimPort().powerOffVMTask(vm));
    }

    public static void shutdownVM(ManagedObjectReference vm) throws InvalidStateFaultMsg, RuntimeFaultFaultMsg, TaskInProgressFaultMsg, ToolsUnavailableFaultMsg {
		SSOSession ses = SSOSession.get();
		// doesn't wait... weird.
		ses.getVimPort().shutdownGuest(vm);
    }
    
    public static void rebootVM(ManagedObjectReference vm) throws InvalidStateFaultMsg, RuntimeFaultFaultMsg, TaskInProgressFaultMsg, ToolsUnavailableFaultMsg {
		SSOSession ses = SSOSession.get();
		// doesn't wait... weird.
		ses.getVimPort().rebootGuest(vm);
    }
}
