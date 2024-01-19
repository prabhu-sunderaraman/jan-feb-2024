package com.herbalife.labs;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLException;

import static com.herbalife.labs.Constants.*;

public class Lab10 {

    static ObjectMapper mapper = new ObjectMapper();
    static MovieApiUtil movieApiUtil = new MovieApiUtil();
    static MovieDbUtil movieDbUtil = new MovieDbUtil();

    public static void main(String[] args) {
        try {
            String movieName = System.getProperty("movieName"); //-DmovieName="The Matrix"
            String movieDetails = movieApiUtil.fetchMovieDetails(movieName);
            if (movieDetails.contains(MOVIE_NOT_FOUND)) {
                System.out.println(MOVIE_NOT_FOUND_MESSAGE.formatted(movieName));
                return;
            }
            Movie movie = mapper.readValue(movieDetails, Movie.class);
            System.out.println(movie);
            movieDbUtil.insertMovie(movie);
        } catch (IOException | InterruptedException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
