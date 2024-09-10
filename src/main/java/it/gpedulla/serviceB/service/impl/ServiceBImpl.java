package it.gpedulla.serviceB.service.impl;

import org.springframework.stereotype.Service;

import it.gpedulla.serviceB.service.ServiceB;

@Service
public class ServiceBImpl implements ServiceB {

	@Override
	public String reply(String message) {
		
		if(message == null || message.isBlank()) {
			return "Received an empty message" ;
		}
		
		return "Message received: " + message;
	}
	
	
}
