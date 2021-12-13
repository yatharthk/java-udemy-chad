package com.crm.springdemo.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getAllCustomers() {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		//create and execcute a query
		Query<Customer> query= session.createQuery("From Customer",Customer.class);

		//get the query results
		List<Customer> customers= query.getResultList();

		//return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public int deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
