package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
    private PaymentService service;

    @PostMapping("/create")
    public String pay(@RequestParam Double amount) throws Exception {
        return service.createPayment(amount);
}
}
