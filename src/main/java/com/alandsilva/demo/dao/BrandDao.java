package com.alandsilva.demo.dao;

import com.alandsilva.demo.model.Brand;

public interface BrandDao extends GenericDao<Brand, Long> {

    Brand findByTitle(String title);
}
