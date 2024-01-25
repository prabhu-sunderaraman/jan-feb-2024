package com.herbalife.resource;

import com.herbalife.service.PalindromeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/palindrome")
public class PalindromeResource {
    @Inject
    PalindromeService palindromeService;

    @GET
    @Path("/{word}")
    public boolean isPalindrome(@PathParam("word") String word) {
        return palindromeService.isPalindrome(word);
    }
}
