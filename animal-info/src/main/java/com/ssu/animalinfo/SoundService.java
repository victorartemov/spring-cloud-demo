package com.ssu.animalinfo;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Service
@EnableFeignClients
public class SoundService {

    private AnimalSoundFeignClient animalSoundFeignClient;

    public SoundService(AnimalSoundFeignClient animalSoundFeignClient) {
        this.animalSoundFeignClient = animalSoundFeignClient;
    }

    public String getSound(String creature) {
        return animalSoundFeignClient.getSound(creature);
    }

    //    private static final String URL = "http://animal-sound";
//    private RestTemplate rest;
//
//    public SoundService(RestTemplate rest) {
//        this.rest = rest;
//    }
//
//    public String getSound() {
//        return rest.getForObject(URL, String.class);
//    }
//
//    public String getSound(String creature) {
//        return rest.getForObject(
//                new StringBuilder()
//                        .append(URL).append("/")
//                        .append(creature).toString(),
//                String.class);
//    }

    @FeignClient("animal-sound")
    static interface AnimalSoundFeignClient {
        @RequestMapping("/{creature}")
        public String getSound(@PathVariable String creature);
    }
}
