package com.tp.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class PackageBooking {

	@Id
	@GeneratedValue
	private int packBookID;

	private int noOfDays;
	private int noOfPeope;
	private double packageCost;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "packageID", referencedColumnName = "PACKAGEID")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Packages pack;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "customerID", referencedColumnName = "CUSTOMERID")
	private Customer customer;
	
	@OneToOne(targetEntity = RentalTransport.class, cascade=CascadeType.ALL)
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private RentalTransport rentTransport;

	public PackageBooking() {
		super();
	}

	public PackageBooking(int packBookID, int noOfDays, int noOfPeope, double packageCost, Date startDate, Date endDate,
			Packages pack, Customer customer, RentalTransport rentTransport) {
		super();
		this.packBookID = packBookID;
		this.noOfDays = noOfDays;
		this.noOfPeope = noOfPeope;
		this.packageCost = packageCost;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pack = pack;
		this.customer = customer;
		this.rentTransport = rentTransport;
	}

	public int getPackBookID() {
		return packBookID;
	}

	public void setPackBookID(int packBookID) {
		this.packBookID = packBookID;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public int getNoOfPeope() {
		return noOfPeope;
	}

	public void setNoOfPeope(int noOfPeope) {
		this.noOfPeope = noOfPeope;
	}

	public double getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Packages getPack() {
		return pack;
	}

	public void setPack(Packages pack) {
		this.pack = pack;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public RentalTransport getRentTransport() {
		return rentTransport;
	}

	public void setRentTransport(RentalTransport rentTransport) {
		this.rentTransport = rentTransport;
	}

	@Override
	public String toString() {
		return "PackageBooking [packBookID=" + packBookID + ", noOfDays=" + noOfDays + ", noOfPeope=" + noOfPeope
				+ ", packageCost=" + packageCost + ", startDate=" + startDate + ", endDate=" + endDate + ", pack="
				+ pack + ", customer=" + customer + ", rentTransport=" + rentTransport + "]";
	}

}
