package com.alkafol.nameshandler.ageproviders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Order(2)
public class ExternalAgeProvider implements AgeProvider{
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public ExternalAgeProvider(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public short getAgeByName(String name) {
        String response = restTemplate.getForObject("https://api.agify.io/?name=" + name, String.class);

        try {
            JsonNode root = objectMapper.readTree(response);
            JsonNode ageNode = root.get("age");
            return ageNode.isNull() ? -1 : (short) ageNode.asInt();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return -1;
    }
}
