package com.zirconiatic.employeemanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zirconiatic.employeemanager.entity.Registration;

@Repository
@Transactional
public interface RegistrationRepository extends JpaRepository<Registration, Integer>{

	//Using Native Query
	@Query(nativeQuery = true,value = "select * from registration where email_id=:eid and password=:pass")
	public Registration getUserDetails(@Param("eid") String emailId, @Param("pass") String password);
}
