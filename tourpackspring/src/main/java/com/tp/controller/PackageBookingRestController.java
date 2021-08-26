package com.tp.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tp.entity.PackageBooking;
import com.tp.service.PackageBookingService;

/**
 * The Class PackageBookingRestController.
 */
@CrossOrigin(origins="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/packageBooking")
public class PackageBookingRestController {
	
	/** The package booking service. */
	@Autowired
	PackageBookingService packageBookingService;
	
	/** The Constant logger. */
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger("PackageBookingRestController.class");
	
	/**
	 * Gets the package bookings.
	 * @author Dhanushya
	 * @return the package bookings
	 */
	@GetMapping("/allPackBooking")
	public ResponseEntity<List<PackageBooking>> allPackageBookings() {
		
		List<PackageBooking> packbookinglist = packageBookingService.getAllPackageBookings();
		System.out.println("From Rest allpackBooking : " + packbookinglist);
		
		if(packbookinglist.isEmpty()) {
			
			return new ResponseEntity<List<PackageBooking>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PackageBooking>>(packbookinglist,HttpStatus.OK);		
	}
	
	/**
	 * Creates the package booking.
	 *
	 * @param packBooking the package booking
	 * @return the package booking
	 */
	@PostMapping("/createPackBooking")
	public PackageBooking createPackage(@RequestBody PackageBooking packBooking) {
		packageBookingService.createPackageBooking(packBooking);
		return packBooking;
	}
	
	/**
	 * Update package booking.
	 * @author Dhanushya
	 * @param packBooking This param includes
	 *               the details of package booking
	 *               to be updated
	 * @return the response entity
	 */
	@PutMapping("/updatePackBooking")
	public ResponseEntity<List<PackageBooking>> updatePackageBooking(@RequestBody PackageBooking packBooking) {
		
		List<PackageBooking> packBookinglist = packageBookingService.updatePackageBooking(packBooking);
		System.out.println("From Rest update packBooking : " + packBookinglist);
		
		if(packBookinglist.isEmpty()) {
			
			return new ResponseEntity<List<PackageBooking>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PackageBooking>>(packBookinglist,HttpStatus.OK);		
	}
	
	/**
	 * Delete package booking.
	 * @author Dhanushya
	 * @param id  This param includes which
	 *             package booking should be deleted
	 * @return the response entity
	 */
	@DeleteMapping("/deletePackBooking/{id}")
	public ResponseEntity<List<PackageBooking>> deletePackageBooking(@PathVariable("id") int pbid) {
		
		List<PackageBooking> packBookinglist = packageBookingService.deletePackageBooking(pbid);
		System.out.println("From Rest update packBooking : " + packBookinglist);
		
		if(packBookinglist.isEmpty()) {
			
			return new ResponseEntity<List<PackageBooking>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PackageBooking>>(packBookinglist,HttpStatus.OK);		
	}
	
	/**
	 * Gets the package bookings.
	 * @author Dhanushya
	 * @param id  This param includes 
	 *              the id of a package booking
	 *                to retrive details
	 * @return the package bookings
	 */	
	@GetMapping("/getPackBookingAdmin/{id}")
	public ResponseEntity<PackageBooking> getPackageBookingById(@PathVariable("id") int pbid) {
		
		PackageBooking packBooking = packageBookingService.getPackageBookingById(pbid);
		System.out.println("From Rest update packBooking : " + packBooking);
		
		if(packBooking == null) {
			
			return new ResponseEntity<PackageBooking>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<PackageBooking>(packBooking,HttpStatus.OK);		
	}
	
	/**
	 * Gets the package bookings.
	 * @author Dhanushya
	 * @param id  This param includes 
	 *              the id of a customer
	 *                to retrive package bookings details
	 * @return the package bookings
	 */	
	@GetMapping("/getPackBookingCustomer/{id}")
	public ResponseEntity<List<PackageBooking>> getPackageBookingByCId(@PathVariable("id") int cid) {
		
		List<PackageBooking> packBooking = packageBookingService.getPackageBookingByCId(cid);
		System.out.println("From Rest update packBooking : " + packBooking);
		
		if(packBooking == null) {
			
			return new ResponseEntity<List<PackageBooking>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PackageBooking>>(packBooking,HttpStatus.OK);		
	}
	
	
}