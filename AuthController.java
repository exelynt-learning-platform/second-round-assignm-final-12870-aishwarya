package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	 @Autowired
	    private AuthService service;

	    @PostMapping("/register")
	    public String register(@RequestBody RegisterRequest req) {
	        return service.register(req);
	    }

	    @PostMapping("/login")
	    public String login(@RequestBody LoginRequest req) {
	        return service.login(req);
	
}
}
