package com.example.demo;


import io.swagger.annotations.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import org.springdoc.api.annotations.EnableOpenApi;


//@Info(title = "Withdrawal app Documentation", version = "1.0")
@EnableSwagger2
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.demo.repos")
public class RunApp {
    public static void main(String[] args) {
        SpringApplication.run(RunApp.class, args);

    }
}

