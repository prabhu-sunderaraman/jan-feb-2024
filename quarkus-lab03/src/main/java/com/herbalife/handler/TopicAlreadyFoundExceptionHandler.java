package com.herbalife.handler;

import com.herbalife.dto.ErrorDto;
import com.herbalife.exception.TopicAlreadyFoundException;
import com.herbalife.exception.TopicNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDateTime;

@Provider
public class TopicAlreadyFoundExceptionHandler implements ExceptionMapper<TopicAlreadyFoundException> {
    @Override
    public Response toResponse(TopicAlreadyFoundException e) {
        String message = "Topic already exists: %s".formatted(e.getMessage());
        ErrorDto errorDto = new ErrorDto(message, LocalDateTime.now().toString());
        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(errorDto)
                .build();
    }
}
