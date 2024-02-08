package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class CalcConsumer {

    @Incoming("calc-channel")
    public void consume(ConsumerRecord<String, CalculatorDto> record) {
        CalculatorDto dto = record.value();
        String key = record.key();
        switch (key) {
            case "square" -> System.out.println("Square of " + dto.number() + " is " + dto.number() * dto.number());
            case "cube" ->
                    System.out.println("Cube of " + dto.number() + " is " + dto.number() * dto.number() * dto.number());
            default -> System.out.println("Invalid operation");
        }
    }
}
