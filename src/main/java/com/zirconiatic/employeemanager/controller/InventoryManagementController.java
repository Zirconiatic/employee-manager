package com.zirconiatic.employeemanager.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zirconiatic.employeemanager.dao.EmployeeRepository;
import com.zirconiatic.employeemanager.dao.InventoryRepository;
import com.zirconiatic.employeemanager.entity.Employee;
import com.zirconiatic.employeemanager.entity.Inventory;

@RestController
public class InventoryManagementController {
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add/inventory")
	public Map<String,Inventory> addInventory(@RequestBody Inventory inventory, @RequestParam("employeeId") Integer employeeId){
		
		Optional<Employee> optEmp = employeeRepository.findById(employeeId);
		inventory.setEmployee(optEmp.get());
		Inventory addedInventory = inventoryRepository.save(inventory);
		Map<String, Inventory> hsmp = new HashMap<String, Inventory>();
		hsmp.put("Inventory Added:", addedInventory);
		
		return hsmp;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/inventory")
	public Map<String,Integer> deleteInventory(@RequestParam("inventoryId") Integer inventoryId){
		
		inventoryRepository.deleteById(inventoryId);
		
		Map<String, Integer> hsmp = new HashMap<String, Integer>();
		hsmp.put("Inventory deleted:", inventoryId);
		
		return hsmp;
	}

	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/update/inventory")
	public Map<String,Inventory> updateInventory(@RequestBody Inventory inventory){
		
		inventoryRepository.updateInventoryDetails(inventory.getProductName(), inventory.getProductType(), inventory.getProductId());
		
		Map<String, Inventory> hsmp = new HashMap<String, Inventory>();
		hsmp.put("Inventory updated:", inventory);
		
		return hsmp;
	}
	
}
