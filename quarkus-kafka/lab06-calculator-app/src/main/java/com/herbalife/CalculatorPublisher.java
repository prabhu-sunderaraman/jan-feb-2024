package com.herbalife;

import io.quarkus.scheduler.Scheduled;
import io.smallrye.reactive.messaging.kafka.api.OutgoingKafkaRecordMetadata;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;

@ApplicationScoped
public class CalculatorPublisher {
    @Inject
    @Channel("calc-channel")
    Emitter<CalculatorDto> emitter;

    @Scheduled(every = "5s")
    public void generateNumberForComputingSquare() {
        int number = (int) (Math.random() * 1000);
        publish("square", new CalculatorDto(number));
    }

    @Scheduled(every = "10s")
    public void generateNumberForComputingCube() {
        int number = (int) (Math.random() * 1000);
        publish("cube", new CalculatorDto(number));
    }

    public void publish(String key, CalculatorDto calculatorDto) {
        //We will change this to use serializer later
//        String json = """
//                {
//                    "number": %d
//                }
//                """.formatted(calculatorDto.number());
        OutgoingKafkaRecordMetadata<Object> metadata = OutgoingKafkaRecordMetadata.builder()
                .withKey(key)
                .build();
        Message<CalculatorDto> message = Message.of(calculatorDto).addMetadata(metadata);
        emitter.send(message);
    }

}
