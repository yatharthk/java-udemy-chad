package com.crm.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crm.springdemo.DAO.CustomerDAO;
import com.crm.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject the customer DAO into the controller
	@Autowired
	private CustomerDAO customerDAO;
	

	@RequestMapping("/list")
	public String listOfCustomers(Model theModel) {
		
		//get customers from dao
		
		List<Customer> customers= customerDAO.getAllCustomers();
		
		//add the customers to the model
		theModel.addAttribute("customers",customers);
		
		return "list-customer";
	}
	
	
	
}
