package com.herbalife.labs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class Lab11 {
    static MovieApiUtil movieApiUtil = new MovieApiUtil();
    static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("./movies.txt"));

        ForkJoinPool forkJoinPool = new ForkJoinPool(80);
        forkJoinPool.submit(() -> {
            lines
                    .parallelStream()
                    .map(Lab11::fetchMovieDetails)
                    .map(Lab11::parseMovie)
                    .collect(Collectors.groupingBy(Movie::response))
                    .forEach(Lab11::printMovieDetails);
        });
        Thread.sleep(10000);
    }

    private static void printMovieDetails(String response, List<Movie> movies) {
        if (response.equals("False")) {
            System.out.println("******Failed to fetch movie details for:*******");
            movies.forEach(movie -> System.out.println(movie.error()));
        } else {
            System.out.println("Fetched movie details for:");
            movies.forEach(movie -> System.out.println(movie));
        }
    }

    private static Movie parseMovie(String movieDetails) {
        Movie movie = null;
        try {
            movie = objectMapper.readValue(movieDetails, Movie.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            movie = new Movie(null, null, null, "False", "Failed to parse movie details " + e.getMessage());
        }
        return movie;
    }

    static String fetchMovieDetails(String movieName) {
        System.out.println("Fetching movie details for: " + movieName + " on " + Thread.currentThread().getName());
        String movieDetails = null;
        try {
            movieDetails = movieApiUtil.fetchMovieDetails(movieName);
            if (movieDetails.contains("Movie not found!")) {
                movieDetails = movieDetails.replace("Movie not found!", "%s not found!".formatted(movieName));
            }
        } catch (Exception e) {
            e.printStackTrace();
            movieDetails = "{\"Title\": \"%s\", \"Response\": \"False\"}".formatted(movieName);
        }
        return movieDetails;
    }
}
