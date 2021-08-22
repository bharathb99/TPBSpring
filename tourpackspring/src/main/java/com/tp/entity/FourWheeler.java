package com.tp.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("FourWheeler")
@PrimaryKeyJoinColumn(name="rentTransID") 
public class FourWheeler extends RentalTransport {

	private int noOfSeats;//4,5 or 7 seater
	
	public FourWheeler() {
		super();
		System.out.println("From FourWheeler");
	}
	
	public FourWheeler(int noOfSeats) {
		super();
		this.noOfSeats = noOfSeats;
	}
	
	public int getNoOfSeats() {
		return noOfSeats;
	}
	
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
	@Override
	public String toString() {
		return "FourWheeler [noOfSeats=" + noOfSeats + "]";
	}
		
}