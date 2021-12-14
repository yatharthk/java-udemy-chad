package com.crm.springdemo.DAO;

import java.util.List;

import com.crm.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getAllCustomers(); 
	public void saveCustomer(Customer customer);
	public Customer getCustomer(int id);
	public void deleteCustomer(int customerId);
	public List<Customer> searchCustomer(String searchTerm);
	

}
