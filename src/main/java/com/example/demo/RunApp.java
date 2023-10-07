package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springdoc.api.annotations.EnableOpenApi;


//@EnableOpenApi
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.demo.repos")
public class RunApp {
    public static void main(String[] args) {
        SpringApplication.run(RunApp.class, args);

    }
}

