package com.herbalife;

import io.quarkus.kafka.client.serialization.ObjectMapperSerializer;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyCalcSerializer extends ObjectMapperSerializer<CalculatorDto> {
    public MyCalcSerializer() {
        super();
    }
}
