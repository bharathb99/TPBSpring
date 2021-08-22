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

import com.tp.entity.FourWheeler;
import com.tp.entity.RentalTransport;
import com.tp.entity.TwoWheeler;
import com.tp.service.RentalTransportService;

@CrossOrigin(origins="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/rentalTransport")
public class RentalTransportRestController {
	
	@Autowired
	RentalTransportService rentalTransportService;
	
	
	@GetMapping("/allrentalTransport")
	public ResponseEntity<List<RentalTransport>> allRentalTransport() {
		
		List<RentalTransport> rentalTransportlist = rentalTransportService.getAllRentalTransport();
		System.out.println("From Rest allrentalTransport : " + rentalTransportlist);
		
		if(rentalTransportlist.isEmpty()) {
			
			return new ResponseEntity<List<RentalTransport>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<RentalTransport>>(rentalTransportlist,HttpStatus.OK);		
	}
	
	@PostMapping("/createFourWheeler")
	public RentalTransport createFourWheeler(@RequestBody FourWheeler fourWheeler) {
		rentalTransportService.createFourWheeler(fourWheeler);
		return fourWheeler;
	}
	
	@PostMapping("/createTwoWheeler")
	public RentalTransport createTwoWheeler(@RequestBody TwoWheeler twoWheeler) {
		rentalTransportService.createTwoWheeler(twoWheeler);
		return twoWheeler;
	}
	
	@PutMapping("/updateFourWheeler")
	public ResponseEntity<List<RentalTransport>> updateFourWheeler(@RequestBody FourWheeler rentalTransport) {
		
		List<RentalTransport> rentalTransportlist = rentalTransportService.updateFourWheeler(rentalTransport);
		System.out.println("From Rest update rentalTransport : " + rentalTransportlist);
		
		if(rentalTransportlist.isEmpty()) {
			
			return new ResponseEntity<List<RentalTransport>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<RentalTransport>>(rentalTransportlist,HttpStatus.OK);		
	}
	
	@PutMapping("/updateTwoWheeler")
	public ResponseEntity<List<RentalTransport>> updateTwoWheeler(@RequestBody TwoWheeler rentalTransport) {
		
		List<RentalTransport> rentalTransportlist = rentalTransportService.updateTwoWheeler(rentalTransport);
		System.out.println("From Rest update rentalTransport : " + rentalTransportlist);
		
		if(rentalTransportlist.isEmpty()) {
			
			return new ResponseEntity<List<RentalTransport>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<RentalTransport>>(rentalTransportlist,HttpStatus.OK);		
	}
	
	@DeleteMapping("/deleteRentalTransport/{id}")
	public ResponseEntity<List<RentalTransport>> deleteRentalTransport(@PathVariable("id") int rtid) {
		
		List<RentalTransport> rentalTransportlist = rentalTransportService.deleteRentalTransport(rtid);
		System.out.println("From Rest update rentalTransport : " + rentalTransportlist);
		
		if(rentalTransportlist.isEmpty()) {
			
			return new ResponseEntity<List<RentalTransport>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<RentalTransport>>(rentalTransportlist,HttpStatus.OK);		
	}
	
	@GetMapping("/getRentalTransport/{id}")
	public ResponseEntity<RentalTransport> getRentalTransport(@PathVariable("id") int rtid) {
		
		RentalTransport rentalTransport = rentalTransportService.getRentalTransportById(rtid);
		System.out.println("From Rest update rentalTransport : " +rentalTransport);
		
		if(rentalTransport == null) {
			
			return new ResponseEntity<RentalTransport>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<RentalTransport>(rentalTransport,HttpStatus.OK);		
	}
	
}