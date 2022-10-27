package com.alandsilva.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alandsilva.demo.dao.BrandDao;
import com.alandsilva.demo.dao.ProductDao;
import com.alandsilva.demo.dto.ProductCreationDto;
import com.alandsilva.demo.model.Brand;
import com.alandsilva.demo.model.Product;
import com.alandsilva.demo.service.ProductServiceImpl;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    BrandDao brandDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    ProductServiceImpl productServiceImpl;

    @GetMapping("")
    public String getProducts(Model model) {
        List<Product> products = (List<Product>) productDao.findAll();
        System.out.println(products);
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/add")
    public String getAddProducts(Model model) {
        List<Brand> brands = (List<Brand>) brandDao.findAll();
        model.addAttribute("brands", brands);
        return "addProduct";
    }

    @PostMapping("/add")
    public String postAddProducts(@ModelAttribute ProductCreationDto productCreationDto) {
        System.out.println(productCreationDto);
        productServiceImpl.createProduct(productCreationDto);
        return "redirect:/products";
    }
}
