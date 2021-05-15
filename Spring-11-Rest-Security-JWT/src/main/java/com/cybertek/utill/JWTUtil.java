package com.cybertek.utill;

import com.cybertek.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtil {
    //this annotation is used bring inject property in a class
    @Value("${security.jwt.secret-key}")
    private String secret = "cybertek";


    // here we create first part of token PAyload (claims)
    public String generateToken(User user,String username){
        Map<String,Object>claims = new HashMap<>();
        claims.put("username",user.getUsername());
        claims.put("email",user.getEmail());
        return createToken(claims,username);
    }

  // we pass username separatley bc there parameter JWT parameter Subject
    private String createToken(Map<String,Object> claims,String username){
            return Jwts
                    .builder()
                    .setClaims(claims)
                    .setSubject(username)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 *10)) //10 hours token validity
                    .signWith(SignatureAlgorithm.HS256,secret).compact();

        }
}
