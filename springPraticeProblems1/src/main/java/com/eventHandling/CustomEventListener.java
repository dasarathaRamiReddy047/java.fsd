package com.eventHandling;

import org.springframework.context.ApplicationListener;

public class CustomEventListener implements ApplicationListener<eventHandlingEvent> {

    public void onApplicationEvent(eventHandlingEvent event) {
        System.out.println("Custom Event Received: " + event.getMessage());
    }
}
