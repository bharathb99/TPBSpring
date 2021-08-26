package com.tp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tp.entity.Customer;

/**
 * The Class CustomerDaoImpl.
 * @author Bharath
 */
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Gets the session.
	 * 
	 * @return the session
	 */
	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Creates the customer.
	 * 
	 * @author Bharath
	 * @param customer the customer
	 */
	@Override
	public void createCustomer(Customer customer) {
		getSession().saveOrUpdate(customer);
		System.out.println("Customer has been stored successfully in DB !");
	}
	
	/**
	 * Gets the customer list.
	 * 
	 * @author Bharath
	 * @return the customer list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> cuslist = new ArrayList<Customer>();
		try {
			Query query = getSession().createQuery("from Customer cus");
			cuslist = query.list();
			System.out.println(cuslist);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cuslist;
	}
	
	/**
	 * Gets the customer.
	 * 
	 * @author Bharath
	 * @param email the email 
	 * @return the customer
	 */
	@Override
	public Customer getCustomer(String email) {
		Criteria c = getSession().createCriteria(Customer.class);
		c.add(Restrictions.eq("email", email));
		Customer cus = (Customer)c.uniqueResult();
		System.out.println("Customer Retrieved : " + cus);
		return cus;
	}

	/**
	 * Update customer.
	 *
	 * @param customer the customer
	 * @return the list
	 */
	@Override
	public List<Customer> updateCustomer(Customer customer) {
		getSession().saveOrUpdate(customer);
		System.out.println("Customer has been updated successfully in DB !");
		
		return getAllCustomers();
	}

	/**
	 * Delete customer.
	 *
	 * @param cno the cno
	 * @return the list
	 */
	@Override
	public List<Customer> deleteCustomer(int cno) {
		Query query = getSession().createQuery("delete from Customer cus where customerid=:cno");
		query.setParameter("cno", cno);
		int noofrows = query.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Deleted " + noofrows + " rows");
		}
		return getAllCustomers();
	}

	/**
	 * Gets the customer.
	 * 
	 * @author Bharath
	 * @param cid the cid
	 * @return the customer
	 */
	@Override
	public Customer getCustomerById(int cid) {
		Criteria c = getSession().createCriteria(Customer.class);
		c.add(Restrictions.eq("customerID", cid));
		Customer cus = (Customer) c.uniqueResult();
		System.out.println(cus);
		return cus;
	}
	
}
