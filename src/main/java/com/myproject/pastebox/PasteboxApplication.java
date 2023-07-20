package com.myproject.pastebox;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class PasteboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasteboxApplication.class, args);
    }

}
