package it.gpedulla.serviceB;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import it.gpedulla.serviceB.service.ServiceAClient;
import it.gpedulla.serviceB.service.impl.ServiceBImpl;

public class MockTestB {

	@Mock
	private ServiceAClient serviceAClient;

	@InjectMocks
	private ServiceBImpl serviceB;

	public MockTestB() {
	        MockitoAnnotations.openMocks(this);
	    }

	@Test
	public void testCallServiceA() throws Exception {
		when(serviceAClient.reply("test")).thenReturn(ResponseEntity.ok("Hello test from service a."));

		String result = serviceB.callServiceA("test");
		assertEquals("Hello test from service a.", result);
	}

	@Test
	public void testCallServiceA_Exception() {
		when(serviceAClient.reply("test")).thenThrow(new RuntimeException("Feign client error"));

		Exception exception = assertThrows(Exception.class, () -> {
			serviceB.callServiceA("test");
		});

		assertTrue(exception.getMessage().contains("Feign client error"));
	}
}
