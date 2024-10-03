package it.gpedulla.serviceB;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.gpedulla.serviceB.service.impl.ServiceBImpl;

public class ServiceBImplTest {

    private final ServiceBImpl serviceB = new ServiceBImpl();

    @Test
    public void testReply() {
        String result = serviceB.reply("Hello from Service A!");
        assertEquals("Message received: Hello from Service A!", result);
    }
}

