package com.masai.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.Entity.Customer;
import com.masai.app.Repository.CustomerRepository;

@RestController
@RequestMapping
public class AuthenticationController {
	@Autowired
	CustomerRepository rep;

	@PostMapping("/signin")
	public ResponseEntity<Customer> signup(Authentication auth) throws Exception {
		Customer customer = rep.findByEmail(auth.getName())
				.orElseThrow(() -> new Exception("Invalid Username or passowrd"));
		return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
	}
}
