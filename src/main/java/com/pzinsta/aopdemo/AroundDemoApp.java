package com.pzinsta.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pzinsta.aopdemo.config.DemoConfig;
import com.pzinsta.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService = context.getBean(TrafficFortuneService.class);
        
        System.out.println(trafficFortuneService.getFortune());
        
        context.close();
    }

}
