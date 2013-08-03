package com.alesaudate.camel.example.jabber;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Init {

	
	public static void main(String[] args) throws InterruptedException {
		new ClassPathXmlApplicationContext("applicationContext.xml");
		Thread.sleep(Long.MAX_VALUE);	

	}

}
