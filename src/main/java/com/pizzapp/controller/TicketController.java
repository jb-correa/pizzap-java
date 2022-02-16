package com.pizzapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pizzapp.entity.Product;
import com.pizzapp.repository.ClientRepository;
import com.pizzapp.repository.ProductRepository;
import com.pizzapp.service.ClientService;
import com.pizzapp.service.ProductService;
import com.pizzapp.service.TicketService;

@Controller
@RequestMapping("/")
public class TicketController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ClientService clientService;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ProductService productService;
	@Autowired
	private TicketService ticketService;

	@GetMapping("ticket/{id}")
	public String ticket(HttpSession request, ModelMap model, @PathVariable String id) {

		
		List<Product> carritoList;

		if (request.getAttribute("carrito") != null) {
			carritoList = new ArrayList<>((List) request.getAttribute("carrito"));
		} else {
			carritoList = new ArrayList<>();
		}


//		request.invalidate();

		

		Optional<Product> check = productRepository.findById(id);
		if (check != null) {
			Product product = check.get();
			carritoList.add(product);
		
		}

		request.setAttribute("carrito", carritoList);

		return "redirect:/product";

	}

}
