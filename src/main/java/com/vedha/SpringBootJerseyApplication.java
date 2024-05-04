package com.vedha;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Spring Jersey API", version = "1.0", description = "Spring Jersey API"))
public class SpringBootJerseyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJerseyApplication.class, args);
	}

}
