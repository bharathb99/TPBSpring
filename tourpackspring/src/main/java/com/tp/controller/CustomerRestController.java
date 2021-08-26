package com.tp.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tp.entity.Customer;
import com.tp.service.CustomerService;

/**
 * The Class CustomerRestController.
 */
@CrossOrigin(origins="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/customer")
public class CustomerRestController {

	/** The customer service. */
	@Autowired
	CustomerService customerService;
	
	/** The Constant logger. */
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger("CustomerRestController.class");
	
	/**
	 * Gets the customers.
	 * @author Bharath
	 * @return the customers
	 */
	@GetMapping("/allCus")
	public ResponseEntity<List<Customer>> allCustomer() {
		
		List<Customer> cuslist = customerService.getAllCustomers();
		System.out.println("From Rest allcus : " + cuslist);
		
		if(cuslist.isEmpty()) {
			
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(cuslist,HttpStatus.OK);		
	}
	
	/**
	 * Creates the customer.
	 *
	 * @param customer the customer
	 * @return the customer
	 */
	@PostMapping("/createCus")
	public Customer createCustomer(@RequestBody Customer customer) {
		customerService.createCustomer(customer);
		return customer;
	}
	
	/**
	 * Update customer.
	 * @author Bharath
	 * @param customer This param includes
	 *               the details of customer
	 *               to be updated
	 * @return the response entity
	 */
	@PutMapping("/updateCus")
	public ResponseEntity<List<Customer>> updateCustomer(@RequestBody Customer customer) {
		
		List<Customer> cuslist = customerService.updateCustomer(customer);
		System.out.println("From Rest update cus : " + cuslist);
		
		if(cuslist.isEmpty()) {
			
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(cuslist,HttpStatus.OK);		
	}
	
	/**
	 * Delete customer.
	 * @author Bharath
	 * @param id  This param includes which
	 *             customer should be deleted
	 * @return the response entity
	 */
	@DeleteMapping("/deleteCus/{id}")
	public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable("id") int cid) {
		
		List<Customer> cuslist = customerService.deleteCustomer(cid);
		System.out.println("From Rest delete cus : " + cuslist);
		
		if(cuslist.isEmpty()) {
			
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(cuslist,HttpStatus.OK);		
	}
	
	/**
	 * Gets the customer.
	 * @author Bharath
	 * @param id  This param includes 
	 *              the id of a customer
	 *                to retrive details
	 * @return the customer
	 */
	@GetMapping("/getCus/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") int cid) {
		
		Customer cus = customerService.getCustomerById	(cid);
		System.out.println("From Rest get cus by id : " + cus);
		
		if(cus == null) {
			
			return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Customer>(cus,HttpStatus.OK);		
	}
	
	/**
	 * Gets the customer.
	 * @author Bharath
	 * @param email  This param includes 
	 *              the email of a customer
	 *                to retrive details
	 * @return the customer
	 */
	@GetMapping("/signCus/{email}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("email") String email) {

		System.out.println("From Rest get email : " + email);
		Customer cus = customerService.getCustomer(email);
		System.out.println("From Rest get cus : " + cus);
		
		if(cus == null) {
			
			return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Customer>(cus,HttpStatus.OK);		
	}
	
	
}
