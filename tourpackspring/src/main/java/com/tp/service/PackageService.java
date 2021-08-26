package com.tp.service;

import java.util.List;

import com.tp.entity.Packages;

/**
 * The Interface PackageService.
 * * @author Bharath
 */
public interface PackageService {
	/**
	 * Creates the package.
	 * @author Bharath
	 * @param package the package
	 */
	public void createPackage(Packages pack);
	/**
	 * Gets the package list.
	 * @author Bharath
	 * @return the package list
	 */
	public List<Packages> getAllPackages();
	/**
	 * Update package.
	 * @author Bharath
	 * @param package This Param includes 
	 *                  the package object
	 * @return the list
	 */
	public List<Packages> updatePackage(Packages pack);
	/**
	 * Delete package.
	 * @author Bharath
	 * @param pno This Param includes the
	 *           id of the customer to be deleted
	 * @return the package list
	 */
	public List<Packages> deletePackage(int pno);
	/**
	 * Gets the package.
	 * @author Bharath
	 * @param pid This Param includes the
	 *           id of the package object to be retreived
	 * @return the package list
	 */
	
	public Packages getPackageById(int pid);
	/**
	 * Gets the package list.
	 * @author Bharath
	 * @param min,max This Param includes the
	 *           range of costPerDay of the package object to be retreived
	 * @return the package list
	 */
	public List<Packages> SortPackagesByCostPerDay(double min,double max);
	/**
	 * Gets the package list.
	 * @author Bharath
	 * @param min,max This Param includes the
	 *           range of hotelCostPerDay of the package object to be retreived
	 * @return the package list
	 */
	public List<Packages> SortPackagesByHotelCostPerDay(double min,double max);
	/**
	 * Gets the package list.
	 * @author Bharath
	 * @param location This Param includes the
	 *           location of the package object to be retreived
	 * @return the package list
	 */
	public List<Packages> SearchPackagesByLocation(String location);
	
}
