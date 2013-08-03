package com.alesaudate.camel.commander.component;

import java.io.InputStream;

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultProducer;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class CommandProducer extends DefaultProducer{
	
	
	private String host;
	private int port;
	private String pemLocation;
	private String user;
	
	
	
	public CommandProducer(Endpoint endpoint) {
		super(endpoint);
	}
	
	

	@Override
	public void process(Exchange exchange) throws Exception {
		String command = exchange.getIn().getBody(String.class);
		exchange.getIn().setBody(executaComando(command).trim(), String.class);		
	}

	private String executaComando(String command) throws Exception {
		
		
		JSch jSch = new JSch();
		jSch.addIdentity(pemLocation);
		JSch.setConfig("StrictHostKeyChecking", "no");
		Session session = jSch.getSession(user, host, port);
		
		
		
		session.connect();
		Channel channel = session.openChannel("exec");
		((ChannelExec)channel).setCommand(command);
		InputStream in = channel.getInputStream();
		
		channel.connect(60000);
		
		StringBuilder builder = new StringBuilder();
		
		byte[] tmp=new byte[1024];
	      while(true){
	        while(in.available()>0){
	          int i=in.read(tmp, 0, 1024);
	          if(i<0)break;
	          builder.append(new String(tmp, 0, i, "UTF-8"));
	        }
	        if(channel.isClosed()){
	          break;
	        }
	        try{Thread.sleep(1000);}catch(Exception ee){}
	      }
		
		channel.disconnect();
		session.disconnect();
		return builder.toString();
		
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
