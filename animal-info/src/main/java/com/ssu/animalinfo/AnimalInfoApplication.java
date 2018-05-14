package com.ssu.animalinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableConfigurationProperties(InfoProperties.class)
public class AnimalInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimalInfoApplication.class, args);
    }

    @Configuration
    static class MyConfig {
        @Bean
        public RestTemplate rest() {
            return new RestTemplateBuilder().build();
        }
    }
}
