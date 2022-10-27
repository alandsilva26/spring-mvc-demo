package com.alandsilva.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alandsilva.demo.dao.BrandDao;
import com.alandsilva.demo.model.Brand;

@Controller
@RequestMapping(path = "/brands")
public class BrandController {

    @Autowired
    private BrandDao brandDao;

    public BrandController(BrandDao brandDao) {
        this.brandDao = brandDao;
    }

    @GetMapping("")
    public String getBrandsTest() {
        return "redirect:/brands/";
    }

    @GetMapping("/")
    public String getBrands(Model model) {
        List<Brand> brands = (List<Brand>) brandDao.findAll();
        model.addAttribute("brands", brands);
        return "brands";
    }

    @PostMapping("/")
    public String addBrand(@ModelAttribute Brand brand) {
        brandDao.save(brand);
        return "redirect:/brands/";
    }

    @PostMapping("/delete")
    public String deleteBrand(@ModelAttribute Brand brand) {
        brandDao.deleteById(brand.getBrandId());
        return "redirect:/brands/";
    }

    @GetMapping("/edit")
    public String showEditBrand(@RequestParam("brandId") Long brandId, Model model) {
        Brand brand = brandDao.findById(brandId);
        model.addAttribute("editingMode", true);
        model.addAttribute("editBrand", brand);
        return "brands";
    }

    @PostMapping("/edit")
    public String editBrand(@ModelAttribute Brand brand) {
        System.out.println("HERE" + brand);
        brandDao.update(brand);
        return "redirect:/brands/";
    }
}