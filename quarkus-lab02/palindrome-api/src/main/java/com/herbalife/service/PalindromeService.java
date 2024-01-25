package com.herbalife.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PalindromeService {

    public boolean isPalindrome(String word) {
        String reverse = new StringBuilder(word).reverse().toString();
        return word.equals(reverse);
    }
}
