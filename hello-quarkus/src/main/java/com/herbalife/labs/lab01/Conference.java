package com.herbalife.labs.lab01;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class Conference {
    @Inject
    SessionPlanner sessionPlanner;

    public List<String> getTopics(int minutes) {
        return sessionPlanner.topics().get(minutes);
    }
}
