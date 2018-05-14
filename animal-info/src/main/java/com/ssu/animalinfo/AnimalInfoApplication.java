package com.ssu.animalinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableConfigurationProperties(InfoProperties.class)
@EnableDiscoveryClient
@EnableZuulProxy
public class AnimalInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimalInfoApplication.class, args);
    }

    @Configuration
    static class MyConfig {
        @Bean
        @LoadBalanced //ribbon stuff
        public RestTemplate rest() {
            return new RestTemplateBuilder().build();
        }

        @Bean
        public Sampler getSampler() {
            return new AlwaysSampler();
        }
    }
}
