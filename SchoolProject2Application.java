package com.SchoolProject2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.SchoolProject2")
public class SchoolProject2Application {
    public static void main(String[] args) {
        SpringApplication.run(SchoolProject2Application.class, args);
    }
}
