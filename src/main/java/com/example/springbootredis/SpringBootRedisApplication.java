package com.example.springbootredis;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Chaine API", version = "1.0", description = "Stocke et signe une chaine de caractères donnée"))
public class SpringBootRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisApplication.class, args);
	}

}
