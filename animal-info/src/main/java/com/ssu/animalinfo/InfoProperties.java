package com.ssu.animalinfo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties
@Getter
@Setter
public class InfoProperties {
    private String defaultInfo;
    private Map<String, String> infos;
}
