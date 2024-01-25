package com.herbalife.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;

import java.net.http.HttpClient;

public class BeansConfiguration {
    @Produces
    @ApplicationScoped
    public HttpClient httpClient() {
        //You can configure SSL headers here
        return HttpClient
                .newBuilder()
                .build();
    }
}
