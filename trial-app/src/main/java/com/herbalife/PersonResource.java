package com.herbalife;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Path("/persons")
public class PersonResource {
    @Inject
    PersonService personService;

    @POST
    public Uni<Person> createPerson(Person person) {
        Uni<Person> personUni = personService.createPerson(person);
        return personUni;
    }

//    @GET
//    //@Blocking
//    public Uni<List<Person>> getPersons() {
//        return personService.getPersons();
//    }

    @GET
    @Blocking
    public List<Person> getPersons() {
        //convert Uni<List<Person>> to List<Person> without using await
//        List<Person> list = new ArrayList<>();
//        personService.getPersons().subscribe().with(l -> list.addAll(l));
//        return list;

        return personService.getPersons()
                .emitOn(Infrastructure.getDefaultExecutor())
                .await().asOptional().atMost(Duration.ofSeconds(5)).get();
                //.indefinitely();

//        return personService.getPersons().runSubscriptionOn(e -> {
//            System.out.println("====== getPersons subscribed on " + Thread.currentThread().getName());
//            Infrastructure.getDefaultExecutor();
//        }).emitOn(e -> {
//            System.out.println("====== getPersons emitted on " + Thread.currentThread().getName());
//            Infrastructure.getDefaultExecutor();
//        }).onItem().transform(l -> {
//            System.out.println("====== getPersons transformed on " + Thread.currentThread().getName());
//            return l;
//        });

    }

    @GET
    @Path("/stocks")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public List<String> getCurrentMarketPriceOfStocks() {
        List<String> stocks = List.of("AAPL", "GOOG", "TSLA", "AMZN", "MSFT", "FB", "NFLX", "ORCL", "IBM", "INTC");
        return stocks
                .stream()
                .map(stock -> {
                    //Ideally this should be a call to a remote service
                    String stockPrice = stock + " : " + (Math.random() * 1000);
                    try {
                        Thread.sleep(1000); //Induce a delay
                    } catch (InterruptedException e) {
                    }
                    return stockPrice;
                })
                .toList();
    }

    @GET
    @Path("/stocks-reactive")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<String> getCurrentMarketPriceOfStocksReactive() {
        List<String> stocks = List.of("AAPL", "GOOG", "TSLA", "AMZN", "MSFT", "FB", "NFLX", "ORCL", "IBM", "INTC");
        return Multi
                .createFrom()
                .items(stocks.stream())
                .onItem()
                .transformToUni(value -> Uni
                        .createFrom()
                        .item(value + " : " + (Math.random() * 1000))
                        .onItem()
                        .delayIt()
                        .by(Duration.ofSeconds(1)))
                .concatenate();
    }
}
