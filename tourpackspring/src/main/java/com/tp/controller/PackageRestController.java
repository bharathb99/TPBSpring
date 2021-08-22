package com.tp.controller;

import java.util.List;

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

@CrossOrigin(origins="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/package")
public class PackageRestController {
	
	@Autowired
	PackageService packageService;
	
	@GetMapping("/allPack")
	public ResponseEntity<List<Packages>> allPackage() {
		
		List<Packages> packlist = packageService.getAllPackages();
		System.out.println("From Rest allpack : " + packlist);
		
		if(packlist.isEmpty()) {
			
			return new ResponseEntity<List<Packages>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Packages>>(packlist,HttpStatus.OK);		
	}
	
	@PostMapping("/createPack")
	public Packages createPackage(@RequestBody Packages pack) {
		packageService.createPackage(pack);
		return pack;
	}
	
	@PutMapping("/updatePack")
	public ResponseEntity<List<Packages>> updatePackage(@RequestBody Packages pack) {
		
		List<Packages> packlist = packageService.updatePackage(pack);
		System.out.println("From Rest update pack : " + packlist);
		
		if(packlist.isEmpty()) {
			
			return new ResponseEntity<List<Packages>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Packages>>(packlist,HttpStatus.OK);		
	}
	
	@DeleteMapping("/deletePack/{id}")
	public ResponseEntity<List<Packages>> deletePackage(@PathVariable("id") int pid) {
		
		List<Packages> packlist = packageService.deletePackage(pid);
		System.out.println("From Rest update cus : " + packlist);
		
		if(packlist.isEmpty()) {
			
			return new ResponseEntity<List<Packages>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Packages>>(packlist,HttpStatus.OK);		
	}
	
	@GetMapping("/getPack/{id}")
	public ResponseEntity<Packages> getPackage(@PathVariable("id") int pid) {
		
		Packages pack = packageService.getPackageById	(pid);
		System.out.println("From Rest update pack : " + pack);
		
		if(pack == null) {
			
			return new ResponseEntity<Packages>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Packages>(pack,HttpStatus.OK);		
	}
	
	@GetMapping("/sortPackCost/{min}/{max}")
	public ResponseEntity<List<Packages>> sortPackageByCost(@PathVariable("min") double min, @PathVariable("max") double max) {
		
		List<Packages> packlist = packageService.SortPackagesByCostPerDay(min, max);
		System.out.println("From Rest update cus : " + packlist);
		
		if(packlist.isEmpty()) {
			
			return new ResponseEntity<List<Packages>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Packages>>(packlist,HttpStatus.OK);		
	}
	
	@GetMapping("/sortPackHotelCost/{min}/{max}")
	public ResponseEntity<List<Packages>> sortPackageByHotelCost(@PathVariable("min") double min, @PathVariable("max") double max) {
		
		List<Packages> packlist = packageService.SortPackagesByHotelCostPerDay(min, max);
		System.out.println("From Rest update cus : " + packlist);
		
		if(packlist.isEmpty()) {
			
			return new ResponseEntity<List<Packages>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Packages>>(packlist,HttpStatus.OK);		
	}
	
}
