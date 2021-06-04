package com.cybertek.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/*
 this class is needed for request body creation. it is not entity its not  related to DATABASE
 */
@Getter
@Setter
@AllArgsConstructor
public class AuthenticationRequest {

    private String username;
    private String password;

}
