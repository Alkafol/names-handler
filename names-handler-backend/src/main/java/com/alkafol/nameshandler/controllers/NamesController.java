package com.alkafol.nameshandler.controllers;

import com.alkafol.nameshandler.dto.NameAgeResponseDto;
import com.alkafol.nameshandler.services.NamesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"${frontend.url}"})
public class NamesController {
    private final NamesService namesService;


    public NamesController(NamesService namesService) {
        this.namesService = namesService;
    }

    @GetMapping("/get_age/{name}")
    public NameAgeResponseDto getAge(@PathVariable String name){
        return namesService.getAgeByName(name);
    }
}
