package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerService service;
	
	@GetMapping("/customers")
	public List<Customer> listCustomers(){
		return service.getCustomers();
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable("id") int id) {
		Customer cus=service.getCustomer(id);
		if(cus==null) {
			throw new CustomerNotFoundException("customer not with this id: "+id);
		}
		return cus;
	}
	
	@PostMapping("/customers/")
	public void addCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		service.saveCustomer(customer);
	}
	
	@PutMapping("/customers")
	public void editCustomer(@RequestBody Customer customer) {
		service.saveCustomer(customer);
		return;
	}

	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable("id") int id) {
		Customer cus=service.getCustomer(id);
		if(cus==null) {
			throw new CustomerNotFoundException("customer not with this id: "+id);
		}
		service.deleteCustomer(id);
		return "deleted customer: "+id;
	}
		
}
