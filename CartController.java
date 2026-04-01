package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	
	 @Autowired
	    private CartService cartService;

	    @Autowired
	    private ProductService productService;

	    @Autowired
	    private UserRepository userRepo;   

	    @PostMapping("/add")
	    public Cart addToCart(@RequestParam Long productId,
	                          @RequestParam int qty) 
	    {
			String username = SecurityContextHolder.getContext()
                      .getAuthentication().getName();

	        User user = userRepo.findByUsername(username);

	        Product product = productService.getById(productId); 

	        return cartService.addToCart(user, product, qty);
	    }
}
