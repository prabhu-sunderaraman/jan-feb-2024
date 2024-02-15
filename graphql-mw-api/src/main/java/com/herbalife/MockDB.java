package com.herbalife;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MockDB {
    public List<Company> companies = new ArrayList<>();
    public List<StartUp> startUps = new ArrayList<>();
    public List<Library> libraries = new ArrayList<>();


    public MockDB() {
        Library library1 = new Library();
        library1.setName("Horror books Library");
        List<Book> library1BookList = new ArrayList<>();

        Book book1 = new Book();
        book1.setIsbn("1234");
        book1.setTitle("The Shining");
        library1BookList.add(book1);
        Person author1 = new Person();
        author1.setId("a1");
        author1.setName("Stephen King");
        City city1 = new City();
        city1.setId("c1");
        city1.setName("Bangalore");
        author1.setCity(city1);
        book1.setAuthor(author1);

        Book book2 = new Book();
        book2.setIsbn("1235");
        book2.setTitle("The Exorcist");
        Person author2 = new Person();
        author2.setId("a2");
        author2.setName("William Peter Blatty");
        City city2 = new City();
        city2.setId("c2");
        city2.setName("Mumbai");
        author2.setCity(city2);
        library1BookList.add(book2);

        library1.setBooks(library1BookList);

        Library library2 = new Library();
        library2.setName("Science Fiction books Library");
        List<Book> library2BookList = new ArrayList<>();
        Book book3 = new Book();
        book3.setIsbn("1236");
        book3.setTitle("Dune");
        library2BookList.add(book3);
        Person author3 = new Person();
        author3.setId("a3");
        author3.setName("Frank Herbert");
        City city3 = new City();
        city3.setId("c3");
        city3.setName("Chennai");
        city3.setCountry("India");
        author3.setCity(city3);
        book3.setAuthor(author3);
        library2.setBooks(library2BookList);
        libraries.add(library1);
        libraries.add(library2);


        StartUp startUp1 = new StartUp();
        startUp1.setId("a101");
        startUp1.setName("Skanray Technologies");
        startUp1.setFounder("Vishwaprasad Alva");
        startUp1.setYear(2007);
        startUp1.setFunding("Series C");
        startUps.add(startUp1);

        StartUp startUp2 = new StartUp();
        startUp2.setId("a201");
        startUp2.setName("CureFit");
        startUp2.setFounder("Mukesh Bansal");
        startUp2.setYear(2016);
        startUp2.setFunding("Series D");
        startUps.add(startUp2);

        StartUp startUp3 = new StartUp();
        startUp3.setId("a301");
        startUp3.setName("Unacademy");
        startUp3.setFounder("Gaurav Munjal");
        startUp3.setYear(2015);
        startUp3.setFunding("Series E");
        startUps.add(startUp3);

        StartUp startUp4 = new StartUp();
        startUp4.setId("a401");
        startUp4.setName("Zerodha");
        startUp4.setFounder("Nithin Kamath");
        startUp4.setYear(2010);
        startUp4.setFunding("Series F");
        startUps.add(startUp4);


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
