package com.ssu.animalinfo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SoundService {
    private static final String URL = "http://localhost:9091";
    private RestTemplate rest;

    public SoundService(RestTemplate rest) {
        this.rest = rest;
    }

    public String getSound() {
        return rest.getForObject(URL, String.class);
    }

    public String getSound(String creature) {
        return rest.getForObject(
                new StringBuilder()
                        .append(URL).append("/")
                        .append(creature).toString(),
                String.class);
    }
}
