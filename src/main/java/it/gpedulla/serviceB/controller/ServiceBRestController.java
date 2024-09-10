package it.gpedulla.serviceB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.gpedulla.serviceB.model.Payload;
import it.gpedulla.serviceB.service.ServiceB;

@RestController
@RequestMapping("/serviceB")
public class ServiceBRestController {

	@Autowired
	private ServiceB service;

	@PostMapping("/receive")
    public ResponseEntity<Payload<String>> receiveMessage(@RequestBody String message) {

		try {
			return ResponseEntity.ok(new Payload<String>(service.reply(message), "ok"));
		} catch (Exception e) {
			return new ResponseEntity<>(
					new Payload<>(null, "Error: " + e.getMessage()),//Body
					HttpStatus.INTERNAL_SERVER_ERROR);//Response code
		}

	}
	
    @GetMapping("/serviceA")
    public ResponseEntity<Payload<String>> callServiceA(@RequestParam(required = false) String name) {
    	try {
    		String response = service.callServiceA(name);
			return ResponseEntity.ok(new Payload<String>(response, "ok"));
    	} catch(Exception e) {
			return new ResponseEntity<>(
					new Payload<>(null, "Error: " + e.getMessage()),//Body
					HttpStatus.INTERNAL_SERVER_ERROR);//Response code
    	}
    }
}
