package com.alandsilva.demo.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.Data;

@Data
class Numbers {
    private int num1;
    private int num2;

    public Numbers() {

    }

    public Numbers(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int add() {
        return num1 + num2;
    }
}

@Controller
public class MainController {

    @Autowired
    LocalSessionFactoryBean sessionFactory;

    @RequestMapping("/")
    public ModelAndView index() {
        String test = "lemon potter";
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("test", test);
        return mv;
    }

    @GetMapping("/add")
    public String addForm(Model mv) {
        return "add";
    }

    @PostMapping("/add")
    public ModelAndView postAddForm(@ModelAttribute("numbers") Numbers numbers) {
        System.out.println("HERE" + numbers);
        ModelAndView mv = new ModelAndView();
        mv.addObject("sumTest", numbers.add());
        mv.setViewName("add");
        return mv;
    }
}
