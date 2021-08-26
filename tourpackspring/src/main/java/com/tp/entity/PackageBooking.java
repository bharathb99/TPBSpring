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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class PackageBooking.
 * @author Chiranjeevi
 */
@Entity
public class PackageBooking {

	/** The packBook id. */
	@Id
	@GeneratedValue
	private int packBookID;
	/** The no of days. */
	private int noOfDays;
	/** The no of people. */
	private int noOfPeope;
	/** The package cost. */
	private double packageCost;
	/** The start date. */
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date startDate;
	/** The end date. */
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date endDate;
	/** The booking date. */
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date bookingDate;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "packageID", referencedColumnName = "PACKAGEID")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Packages pack;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "customerID", referencedColumnName = "CUSTOMERID")
	private Customer customer;


	public PackageBooking() {
		super();
	}

	/**
	 * Instantiates a new package booking.
	 *
	 * @param packBookID the package booking id
	 * @param noOfDays the number of days
	 * @param noOfPeope the number of peope
	 * @param packageCost the package cost
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param bookingDate the booking date
	 * @param pack the package
	 * @param customer the customer 
	 */
	public PackageBooking(int packBookID, int noOfDays, int noOfPeope, double packageCost, Date startDate, Date endDate,
			Date bookingDate, Packages pack, Customer customer) {
		super();
		this.packBookID = packBookID;
		this.noOfDays = noOfDays;
		this.noOfPeope = noOfPeope;
		this.packageCost = packageCost;
		this.startDate = startDate;
		this.endDate = endDate;
		this.bookingDate = bookingDate;
		this.pack = pack;
		this.customer = customer;
	}

	/**
	 * Gets the package booking id.
	 *
	 * @return the package booking id
	 */
	public int getPackBookID() {
		return packBookID;
	}

	/**
	 * Sets the package booking id.
	 *
	 * @param customerID the new package booking id
	 */
	public void setPackBookID(int packBookID) {
		this.packBookID = packBookID;
	}

	/**
	 * Gets the number of days.
	 *
	 * @return the number of days
	 */
	public int getNoOfDays() {
		return noOfDays;
	}

	/**
	 * Sets the number of days.
	 *
	 * @param noOfDays the number of days
	 */
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	/**
	 * Gets the number of peope.
	 *
	 * @return the number of peope
	 */
	public int getNoOfPeope() {
		return noOfPeope;
	}
	/**
	 * Sets the number of peope.
	 *
	 * @param noOfPeope the number of peope
	 */
	public void setNoOfPeope(int noOfPeope) {
		this.noOfPeope = noOfPeope;
	}
	/**
	 * Gets the package cost.
	 *
	 * @return the package cost
	 */
	public double getPackageCost() {
		return packageCost;
	}
	/**
	 * Sets the package cost.
	 *
	 * @param packageCost the package cost
	 */
	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}
	/**
	 * Gets the start date.
	 *
	 * @return the start date 
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * Sets the start date.
	 *
	 * @param startDate the start date. 
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * Gets the end date
	 *
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * Sets the end date.
	 *
	 * @param endDate the end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * Gets the booking date.
	 *
	 * @return the booking date
	 */
	public Date getBookingDate() {
		return bookingDate;
	}
	/**
	 * Sets the booking date.
	 *
	 * @param bookingDate the booking date
	 */
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public Packages getPack() {
		return pack;
	}
	/**
	 * Sets the package.
	 *
	 * @param pack the package
	 */
	public void setPack(Packages pack) {
		this.pack = pack;
	}
	/**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * Sets the customer.
	 *
	 * @param customer the customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PackageBooking [packBookID=" + packBookID + ", noOfDays=" + noOfDays + ", noOfPeope=" + noOfPeope
				+ ", packageCost=" + packageCost + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", bookingDate=" + bookingDate + ", pack=" + pack + ", customer=" + customer + "]";
	}

}
