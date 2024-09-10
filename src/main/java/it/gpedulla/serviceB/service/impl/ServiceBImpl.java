package it.gpedulla.serviceB.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.gpedulla.serviceB.service.ServiceAClient;
import it.gpedulla.serviceB.service.ServiceB;

@Service
public class ServiceBImpl implements ServiceB {
	
	@Autowired
	private ServiceAClient serviceAClient; // Feign client per chiamare ServiceA

	@Override
	public String reply(String message) {
		
		if(message == null || message.isBlank()) {
			return "Received an empty message" ;
		}
		
		return "Message received: " + message;
	}


    @Override
    public String callServiceA(String name) {
        ResponseEntity<String> response = serviceAClient.reply(name);
        return "Response from ServiceA: " + response.getBody();
    }
	
}
