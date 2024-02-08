package com.herbalife;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalcDeserializer extends ObjectMapperDeserializer<CalculatorDto> {
    public CalcDeserializer() {
        super(CalculatorDto.class);
    }
}
