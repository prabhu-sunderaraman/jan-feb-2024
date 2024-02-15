package com.herbalife;

import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
public class CompanyResource {

    @Inject
    private MockDB mockDB;


    @Query("companyInfo")
    public Company getCompanyInfo(@Name("name") String name) {
        //Ideally you will go to a REST API or DB to fetch the data
        return mockDB.companies
                .stream()
                .filter(company -> company.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Query("startUps")
    public List<StartUp> getAllStartUps() {
        //Ideally you will go to a REST API or DB to fetch the data
        return mockDB.startUps;
    }

    @Query("listedCompanies")
    public List<Company> getAllListedCompanies(@Name("listed") boolean listed) {
        //Ideally you will go to a REST API or DB to fetch the data
        return mockDB
                .companies
                .stream().filter(company -> company.isListed() == listed)
                .toList();
    }

    @Query("companies")
    public List<Company> getAllCompanies() {
        //Ideally you will go to a REST API or DB to fetch the data
        return mockDB.companies;
    }
}
