package com.tp.service;

import java.util.List;

import com.tp.entity.Customer;
/**
 * The Interface CustomerService.
 * * @author Bharath
 */
public interface CustomerService {
	/**
	 * Creates the customer.
	 *@author Bharath
	 * @param customer This Param includes 
	 *                  the customer object
	 */
	public void createCustomer(Customer customer);
	/**
	 * Gets the customer list.
	 * @author Bharath
	 * @return the customer list
	 */
	public List<Customer> getAllCustomers();
	/**
	 * Update customer.
	 * @author Bharath
	 * @param customer This Param includes 
	 *                  the customer object
	 * @return the list
	 */
	public List<Customer> updateCustomer(Customer customer);
	/**
	 * Delete customer.
	 * @author Bharath
	 * @param cno This Param includes the
	 *           id of the customer to be deleted
	 * @return the list
	 */
	public List<Customer> deleteCustomer(int cno);
	/**
	 * Gets the customer.
	 * @author Bharath
	 * @param cid This Param includes the
	 *           id of the customer object to be retreived
	 * @return the customer
	 */
	public Customer getCustomerById(int cid);
	/**
	 * Gets the customer.
	 * @author Bharath
	 * @param email This Param includes the
	 *           email of the customer object to be retreived
	 * @return the customer
	 */
	public Customer getCustomer(String email);
}
