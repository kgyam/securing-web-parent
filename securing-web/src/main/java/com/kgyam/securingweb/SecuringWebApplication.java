package com.kgyam.securingweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecuringWebApplication {
    public static void main(String[] args) throws Throwable {
        SpringApplication.run(SecuringWebApplication.class, args);
    }
}
