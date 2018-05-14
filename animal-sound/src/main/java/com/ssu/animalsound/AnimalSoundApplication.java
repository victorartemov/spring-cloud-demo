package com.ssu.animalsound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(SoundProperties.class)
@EnableDiscoveryClient
public class AnimalSoundApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimalSoundApplication.class, args);
    }

    @Bean
    public Sampler getSampler() {
        return new AlwaysSampler();
    }
}
