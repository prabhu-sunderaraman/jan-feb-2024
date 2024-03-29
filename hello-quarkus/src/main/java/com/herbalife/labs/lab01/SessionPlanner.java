package com.herbalife.labs.lab01;


import io.smallrye.config.ConfigMapping;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Map;

@ApplicationScoped
@ConfigMapping(prefix = "session")
public interface SessionPlanner {
    Map<Integer, List<String>> topics();

    List<String> longDurationSessions();

    //In the configuration file it expects you to have is as topics-for60-min
    List<String> topicsFor60Min();

    List<String> topicsFor90Min();
    List<String> topicsFor45Min();

}
