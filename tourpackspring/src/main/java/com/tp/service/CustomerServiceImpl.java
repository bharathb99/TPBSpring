package com.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tp.dao.CustomerDao;
import com.tp.entity.Customer;

/**
 * The Class CustomerServiceImpl.
 * * @author Bharath
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	/**
	 * Creates the customer.
	 *@author Bharath
	 * @param customer This Param includes 
	 *                  the customer object
	 */
	@Override
	public void createCustomer(Customer customer) {
		
		customerDao.createCustomer(customer);
	}
	/**
	 * Gets the customer list.
	 * @author Bharath
	 * @return the customer list
	 */
	@Override
	public List<Customer> getAllCustomers() {
	
		return customerDao.getAllCustomers();
	}
	/**
	 * Update customer.
	 * @author Bharath
	 * @param customer This Param includes 
	 *                  the customer object
	 * @return the list
	 */
	@Override
	public List<Customer> updateCustomer(Customer customer) {
		
		return customerDao.updateCustomer(customer);
	}
	/**
	 * Delete customer.
	 * @author Bharath
	 * @param cno This Param includes the
	 *           id of the customer to be deleted
	 * @return the list
	 */
	@Override
	public List<Customer> deleteCustomer(int cno) {
		
		return customerDao.deleteCustomer(cno);
	}
	/**
	 * Gets the customer.
	 * @author Bharath
	 * @param cid This Param includes the
	 *           id of the customer object to be retreived
	 * @return the customer
	 */
	@Override
	public Customer getCustomerById(int cid) {
		
		return customerDao.getCustomerById(cid);
	}
	/**
	 * Gets the customer.
	 * @author Bharath
	 * @param email This Param includes the
	 *           email of the customer object to be retreived
	 * @return the customer
	 */
	@Override
	public Customer getCustomer(String email) {
		
		return customerDao.getCustomer(email);
	}

}
