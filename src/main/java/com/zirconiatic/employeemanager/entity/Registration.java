package com.zirconiatic.employeemanager.entity;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Registration {

	@Id
	private long phoneNumber;
	
	private String name;
	
	private String password;
	
	private String gender;
	
	private String emailId;
	
	private String address;
	
	private int pincode;
	
	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Registration [phoneNumber=" + phoneNumber + ", name=" + name + ", password=" + password + ", gender="
				+ gender + ", emailId=" + emailId + ", address=" + address + ", pincode=" + pincode + "]";
	}

}
