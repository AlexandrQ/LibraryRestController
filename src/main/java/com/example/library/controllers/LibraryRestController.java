package com.example.library.controllers;

import com.example.library.models.Book;
import com.example.library.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class LibraryRestController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public Iterable<Book> all() {
        return bookRepository.findAll();
    }

    @PostMapping("/books")
    public Book updateBook(@RequestParam Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/books/{id}")
    public Book one(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("There is no book with id = " + id));
    }

    @PostMapping("/books/{id}")
    public Book replaceBook(@RequestBody Book newBook, @PathVariable Long id) {
        if(Objects.isNull(newBook) || Objects.isNull(id)) {
            throw new IllegalArgumentException("Params must not be null");
        }
        newBook.setId(id);
        return bookRepository.save(newBook);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

    @GetMapping("/books/publicCatalog")
    public Iterable<Book> publicCatalog() {
        return bookRepository.getAllFromPublicCatalog();
    }

    @GetMapping("/books/privateCatalog")
    public Iterable<Book> privateCatalog() {
        return bookRepository.getAllFromPrivateCatalog();
    }

    @PostMapping("/books/toPrivate/{id}")
    public Book toPrivate(@PathVariable Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("There is no book with id = " + id));
        book.setPublicCatalog(false);
        return bookRepository.save(book);
    }

    @PostMapping("/books/toPublic/{id}")
    public Book toPublic(@PathVariable Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("There is no book with id = " + id));
        book.setPublicCatalog(true);
        return bookRepository.save(book);
    }

}
