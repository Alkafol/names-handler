package com.alkafol.nameshandler.aop;

import com.alkafol.nameshandler.dto.NameAgeResponseDto;
import com.alkafol.nameshandler.services.StatsService;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StatsAspect {
    StatsService statsService;

    public StatsAspect(StatsService statsService) {
        this.statsService = statsService;
    }

    @AfterReturning(value = "Pointcuts.getAgePointcut(name)", returning = "response", argNames = "name, response")
    public void afterGetAgePointcut(String name, NameAgeResponseDto response){
        statsService.processRequest(name, response);
    }
}
