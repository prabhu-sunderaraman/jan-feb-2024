package com.herbalife.resource;

import com.herbalife.service.WordService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.io.IOException;

@Path("/word")
public class WordResource {
    @Inject
    private WordService wordService;

    @GET
    @Path("/palindrome/{word}")
    public String isPalindrome(@PathParam("word") String word) throws IOException, InterruptedException {
        return wordService.isPalindrome(word);
    }
}
