package com.cybertek.controller;

import org.springframework.web.bind.annotation.RestController;
/*/ must be added first to work with mono and flux
 <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webflux</artifactId>
        </dependency>
        In Spring WebFlux, the data returned from any operation is packed into a reactive stream.
        There are two types that embody this approach and are the building blocks in WebFlux applications - Mono and Flux.
Mono is a stream which returns zero items or a single item (0..1), whereas Flux is a stream which returns zero or more items (0..N).
 */
@RestController
public class WebFluxController {
}
