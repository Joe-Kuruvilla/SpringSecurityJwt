package com.masai.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.masai.app.Entity.Customer;
import com.masai.app.Repository.CustomerRepository;


@Service
public class CustomerService {
	@Autowired
	CustomerRepository rep;
	
	@Autowired
	PasswordEncoder encoder;
	
	public Customer registerCustomer(Customer customer) {
		customer.setPassword(encoder.encode(customer.getPassword()));
		return rep.save(customer);
	}
	
	public Customer getCustomerByEmail(String email) {
		return rep.findByEmail(email).orElse(null);
	}
	
	public List<Customer> getAllCustomer(){
		return rep.findAll();
	}
}

