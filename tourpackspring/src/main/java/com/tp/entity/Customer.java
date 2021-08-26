package com.tp.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class Customer.
 * @author Chiranjeevi
 */
@Entity
public class Customer {

	/** The customer id. */
	@Id
	@GeneratedValue
	@PrimaryKeyJoinColumn 
	private int customerID;
	
	/** The customer name. */
	@Embedded
	private Name customerName;
	
	/** The gender. */
	@Column
	private String gender;
	
	/** The password. */
	@Column
	private String password;
	/** The email. */
	@Column(unique=true)
	private String email;
	/** The date of birth. */
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateOfBirth;
	/** The phone number. */
	@Column
	private String phone;
	/** The address. */
	@Embedded
	private Address address;
	
	@OneToMany(targetEntity = PackageBooking.class, mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<PackageBooking> packBooking;

	public Customer() {
		super();
	}

	/**
	 * Instantiates a new customer.
	 *
	 * @param customerID the customer id
	 * @param customerName the customer Name
	 * @param gender the gender
	 * @param password the password
	 * @param email the email
	 * @param dateOfBirth the dateOfBirth
	 * @param phone the phone
	 * @param address the address 
	 */
	public Customer(int customerID, Name customerName, String gender, String password, String email,
			Date dateOfBirth, String phone, Address address) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.gender = gender;
		this.password = password;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.address = address;
	}

	/**
	 * Gets the customer id.
	 *
	 * @return the customer id
	 */
	public int getCustomerID() {
		return customerID;
	}

	/**
	 * Sets the customer id.
	 *
	 * @param customerID the new customer id
	 */
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	/**
	 * Gets the customerName.
	 *
	 * @return the customer name
	 */
	public Name getCustomerName() {
		return customerName;
	}

	/**
	 * Sets the customerName.
	 *
	 * @param customerName the new customer name
	 */
	public void setCustomerName(Name customerName) {
		this.customerName = customerName;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the email .
	 *
	 * @return the email 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email .
	 *
	 * @param email the new email 
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the dateOfBirth .
	 *
	 * @return the dateOfBirth 
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Sets the dateOfBirth.
	 *
	 * @param dateOfBirth the new dateOfBirth 
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", gender=" + gender
				+ ", password=" + password + ", email=" + email + ", dateOfBirth="
				+ dateOfBirth + ", phone=" + phone + ", address=" + address + "]";
	}

}
