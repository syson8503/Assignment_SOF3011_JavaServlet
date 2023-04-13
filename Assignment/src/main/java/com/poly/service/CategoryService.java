package com.poly.service;

import java.util.List;
import java.util.UUID;

import com.poly.entity.Category;

public interface CategoryService {

	public List<Category> findAll();
	public void create(Category category);
	public void update(Category category);
	public void delete(UUID id);
	public Category findOne(UUID id);
}
