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
	public List<Customer> getAllCustomers() {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//create and execcute a query
		Query<Customer> query= session.createQuery("From Customer order by lastName",Customer.class);

		//get the query results
		List<Customer> customers= query.getResultList();

		//return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// get the current  hibernate session object
		Session session= sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
		

	}


	@Override
	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
//		Customer customer=session.get(Customer.class,customerId);
//		session.delete(customer);
		
		Query query= session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", customerId);
		
		query.executeUpdate();
		
	}

	@Override
	public Customer getCustomer(int customerId) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, customerId);
		return customer;
	}

	@Override
	public List<Customer> searchCustomer(String searchTerm) {
		Query<Customer> query=null;
		Session session = sessionFactory.getCurrentSession();
		if(null!=searchTerm && searchTerm.trim().length()>0  ) {
		query= session.createQuery("From Customer where lower(firstName) like :searchTerm or lower(lastName) like :searchTerm",Customer.class);
		query.setParameter("searchTerm", "%"+searchTerm.toLowerCase()+"%");
	}
		else {
			query= session.createQuery("From Customer",Customer.class);
		}
		List<Customer> customerList = query.getResultList();
		
		return customerList;
	}
}
