package com.herbalife;

import io.smallrye.config.ConfigMapping;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
@ConfigMapping(prefix = "db")
public interface DbConstants {
    String host();

    int port();

    String username();

    String password();

    List<String> schemas();

}
