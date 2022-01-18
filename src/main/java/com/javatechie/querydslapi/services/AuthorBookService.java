package com.javatechie.querydslapi.services;

import com.javatechie.querydslapi.dto.AuthorStatistic;
import com.javatechie.querydslapi.entities.Author;
import com.javatechie.querydslapi.entities.Book;
import com.javatechie.querydslapi.repositories.AuthorRepository;
import com.javatechie.querydslapi.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorBookService {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public List<Author> saveAuthorsWithBooks(List<Author> authors){
        return authorRepository.saveAll(authors);
    }

    //  will find N+1 problem in hibernate/jpa
    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Optional<Author> findAuthorByEmail(String email){
        return authorRepository.findAuthorByEmail(email);
    }

    public List<AuthorStatistic> getAuthorStatistic(){
        return authorRepository.getAuthorStatistic();
    }

    //to avoid N+1 problem in hibernate/jpa
    public List<Author> getAuthorsWithFetchJoin(){
        return authorRepository.getAuthors();
    }

}
