package com.zirconiatic.employeemanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zirconiatic.employeemanager.entity.Inventory;

@Repository
@Transactional
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
	
	//Native Query
	@Modifying
	@Query(value = "update inventory set product_name=:pn, product_type=:pt where product_id=:pid",nativeQuery = true)
	public void updateInventoryDetails(@Param("pn") String productName, @Param("pt") String productType, @Param("pid") Integer productId);

}
