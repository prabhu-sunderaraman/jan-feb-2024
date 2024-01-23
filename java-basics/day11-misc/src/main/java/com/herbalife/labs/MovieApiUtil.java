package com.herbalife.labs;

import java.io.IOException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.herbalife.labs.Constants.OMDB_API_BASE_URL;

public class MovieApiUtil {
    private HttpClient client = HttpClient.newHttpClient();

    public String fetchMovieDetails(String movieName) throws IOException, InterruptedException {
        movieName = URLEncoder.encode(movieName);
        String url = OMDB_API_BASE_URL.formatted(movieName);
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(java.net.URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
