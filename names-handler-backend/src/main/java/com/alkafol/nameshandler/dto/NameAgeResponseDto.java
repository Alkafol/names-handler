package com.alkafol.nameshandler.dto;

public class NameAgeResponseDto {
    private final String name;
    private final short age;

    public NameAgeResponseDto(String name, short age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public short getAge() {
        return age;
    }
}
