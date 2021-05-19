package com.zirconiatic.employeemanager.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int productId;
	
	private String productName;
	
	private String productType;
	
	@ManyToOne
	@JoinColumn(name = "employeeId")
	private Employee employee;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employeeId")
    @JsonBackReference
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
