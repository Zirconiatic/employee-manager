package com.zirconiatic.employeemanager.service;

import com.zirconiatic.employeemanager.entity.Registration;

public interface UserRegistration {
	
	public boolean saveRegisteredUser(Registration registration);
	public boolean isUserValid(String emailId, String password);

}