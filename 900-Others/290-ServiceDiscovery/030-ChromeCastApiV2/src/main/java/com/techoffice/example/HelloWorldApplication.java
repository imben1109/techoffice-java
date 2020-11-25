package com.techoffice.example;

import su.litvak.chromecast.api.v2.Application;
import su.litvak.chromecast.api.v2.ChromeCast;
import su.litvak.chromecast.api.v2.ChromeCasts;
import su.litvak.chromecast.api.v2.Status;

import java.io.IOException;
import java.util.List;

public class HelloWorldApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        ChromeCasts.startDiscovery();
        Thread.sleep(3000);
        List<ChromeCast> chromecasts = ChromeCasts.get();
        for(ChromeCast chromeCast: chromecasts){
            System.out.println("Connected Device: " + chromeCast.getName());
        }
        if (chromecasts.size() > 0 ){
            ChromeCast chromecast = chromecasts.get(0);
            Status status = chromecast.getStatus();
            Application application = null;
            if (chromecast.isAppAvailable("CC1AD845") && !status.isAppRunning("CC1AD845")) {
                application = chromecast.launchApp("CC1AD845");
            }
            chromecast.load("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");
        }
        ChromeCasts.stopDiscovery();
    }
}
