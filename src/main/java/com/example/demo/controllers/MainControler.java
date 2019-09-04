package com.example.demo.controllers;


import com.example.demo.models.User;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainControler {
    private ProductService productService;

    @Autowired
    public MainControler(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping({"/", "/home"})
    public String getListProduct(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("productList", productService.findAll());
        String userName = (user == null) ? "Anonymous" : user.getFirstName();
        request.getSession().setAttribute("name", userName);
        return "home";
    }

}
