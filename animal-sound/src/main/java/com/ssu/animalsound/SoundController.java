package com.ssu.animalsound;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class SoundController {

    private static final Logger LOG = Logger.getLogger(SoundController.class.getName());

    private SoundProperties soundProperties;

    public SoundController(SoundProperties soundProperties) {
        this.soundProperties = soundProperties;
    }

    @RequestMapping("/{creature}")
    public String getSound(@PathVariable String creature) {
        LOG.info("Creature: " + creature);
        LOG.info("Sound: " + soundProperties.getSounds().get(creature));

        return soundProperties.getSounds().getOrDefault(creature, soundProperties.getDefaultSound());
    }
}
