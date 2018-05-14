package com.ssu.animalinfo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class InfoController {

    public static final Logger LOG = Logger.getLogger(InfoController.class.getName());

    private SoundService soundService;
    private InfoProperties infoProperties;

    public InfoController(SoundService soundService, InfoProperties infoProperties) {
        this.soundService = soundService;
        this.infoProperties = infoProperties;
    }

    @RequestMapping(value = "/{creature}")
    public String getInfo(@PathVariable String creature) {
        LOG.info("Creature: " + creature);

        String info = infoProperties.getInfos().getOrDefault(creature, infoProperties.getDefaultInfo());
        String sound = soundService.getSound(creature);

        LOG.info("Info: " + info);
        LOG.info("Sound: " + sound);

        String result = new StringBuilder()
                .append(info)
                .append(" It says: ")
                .append(sound)
                .toString();

        return result;
    }
}


