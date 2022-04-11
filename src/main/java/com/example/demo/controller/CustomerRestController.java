package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.exceptions.CustomerNotFoundException;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class CustomerRestController {

    // autowire the CustomerService
    @Autowired
    private CustomerService customerService;

    // add mapping for GET /customers
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();

    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable("id") int theId) {
    	Customer tempCustomer=customerService.getCustomer(theId);
        if(tempCustomer==null) throw new CustomerNotFoundException("Customer id not found-" +theId);
    	return tempCustomer;

    }
    
    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer) {
    	customer.setId(0);
    	customerService.saveCustomer(customer);
    	return customer;
    }
    
    
    @PutMapping("/customers/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int theId,@RequestBody Customer customer) {
    	customerService.saveCustomer(customer);
    	return customer;
    }
    
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") int customerId) {
    	Customer tempCustomer = customerService.getCustomer(customerId);
    	if(tempCustomer == null) {
    		throw new CustomerNotFoundException("Customer id not found  -"+customerId);
    	}
    	customerService.deleteCustomer(customerId);
    	return "Deleted customer id-"+ customerId;
    }




}