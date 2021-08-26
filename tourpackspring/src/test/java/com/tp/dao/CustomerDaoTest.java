package com.tp.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The Class CustomerTest.
 * @author Dhanushya
 */
public class CustomerDaoTest {

	/** The customer dao. */
	static CustomerDao customerDao;
	
	CustomerDao cus;
	
	/**
	 * Setup.
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		
		System.out.println("@Before Class Called");
	}
	
	@Before
	public void setUp() throws java.lang.Exception
	{
		System.out.println("@Before Called");
		ApplicationContext context = new ClassPathXmlApplicationContext("dispserv-servlet.xml");
		customerDao = (CustomerDao) context.getBean("customerDao");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws java.lang.Exception
	{
		System.out.println("@AfterClass Called");
	}

	@After
	public void tearDown() throws java.lang.Exception
	{
		cus=null;
		System.out.println("@After Called");
	}
	
	/**
	 * Gets the customer list.
	 *
	 * @return the customer list
	 */
	@Test
	public void testGetAllCustomers() {

		assertTrue((customerDao.getAllCustomers()).size() >= 1);
	}
	
	/**
	 * Test get customer.
	 */
	@Test
	public void testGetCustomer() {
		
		String email = "priya@gmail.com";
		assertEquals(1,customerDao.getCustomer(email).getCustomerID());
	}
	
}
