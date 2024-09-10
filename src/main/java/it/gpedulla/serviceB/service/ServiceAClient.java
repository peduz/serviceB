package it.gpedulla.serviceB.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "serviceA", url = "http://localhost:8080/serviceA")
public interface ServiceAClient {

    @GetMapping("/")
    ResponseEntity<String> reply(@RequestParam(value = "name", required = false) String name);
}
