package com.tp.dao;

import java.util.List;

import com.tp.entity.PackageBooking;

public interface PackageBookingDao {

	public void createPackageBooking(PackageBooking packBooking);
	public List<PackageBooking> getAllPackageBookings();
	public List<PackageBooking> updatePackageBooking(PackageBooking packBooking);
	public List<PackageBooking> deletePackageBooking(int pno);
	public PackageBooking getPackageBookingById(int pid);
	
	public List<PackageBooking> getPackageBookingsByCId(int cid);
}
