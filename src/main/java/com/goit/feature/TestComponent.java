package com.goit.feature;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TestComponent {
    @PostConstruct
    public void init() {
        System.out.println("PostConstruct method");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("PreDestroy method");
    }
}
