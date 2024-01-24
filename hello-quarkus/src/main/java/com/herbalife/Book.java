package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class Book {
    String title;
    String author;

//    public Book(@ConfigProperty(defaultValue = "ABC") String title,
//                @ConfigProperty(defaultValue = "Joe") String author) {
//        this.title = title;
//        this.author = author;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
