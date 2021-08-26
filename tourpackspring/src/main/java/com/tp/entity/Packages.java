package com.tp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class PackageBooking.
 * @author Chiranjeevi
 */
@Entity
public class Packages {

	/** The package id. */
	@Id
	@GeneratedValue
	private int packageID;
	/** The package name. */
	private String packageName;
	/** The package image. */
	private String packageImage;
	/** The itenary. */
	private String itenary;
	/** The location. */
	private String location;
	/** The hotel name. */
	private String hotelName;
	/** The hotel cost per day. */
	private double hotelCostPerDay;
	/** The cost per day. */
	private double costPerDay;
	
	@OneToMany(targetEntity = PackageBooking.class, mappedBy = "pack", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<PackageBooking> packBooking;

	public Packages() {
		super();
	}

	/**
	 * Instantiates a new customer.
	 *
	 * @param packageID the package id
	 * @param packageName the package name
	 * @param packageImage the package image
	 * @param itenary the itenary
	 * @param location the location
	 * @param hotelName the hotel name
	 * @param hotelCostPerDay the hotel cost per day
	 * @param costPerDay the cost per day 
	 */
	public Packages(int packageID, String packageName, String packageImage, String itenary, String location, String hotelName,
			double hotelCostPerDay, double costPerDay) {
		super();
		this.packageID = packageID;
		this.packageName = packageName;
		this.packageImage = packageImage;
		this.itenary = itenary;
		this.location = location;
		this.hotelName = hotelName;
		this.hotelCostPerDay = hotelCostPerDay;
		this.costPerDay = costPerDay;
	}

	/**
	 * Gets the package id.
	 *
	 * @return the package id
	 */
	public int getPackageID() {
		return packageID;
	}

	/**
	 * Sets the package id.
	 *
	 * @param packageName the package id
	 */
	public void setPackageID(int packageID) {
		this.packageID = packageID;
	}

	/**
	 * Gets the package name.
	 *
	 * @return the package name
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * Sets the package name.
	 *
	 * @param packageName the package name
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	/**
	 * Gets the package image.
	 *
	 * @return the package image
	 */
	public String getPackageImage() {
		return packageImage;
	}

	/**
	 * Sets the package image.
	 *
	 * @param packageImage the package image
	 */
	public void setPackageImage(String packageImage) {
		this.packageImage = packageImage;
	}

	/**
	 * Gets the itenary.
	 *
	 * @return the itenary
	 */
	public String getItenary() {
		return itenary;
	}

	/**
	 * Sets the itenary.
	 *
	 * @param itenary the itenary
	 */
	public void setItenary(String itenary) {
		this.itenary = itenary;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the hotel name.
	 *
	 * @return the hotel name
	 */
	public String getHotelName() {
		return hotelName;
	}

	/**
	 * Sets the hotel name.
	 *
	 * @param hotelName the hotel name
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	/**
	 * Gets the hotel cost per day.
	 *
	 * @return the hotel cost per day
	 */
	public double getHotelCostPerDay() {
		return hotelCostPerDay;
	}

	/**
	 * Sets the hotel cost per day.
	 *
	 * @param hotelCostPerDay the hotel cost per day
	 */
	public void setHotelCostPerDay(double hotelCostPerDay) {
		this.hotelCostPerDay = hotelCostPerDay;
	}

	/**
	 * Gets the cost per day.
	 *
	 * @return the cost per day
	 */
	public double getCostPerDay() {
		return costPerDay;
	}

	/**
	 * Sets the cost per day.
	 *
	 * @param costPerDay the cost per day
	 */
	public void setCostPerDay(double costPerDay) {
		this.costPerDay = costPerDay;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Packages [packageID=" + packageID + ", packageName=" + packageName + ", packageImage=" + packageImage
				+ ", itenary=" + itenary + ", location=" + location + ", hotelName=" + hotelName + ", hotelCostPerDay="
				+ hotelCostPerDay + ", costPerDay=" + costPerDay + "]";
	}

}
