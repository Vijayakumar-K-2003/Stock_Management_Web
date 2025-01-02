package com.project.stock_Management_Web.service;

import java.util.List;

import com.project.stock_Management_Web.model.Products;

public interface ProductsService {
	List<Products> getAllProducts();
	void saveProduct (Products product);
	Products getProductById(long id);
	void deleteProductById(long id);
}
