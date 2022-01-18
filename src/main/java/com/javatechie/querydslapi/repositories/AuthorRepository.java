package com.javatechie.querydslapi.repositories;

import com.javatechie.querydslapi.dto.AuthorStatistic;
import com.javatechie.querydslapi.entities.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends BaseRepository<Author, Integer> {

    Optional<Author> findAuthorByEmail(String email);
    List<AuthorStatistic> getAuthorStatistic();
    List<Author> getAuthors();
}
