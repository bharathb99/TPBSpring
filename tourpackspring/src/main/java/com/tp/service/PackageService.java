package com.tp.service;

import java.util.List;

import com.tp.entity.Packages;

public interface PackageService {

	public void createPackage(Packages pack);
	public List<Packages> getAllPackages();
	public List<Packages> updatePackage(Packages pack);
	public List<Packages> deletePackage(int pno);
	
	public Packages getPackageById(int pid);
	public List<Packages> SortPackagesByCostPerDay(double min,double max);
	public List<Packages> SortPackagesByHotelCostPerDay(double min,double max);
}
