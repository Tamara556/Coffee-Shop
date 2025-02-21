package org.example.coffeeshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class CoffeeShopApplication {

    public static void main(String[] args) {

        SpringApplication.run(CoffeeShopApplication.class, args);
    }

}
