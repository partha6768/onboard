package com.imovies.onboard;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@OpenAPIDefinition(info = @Info(title = "Onboard API", version = "1.0", description = "Onboard Information"))
public class OnboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnboardApplication.class, args);
	}

}
