package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class WordConsumer {

    @Incoming("word-channel")
    public void consume(ConsumerRecords<String, String> records) {
        System.out.println("**********************Consumption**********************");
        records.forEach(record -> {
            String key = record.key();
            String value = record.value();
            long offset = record.offset();
            int partition = record.partition();
            String topic = record.topic();
            long ts = record.timestamp();
            System.out.println("====Consumed word: " + value + " from topic: " + topic + " with key: " + key + " and partition: " + partition + " and offset: " + offset + " and timestamp: " + ts);
        });
    }

//    @Incoming("word-channel")
//    public void consume(ConsumerRecord<String, String> record) {
//        System.out.println("**********************Consumption**********************");
//        String key = record.key();
//        String value = record.value();
//        long offset = record.offset();
//        int partition = record.partition();
//        String topic = record.topic();
//        long ts = record.timestamp();
//        System.out.println("====Consumed word: " + value + " from topic: " + topic + " with key: " + key + " and partition: " + partition + " and offset: " + offset + " and timestamp: " + ts);
//    }

//    @Incoming("word-channel")
//    public void consume(ConsumerRecord<String, String> record) {
//        String key = record.key();
//        String value = record.value();
//        long offset = record.offset();
//        int partition = record.partition();
//        String topic = record.topic();
//        long ts = record.timestamp();
//        System.out.println("====Consumed word: " + value + " from topic: " + topic + " with key: " + key + " and partition: " + partition + " and offset: " + offset + " and timestamp: " + ts);
//        record
//                .headers()
//                .forEach(header -> System.out.println("Header: " + header.key() + " = " + new String(header.value())));
//    }

//    @Incoming("word-channel")
//    public void consume(String word) {
//        System.out.println("====Consumed word: " + word);
//    }
}
