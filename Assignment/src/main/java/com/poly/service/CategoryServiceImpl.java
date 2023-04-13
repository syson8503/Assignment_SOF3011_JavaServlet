package com.poly.service;

import java.util.List;
import java.util.UUID;

import com.poly.dao.CategoryDao;
import com.poly.entity.Category;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao = new CategoryDao();
	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}
	@Override
	public void create(Category category) {
		categoryDao.create(category);
	}
	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}
	@Override
	public void delete(UUID id) {
		categoryDao.delete(id);
	}
	@Override
	public Category findOne(UUID id) {
		return categoryDao.findOne(id);
	}

}
