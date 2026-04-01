package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	 @Autowired
	    private ProductRepository repo;

	    public Product save(Product p) {
	        return repo.save(p);
	    }

	    public List<Product> getAll() {
	        return repo.findAll();
	    }

	    public Product getById(Long id) {
	        return repo.findById(id).orElse(null);
	    }

	    public Product update(Long id, Product p) {
	        Product existing = repo.findById(id).orElse(null);
	        if (existing != null) {
	            existing.setName(p.getName());
	            existing.setDescription(p.getDescription());
	            existing.setPrice(p.getPrice());
	            existing.setStock(p.getStock());
	            existing.setImageUrl(p.getImageUrl());
	            return repo.save(existing);
	        }
	        return null;
	    }

	    public void delete(Long id) {
	        repo.deleteById(id);
	    }
	}
