package com.zirconiatic.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zirconiatic.employeemanager.dao.RegistrationRepository;
import com.zirconiatic.employeemanager.entity.Registration;
import com.zirconiatic.employeemanager.util.Validation;

@Service
public class UserRegistrationImpl implements UserRegistration {
	
	@Autowired
	private Validation validation;

	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Override
	public boolean saveRegisteredUser(Registration registration) {
		
		Registration savedRegistration = null;
		
		if(validation.isValidString(registration.getName())) {
			savedRegistration = registrationRepository.saveAndFlush(registration);
		}
		
		return (savedRegistration != null);
	}

	@Override
	public boolean isUserValid(String emailId, String password) {
		
		Registration savedRegistration = registrationRepository.getUserDetails(emailId, password);

		return (savedRegistration != null);
	}

}
