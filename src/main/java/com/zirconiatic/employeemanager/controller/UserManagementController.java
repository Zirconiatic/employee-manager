package com.zirconiatic.employeemanager.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zirconiatic.employeemanager.entity.Registration;
import com.zirconiatic.employeemanager.service.UserRegistration;

@RestController
@RequestMapping("/user")
public class UserManagementController {

	@Autowired
	private UserRegistration userRegistration;
	
	@GetMapping("/validate")
	public Map<String, Boolean> isUserRegistered(@RequestParam("emailId") String emailId, @RequestParam("password") String password){
		Map<String, Boolean> hsmp = new HashMap<String, Boolean>();
		
		boolean isUserRegistered = userRegistration.isUserValid(emailId, password);
		
		hsmp.put("result", isUserRegistered);
		
		return hsmp;
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/register")
	public Map<String, Boolean> registerUserIfnotRegistered(@RequestBody Registration registrationDetails){
		Map<String, Boolean> hsmp = new HashMap<String, Boolean>();
		
		boolean isUserRegistered = userRegistration.saveUserDetails(registrationDetails);
		
		hsmp.put("result", isUserRegistered);
		
		return hsmp;
	}
}
