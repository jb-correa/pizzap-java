package com.pizzapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzapp.entity.*;
import com.pizzapp.error.ErrorService;
import com.pizzapp.repository.*;

@Service
public class IngredientService {

	@Autowired
	private IngredientRepository ingredientRepository;

	@Transactional
	public Ingredient loadIngredients(String cheese, String sauce, String mass, String topping, String olive) {

		Ingredient ingredient = new Ingredient();

		ingredient.setCheese(cheese);
		ingredient.setSauce(sauce);
		ingredient.setMass(mass);
		ingredient.setTopping(topping);
		ingredient.setOlive(olive);
		return ingredientRepository.save(ingredient);
	}

	@Transactional
	public Ingredient editIngredients(String id, String cheese, String sauce, String mass, String topping,
			String olive) throws ErrorService {

		Optional<Ingredient> check = ingredientRepository.findById(id);

		if (check != null) {
			Ingredient ingredient = check.get();
			ingredient.setCheese(cheese);
			ingredient.setSauce(sauce);
			ingredient.setMass(mass);
			ingredient.setTopping(topping);
			ingredient.setOlive(olive);
			return ingredientRepository.save(ingredient);

		} else {

			throw new ErrorService("No se encuentra el id a editar");
		}

	}

	@Transactional
	public Ingredient active(String id) throws ErrorService {

		Optional<Ingredient> check = ingredientRepository.findById(id);

		if (check != null) {
			Ingredient ingredient = check.get();
			ingredient.setStatus(true);
			return ingredientRepository.save(ingredient);

		} else {

			throw new ErrorService("No se encuentra el id");
		}

	}

	@Transactional
	public Ingredient passive(String id) throws ErrorService {

		Optional<Ingredient> check = ingredientRepository.findById(id);

		if (check != null) {
			Ingredient ingredient = check.get();
			ingredient.setStatus(false);
			return ingredientRepository.save(ingredient);

		} else {

			throw new ErrorService("No se encuentra el id");
		}

	}

	@Transactional
	public Ingredient deleteIngredients(String id) throws ErrorService {

		Optional<Ingredient> check = ingredientRepository.findById(id);

		if (check != null) {

			Ingredient ingredient = check.get();

			ingredientRepository.delete(ingredient);

		} else {

			throw new ErrorService("No se encuentra el id, para borrar");
		}

		return null;

	}

	@Transactional(readOnly = true)
	public List<Ingredient> findTrue() {
		return ingredientRepository.findTrue();
	}

	@Transactional(readOnly = true)
	public Ingredient findId(String id) {
		return ingredientRepository.findId(id);
	}

	@Transactional(readOnly = true)
	public Optional<Ingredient> findByid(String id) {
		return ingredientRepository.findById(id);
	}

	@Transactional(readOnly = true)
	public List<Ingredient> findFalse() {
		return ingredientRepository.findFalse();
	}

	@Transactional(readOnly = true)
	public List<Ingredient> findAll() {
		return ingredientRepository.findAll();
	}

	@Transactional(readOnly = true)
	public List<Ingredient> findCheese(String cheese) {
		return ingredientRepository.listCheese(cheese);
	}

	@Transactional(readOnly = true)
	public List<Ingredient> findSauce(String sauce) {
		return ingredientRepository.listSauce(sauce);
	}

	@Transactional(readOnly = true)
	public List<Ingredient> findMass(String mass) {
		return ingredientRepository.listMass(mass);
	}

	@Transactional(readOnly = true)
	public List<Ingredient> findTopping(String topping) {
		return ingredientRepository.listTopping(topping);
	}

	@Transactional(readOnly = true)
	public List<Ingredient> findOlive(String olive) {
		return ingredientRepository.listOlive(olive);
	}

}
