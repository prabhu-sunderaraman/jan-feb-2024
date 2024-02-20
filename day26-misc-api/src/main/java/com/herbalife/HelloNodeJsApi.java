package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@ApplicationScoped
@RegisterRestClient(configKey = "hello-api")
public interface HelloNodeJsApi {
    @GET
    @Path("/hello/{name}")
    String greetings(@PathParam("name") String name);

    @POST
    @Path("/bye/{name}")
    String bye(@PathParam("name") String name);
}
