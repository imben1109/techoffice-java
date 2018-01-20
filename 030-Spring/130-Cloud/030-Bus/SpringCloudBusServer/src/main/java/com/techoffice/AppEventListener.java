package com.techoffice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppEventListener implements ApplicationListener<AppEvent> {

    private static final Logger logger = LoggerFactory.getLogger(AppEventListener.class);

	public void onApplicationEvent(AppEvent arg0) {
        logger.info("Received MyCustomRemoteEvent - message: " + arg0.getMessage());
	}

}
