package com.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tp.dao.PackageDao;
import com.tp.entity.Packages;

@Service
@Transactional
public class PackageServiceImpl implements PackageService{

	@Autowired
	PackageDao packageDao;
	
	@Override
	public void createPackage(Packages pack) {
		
		packageDao.createPackage(pack);
	}

	@Override
	public List<Packages> getAllPackages() {
		
		return packageDao.getAllPackages();
	}

	@Override
	public List<Packages> updatePackage(Packages pack) {
		
		return packageDao.updatePackage(pack);
	}

	@Override
	public List<Packages> deletePackage(int pno) {
		
		return packageDao.deletePackage(pno);
	}

	@Override
	public Packages getPackageById(int pid) {
		
		return packageDao.getPackageById(pid);
	}

	@Override
	public List<Packages> SortPackagesByCostPerDay(double min, double max) {
		
		return packageDao.SortPackagesByCostPerDay(min, max);
	}

	@Override
	public List<Packages> SortPackagesByHotelCostPerDay(double min, double max) {
		
		return packageDao.SortPackagesByHotelCostPerDay(min, max);
	}

	
}
