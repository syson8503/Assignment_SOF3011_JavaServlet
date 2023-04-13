package com.poly.service;

import java.util.List;
import java.util.UUID;

import com.poly.entity.Product;

public interface ProductService {

	List<Product> findAll();
	public Product findOne(UUID id);
	public void create(Product product);
	public void update(Product product);
	public void delete(UUID id);
	public List<Product> findByKeyword(String keyword);
}
