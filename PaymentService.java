package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;

@Service
public class PaymentService {

	 @Value("${stripe.secret.key}")
	    private String secretKey;

	    public String createPayment(Double amount) throws Exception {

	        Stripe.apiKey = secretKey;

	        Map<String, Object> params = new HashMap<>();
	        params.put("amount", (int) (amount * 100)); 
	        params.put("currency", "inr");

	        PaymentIntent intent = PaymentIntent.create(params);

	        return intent.getClientSecret();
}
}
