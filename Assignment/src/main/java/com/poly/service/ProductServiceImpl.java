package com.poly.service;

import java.util.List;
import java.util.UUID;

import com.poly.dao.ProductDao;
import com.poly.entity.Product;

public class ProductServiceImpl implements ProductService {

	private ProductDao dao = new ProductDao();
	
	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

	@Override
	public Product findOne(UUID id) {
		
		return dao.findOne(id);
	}

	@Override
	public void create(Product product) {
		dao.create(product);
	}

	@Override
	public void update(Product product) {
		dao.update(product);
	}

	@Override
	public void delete(UUID id) {
		dao.delete(id);
	}

	@Override
	public List<Product> findByKeyword(String keyword) {
		return dao.findByKeyword(keyword);
	}

}
