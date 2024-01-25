package com.herbalife.config;

import io.smallrye.config.ConfigMapping;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ConfigMapping(prefix = "palindrome.api")
public interface PalindromeApiConfiguration {
    String server();

    int port();

    String basePath();

}
