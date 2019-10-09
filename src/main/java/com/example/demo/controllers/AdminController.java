package com.example.demo.controllers;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;


@Controller
public class AdminController {
    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public AdminController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }


    @GetMapping("/admin")
    public String getListProduct(HttpServletRequest request, Model model) {

        model.addAttribute("prduct", new Product());
        System.out.println("");
        request.setAttribute("products", productService.findAll());
        model.addAttribute("categoryList", categoryService.findAll());
        return "th_admin";
    }

    @GetMapping("/category")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("categoryList", categoryService.findAll());
        return "th_addcategory";
    }

    @PostMapping("/category_edit/{id}")
    public String addCategory(@RequestParam String parents, @PathVariable String id) throws NotFoundException {
        Category category = categoryService.findById(Long.parseLong(id));
        category.setParents_id(Long.parseLong(parents));
        categoryService.addCategory(category);
        /* public String addCategory( @ModelAttribute Category category,String parents) throws NotFoundException {
        category.setParents_id(Long.parseLong(parents));*/
        System.out.println(categoryService.findById(Long.parseLong(id)).getName() + "--" + parents);
        return "redirect:/category";
    }

    @PostMapping("/adminAddCategory")
    public String categoryAdded(@ModelAttribute Category category) {
        categoryService.addCategory(category);
        return "redirect:/category";
    }

    @GetMapping("/menu")
    public String menu(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        return "th_menu";
    }

    @PostMapping("admin/delete/{id}")
    public String delete(@PathVariable String id, ServletRequest request) throws NotFoundException {
        categoryService.delCategory(categoryService.findById(Long.parseLong(id)));
        return "redirect:/category";
    }

    @PostMapping("admin_inc")
    public String incQuantityOfProduct(@ModelAttribute("inc") String id) throws NotFoundException {
        productService.editProductQuantity(productService.findById((Long.parseLong(id))), "inc");
        return "redirect:/admin";
    }

    @PostMapping("admin_dec")
    public String decQuantityOfProduct(@ModelAttribute("dec") String id) throws NotFoundException {
        productService.editProductQuantity(productService.findById((Long.parseLong(id))), "dec");
        return "redirect:/admin";
    }

    @PostMapping("editProduct")
    public String editProduct(@ModelAttribute("id") String id, Model model) throws NotFoundException {
        model.addAttribute("product", productService.findById(Long.parseLong(id)));
        model.addAttribute("categoryList", categoryService.findAll());
        return "th_editProduct";
    }

    @PostMapping("/editableAdmin")
    public String addEditedProduct(@ModelAttribute Product product, @ModelAttribute("cat") String cat) {
        product.setCategory(categoryService.getCategory(cat));
        productService.addProduct(product);
        return "redirect:/admin";
    }

    @RequestMapping(value = "admin_add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product, @ModelAttribute("cat") String category) {
        product.setCategory(categoryService.getCategory(category));
        productService.addProduct(product);
        return "redirect:/admin";
    }

    @PostMapping("admin_remove")
    public String removeProduct(@ModelAttribute("id") String id) throws NotFoundException {
        productService.removeProduct(productService.findById(Long.parseLong(id)));
        return "redirect:/admin";
    }

    @PostMapping("/product_cat_edit")
    public String changeCategory(@ModelAttribute("cat") String cat, @ModelAttribute("prductId") String prID) throws NotFoundException {
        Product product=productService.findById(Long.parseLong(prID));
        product.setCategory(categoryService.findById(Long.parseLong(cat)));
        productService.addProduct(product);
        return "redirect:/admin";
    }

    @GetMapping("ProductCat")
    public String getCategoryListProduct(ServletRequest req, @RequestParam String cat) {
        Long caty = Long.parseLong(cat);
        System.out.println("Category " + cat);
        req.setAttribute("categoryId", cat);
        req.setAttribute("productList", productService.findAll());
        req.setAttribute("categoryList", categoryService.findAll());
        return "/home";

    }
}


