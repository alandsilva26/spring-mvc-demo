package com.alandsilva.demo.dao;

public interface GenericDao<T, ID> {

    Iterable<T> findAll();

    T findById();

    ID save();
}
