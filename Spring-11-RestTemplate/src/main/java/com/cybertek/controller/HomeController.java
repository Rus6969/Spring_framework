package com.cybertek.controller;

import com.cybertek.entity.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;

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

    // if we consume third party api with a header we need to use "exchange" and provide headers which required third party api
    // when we add outr headers in http certain structure so here we are mapping to certain structure
    @GetMapping("test")
    public ResponseEntity<Object>consumePostsFromDummyApi(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id","lTE5abbDxdjGplutvTuc");
       // this entity  is a header
        HttpEntity<String> entity = new HttpEntity<>(headers);
                                 // here we are passing URI provide what type of a call ,headers and add Object class
        ResponseEntity<Object> response = restTemplate.exchange("https://dummyapi.io/data/api/user?limit=10", HttpMethod.GET,entity,Object.class);

        return response;

    }


}
