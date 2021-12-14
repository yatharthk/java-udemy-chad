package com.crm.springdemo.service;

import java.util.List;

import com.crm.springdemo.entity.Customer;

public interface CustomerService {
	List<Customer> getCustomers();

	void saveCustomer(Customer tempCustomer);

	public Customer getCustomer(int customerId);

	public void deleteCustomer(int customerId);

	List<Customer> searchCustomers(String searchTerm);


}
