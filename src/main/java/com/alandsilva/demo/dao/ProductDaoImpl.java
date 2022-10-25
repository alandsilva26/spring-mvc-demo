package com.alandsilva.demo.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alandsilva.demo.model.Product;

public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Iterable<Product> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Product findById() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long save() {
        // TODO Auto-generated method stub
        return null;
    }

}
