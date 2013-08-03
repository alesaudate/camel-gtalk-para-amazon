package com.alesaudate.camel.commander.component;

import java.util.Map;

import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;

public class CommandComponent extends DefaultComponent{

	private String host;
	private int port;
	private String pemLocation;
	private String user;
	
	@Override
	protected Endpoint createEndpoint(String uri, String remaining,
			Map<String, Object> parameters) throws Exception {
		CommandEndpoint commandEndpoint = new CommandEndpoint();
		commandEndpoint.setHost(getHost());
		commandEndpoint.setPort(getPort());
		commandEndpoint.setPemLocation(getPemLocation());
		commandEndpoint.setUser(getUser());
		return commandEndpoint;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPemLocation() {
		return pemLocation;
	}

	public void setPemLocation(String pemLocation) {
		this.pemLocation = pemLocation;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	
	
}
