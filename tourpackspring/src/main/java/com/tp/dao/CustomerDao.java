package com.tp.dao;

import java.util.List;

import com.tp.entity.Customer;

/**
 * The Interface CustomerDao.
 * @author Bharath
 */
public interface CustomerDao {
	
	/**
	 * Creates the customer.
	 *
	 * @param customer This Param includes 
	 *                  the customer object
	 */
	public void createCustomer(Customer customer);
	
	/**
	 * Gets the customer list.
	 *
	 * @return the customer list
	 */
	public List<Customer> getAllCustomers();
	
	/**
	 * Update customer.
	 *
	 * @param customer This Param includes 
	 *                  the customer object
	 * @return the list
	 */
	public List<Customer> updateCustomer(Customer customer);
	
	/**
	 * Delete customer.
	 *
	 * @param cno This Param includes the
	 *           id of the customer to be deleted
	 * @return the list
	 */
	public List<Customer> deleteCustomer(int cno);
	
	/**
	 * Gets the customer.
	 *
	 * @param cid This Param includes the
	 *           id of the customer object to be retreived
	 * @return the customer
	 */
	public Customer getCustomerById(int cid);
	
	/**
	 * Gets the customer.
	 *
	 * @param email This Param includes the
	 *           email of the customer object to be retreived
	 * @return the customer
	 */
	public Customer getCustomer(String email);

}
