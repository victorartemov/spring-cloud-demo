package com.ssu.animalsound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(SoundProperties.class)
public class AnimalSoundApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalSoundApplication.class, args);
	}
}
