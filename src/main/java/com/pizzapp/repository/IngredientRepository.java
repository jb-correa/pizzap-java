package com.pizzapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pizzapp.entity.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {

	@Query("SELECT a FROM Ingredient a WHERE a.id=:id")
	public Ingredient findId(@Param("id") String id);

	@Query("SELECT a FROM Ingredient a WHERE a.status=true")
	public List<Ingredient> findTrue();

	@Query("SELECT a FROM Ingredient a WHERE a.status=false")
	public List<Ingredient> findFalse();

	@Query("SELECT a FROM Ingredient a WHERE a.cheese=:cheese")
	public List<Ingredient> listCheese(@Param("cheese") String cheese);

	@Query("SELECT a FROM Ingredient a WHERE a.cheese=:sauce")
	public List<Ingredient> listSauce(@Param("sauce") String sauce);

	@Query("SELECT a FROM Ingredient a WHERE a.cheese=:mass")
	public List<Ingredient> listMass(@Param("mass") String mass);

	@Query("SELECT a FROM Ingredient a WHERE a.cheese=:topping")
	public List<Ingredient> listTopping(@Param("topping") String topping);

	@Query("SELECT a FROM Ingredient a WHERE a.cheese=:olive")
	public List<Ingredient> listOlive(@Param("olive") String olive);

}
