package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.service.CartService;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	 @Autowired
	    private OrderService orderService;

	    @Autowired
	    private CartService cartService;
	@Autowired
    private UserRepository userRepo;

	    @PostMapping("/create")
	    public Order createOrder
	    {
			String username = SecurityContextHolder
            .getContext()
            .getAuthentication()
            .getName();
	        User user = cartService.getCartByUsername(username);

	        if (cart == null) 
	        {  
	            throw new RuntimeException("User not found");
	        }
           Cart cart = cartService.getCartByUser(user);
			if (cart == null) {
        throw new RuntimeException("Cart is empty");
    }
	        return orderService.createOrder(user, cart);
	}
	}

