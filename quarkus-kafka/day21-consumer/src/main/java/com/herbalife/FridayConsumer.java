package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class FridayConsumer {


    @Incoming("fridaydlq-in")
    public void receiveDLQ(String message) {
        //If this method also throws an exception, you may have to catch it and log it
        //One use case is to log the message and then write it to a NoSQL database for further analysis
        //And send an alert to the support team
        System.out.println("*************Processing messages from Friday DLQ: " + message);
    }

    @Incoming("friday-in")
    public void receive(String message) {
        //Let us simulate some exception to understand how the consumer retries
        if (message.contains("fool") || message.contains("idiot") || message.contains("stupid")) {
            throw new RuntimeException("====Friday: " + message + " - I don't like this message");
        }
        System.out.println("====Friday: " + message);
    }
}
