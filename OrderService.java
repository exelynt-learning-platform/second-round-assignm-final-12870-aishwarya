package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.entity.OrderItem;
import com.example.demo.entity.CartItem;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {
	
	 @Autowired
	    private OrderRepository repo;

	    public Order createOrder(User user, Cart cart) {

	        Order order = new Order();
	        order.setUser(user);
			List<OrderItem> orderItems = new ArrayList<>();

	        double total = 0;
			for (CartItem cartItem : cart.getItems()) {
        OrderItem item = new OrderItem();
        item.setProduct(cartItem.getProduct());
        item.setQuantity(cartItem.getQuantity());
        item.setOrder(order);

        orderItems.add(item);

        total += cartItem.getProduct().getPrice() * cartItem.getQuantity();
    }

    order.setItems(orderItems);   
    order.setTotalPrice(total);
    order.setStatus("CREATED");

	        return repo.save(order);
}
}
