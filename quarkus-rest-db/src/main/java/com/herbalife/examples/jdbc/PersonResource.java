package com.herbalife.examples.jdbc;

import jakarta.inject.Inject;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("/persons-jdbc")
public class PersonResource {

    @Inject
    DataSource dataSource; //Collection of connections to the database

    @GET
    public List<String> getFirstNames() {
        List<String> names = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()) {
            String sql = "select first_name from persons";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs =  statement.executeQuery();
            while(rs.next()) {
                names.add(rs.getString("first_name"));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return names;
    }

    @POST
    public String createPerson(@FormParam("firstName") String firstName,
                               @FormParam("lastName") String lastName,
                               @FormParam("age") int age) throws SQLException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            String sql = "insert into persons(first_name, last_name, age) values (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return "Person created";
    }
}
