package com.zirconiatic.employeemanager.service;

import java.util.Optional;

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
	public boolean saveUserDetails(Registration registration) {
		
		//check if the user is already present
		Optional<Registration> isUserRegistered = registrationRepository.findById(registration.getPhoneNumber());
		
		if(isUserRegistered.isEmpty()) {
			//save the user in the repository
			Registration savedRegistration = null;
			
			if(validation.isValidString(registration.getName())) {
				savedRegistration = registrationRepository.saveAndFlush(registration);
			}
			
			return (savedRegistration != null);
		}
		
		//else log the registered user details and return false
		
		return false;
	}

	@Override
	public boolean isUserValid(String emailId, String password) {
		
		Registration savedRegistration = registrationRepository.getUserDetails(emailId, password);

		return (savedRegistration != null);
	}

}
