package com.herbalife.handler;

import com.herbalife.dto.ErrorDto;
import com.herbalife.exception.TopicNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDateTime;

@Provider
public class TopicNotFoundExceptionHandler implements ExceptionMapper<TopicNotFoundException> {
    @Override
    public Response toResponse(TopicNotFoundException e) {
        String message = "Topic not found: %s".formatted(e.getMessage());
        ErrorDto errorDto = new ErrorDto(message, LocalDateTime.now().toString());
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(errorDto)
                .build();
    }
}
