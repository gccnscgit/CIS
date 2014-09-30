# 
# SnapshotVMs.ps1: Make initial snapshots of all VMs in inventory.
# Author: Mike Matera
#
# This script searches the entire inventory on a vSphere server. If
# a VM is powered off and it has no existing snapshot it makes one. 
# The user is prompted before a snapshot is made. The "force" parameter
# overrides the prompt (with an answer of yes). 
#
# A popup aking for VMware credentials will happen.
#

param (
	[string]$server = "vcenter",
	[switch]$force = $false
)

Write-Host "Initializing VMWare Automation Core (this can take a little while)"

if ((Get-PSSnapin -Name "VMware.VimAutomation.Core" -ErrorAction SilentlyContinue) -eq $null) {
	Add-PSSnapin -Name "VMware.VimAutomation.Core"
}

Write-Host "Logging into vSphere server $server"
$vc = Connect-VIServer -Server $server

foreach ($vm in get-vm -server $vc) {	
	$folder = $vm.Folder
	$parent = $folder.Parent	
	$path = @($folder)
	do {
		$path += $parent
		$parent = $parent.Parent
	} while ($parent -ne $null)
	[array]::Reverse($path)	
	$name = $vm.Name
	$fullname = [system.String]::Join("\", $path) 
	$fullname += "\$name"
	$snapshots = get-snapshot -VM $vm -Server $vc
	
	if ($snapshots -ne $null) {
		Write-Host "Skipping $fullname because it has a snapshot already."
	}else{
		if ($vm.PowerState -ne "PoweredOff") {
			Write-Host "Skipping $fullname because it is powered on."
		}else{
			$title = "Make Snapshot"
			$message = "Do you want to take a snapshot of $fullname"
			$yes = New-Object System.Management.Automation.Host.ChoiceDescription "&Yes", "Take Snapshot"
			$no = New-Object System.Management.Automation.Host.ChoiceDescription "&No", "No Snapshot"
			$options = [System.Management.Automation.Host.ChoiceDescription[]]($yes, $no)
			if ($force -ne $false -or $host.ui.PromptForChoice($title, $message, $options, 1) -eq 0) {
				Write-Host "Making snapshot!"
				New-Snapshot -VM $vm -Name "GOLDEN_MASTER" -Description "Automatic snapshot taken by SnapshotVMs.ps1"
			}
		}
	}
}

