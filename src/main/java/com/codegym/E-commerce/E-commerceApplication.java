package com.codegym.cgzgearservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication @EnableWebSecurity

public class CgZgearServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CgZgearServiceApplication.class, args);
    }

}