package com.example.ulsu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UlsuApplication {

    public static void main(String[] args) {
        SpringApplication.run(UlsuApplication.class, args);
    }

}
