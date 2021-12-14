package com.crm.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.springdemo.DAO.CustomerDAO;
import com.crm.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getAllCustomers();
	
	}
	
	@Override
	@Transactional
	public void saveCustomer(Customer tempCustomer) {
		customerDAO.saveCustomer(tempCustomer);
		
	}
	
	@Override
	@Transactional
	public Customer getCustomer(int customerId) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(customerId);
	}
	
	
	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		customerDAO.deleteCustomer(customerId);
		
	}
	
	
	@Override
	@Transactional
	public List<Customer> searchCustomers(String searchTerm) {
		
		return customerDAO.searchCustomer(searchTerm);
	}
	
	
}
