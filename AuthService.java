package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class AuthService {
	
	 @Autowired
	    private UserRepository repo;
	       @Autowired
           private JwtUtil jwtUtil;

	    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	    public String register(RegisterRequest req) {

	        User user = new User();
	        user.setUsername(req.getUsername());
	        user.setPassword(encoder.encode(req.getPassword()));
	        user.setRole("ROLE_USER");

	        repo.save(user);

	        return "User Registered Successfully";
	    }

	    public String login(LoginRequest req) {

	        User user = repo.findByUsername(req.getUsername());

	        if (user != null && encoder.matches(req.getPassword(), user.getPassword())) {
	            return jwtUtil.generateToken(user.getUsername());
	            
	        }

	        return "Invalid Credentials";
	    }
}
	    


