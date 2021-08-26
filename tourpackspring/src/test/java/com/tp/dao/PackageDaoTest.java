package com.tp.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * The Class CustomerTest.
 * @author Dhanushya
 */
public class PackageDaoTest {

	/** The package dao. */
	static PackageDao packageDao;
	
	/**
	 * Setup.
	 */
	@BeforeClass
	public static void setup() {
		System.out.println("Before class");
		ApplicationContext context = new ClassPathXmlApplicationContext("dispserv-servlet.xml");
		packageDao = (PackageDao) context.getBean("packageDao");
	}
	
	/**
	 * Gets the package list.
	 *
	 * @return the package list
	 */
	@Test
	public void testGetAllPackages() {

		assertTrue((packageDao.getAllPackages()).size() >= 1);
	}
	
	/**
	 * Test get package by id.
	 */
	@Test
	public void testGetPackageById() {
		
		int id = 1;
		assertEquals(packageDao.getPackageById(id).getPackageName(),"GoGoaGone");
	}
	
	/**
	 * Test sort package by cost per day.
	 */
	@Test
	public void testSortPackagesByCostPerDay() {
		
		double min=500.00, max=1000.00;
		assertTrue((packageDao.SortPackagesByCostPerDay(min, max)).size()<1);
	}
	
	/**
	 * Test sort package by hotel cost per day.
	 */
	@Test
	public void testSortPackageByHotelCostPerDay() {
		
		double min=500.00, max=1000.00;
		assertTrue((packageDao.SortPackagesByHotelCostPerDay(min, max)).size()>=2);
	}
	
}
