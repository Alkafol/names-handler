package com.alkafol.nameshandler.aop;
import org.aspectj.lang.annotation.Pointcut;


public class Pointcuts {

    @Pointcut(value = "execution(* com.alkafol.nameshandler.controllers.NamesController.getAge(String)) && args(name)")
    public void getAgePointcut(String name){}
}
