package com.alkafol.nameshandler.services;

import com.alkafol.nameshandler.ageproviders.AgeProvider;
import com.alkafol.nameshandler.dto.NameAgeResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NamesService {
    private final List<AgeProvider> ageProviderList;

    public NamesService(List<AgeProvider> ageProviderList) {
        this.ageProviderList = ageProviderList;
    }

    public NameAgeResponseDto getAgeByName(String name) {
        for(AgeProvider ageProvider : ageProviderList){
            short age = ageProvider.getAgeByName(name);
            if (age != -1){
                return new NameAgeResponseDto(name, age);
            }
        }

        throw new RuntimeException();
    }
}
