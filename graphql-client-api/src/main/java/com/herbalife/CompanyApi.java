package com.herbalife;

import io.smallrye.graphql.client.typesafe.api.GraphQLClientApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLClientApi(configKey = "company-api")
public interface CompanyApi {

    @Query("companies")
    List<Company> getAllCompanies();

    @Mutation("addCompany")
    Company addCompany(CompanyDto companyDto);

    @Query("companyInfo")
    Company getCompanyInfo(String name);
}
