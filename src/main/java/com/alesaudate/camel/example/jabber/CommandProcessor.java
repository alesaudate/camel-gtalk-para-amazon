package com.alesaudate.camel.example.jabber;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;



public class CommandProcessor implements Processor{

	
	public static final String STRING_COMANDO = "comando:";
	
	
	public boolean testaInput(String comando) {
		return comando != null && comando.toLowerCase().startsWith(STRING_COMANDO);
	}
	
	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.getIn().setBody(
				exchange.getIn().getBody(String.class)
						.substring(CommandProcessor.STRING_COMANDO.length()));

	}

}
