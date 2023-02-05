package com.masai.app.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.Entity.Customer;


@RestController
@RequestMapping
public class CustomerController {
	@Autowired
	CustomerService custService;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer){
		return new ResponseEntity<>(custService.registerCustomer(customer),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customer/{email}")
	public ResponseEntity<Customer> findCustomerbyEmail(@PathVariable String email){
		return new ResponseEntity<>(custService.getCustomerByEmail(email),HttpStatus.OK);
	}
	
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> findAllCustomers(){
		return new ResponseEntity<>(custService.getAllCustomer(),HttpStatus.OK);
	}
}
