package com.cybertek.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenApi(){
        SecurityScheme securitySchemeItem = new SecurityScheme();
        securitySchemeItem.setType(SecurityScheme.Type.HTTP);
        // we are saying that we will use token authentication
        securitySchemeItem.setScheme("bearer");
        //token format
        securitySchemeItem.setBearerFormat("JWT");
        //where token is located
        securitySchemeItem.setIn(SecurityScheme.In.HEADER);
        //key name
        securitySchemeItem.setName("Authorization");
        io.swagger.v3.oas.models.info.Info infoVersion = new io.swagger.v3.oas.models.info.Info().title("Cybertek API").version("snapshot");
        SecurityRequirement securityItem = new SecurityRequirement().addList("bearer-jwt", Arrays.asList("read","write"));

        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-jwt",securitySchemeItem))
                .info(infoVersion)
                .addSecurityItem(securityItem);


    }
}
