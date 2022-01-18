package com.javatechie.querydslapi.repositories.impl;

import com.javatechie.querydslapi.dto.AuthorStatistic;
import com.javatechie.querydslapi.entities.Author;
import com.javatechie.querydslapi.repositories.AuthorRepository;
import com.querydsl.core.types.Projections;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class AuthorRepositoryImpl extends BaseRepositoryImpl<Author, Integer> implements AuthorRepository {

    public AuthorRepositoryImpl(EntityManager entityManager) {
        super(Author.class, entityManager);
    }

    @Override
    public Optional<Author> findAuthorByEmail(String email) {
        return Optional.ofNullable(jpaQueryFactory
                .select(qAuthor)
                .from(qAuthor)
                .where(qAuthor.email.equalsIgnoreCase(email))
                .fetchFirst());
    }

    @Override
    public List<AuthorStatistic> getAuthorStatistic() {
        return jpaQueryFactory.from(qAuthor)
                .innerJoin(qAuthor.books, qBook)
                .groupBy(qAuthor.name)
                .select(Projections.constructor(AuthorStatistic.class,
                        qAuthor.name, qBook.count()))
                .fetch();
    }

    // n + 1 resolvido
    @Override
    public List<Author> getAuthors() {
        return jpaQueryFactory
                .select(qAuthor)
                .distinct()
                .from(qAuthor)
                .innerJoin(qAuthor.books, qBook)
                .fetchJoin().fetch();
    }
}
