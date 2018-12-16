package com.springstore.controllers;

import com.springstore.models.Book;
import com.springstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "/Books")
    public List<Book> getAllBooks () {
        return (List<Book>) bookRepository.findAll();
    }

    @PostMapping(value = "/Book")
    public Book newBook (@RequestBody Book newBook) {
        return bookRepository.save(newBook);
    }

    @GetMapping(value = "/Book")
    public Book getBook(@RequestParam Long bookId) {
        Optional<Book> book =bookRepository.findById(bookId);
        if (book.isPresent()){
            return book.get();
        }
        return null;
    }
}
