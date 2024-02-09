package com.herbalife;

import io.smallrye.reactive.messaging.kafka.api.OutgoingKafkaRecordMetadata;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;

@Path("/orders")
public class OrderResource {
    @Inject
    @Channel("orders-channel")
    Emitter<String> orderEmitter;

    @POST
    public String createOrder(@QueryParam("key") String key, @QueryParam("order") String order) {
        //NOT RECOMMENDED FOR PRODUCTION
        //You can come with a better way to determine the partition
        int partition = 3;
        if (key == null || key.isBlank()) {
            partition = 0;
        } else if (key.length() >= 0 && key.length() <= 3) {
            partition = 1;
        } else if (key.length() > 3 && key.length() <= 8) {
            partition = 2;
        }


        OutgoingKafkaRecordMetadata<Object> metadata = OutgoingKafkaRecordMetadata.builder()
                .withKey(key)
                .withPartition(partition)
                .build();
        Message<String> message = Message.of(order).addMetadata(metadata);
        orderEmitter.send(message);
        return "Order %s sent to Kafka in partition %d".formatted(order, partition);
    }
}
