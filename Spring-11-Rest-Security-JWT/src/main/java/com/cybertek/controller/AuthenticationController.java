package com.cybertek.controller;

import com.cybertek.entity.AuthenticationRequest;
import com.cybertek.entity.ResponseWrapper;
import com.cybertek.entity.User;
import com.cybertek.service.UserService;
import com.cybertek.utill.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTUtil jwtUtil;

 // we use responseWrapper to use our custom response
    @PostMapping("/authenticate")
    public ResponseEntity<ResponseWrapper>doLogin(@RequestBody AuthenticationRequest authenticationRequest){
        /*
        from request body what ever we gonna pass , after we capture username and password line 26-27

         */
        String password = authenticationRequest.getPassword();
        String username = authenticationRequest.getUsername();
        // based on that username check DB with this username, since in JWT class we getting user from DB, we need provide it
        // for token creation
        User foundUSer = userService.readByUsername(username);
        //
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        //through authentication managerbean  we do authentication since we do not have form we call manager
        // ( its not about token its api between DB)
        authenticationManager.authenticate(authenticationToken);

        /// here TOKEN GENERATION
        String jwtToken = jwtUtil.generateToken(foundUSer);

        return ResponseEntity.ok(new ResponseWrapper("Login Successful",jwtToken));

    }
}
