package com.zirconiatic.employeemanager.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zirconiatic.employeemanager.dao.EmployeeRepository;
import com.zirconiatic.employeemanager.entity.Employee;

@RestController
public class EmployeeManagementController {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(value="/employee/details")
	public List<Employee> getAllEmployeeDetails(){
		return employeeRepository.findAll();
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(value="/add/employee/details")
	public Map<String, Integer> addEmployeeDetails(@RequestBody Employee employee){
		
		Employee addedEmployee = employeeRepository.saveAndFlush(employee);
		Map<String, Integer> hsmp = new HashMap<String, Integer>();
		hsmp.put("Added Employee Id", addedEmployee.getEmployeeId());
		
		return hsmp;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping(value = "/update/employee/details")
	public Map<String, Employee> updateEmployee(@RequestBody Employee employee){
		
		employeeRepository.updateEmployeeDetails(employee.getEmployeeDateOfBirth(), employee.getEmployeeDepartment(), employee.getEmployeeName(), employee.getEmployeeId());
		Map<String, Employee> hsmp = new HashMap<String, Employee>();
		hsmp.put("Updated Entry", employee);
		
		return hsmp;
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/delete/employee/details")
	public Map<String, Integer> deleteEmployee(@RequestParam int employeeId){
		
		employeeRepository.deleteById(employeeId);
		Map<String, Integer> hsmp = new HashMap<String, Integer>();
		hsmp.put("Employee With the mentioned id is Deleted", employeeId);
		
		return hsmp;
	}
}
