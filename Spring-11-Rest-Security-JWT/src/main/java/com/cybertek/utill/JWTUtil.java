package com.cybertek.utill;

import com.cybertek.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/*
1. create token using secret + payload creation what you want to pass
2. after we create a token and hit an api providing token in a header ( we need decode token for validation against db ( userDetails class is used)
3. once we deon with token creation token decoding and token validation next step is add FILTERING class located under service :
 */

@Component
public class JWTUtil {
    //this annotation is used bring inject property in a class
    @Value("${security.jwt.secret-key}")
    private String secret = "cybertek";

    public String generateToken(User user){

        Map<String,Object> claims = new HashMap<>();
        claims.put("username",user.getUsername());
        claims.put("email",user.getEmail());
        return createToken(claims,user.getUsername());
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
/*
    after we create token and send it user hit api , before token verification we need   to decode token
    in this method we getting body of a claim ( payload)
     */

    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
    //functional interfaces only abstract method existed with one abstract method , NOOOOOTCLEAR
    private <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String extractUsername(String token){
        return extractClaim(token,Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);

    }

    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    // we are adding user details bc spring needs to evaluate  a token after extraction we have user, email etc now it need to do validation against DB
    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }












}