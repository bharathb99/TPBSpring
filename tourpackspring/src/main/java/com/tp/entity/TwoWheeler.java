package com.tp.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("TwoWheeler")
@PrimaryKeyJoinColumn(name="rentTransID") 
public class TwoWheeler extends RentalTransport {

	private String vehicleType;//bike or scooter
	
	public TwoWheeler() {
		super();
		System.out.println("From TwoWheeler");
	}
	
	public TwoWheeler(String vehicleType) {
		super();
		this.vehicleType = vehicleType;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Override
	public String toString() {
		return "TwoWheeler [vehicleType=" + vehicleType + "]";
	}
	
}
