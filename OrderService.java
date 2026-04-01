package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {
	
	 @Autowired
	    private OrderRepository repo;

	    public Order createOrder(User user, Cart cart) {

	        Order order = new Order();
	        order.setUser(user);

	        double total = cart.getItems()
	                .stream()
	                .mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity())
	                .sum();

	        order.setTotalPrice(total);
	        order.setStatus("CREATED");

	        return repo.save(order);
}
}
