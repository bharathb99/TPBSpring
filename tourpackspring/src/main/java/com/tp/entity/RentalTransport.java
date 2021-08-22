package com.tp.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "RENTAL_TYPE")
@Entity
public class RentalTransport {

	@Id
	@GeneratedValue
	private int rentTransID;

	private String vehicleProvider;
	private double chargesPerDay;

	public RentalTransport() {
		super();
		System.out.println("From RentalTransport");
	}

	public RentalTransport(int rentalTransportID, String vehicleProvider, double chargesPerDay) {
		super();
		this.rentTransID = rentalTransportID;
		this.vehicleProvider = vehicleProvider;
		this.chargesPerDay = chargesPerDay;
	}

	public int getRentalTransportID() {
		return rentTransID;
	}

	public void setRentalTransportID(int rentalTransportID) {
		this.rentTransID = rentalTransportID;
	}

	public String getVehicleProvider() {
		return vehicleProvider;
	}

	public void setVehicleProvider(String vehicleProvider) {
		this.vehicleProvider = vehicleProvider;
	}
	

	public double getChargesPerDay() {
		return chargesPerDay;
	}

	public void setChargesPerDay(double chargesPerDay) {
		this.chargesPerDay = chargesPerDay;
	}

	@Override
	public String toString() {
		return "RentalTransport [rentalTransportID=" + rentTransID + ", vehicleProvider=" + vehicleProvider
				+ ", chargesPerDay=" + chargesPerDay + "]";
	}

}
