package com.tp.dao;

import java.util.List;

import com.tp.entity.PackageBooking;

/**
 * The Interface PackageBookingDao.
 * * @author Dhanushya
 */
public interface PackageBookingDao {

	/**
	 * Creates the packageBooking.
	 * @author Dhanushya
	 * @param packageBooking This Param includes 
	 *                  the packageBooking object
	 */
	public void createPackageBooking(PackageBooking packBooking);
	/**
	 * Gets the packagebooking list.
	 * @author Dhanushya
	 * @return the packagebooking list
	 */
	public List<PackageBooking> getAllPackageBookings();
	/**
	 * Update packagebooking.
	 * 
	 *@author Dhanushya
	 * @param packagebooking This Param includes 
	 *                  the packagebooking object
	 * @return the list
	 */
	public List<PackageBooking> updatePackageBooking(PackageBooking packBooking);
	/**
	 * Delete packagebooking.
	 * @author Dhanushya
	 * @param pbno This Param includes the
	 *           id of the packagebooking to be deleted
	 * @return the list
	 */
	public List<PackageBooking> deletePackageBooking(int pno);
	/**
	 * Gets the packagebooking.
	 * @author Dhanushya
	 * @param pbid This Param includes the
	 *           id of the packagebooking object to be retreived
	 * @return the packagebooking
	 */
	public PackageBooking getPackageBookingById(int pid);
	/**
	 * Gets the packagebooking.
	 * @author Dhanushya
	 * @param cid This Param includes the
	 *           cid of the customer of whose packagebooking object to be retreived
	 * @return the packagebooking
	 */
	public List<PackageBooking> getPackageBookingsByCId(int cid);
}
