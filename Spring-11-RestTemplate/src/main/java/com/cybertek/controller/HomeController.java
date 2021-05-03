package com.cybertek.controller;

import com.cybertek.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

@RestController
public class HomeController {
    // here we show which URI we want to Consume !!!
    final String URI = "https://jsonplaceholder.typicode.com/users";
    // second step we inject bean
    private RestTemplate restTemplate;

    public HomeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // here RestTemplate will go to URI provided above get json and will convert to USER entity, since method get.FOR.Entity returns Array
    // we need return array
    @GetMapping
    public User[] readAllUsers() {
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(URI, User[].class);
        return responseEntity.getBody();
    }

    @GetMapping(value = "/{id}")
    public Object readUser(@PathVariable("id") Integer id) {
        // we use concatanation bc we want get specific user :    final String URI = "https://jsonplaceholder.typicode.com/users"; / id
        String URL = URI + "/{id}";
        return restTemplate.getForObject(URL, Object.class, id);
    }
}
