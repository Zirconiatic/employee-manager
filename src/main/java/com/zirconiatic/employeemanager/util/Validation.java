package com.zirconiatic.employeemanager.util;

import org.springframework.stereotype.Component;

@Component
public class Validation {
	
	public boolean isValidString(String inputString) {
		
		return (!inputString.equals(""))
	            && (inputString != null)
	            && (inputString.matches("^[a-zA-Z]*$"));
	}

}
