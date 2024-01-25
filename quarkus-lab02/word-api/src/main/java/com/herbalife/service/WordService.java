package com.herbalife.service;

import com.herbalife.config.PalindromeApiConfiguration;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@ApplicationScoped
public class WordService {
    @Inject
    private PalindromeApiConfiguration palindromeApiConfiguration;

    private String palindromeApiUrl;

    @PostConstruct
    public void init() {
        palindromeApiUrl = "http://" + palindromeApiConfiguration.server() + ":" + palindromeApiConfiguration.port() + palindromeApiConfiguration.basePath() + "/%s";
    }

    @Inject
    private HttpClient httpClient;

    public String isPalindrome(String word) throws IOException, InterruptedException {
        String url = palindromeApiUrl.formatted(URLEncoder.encode(word));
        String response = httpClient.send(
                HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .GET()
                        .build(),
                HttpResponse.BodyHandlers.ofString()
        ).body();
        return Boolean.parseBoolean(response) ? word + " is a palindrome" : word + " is not a palindrome";

    }
}
