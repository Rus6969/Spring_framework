package com.cybertek.Controller;

import com.cybertek.entity.User;
import com.cybertek.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
@RestController
@Tag(name = "User",description = "User Api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @Operation(summary = "find all users ")
    // to add 200,400 ets responses
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Successfully retrieved",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "400",description = "Something went wrong",content = @Content),
            @ApiResponse(responseCode = "404",description = "User not found",content = @Content)
    })
    public List<User>findAllUSers(){
        return userRepository.findAll();
    }
}
