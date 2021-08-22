package com.tp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tp.dao.CustomerDao;

public class CustomerTest {

	static CustomerDao customerDao;
	
	@BeforeClass
	public static void setup() {
		System.out.println("Before class");
		ApplicationContext context = new ClassPathXmlApplicationContext("dispserv-servlet.xml");
		customerDao = (CustomerDao) context.getBean("customerDao");
	}
	
	@Test
	public void testGetAllCustomers() {

		assertTrue((customerDao.getAllCustomers()).size() >= 1);
	}
	
	@Test
	public void testGetCustomer() {
		
		String email = "dhanu@gmail.com";
		assertEquals(customerDao.getCustomer(email).getCustomerName().getFname(), "Dhanu");
	}
	
}
