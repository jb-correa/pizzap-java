package com.pizzapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pizzapp.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	@Query("SELECT a FROM Product a WHERE a.status=true")
	public List<Product> findTrue();

	@Query("SELECT a FROM Product a WHERE a.status=false")
	public List<Product> findFalse();
	
	
	@Query("SELECT a FROM Product a WHERE a.id=:idS")
	public Product findId(@Param("id")String idS);
	
	@Query("SELECT a FROM Product a")
	public List<Product>findAllS();
	
	
	

}
