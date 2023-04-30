package com.alkafol.nameshandler.services;

import com.alkafol.nameshandler.dto.NameAgeResponseDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StatsService {
    private Map<String, Integer> frequencyMap = new HashMap<>();
    private short maxAge = -1;
    private String maxAgeName = "None";

    public void processRequest(String name, NameAgeResponseDto response){
        frequencyMap.putIfAbsent(name, 0);
        frequencyMap.put(name, frequencyMap.get(name) + 1);

        if (response.getAge() > maxAge){
            maxAge = response.getAge();
            maxAgeName = name;
        }
    }

    public Map<String, Integer> getFrequencyMap(){
        return frequencyMap;
    }

    public Map<String, Short> getMaxNameAge(){
        return new HashMap<>(){{
            put(maxAgeName, maxAge);
        }};
    }
}
