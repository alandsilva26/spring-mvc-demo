package com.alandsilva.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alandsilva.demo.dao.BrandDao;
import com.alandsilva.demo.dao.ProductDao;
import com.alandsilva.demo.dto.ProductCreationDto;
import com.alandsilva.demo.model.Brand;
import com.alandsilva.demo.model.Product;

@Service
public class ProductServiceImpl {

    @Autowired
    private BrandDao brandDao;
    @Autowired
    private ProductDao productDao;

    public void createProduct(ProductCreationDto productCreationDto) {
        Brand brand = null;
        System.out.println(productCreationDto.brandTitle);
        brand = brandDao.findByTitle(productCreationDto.brandTitle);
        if (brand == null) {
            brand = new Brand(productCreationDto.brandTitle);
            Long id = brandDao.save(brand);
            brand.setBrandId(id);
        }
        Product product = new Product();
        product.setBrand(brand);
        product.setTitle(productCreationDto.title);
        product.setPrice(productCreationDto.price);
        product.setQuantity(productCreationDto.quantity);

        System.out.println(product);
        productDao.save(product);
    }
}