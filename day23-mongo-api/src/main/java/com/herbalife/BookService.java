package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookService {
    @Inject
    BookRepository bookRepository;

    public void addBook(Book book) {
        bookRepository.persist(book);
    }

    public List<Book> getBooks() {
        return bookRepository.listAll();
    }

    public void deleteBooks(String title) {
        bookRepository.delete("title", title);
    }

    public void updatePrice(Book book) {
        Optional<Book> bookOptional =
                bookRepository
                        .find("title", book.getTitle())
                        .firstResultOptional();
        if (bookOptional.isPresent()) {
            Book bookToUpdate = bookOptional.get();
            bookToUpdate.setPrice(book.getPrice());
            bookRepository.update(bookToUpdate);
        }
    }
}
