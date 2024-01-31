package com.herbalife.exception;

public class TopicAlreadyFoundException extends RuntimeException {
    public TopicAlreadyFoundException(String message) {
        super(message);
    }
}
