package com.masai.app.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.app.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	public Optional<Customer> findByEmail(String email);
}
