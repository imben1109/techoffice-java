package com.techoffice;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

public class AppEvent extends RemoteApplicationEvent{

	private static final long serialVersionUID = 1L;

	private String message;

    public AppEvent() {
    }

    public AppEvent(Object source, String originService, String message) {
        super(source, originService);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public AppEvent setMessage(String message) {
        this.message = message;
        return this;
    }

}
