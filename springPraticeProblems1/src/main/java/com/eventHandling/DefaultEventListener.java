package com.eventHandling;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class DefaultEventListener implements ApplicationListener<ContextRefreshedEvent> {
    
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Default Event Received: Context Refreshed");
    }
}

