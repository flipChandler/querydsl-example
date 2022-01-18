package com.javatechie.querydslapi.repositories.impl;

import com.javatechie.querydslapi.entities.Book;
import com.javatechie.querydslapi.repositories.BookRepository;

import javax.persistence.EntityManager;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book, Integer> implements BookRepository {

    public BookRepositoryImpl(EntityManager entityManager) {
        super(Book.class, entityManager);
    }
}
