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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Customer {

	@Id
	@GeneratedValue
	@PrimaryKeyJoinColumn 
	private int customerID;
	
	@Embedded
	private Name customerName;
	@Column
	private String gender;
	@Column
	private String password;
	@Column
	private String email;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Column
	private String phone;
	
	@Embedded
	private Address address;
	
	@OneToMany(targetEntity = PackageBooking.class, mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<PackageBooking> packBooking;

	public Customer() {
		super();
	}

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

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public Name getCustomerName() {
		return customerName;
	}

	public void setCustomerName(Name customerName) {
		this.customerName = customerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", gender=" + gender
				+ ", password=" + password + ", email=" + email + ", dateOfBirth="
				+ dateOfBirth + ", phone=" + phone + ", address=" + address + "]";
	}

}
