package com.herbalife;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MockDB {
    public List<Company> companies = new ArrayList<>();

    @PostConstruct
    public void init() {
        Company company1 = new Company();
        company1.setId("101");
        company1.setName("Herbalife");
        company1.setCeo("John Agwunobi");
        company1.setHeadCount(8000);
        company1.setListed(true);
        companies.add(company1);

        Company company2 = new Company();
        company2.setId("201");
        company2.setName("Amway");
        company2.setCeo("Milind Pant");
        company2.setHeadCount(15000);
        company2.setListed(false);
        companies.add(company2);

        Company company3 = new Company();
        company3.setId("301");
        company3.setName("Avon");
        company3.setCeo("Angela Cretu");
        company3.setHeadCount(25000);
        company3.setListed(true);
        companies.add(company3);

        Company company4 = new Company();
        company4.setId("401");
        company4.setName("Natura");
        company4.setCeo("Roberto Marques");
        company4.setHeadCount(40000);
        company4.setListed(true);
        companies.add(company4);

        Company company5 = new Company();
        company5.setId("501");
        company5.setName("Oriflame");
        company5.setCeo("Gunnar Gislason");
        company5.setHeadCount(10000);
        company5.setListed(false);
        companies.add(company5);


    }

}
