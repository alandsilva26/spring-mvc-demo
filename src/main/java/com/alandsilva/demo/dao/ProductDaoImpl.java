package com.alandsilva.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alandsilva.demo.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Iterable<Product> findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("from Product", Product.class)
                .list();
        session.close();
        return products;
    }

    @Override
    public Long save(Product entity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Long id = (Long) session.save(entity);
        session.close();
        return id;
    }

    @Override
    public Product findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Product entity) {
        // TODO Auto-generated method stub

    }

}