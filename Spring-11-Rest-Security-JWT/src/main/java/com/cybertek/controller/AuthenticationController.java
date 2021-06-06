package com.cybertek.controller;
import com.cybertek.entity.AuthenticationRequest;
import com.cybertek.entity.ResponseWrapper;
import com.cybertek.entity.User;
import com.cybertek.exception.ServiceException;
import com.cybertek.service.UserService;
import com.cybertek.utill.JWTUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Authenticate controller",description = "Authenticate API")
public class AuthenticationController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTUtil jwtUtil;

    // we use responseWrapper to use our custom response
    @PostMapping("/authenticate")
  //  @DefaultExceptionMessage(defaultMessage = "Bad Credentials")
    @Operation(summary = "Login to application")
    public ResponseEntity<ResponseWrapper> doLogin(@RequestBody AuthenticationRequest authenticationRequest){
/*
        from request body what ever we gonna pass , after we capture username and password line 26-27

         */

        String password = authenticationRequest.getPassword();
        String username = authenticationRequest.getUsername();
        // based on that username check DB with this username, since in JWT class we getting user from DB, we need provide it
        // for token creation

        User foundUser = userService.readByUsername(username);
//through authentication managerbean  we do authentication since we do not have form we call manager
        // ( its not about token its api between DB)


        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        authenticationManager.authenticate(authenticationToken);

        String jwtToken = jwtUtil.generateToken(foundUser);

        return ResponseEntity.ok(new ResponseWrapper("Login Succesfull!",jwtToken));

    }

    @PostMapping("/create-user")
    @Operation(summary = "Create a new user")
    // @DefaultExceptionMessage(defaultMessage = "Failed to crate user, please try again")
    public ResponseEntity<ResponseWrapper> createAccount(@RequestBody User user) throws ServiceException {

        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(new ResponseWrapper("User has been created successfully",createdUser));

    }


}