package com.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tp.dao.PackageBookingDao;
import com.tp.entity.PackageBooking;

@Service
@Transactional
public class PackageBookingServiceImpl implements PackageBookingService{
	
	@Autowired
	PackageBookingDao packageBookingDao;
	
	@Override
	public void createPackageBooking(PackageBooking packBook) {
		
		packageBookingDao.createPackageBooking(packBook);
		
	}

	@Override
	public List<PackageBooking> getAllPackageBookings() {
		
		return packageBookingDao.getAllPackageBookings();
	}

	@Override
	public List<PackageBooking> updatePackageBooking(PackageBooking packBook) {
		
		return packageBookingDao.updatePackageBooking(packBook);
	}

	@Override
	public List<PackageBooking> deletePackageBooking(int pbno) {
		
		return packageBookingDao.deletePackageBooking(pbno);
	}

	@Override
	public PackageBooking getPackageBookingById(int pbid) {
		
		return packageBookingDao.getPackageBookingById(pbid);
	}

	@Override
	public List<PackageBooking> getPackageBookingByCId(int cid) {
		
		return packageBookingDao.getPackageBookingsByCId(cid);
	}
	
}
