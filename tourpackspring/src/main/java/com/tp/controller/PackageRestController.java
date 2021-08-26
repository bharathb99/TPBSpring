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

import com.tp.entity.Packages;
import com.tp.service.PackageService;

/**
 * The Class PackageRestController.
 */
@CrossOrigin(origins="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/package")
public class PackageRestController {
	
	/** The package service. */
	@Autowired
	PackageService packageService;
	
	/** The Constant logger. */
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger("PackageRestController.class");
	
	/**
	 * Gets the packages.
	 * @author Bharath
	 * @return the packages
	 */
	@GetMapping("/allPack")
	public ResponseEntity<List<Packages>> allPackage() {
		
		List<Packages> packlist = packageService.getAllPackages();
		System.out.println("From Rest allpack : " + packlist);
		
		if(packlist.isEmpty()) {
			
			return new ResponseEntity<List<Packages>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Packages>>(packlist,HttpStatus.OK);		
	}
	
	/**
	 * Creates the package.
	 *
	 * @param pack the package
	 * @return the package
	 */
	@PostMapping("/createPack")
	public Packages createPackage(@RequestBody Packages pack) {
		packageService.createPackage(pack);
		return pack;
	}
	
	/**
	 * Update package.
	 * @author Bharath
	 * @param pack This param includes
	 *               the details of package
	 *               to be updated
	 * @return the response entity
	 */
	@PutMapping("/updatePack")
	public ResponseEntity<List<Packages>> updatePackage(@RequestBody Packages pack) {
		
		List<Packages> packlist = packageService.updatePackage(pack);
		System.out.println("From Rest update pack : " + packlist);
		
		if(packlist.isEmpty()) {
			
			return new ResponseEntity<List<Packages>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Packages>>(packlist,HttpStatus.OK);		
	}
	
	/**
	 * Delete package.
	 * @author Bharath
	 * @param id  This param includes which
	 *             package should be deleted
	 * @return the response entity
	 */
	@DeleteMapping("/deletePack/{id}")
	public ResponseEntity<List<Packages>> deletePackage(@PathVariable("id") int pid) {
		
		List<Packages> packlist = packageService.deletePackage(pid);
		System.out.println("From Rest update cus : " + packlist);
		
		if(packlist.isEmpty()) {
			
			return new ResponseEntity<List<Packages>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Packages>>(packlist,HttpStatus.OK);		
	}
	
	/**
	 * Gets the package.
	 * @author Bharath
	 * @param id  This param includes 
	 *              the id of a package
	 *                to retrive details
	 * @return the package
	 */
	@GetMapping("/getPack/{id}")
	public ResponseEntity<Packages> getPackage(@PathVariable("id") int pid) {
		
		Packages pack = packageService.getPackageById	(pid);
		System.out.println("From Rest update pack : " + pack);
		
		if(pack == null) {
			
			return new ResponseEntity<Packages>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Packages>(pack,HttpStatus.OK);		
	}
	
	/**
	 * Gets the packages based on range of the cost per day.
	 * @author Bharath
	 * @param min  This param includes 
	 *              the minimum cost per day of the packages
	 *                to retrive details
	 * @param max  This param includes 
	 *              the maximum cost per day of the packages
	 *                to retrive details
	 * @return the packages
	 */
	@GetMapping("/sortPackCost/{min}/{max}")
	public ResponseEntity<List<Packages>> sortPackageByCost(@PathVariable("min") double min, @PathVariable("max") double max) {
		
		List<Packages> packlist = packageService.SortPackagesByCostPerDay(min, max);
		System.out.println("From Rest update cus : " + packlist);
		
		if(packlist.isEmpty()) {
			
			return new ResponseEntity<List<Packages>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Packages>>(packlist,HttpStatus.OK);		
	}
	
	/**
	 * Gets the packages based on range of the hotel cost per day.
	 * @author Bharath
	 * @param min  This param includes 
	 *              the minimum hotel cost of the packages
	 *                to retrive details
	 * @param max  This param includes 
	 *              the maximum hotel cost of the packages
	 *                to retrive details
	 * @return the packages
	 */
	@GetMapping("/sortPackHotelCost/{min}/{max}")
	public ResponseEntity<List<Packages>> sortPackageByHotelCost(@PathVariable("min") double min, @PathVariable("max") double max) {
		
		List<Packages> packlist = packageService.SortPackagesByHotelCostPerDay(min, max);
		System.out.println("From Rest update cus : " + packlist);
		
		if(packlist.isEmpty()) {
			
			return new ResponseEntity<List<Packages>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Packages>>(packlist,HttpStatus.OK);		
	}
	
	/**
	 * Gets the packages based on location.
	 * @author Bharath
	 * @return the packages
	 */
	@GetMapping("/searchPackLoc/{loc}")
	public ResponseEntity<List<Packages>>searchPackLoc(@PathVariable("loc") String location) {
		
		List<Packages> packlist = packageService.SearchPackagesByLocation(location);
		System.out.println("From Rest update cus : " + packlist);
		
		if(packlist.isEmpty()) {
			
			return new ResponseEntity<List<Packages>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Packages>>(packlist,HttpStatus.OK);		
	}
	
}
