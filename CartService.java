package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.CartItem;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.repository.CartRepository;

@Service
public class CartService {
	 @Autowired
	    private CartRepository cartRepo;

	    public Cart addToCart(User user, Product product, int qty) {

	        Cart cart = cartRepo.findByUser(user);

	        if (cart == null) {
	            cart = new Cart();
	            cart.setUser(user);
	            cart.setItems(new ArrayList<>());  
	        }

	        if (cart.getItems() == null) {
	            cart.setItems(new ArrayList<>());
	        }

	        CartItem item = new CartItem();
	        item.setProduct(product);
	        item.setQuantity(qty);
	        item.setCart(cart);

	        cart.getItems().add(item);

	        return cartRepo.save(cart);
	    }
	    public Cart getCartByUser(User user) {
	        return cartRepo.findByUser(user);
	    }
	}