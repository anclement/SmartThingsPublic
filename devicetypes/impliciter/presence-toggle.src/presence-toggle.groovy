/**
 *  Presence Toggle
 *
 *  Author: impliciter
 *
 *  Date: 2015-04-01
 */
metadata {
	// Automatically generated. Make future change here.
	definition (name: "Presence Toggle", namespace: "impliciter", author: "impliciter", oauth: true) {
		capability "Actuator"
		capability "Switch"
		capability "Sensor"
        capability "Presence Sensor"
	}

	// simulator metadata
	simulator {
	}

	// UI tile definitions
	tiles {
		standardTile("button", "device.switch", width: 2, height: 2, canChangeIcon: true) {
			state "off", label: 'Away', action: "switch.on", icon: "st.switches.switch.off", backgroundColor: "#ffffff", nextState: "on"
			state "on", label: 'Home', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#79b821", nextState: "off"
		}
        standardTile("presence", "device.presence", width: 2, height: 2, canChangeBackground: true) {
			state "not present", labelIcon:"st.presence.tile.not-present", backgroundColor:"#ffffff"
            state "present", labelIcon:"st.presence.tile.present", backgroundColor:"#53a7c0"
		}
		main(["button","presence"])
		details(["button","presence"])
	}
}

def parse(String description) {
}

def on() {
	sendEvent(name: "switch", value: "on")
    sendEvent(name: 'presence', value: 'present')
}

def off() {
	sendEvent(name: "switch", value: "off")
    sendEvent(name: 'presence', value: 'not present')
}