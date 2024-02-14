package com.herbalife;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/books")
public class BookResource {
    @Inject
    BookService bookService;

    @POST
    public void addBook(Book book) {
        bookService.addBook(book);
    }

    @GET
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @DELETE
    public void deleteBooks(@QueryParam("title") String title) {
        bookService.deleteBooks(title);
    }

    @PUT
    public void updatePrice(Book book) {
        bookService.updatePrice(book);
    }

}
