package com.eventHandling;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class eventHandling {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");

        // Publish custom event
        context.publishEvent(new eventHandlingEvent("Custom event message"));

        context.close();
    }
}
