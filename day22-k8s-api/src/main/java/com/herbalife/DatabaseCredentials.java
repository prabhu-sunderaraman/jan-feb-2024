package com.herbalife;

import io.smallrye.config.ConfigMapping;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ConfigMapping(prefix = "database")
public interface DatabaseCredentials {
    String url();
    String username();
    String password();
}
