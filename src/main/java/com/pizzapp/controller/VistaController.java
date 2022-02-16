package com.pizzapp.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pizzapp.entity.Product;
import com.pizzapp.repository.ProductRepository;
import com.pizzapp.service.ProductService;

@Controller
@RequestMapping("/")
public class VistaController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;

	@GetMapping("/index")
	public String index() {
		return "index.html";
	}

	@GetMapping("/product")
	public String product() {
		return "product.html";
	}
	
	@GetMapping("/product-stock")
	public String productS() {
		return "product-stock.html";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact.html";
	}
	@PreAuthorize("hasAnyRole('ROLE_USER_REGISTER','ROLE_USER_ADMIN')")
	@GetMapping("/creditCardForm")
	public String creditString() {
		
		return "creditCardForm.html";
	}
	

	@GetMapping("/registrate")
	public String register() {
		return "registrate.html";
	}

	@GetMapping("/login")
	public String login() {
		return "login.html";
	}

	@PreAuthorize("hasAnyRole('ROLE_USER_REGISTER','ROLE_USER_ADMIN')")
	@GetMapping("/perfil")
	public String editPerfil() {
		return "perfil.html";
	}

	@GetMapping("/shop")
	public String shop(HttpSession request, ModelMap model) {

		if (request.getAttribute("carrito") != null) {

			List<Product> listProducts = new ArrayList<>((List) request.getAttribute("carrito"));

			model.addAttribute("listProducts", new ArrayList<>((List) request.getAttribute("carrito")));
			Integer saldoTotal = 0;
			for (Product product : listProducts) {
				saldoTotal += product.getPrice();
				model.addAttribute("saldoTotal", saldoTotal);

			}

		}

		return "shop.html";
	}

}
