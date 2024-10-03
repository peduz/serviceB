package it.gpedulla.serviceB;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import it.gpedulla.serviceB.model.Payload;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceBIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCallServiceA() {
        String url = "http://localhost:8081/serviceB/serviceA";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<Payload> response = restTemplate.exchange(url, HttpMethod.GET, entity, Payload.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(((String) response.getBody().getPayload()).contains("Hello"));
    }
}