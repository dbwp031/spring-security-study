package com.example.ch10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class Ch10Application {


    public static void main(String[] args) {
        SpringApplication.run(Ch10Application.class, args);
    }

}
