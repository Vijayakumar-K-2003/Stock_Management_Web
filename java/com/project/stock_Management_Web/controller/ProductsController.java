package com.project.stock_Management_Web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stock_Management_Web.model.Products;
import com.project.stock_Management_Web.service.ProductsService;

@Controller
public class ProductsController {
	@Autowired
	private ProductsService productsservice;
	
	
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listProducts",productsservice.getAllProducts());
		return "index.html";
	}
	
	@GetMapping("/showNewProductForm")
	public String showNewProductForm(Model model) {
		model.addAttribute("product", new Products());
		return "new_Product.html";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Products product) {
		this.productsservice.saveProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) {
		Products product = productsservice.getProductById(id);
		model.addAttribute("product", product);
		return "update_Product.html";
	}
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable (value = "id") long id) {
		this.productsservice.deleteProductById(id);
		return "redirect:/";
	}
	

}