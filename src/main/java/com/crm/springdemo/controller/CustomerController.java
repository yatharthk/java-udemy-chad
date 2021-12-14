package com.crm.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.springdemo.entity.Customer;
import com.crm.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject the customer DAO into the controller
	@Autowired
	private CustomerService  customerService;
	

	@GetMapping("/list")
	public String listOfCustomers(Model theModel) {
		System.out.println("reaching here.");
		
		//get customers from dao
		
		List<Customer> customers= customerService.getCustomers();
		
		//add the customers to the model
		theModel.addAttribute("customers",customers);
		
		return "list-customer";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		
		//create model attribute to bind form data
		Customer customer = new Customer();
		model.addAttribute("customer",customer);
		return "customer-form";
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer tempCustomer) {
		
		customerService.saveCustomer(tempCustomer);
		System.out.println(tempCustomer);
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int customerId, Model theModel) {
		
		//get customer from the database
		Customer customer= customerService.getCustomer(customerId);
		
		//pre-populate the form
		theModel.addAttribute("customer",customer);
		return "customer-form";
	}
	
	@DeleteMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int customerId) {
		customerService.deleteCustomer(customerId);
		return "redirect:/customer/list";
	}
		
	
	@GetMapping("/search")
	public String  searchCustomers(@RequestParam("theSearchTerm") String searchTerm,Model theModel) {
		System.out.println("search term" +searchTerm);
		List<Customer> customerList=customerService.searchCustomers(searchTerm);
		theModel.addAttribute("customers",customerList);
		return "list-customer";
		
	}
	
}
