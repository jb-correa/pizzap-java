package com.pizzapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pizzapp.entity.Photo;
import com.pizzapp.repository.PhotoRepository;
import com.pizzapp.service.PhotoService;


@Controller
@RequestMapping("/")
public class PhotoController {
	
	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private PhotoService photoService;
	
	@GetMapping("/photo-list")
	public String list(ModelMap modelo) {
		List<Photo> all = photoRepository.findAll();		
		modelo.addAttribute("photos", all);
		return "list-photo.html";
	}
	
	@GetMapping("/load/{id}")
	public ResponseEntity<byte[]> cargarFoto(@PathVariable String id) {
		Photo photo = photoService.getOne(id);
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<>(photo.getContent(), headers, HttpStatus.OK);
	}

	
}
