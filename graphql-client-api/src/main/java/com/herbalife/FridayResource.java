package com.herbalife;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import io.smallrye.graphql.client.GraphQLClient;
import io.smallrye.graphql.client.dynamic.api.DynamicGraphQLClient;
import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Path("/friday")
public class FridayResource {

    @Inject
    @GraphQLClient("company-api")
    DynamicGraphQLClient graphQLClient;

    @Inject
    CompanyApi companyApi;

    @GET
    @Path("/companies")
    public List<Company> getCompanies() {
        return companyApi.getAllCompanies();
    }

    @POST
    @Path("/companies")
    public Company addCompany(CompanyDto companyDto) {
        return companyApi.addCompany(companyDto);
    }

    @GET
    @Path("/companies/{name}")
    public Company getCompanyInfo(String name) {
        return companyApi.getCompanyInfo(name);
    }


    @GET
    @Path("/companiesDiffStyle")
    public JsonObject getCompaniesDifferentStyle() throws ExecutionException, InterruptedException {
        String query = """
                query {
                    companies {
                        id
                        name
                        ceo
                     }
                    startUps {
                        id
                        name
                        founder
                    }
                }
                """;
        return graphQLClient
                .executeSync(query)
                .getData();
    }

    @POST
    @Path("/companiesDiffStyle")
    public JsonObject addCompanyDifferentStyle(CompanyDto companyDto) throws ExecutionException, InterruptedException {
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
