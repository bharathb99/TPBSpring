package com.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tp.dao.PackageDao;
import com.tp.entity.Packages;

/**
 * The Class PackageServiceImpl.
 * * @author Bharath
 */
@Service
@Transactional
public class PackageServiceImpl implements PackageService{

	@Autowired
	PackageDao packageDao;
	/**
	 * Creates the package.
	 * @author Bharath
	 * @param package the package
	 */
	@Override
	public void createPackage(Packages pack) {
		
		packageDao.createPackage(pack);
	}
	/**
	 * Gets the package list.
	 * @author Bharath
	 * @return the package list
	 */
	@Override
	public List<Packages> getAllPackages() {
		
		return packageDao.getAllPackages();
	}
	/**
	 * Update package.
	 * @author Bharath
	 * @param package This Param includes 
	 *                  the package object
	 * @return the list
	 */
	@Override
	public List<Packages> updatePackage(Packages pack) {
		
		return packageDao.updatePackage(pack);
	}
	/**
	 * Delete package.
	 * @author Bharath
	 * @param pno This Param includes the
	 *           id of the customer to be deleted
	 * @return the package list
	 */
	@Override
	public List<Packages> deletePackage(int pno) {
		
		return packageDao.deletePackage(pno);
	}
	/**
	 * Gets the package.
	 * @author Bharath
	 * @param pid This Param includes the
	 *           id of the package object to be retreived
	 * @return the package list
	 */
	@Override
	public Packages getPackageById(int pid) {
		
		return packageDao.getPackageById(pid);
	}
	/**
	 * Gets the package list.
	 * @author Bharath
	 * @param min,max This Param includes the
	 *           range of costPerDay of the package object to be retreived
	 * @return the package list
	 */
	@Override
	public List<Packages> SortPackagesByCostPerDay(double min, double max) {
		
		return packageDao.SortPackagesByCostPerDay(min, max);
	}
	/**
	 * Gets the package list.
	 * @author Bharath
	 * @param min,max This Param includes the
	 *           range of hotelCostPerDay of the package object to be retreived
	 * @return the package list
	 */
	@Override
	public List<Packages> SortPackagesByHotelCostPerDay(double min, double max) {
		
		return packageDao.SortPackagesByHotelCostPerDay(min, max);
	}
	/**
	 * Gets the package list.
	 * @author Bharath
	 * @param location This Param includes the
	 *           location of the package object to be retreived
	 * @return the package list
	 */
	@Override
	public List<Packages> SearchPackagesByLocation(String location) {
		
		return packageDao.SearchPackagesByLocation(location);
	}
	
}
