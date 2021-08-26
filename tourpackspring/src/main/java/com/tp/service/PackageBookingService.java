package com.tp.service;

import java.util.List;

import com.tp.entity.PackageBooking;

/**
 * The Interface PackageBookingService.
 * * @author Dhanushya
 */
public interface PackageBookingService {
	/**
	 * Creates the packageBooking.
	 * @author Dhanushya
	 * @param packageBooking This Param includes 
	 *                  the packageBooking object
	 */
	public void createPackageBooking(PackageBooking packBook);
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
	public List<PackageBooking> updatePackageBooking(PackageBooking packBook);
	/**
	 * Delete packagebooking.
	 * @author Dhanushya
	 * @param pbno This Param includes the
	 *           id of the packagebooking to be deleted
	 * @return the list
	 */
	public List<PackageBooking> deletePackageBooking(int pbno);
	/**
	 * Gets the packagebooking.
	 * @author Dhanushya
	 * @param pbid This Param includes the
	 *           id of the packagebooking object to be retreived
	 * @return the packagebooking
	 */
	public PackageBooking getPackageBookingById(int pbid);
	/**
	 * Gets the packagebooking.
	 * @author Dhanushya
	 * @param cid This Param includes the
	 *           cid of the customer of whose packagebooking object to be retreived
	 * @return the packagebooking
	 */
	public List<PackageBooking> getPackageBookingByCId(int cid);
}