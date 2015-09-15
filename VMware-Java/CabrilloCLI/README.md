
This project is the start of an automation tool for VMware. It uses 
VMwares's Web/SOAP API in the Java programming language. Commands
are derived from VMware's sample code. 

You will need do download your own copy of VMware's Java SDK here:

https://developercenter.vmware.com/web/sdk/55/vsphere-management

You will need your own copy of ANTLR-4.4 or higher here:

http://www.antlr.org/download.html

Commands: 

This project is still very ALPHA. Commands take two kinds of argument. Virtual
Resource Locators (VRLs) and Strings. The syntax of a VRL is:

<type>://<part>[/<part>...]/ 

Notice the trailing slash. It's required! The Syntax of a string is:

"<stuff>" 

Quotes are required. The following VRLs are valid: 

     folder://<datacenter>/<folder..>/
         vm://<datacenter>/<folder...>/<vmname>/
   snapshot://<datacenter>/<folder...>/<vmname>/<snapshotname>/
  portgroup://<host>/<vswitch>/<pgname>/<vlan>/
  datastore://<datacenter>/<datastore>/

The following commands work:

Create a linked clone from a snapshot:
    linkedclone <vrl:Snapshot> <vrl:TargetFolder>

Move a VM or folder to another folder:
    move  <vrl:Source> <vrl:Destination>

Rename a resource (VM or Folder):
    rename <vrl:Resource> <string:NewName>

Make a new folder:
    mkdir <vrl:Parent Folder> <string:Name>

Delete a port group (it's too dangerous to delete folders):
    delete <vrl:Portgroup>

Create a port group:
    create <vrl:Portgroup>

Add a network adapter to a VM connected to the specified network:
    addnet <vrl:VM> <String:Network Name> [<String:MAC Address> <String:Hardware Type>]

    Supported types are "E1000E", "E1000", and "VMXNET3" (The default is VMXNET3)
    If the optional arguments are not supplied the MAC address is chosen at random 

Remove a netwrork adapter from a VM with the specifed name:
    delnet <vrl:VM> <String:Adapter Name>

Migrate a VM from one datastore to another on the same host:
    migrate <vrl:VM> <vrl:Datastore>

Power on a VM:
    poweron <vrl:VM>

Power off a VM:
    poweron <vrl:VM>

Tell a guest OS to shutdown:
    shutdown <vrl:VM>

Tell a guest OS to reboot:
    reboot <vrl:VM>

Usage:
  -h | --help   : This message
  -u <username> : specify the user to login as (otherwise you'll be prompted)
  <file>        : Execute the commands in the file (otherwise STDIN)
