package com.cyriljoui.spring.poc.springrabbitmq;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Receiver {
    private AtomicInteger countDown = new AtomicInteger();

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDown.incrementAndGet();
    }

    public AtomicInteger getCountDown() {
        return countDown;
    }
}
