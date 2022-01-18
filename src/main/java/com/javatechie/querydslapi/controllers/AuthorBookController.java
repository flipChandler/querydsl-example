package com.javatechie.querydslapi.controllers;

import com.javatechie.querydslapi.dto.AuthorStatistic;
import com.javatechie.querydslapi.entities.Author;
import com.javatechie.querydslapi.entities.Book;
import com.javatechie.querydslapi.services.AuthorBookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
@AllArgsConstructor
public class AuthorBookController {

    private AuthorBookService authorBookService;

    @PostMapping("/authors/book")
    public List<Author> saveAuthorsWithBooks(@RequestBody List<Author> authors) {
        return authorBookService.saveAuthorsWithBooks(authors);
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorBookService.getAuthors();
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return authorBookService.getBooks();
    }

    @GetMapping("/author/email")
    public Optional<Author> findAuthorByEmail(@RequestParam("email") String email) {
        return authorBookService.findAuthorByEmail(email);
    }

    @GetMapping("/author-statistic")
    public List<AuthorStatistic> getAuthorStatistic() {
        return authorBookService.getAuthorStatistic();
    }

    //to avoid N+1 problem in hibernate/jpa
    @GetMapping("/authors/fetch-join")
    public List<Author> getAuthorsWithFetchJoin() {
        return authorBookService.getAuthorsWithFetchJoin();
    }
}
