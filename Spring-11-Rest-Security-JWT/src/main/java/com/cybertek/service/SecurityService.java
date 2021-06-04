package com.cybertek.service;

import com.cybertek.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityService implements UserDetailsService {

    private UserService userService;

    public SecurityService(UserService userService) {
        this.userService = userService;
    }
    // purpose get a user from DB , we do not have user interface so we convert  directly convert value  to USER
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User foundUser = loadUser(s);
        if(foundUser == null){
            throw new UsernameNotFoundException("user not found! " + s);
        }
        // its a spring security user spring make authenticztion bvaseon s[rong structure , simmilar we did for MVC
        // ( we need decribe autherities ( we did it in user priciple but here we do not have it _
        return new org.springframework.security.core.userdetails.User(foundUser.getUsername(), foundUser.getPassword(), listAuthorities(foundUser));
    }
    // user can use both email user name
    public User loadUser(String value){
        boolean isEmail = value.contains("@");
        return isEmail ? userService.readByEmail(value) : userService.readByUsername(value);
    }
    // same as for user Principle
    private List<GrantedAuthority> listAuthorities(User user){
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority(user.getRole().name()));
        return grantedAuthorityList;
    }


}