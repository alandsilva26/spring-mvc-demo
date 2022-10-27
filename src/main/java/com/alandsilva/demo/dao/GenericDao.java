package com.alandsilva.demo.dao;

public interface GenericDao<T, ID> {

    Iterable<T> findAll();

    ID save(T entity);

    T findById(ID id);

    void deleteById(ID id);

    void update(T entity);
}
