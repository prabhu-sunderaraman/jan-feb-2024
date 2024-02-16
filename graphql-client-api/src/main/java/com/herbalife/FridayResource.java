package com.herbalife;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import io.smallrye.graphql.client.GraphQLClient;
import io.smallrye.graphql.client.dynamic.api.DynamicGraphQLClient;
import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.concurrent.ExecutionException;

@Path("/friday")
public class FridayResource {

    @Inject
    @GraphQLClient("company-api")
    DynamicGraphQLClient graphQLClient;

    @GET
    @Path("/companies")
    public JsonObject getCompanies() throws ExecutionException, InterruptedException {
        String query = """
                query {
                    companies {
                        id
                        name
                        ceo
                        headCount
                        listed
                    }
                }
                """;
        return graphQLClient
                .executeSync(query)
                .getData();
    }

    @POST
    @Path("/companies")
    public JsonObject addCompany(CompanyDto companyDto) throws ExecutionException, InterruptedException {
        String mutation = """
                mutation {
                    addCompany(company: {
                        id: "%s",
                        name: "%s",
                        ceo: "%s",
                        headCount: %d,
                        listed: %b
                    }) {
                        id
                        name
                        ceo
                        headCount
                        listed
                    }
                }
                """.formatted(companyDto.id(), companyDto.name(), companyDto.ceo(), companyDto.headCount(), companyDto.listed());

        return graphQLClient.executeSync(mutation).getData();
    }
}
