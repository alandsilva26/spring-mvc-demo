package com.alandsilva.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alandsilva.demo.model.Brand;

@Repository
public class BrandDaoImpl implements BrandDao {

    @Autowired
    private SessionFactory sessionFactory;

    public BrandDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Iterable<Brand> findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Brand> brands = session.createQuery("from Brand", Brand.class).list();
        session.close();

        return brands;
    }

    @Override
    public Long save(Brand entity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Long id = (Long) session.save(entity);
        session.close();
        return id;
    }

    @Override
    public Brand findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<Brand> query = session.createQuery("FROM Brand WHERE brand_id = :brandId", Brand.class);
        query.setParameter("brandId", id);
        Brand brand = query.getSingleResult();
        session.close();
        return brand;
    }

    @Override
    public Brand findByTitle(String title) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<Brand> query = session.createQuery("FROM Brand WHERE title = :title", Brand.class);
        query.setParameter("title", title);
        Brand brand = query.getSingleResult();
        session.close();
        return brand;
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Brand WHERE brand_id = :brandId");
        query.setParameter("brandId", id);
        query.executeUpdate();
        session.close();
    }

    @Override
    public void update(Brand entity) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }
}
