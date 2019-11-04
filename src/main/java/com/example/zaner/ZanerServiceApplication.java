package com.example.zaner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ZanerServiceApplication {

    

    public static void main(String[] args) {
        SpringApplication.run(ZanerServiceApplication.class, args);
  

    }

}
