package com.tp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Packages {

	@Id
	@GeneratedValue
	private int packageID;
	
	private String packageName;
	private String itenary;
	private String location;
	private String hotelName;
	private double hotelCostPerDay;
	private double costPerDay;
	
	@OneToMany(targetEntity = PackageBooking.class, mappedBy = "pack", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<PackageBooking> packBooking;

	public Packages() {
		super();
	}

	public Packages(int packageID, String packageName, String itenary, String location, String hotelName,
			double hotelCostPerDay, double costPerDay) {
		super();
		this.packageID = packageID;
		this.packageName = packageName;
		this.itenary = itenary;
		this.location = location;
		this.hotelName = hotelName;
		this.hotelCostPerDay = hotelCostPerDay;
		this.costPerDay = costPerDay;
	}

	public int getPackageID() {
		return packageID;
	}

	public void setPackageID(int packageID) {
		this.packageID = packageID;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getItenary() {
		return itenary;
	}

	public void setItenary(String itenary) {
		this.itenary = itenary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public double getHotelCostPerDay() {
		return hotelCostPerDay;
	}

	public void setHotelCostPerDay(double hotelCostPerDay) {
		this.hotelCostPerDay = hotelCostPerDay;
	}

	public double getCostPerDay() {
		return costPerDay;
	}

	public void setCostPerDay(double costPerDay) {
		this.costPerDay = costPerDay;
	}

	@Override
	public String toString() {
		return "Packages [packageID=" + packageID + ", packageName=" + packageName + ", itenary=" + itenary
				+ ", location=" + location + ", hotelName=" + hotelName + ", hotelCostPerDay=" + hotelCostPerDay
				+ ", costPerDay=" + costPerDay + "]";
	}
	
}
