package com.project.stock_Management_Web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.stock_Management_Web.model.Products;
@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

}
