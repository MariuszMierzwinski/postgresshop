package com.example.demo.services;

import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(Long id) throws NotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("There is not Product"));
    }

    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        productRepository.findAll().forEach(list::add);
        return list;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void removeProduct(Product product) {
        productRepository.delete(product);
    }

    public Product editProductQuantity(Product product, String act) {
        Product editProduct = productRepository.findById(product.getId()).get();
        if ("dec".equalsIgnoreCase(act)) {
            editProduct.setQuantity(product.getQuantity() - 1);
        } else {
            editProduct.setQuantity(product.getQuantity() + 1);
        }
        productRepository.save(editProduct);
        return editProduct;
    }


}
