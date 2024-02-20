package com.herbalife;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.Duration;
import java.util.List;

@Path("/sample")
public class SampleResource {

    @Inject
    @RestClient
    HelloNodeJsApi helloNodeJsApi;

    @GET
    @Path("/{name}")
    public String getResponseFromNodeJsApi(String name) {
        //HttpClient and invoke the nodejs api
        return helloNodeJsApi.greetings(name) + ", " + helloNodeJsApi.bye(name);
    }


    @GET
    @Path("/stockpricesreactive")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<String> getStockPricesReactive() {
        //Not a good practice to block the thread
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        //call a db operation where they wait indefinitely
        System.out.println("********* Stock Prices Reactive called on thread " + Thread.currentThread().getName());
        List<String> symbols = List.of("AAPL", "GOOGL", "MSFT", "AMZN", "FB", "TSLA", "NVDA", "INTC", "CSCO", "ADBE");
        return Multi
                .createFrom()
                .items(symbols.stream())
                .onItem()
                .transformToUni(symbol -> Uni
                        .createFrom()
                        .item(symbol + " : " + Math.random() * 1000)
                        .onItem()
                        .delayIt()
                        .by(Duration.ofSeconds(1)))
                .concatenate();
    }

    @GET
    @Path("/stockprices")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public List<String> getStockPrices() {
        System.out.println("********* Stock Prices Reactive called on thread " + Thread.currentThread().getName());
        List<String> symbols = List.of("AAPL", "GOOGL", "MSFT", "AMZN", "FB", "TSLA", "NVDA", "INTC", "CSCO", "ADBE");
        return symbols
                .stream()
                .map(symbol -> {
                    //Let's assume it's going to take a second to compute the stock price as you are calling an external service
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return symbol + " : " + Math.random() * 1000;
                })
                .toList();
    }

    @GET
    @Path("/reactive")
    @NonBlocking //It means that the method is non-blocking and the thread is not blocked
    public String getReactiveResponse() {
        System.out.println("-======= Reactive Request called on thread " + Thread.currentThread().getName());
        String message = "Request called on thread " + Thread.currentThread().getName();
        return message;
    }

    @GET
    @Path("/nonreactive")
    //@Blocking
    public String getNonReactiveResponse() {
        //Long running task
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("****** Non reactive Request called on thread " + Thread.currentThread().getName());
        String message = "Request called on thread " + Thread.currentThread().getName();
        return message;
    }
}
