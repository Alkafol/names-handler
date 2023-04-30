package com.alkafol.nameshandler.controllers;

import com.alkafol.nameshandler.services.StatsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = {"${frontend.url}"})
public class StatsController {
    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/get_frequency")
    public Map<String, Integer> getFrequency(){
        return statsService.getFrequencyMap();
    }

    @GetMapping("/get_max_age")
    public Map<String, Short> getMaxAge(){
        return statsService.getMaxNameAge();
    }
}
