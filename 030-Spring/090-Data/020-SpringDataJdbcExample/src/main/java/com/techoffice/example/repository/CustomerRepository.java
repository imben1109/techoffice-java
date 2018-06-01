package com.techoffice.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techoffice.example.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>  {
	
	List<Customer> findAll();
	
}
