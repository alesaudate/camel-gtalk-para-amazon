package com.alesaudate.camel.commander.component;

import org.apache.camel.Producer;
import org.apache.camel.component.direct.DirectEndpoint;

public class CommandEndpoint extends DirectEndpoint {

	
	private String host;
	private int port;
	private String pemLocation;
	private String user;
	
	
	@Override
	public Producer createProducer() throws Exception {
		CommandProducer commandProducer = new CommandProducer(this);
		commandProducer.setHost(host);
		commandProducer.setPort(port);
		commandProducer.setPemLocation(pemLocation);
		commandProducer.setUser(user);
		return commandProducer;
	}
	
	@Override
	protected String createEndpointUri() {
		
		return "command";
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setPemLocation(String pemLocation) {
		this.pemLocation = pemLocation;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	
	

}
