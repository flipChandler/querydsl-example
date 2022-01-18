package com.javatechie.querydslapi.repositories.impl;

import com.javatechie.querydslapi.entities.QAuthor;
import com.javatechie.querydslapi.entities.QBook;
import com.javatechie.querydslapi.repositories.BaseRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

public abstract class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    EntityManager em;
    JPAQueryFactory jpaQueryFactory;

    protected final QAuthor qAuthor = QAuthor.author;
    protected  final QBook qBook= QBook.book;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.em = entityManager;
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public T findByIdMandatory(ID id) throws IllegalArgumentException {
        return findById(id)
                .orElseThrow(()->new IllegalArgumentException("entity not found with id " + id));
    }
}
