package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
    private ProductService service;

   
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return service.save(product);
    }
        @GetMapping
        public List<Product> getAllProducts() {
            return service.getAll();
        }

        @PutMapping("/{id}")
        public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
            return service.update(id, product);
        }

        @DeleteMapping("/{id}")
        public String deleteProduct(@PathVariable Long id) {
            service.delete(id);
            return "Product Deleted Successfully";
}
}
