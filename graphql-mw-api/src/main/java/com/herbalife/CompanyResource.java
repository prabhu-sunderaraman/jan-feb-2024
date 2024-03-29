package com.herbalife;

import io.smallrye.graphql.api.Subscription;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.operators.multi.processors.BroadcastProcessor;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
public class CompanyResource {

    @Inject
    private MockDB mockDB;

    private BroadcastProcessor<Company> addCompanyBroadcastProcessor = BroadcastProcessor.create();

    @Subscription("onCompanyAdded")
    public Multi<Company> onCompanyAdded() {
        return addCompanyBroadcastProcessor;
    }

    @Mutation("addCompany")
    public Company addCompany(@Name("company") Company company) {
        //Ideally you will go to a REST API or DB to fetch the data
        if (mockDB.companies.stream().anyMatch(c -> c.getId().equals(company.getId()))) {
            throw new RuntimeException("Company with id " + company.getId() + " already exists");
        }
        if (mockDB.companies.stream().anyMatch(c -> c.getName().equals(company.getName()))) {
            throw new RuntimeException("Company with name " + company.getName() + " already exists");
        }
        mockDB.companies.add(company);
        addCompanyBroadcastProcessor.onNext(company);
        return company;
    }

    @Mutation("removeCompany")
    public boolean removeCompany(@Name("name") String name) {
        //Ideally you will go to a REST API or DB to fetch the data
        Company companyToBeRemoved = mockDB.companies
                .stream()
                .filter(company -> company.getName().equals(name))
                .findFirst()
                .orElse(null);
        if (companyToBeRemoved != null) {
            mockDB.companies.remove(companyToBeRemoved);
        }
        return companyToBeRemoved != null;
    }

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
