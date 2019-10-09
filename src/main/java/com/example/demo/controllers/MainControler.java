package com.example.demo.controllers;


import com.example.demo.models.User;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MainControler {
    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public MainControler(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping({"/", "/home"})
    public String getListProduct(HttpServletRequest request, ServletRequest req) {
        User user = (User) request.getSession().getAttribute("user");
        System.out.println(req.getAttribute("categoryId"));
       Long id =  (Long)req.getAttribute("categoryId");
        request.setAttribute("productList", productService.findAll());
        request.setAttribute("categoryList",categoryService.findAll());
        System.out.println("home id="+id);
        if (id != null) {
            request.setAttribute("categoryId", id);
        } else {
            request.setAttribute("categoryId", 0);
        }
    /*    String userName = (user == null) ? "Anonymous" : user.getFirstName();
        request.getSession().setAttribute("name", userName);*/
        return "home";
    }

}
