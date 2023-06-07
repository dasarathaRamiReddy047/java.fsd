package com.eventHandling;

import org.springframework.context.ApplicationEvent;

public class eventHandlingEvent extends ApplicationEvent {

    private String message;

    public eventHandlingEvent(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
