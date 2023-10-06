package com.example.demo.Services;
/** services encapsulate the business logic.Methods perform specific operations on the data, **/


import com.example.demo.Models.Products;
import com.example.demo.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


// manages operations related to the Product
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Products getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Products saveProduct(Products products) {
        return productRepository.save(products);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}