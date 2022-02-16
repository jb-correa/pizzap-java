package com.pizzapp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.pizzapp.entity.*;
import com.pizzapp.error.ErrorService;
import com.pizzapp.repository.*;

@Service
public class MenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	private PhotoService photoService;

	@Transactional
	public Menu createMenu(MultipartFile file, String name) throws ErrorService {

		Menu menu = new Menu();
		menu.setName(name);
		menu.setLoad(new Date());
		menu.setStatus(true);
		Photo photo = photoService.multiPartToEntity(file);
		menu.setPhoto(photo);

		return menuRepository.save(menu);
	}

	@Transactional
	public Menu editMenu(String idMenu, MultipartFile file, String name) throws ErrorService {

		Optional<Menu> check = menuRepository.findById(idMenu);
		if (check != null) {

			Menu menu = check.get();
			menu.setName(name);
			menu.setEdit(new Date());
			menu.setStatus(true);
			Photo photo = photoService.multiPartToEntity(file);
			menu.setPhoto(photo);
			return menuRepository.save(menu);

		} else {

			throw new ErrorService("No se encuentra el id del Menu para editar");
		}

	}

	@Transactional
	public void removeMenu(String idMenu) throws ErrorService {

		Optional<Menu> check = menuRepository.findById(idMenu);
		if (check != null) {
			Menu menu = check.get();
			menuRepository.delete(menu);
		} else {
			throw new ErrorService("No se encuentra el id del Menu para eliminar");
		}

	}

	@Transactional
	public void active(String idMenu) {
		Optional<Menu> check = menuRepository.findById(idMenu);
		if (check != null) {
			Menu menu = check.get();
			menu.setStatus(true);
			menuRepository.save(menu);
		}
	}

	@Transactional
	public void passive(String idMenu) {
		Optional<Menu> check = menuRepository.findById(idMenu);
		if (check != null) {
			Menu menu = check.get();
			menu.setStatus(false);
			menuRepository.save(menu);
		}
	}

	@Transactional(readOnly = true)
	public List<Menu> findAll() {
		return menuRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<Menu> findID(String id) {
		return menuRepository.findById(id);
	}

	@Transactional(readOnly = true)
	public List<Menu> findTrue() {
		return menuRepository.findTrue();
	}

	@Transactional(readOnly = true)
	public List<Menu> findFalse() {
		return menuRepository.findFalse();
	}

	@Transactional(readOnly = true)
	public List<Menu> findName(String name) {
		return menuRepository.findName(name);
	}

}
