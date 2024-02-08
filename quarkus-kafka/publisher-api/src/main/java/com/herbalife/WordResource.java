package com.herbalife;

import io.smallrye.reactive.messaging.kafka.api.OutgoingKafkaRecordMetadata;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;

import java.util.List;
import java.util.stream.IntStream;

@Path("/word")
public class WordResource {
    @Inject
    @Channel("word-channel")
    Emitter<String> wordEmitter;


    @POST
    @Path("/{word}")
    public String sendWord(@PathParam("word") String word) {
        IntStream.range(0, 5).forEach(i -> {
            wordEmitter.send(word + i);
        });
        return "Word %s send to kafka".formatted(word);
    }

//    @POST
//    @Path("/{word}")
//    public String sendWord(@PathParam("word") String word) {
//        Message<String> message = Message.of(word);
//        List<RecordHeader> headers = List.of(
//                new RecordHeader("header1", "value1".getBytes()),
//                new RecordHeader("header2", "value2".getBytes())
//        );
//        OutgoingKafkaRecordMetadata<Object> metadata = OutgoingKafkaRecordMetadata.builder()
//                .withKey("key1212")
//                .withHeaders(headers)
//                .build();
//        wordEmitter.send(message.addMetadata(metadata));
//        return "Word %s send to kafka".formatted(word);
//    }

//    @POST
//    @Path("/{word}")
//    public String sendWord(@PathParam("word") String word) {
//        wordEmitter.send(word);
//        return "Word %s send to kafka".formatted(word);
//    }
}
