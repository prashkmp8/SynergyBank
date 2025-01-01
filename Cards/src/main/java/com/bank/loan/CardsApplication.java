package com.bank.loan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(
		info = @Info(
				title = "Cards service to provide some cards related functionalities for customers",
				description = "Cards service to provide some cards related functionalities for customers",
				license= @License(name = "@abc corp"),
				version = "v1",
				contact = @Contact(
						name = "prashant kumar",
						email = "abc3@gamil.com",
						url = "www.abc.com"
				)
		)
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
