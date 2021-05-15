package com.cybertek.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // since we do not have form http we need add this bean , since we do api authentication instrad form login logout ,
    // remeber me bc we are working with api
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Override
    protected  void configure(HttpSecurity http) throws Exception{
        // csrf = cross side request forgery ( we send request some one want catch api)most company disable and they do custom
            http.csrf()
                    .disable()
                    .authorizeRequests()
                    // means localhost8080/authenticate,all people will have access
                    .antMatchers("authenticate")
                    .permitAll()
                    .anyRequest()
                    .authenticated();
    }

}
