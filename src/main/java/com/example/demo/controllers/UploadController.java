package com.example.demo.controllers;


import com.example.demo.models.Product;
import com.example.demo.services.ProductService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {
    private ProductService productService;

    @Autowired
    public UploadController(ProductService productService) {
        this.productService = productService;
    }

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "/home/mariusz/Documents/POSTGRES2/src/main/webapp/Picture/";


    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes, @ModelAttribute("product_id") String id) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:admin";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            System.out.println("ok" + file.getOriginalFilename() + " Pro " + path.toString()+"##"+UPLOADED_FOLDER);

                Product editedProduct = productService.findById(Long.parseLong(id));
                editedProduct.setPicture("/Picture/" + path.getFileName().toString());
                productService.addProduct(editedProduct);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException | NotFoundException e) {
            e.printStackTrace();
        }

        return "redirect:/admin";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

}