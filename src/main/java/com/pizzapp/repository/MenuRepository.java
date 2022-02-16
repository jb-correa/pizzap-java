package com.pizzapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pizzapp.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {

	@Query("SELECT a FROM Menu a WHERE a.status=true")
	public List<Menu> findTrue();

	@Query("SELECT a FROM Menu a WHERE a.status=false")
	public List<Menu> findFalse();

	@Query("SELECT a FROM Menu a WHERE a.name=:name")
	public List<Menu> findName(@Param("name") String name);

	
	
	
	
}
