package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class Lab06Consumer {

    @Incoming("lab06-in")
    public void consume(ConsumerRecord<String, String> record) {
        System.out.println("***** Record key: " + record.key());
        System.out.println("***** Record: value: " + record.value());
        System.out.println("***** Record: offset: " + record.offset());
        System.out.println("***** Partition: : " + record.partition());
    }
}
