metadata {
	definition (name: "wol-refresh", namespace: "mynamespace", author: "my name") {
		capability "Refresh"
	}


	simulator {
		// TODO: define status and reply messages here
	}

	tiles {
		// TODO: define your main and details tiles here
                standardTile("refresh", "command.refresh", inactiveLabel: false, decoration: "flat") {
			state "default", action:"refresh.refresh", icon:"st.secondary.refresh" // CUSTOMIZATION
		}
	}
}

// parse events into attributes
def parse(String description) {
	log.debug "Parsing '${description}'"
}

def myWOLCommand() {
    def result = new physicalgraph.device.HubAction (
        "wake on lan 94:DE:80:66:26:F6':'>",
        physicalgraph.device.Protocol.LAN,
        null,
        [:]
    )
    return result
}

// handle commands
def refresh() {
    log.debug "Executing 'refresh'"
    def result = myWOLCommand()
    log.debug "result ${result}" // this prints result myrealmacid
}