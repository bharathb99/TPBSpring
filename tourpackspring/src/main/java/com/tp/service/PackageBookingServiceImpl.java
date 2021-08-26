package com.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tp.dao.PackageBookingDao;
import com.tp.entity.PackageBooking;

/**
 * The Class PackageBookingServiceImpl.
 * @author Dhanushya
 */
@Service
@Transactional
public class PackageBookingServiceImpl implements PackageBookingService{
	
	@Autowired
	PackageBookingDao packageBookingDao;
	/**
	 * Creates the packagebooking.
	 * 
	 * @author Dhanushya
	 * @param customer the packagebooking
	 */
	@Override
	public void createPackageBooking(PackageBooking packBook) {
		
		packageBookingDao.createPackageBooking(packBook);
		
	}
	/**
	 * Gets the packagebooking list.
	 * 
	 * @author Dhanushya
	 * @return the packagebooking list
	 */
	@Override
	public List<PackageBooking> getAllPackageBookings() {
		
		return packageBookingDao.getAllPackageBookings();
	}
	/**
	 * Updates the packagebooking.
	 * 
	 * @author Dhanushya
	 * @return the packagebooking list.
	 */
	@Override
	public List<PackageBooking> updatePackageBooking(PackageBooking packBook) {
		
		return packageBookingDao.updatePackageBooking(packBook);
	}
	/**
	 * Delete packagebooking.
	 * @author Dhanushya
	 * @param pbno the pbno
	 * @return the list
	 */
	@Override
	public List<PackageBooking> deletePackageBooking(int pbno) {
		
		return packageBookingDao.deletePackageBooking(pbno);
	}
	/**
	 * Gets the packagebooking.
	 * 
	 * @author Dhanushya
	 * @param pbid the pbid
	 * @return the packagebooking
	 */
	@Override
	public PackageBooking getPackageBookingById(int pbid) {
		
		return packageBookingDao.getPackageBookingById(pbid);
	}
	/**
	 * Gets the packagebooking.
	 * @author Dhanushya
	 * @param cid the cid
	 * @return the packagebooking list.
	 */
	@Override
	public List<PackageBooking> getPackageBookingByCId(int cid) {
		
		return packageBookingDao.getPackageBookingsByCId(cid);
	}
	
}
