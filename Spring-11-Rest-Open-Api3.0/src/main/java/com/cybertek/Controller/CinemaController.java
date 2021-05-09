package com.cybertek.Controller;

import com.cybertek.entity.Cinema;
import com.cybertek.repository.CinemaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
/*/
to do ducomentation at Rest api3.o
1. add dependancy
<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-ui</artifactId>
			<version>1.5.3</version>
		</dependency>
 */
@RestController
@RequestMapping("/cinema")
@Tag(name = "Cinema",description = "Cinema Api")
public class CinemaController {
    @Autowired
    private CinemaRepository cinemaRepository;


    @GetMapping
    // this annotation is used to describe api what it does
    @Operation(summary = "get a all cinimas in all locations in all cities ")
    public List<Cinema> readAll(){
        return cinemaRepository.findAll();

    }
}
