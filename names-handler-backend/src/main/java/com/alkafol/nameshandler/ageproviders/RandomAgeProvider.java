package com.alkafol.nameshandler.ageproviders;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Order(3)
public class RandomAgeProvider implements AgeProvider{
    HashMap<String, Short> nameAgeCache = new HashMap<>();

    @Override
    public short getAgeByName(String name) {
        nameAgeCache.putIfAbsent(name, (short) (Math.random() * 100));
        return nameAgeCache.get(name);
    }
}
