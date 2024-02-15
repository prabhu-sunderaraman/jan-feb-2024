package com.herbalife;

import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
public class CompanyResource {

    @Inject
    private MockDB mockDB;

    @Query("companies")
    public List<Company> getAllCompanies() {
        //Ideally you will go to a REST API or DB to fetch the data
        return mockDB.companies;
    }
}
