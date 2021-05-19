package com.zirconiatic.employeemanager.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int employeeId;
	
	private String employeeName;
	
	private String employeeDepartment;
	
	private Date employeeDateOfBirth;
	
	@OneToMany(cascade={CascadeType.ALL})
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="employeeId", referencedColumnName="employeeId")
	private Set<Inventory> inventories;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
    @JsonManagedReference
	public Set<Inventory> getInventories() {
		return inventories;
	}

	public void setInventories(Set<Inventory> inventories) {
		this.inventories = inventories;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public Date getEmployeeDateOfBirth() {
		return employeeDateOfBirth;
	}

	public void setEmployeeDateOfBirth(Date employeeDateOfBirth) {
		this.employeeDateOfBirth = employeeDateOfBirth;
	}
	
}
