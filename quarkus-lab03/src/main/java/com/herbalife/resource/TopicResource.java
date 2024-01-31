package com.herbalife.resource;

import com.herbalife.dto.TopicInputDto;
import com.herbalife.dto.TopicOutputDto;
import com.herbalife.service.ConferenceService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/topics")
public class TopicResource {

    @Inject
    private ConferenceService conferenceService;

    @GET
    public List<TopicOutputDto> getAllTopics() {
        return conferenceService.getAllTopics();
    }

    @DELETE
    public Response removeTopic(@QueryParam("title") String title) {
        conferenceService.removeTopic(title);
        return Response.noContent().build();
    }

    @POST
    public Response addTopic(TopicInputDto topicInputDto) {
        conferenceService.addTopic(topicInputDto.title(), topicInputDto.duration());
        return Response.ok().build();
    }
}
