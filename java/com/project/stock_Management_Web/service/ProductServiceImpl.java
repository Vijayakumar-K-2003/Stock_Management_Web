package com.project.stock_Management_Web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stock_Management_Web.model.Products;
import com.project.stock_Management_Web.repository.ProductsRepository;

@Service
public class ProductServiceImpl implements ProductsService {
	
	@Autowired
	private ProductsRepository productrepository;
	
	
	
	@Override
	public List<Products> getAllProducts() {
		
		return productrepository.findAll();
	}

	@Override
	public void saveProduct(Products product) {
		this.productrepository.save(product);
		
	}

	@Override
	public Products getProductById(long id) {
		Optional<Products> optional = productrepository.findById(id);
		Products product = null;
		if(optional.isPresent()) {
			product = optional.get();
		}
		else {
			throw new RuntimeException("Product not found");
		}
		
		return product;
	}

	@Override
	public void deleteProductById(long id) {
		this.productrepository.deleteById(id);
		
	}
			
}
