package com.bank.loan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Account service to provide some account related functionalities for customers",
                description = "Account service to provide some account related functionalities for customers",
                license= @License(name = "@abc corp"),
                version = "v1",
                contact = @Contact(
                      name = "prashant kumar",
                      email = "abc3@gamil.com",
                      url = "www.abc.com"
                )
        )
)

public class AccountsApplication {
    public static void main(String []args){
        SpringApplication.run(AccountsApplication.class, args);
    }
}
