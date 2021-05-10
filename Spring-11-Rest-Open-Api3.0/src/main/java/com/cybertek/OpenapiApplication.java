package com.cybertek;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OpenapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenapiApplication.class, args);
	}

	/*
	Open api dependecy to add info properties  OpenAPI bean need to be adedded
	 */

	@Bean
	public OpenAPI customOpenAPI(){
		return new OpenAPI()
				.info(new Info().title("Cinema Application")
				.version("v1")
				.description("Selling online cinema tickets "));

	}

}
