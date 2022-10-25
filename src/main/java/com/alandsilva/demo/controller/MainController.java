package com.alandsilva.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alandsilva.demo.model.Brand;

@Controller
public class MainController {

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/products")
    public ModelAndView allProducts() {
        Brand brand = new Brand();
        brand.setTitle("Test");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("products");
        mv.addObject("brand", brand);

        return mv;
    }
}
