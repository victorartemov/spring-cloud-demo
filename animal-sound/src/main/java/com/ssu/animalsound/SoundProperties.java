package com.ssu.animalsound;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties
@Getter
@Setter
public class SoundProperties {
    private String defaultSound;
    private Map<String, String> sounds;
}
