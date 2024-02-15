package com.herbalife;

import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
public class LibraryResource {
    @Inject
    private MockDB mockDB;

    @Query("libraries")
    public List<Library> getLibraries() {
        return mockDB.libraries;
    }
}
