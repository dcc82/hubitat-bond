/**
 *  BOND Fireplace Light
 *
 *  Copyright 2019-2020 Dominick Meglio
 *
 */
 
metadata {
    definition (
		name: "BOND Fireplace Light", 
		namespace: "bond", 
		author: "dmeglio@gmail.com",
		importUrl: "https://raw.githubusercontent.com/dcmeglio/hubitat-bond/master/drivers/BOND_Fireplace_Light.groovy"
	) {
		capability "Switch"
        capability "Light"
		
		command "fixPower", [[name:"Power*", type: "ENUM", description: "Power", constraints: ["off","on"] ] ]
		command "toggle"
    }
}

def on() {
    
	parent.handleLightOn(device)
}

def off() {
	parent.handleLightOff(device)
}

def toggle() {
	if (device.currentState("switch") == "on")
		off()
	else
		on()
}

def fixPower(power)
{
	parent.fixLightPower(device, power)
}