package com.zirconiatic.employeemanager.dao;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zirconiatic.employeemanager.entity.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	//Native Queries
	@Modifying
	@Query(value = "update employee set employee_date_of_birth=:edob, employee_department=:ed, employee_name=:en where employee_id=:ei",nativeQuery = true)
	void updateEmployeeDetails(@Param("edob") Date employeeDateOfBirth,@Param("ed") String employeeDepartment,@Param("en") String employeeName, @Param("ei") int employeeId);
	//DSL's
	
//	@Modifying
//	@Query(value = "update Employee e set e.employee_date_of_birth=TO_TIMESTAMP(?1 , 'mm/DD/YYYY HH:MI:SS AM'), e.employee_department=?2, e.employee_name=?3 where e.employee_id=?4")
//	void updateEmployeeDetails(Timestamp employeeDateOfBirth, String employeeDepartment, String employeeName, int employeeId);
	
//	@Modifying
//	@Query(value = "update Employee e set e.employee_date_of_birth=TO_TIMESTAMP(:edob , 'mm/DD/YYYY HH:MI:SS AM'), e.employee_department=:ed, e.employee_name=:en where e.employee_id=:ei")
//	void updateEmployeeDetails(@Param("edob") Date employeeDateOfBirth,@Param("ed") String employeeDepartment,@Param("en") String employeeName, @Param("ei") int employeeId);
	
}
