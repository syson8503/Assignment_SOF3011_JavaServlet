package com.poly.dao;

import java.util.List;
import java.util.UUID;

import com.poly.entity.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class CategoryDao {

	private EntityManager em = JpaUtil.getEntityManager();

	public List<Category> findAll() {
		String jpql = "SELECT c FROM Category c";
		TypedQuery<Category> query = em.createQuery(jpql, Category.class);
		List<Category> list = query.getResultList();
		return list;
	}

	public void create(Category category) {
		try {
			em.getTransaction().begin();
			em.persist(category);
			em.getTransaction().commit();
			System.out.println("Thêm mới Thành công");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Thêm mới thất bại");
			e.printStackTrace(System.out);
		}
	}

	public void update(Category category) {
		try {
			em.getTransaction().begin();
			em.merge(category);
			em.getTransaction().commit();
			System.out.println("Cập nhật Thành công");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Cập nhật thất bại");
			e.printStackTrace(System.out);
		}
	}

	public void delete(UUID id) {
		try {
			em.getTransaction().begin();
			Category category = em.find(Category.class, id);
			em.remove(category);
			em.getTransaction().commit();
			System.out.println("Xoá Thành công");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Xoá Thất bại");
			e.printStackTrace(System.out);
		}
	}

	public Category findOne(UUID id) {
		Category category = em.find(Category.class, id);
		return category;
	}
	
	public static void main(String[] args) {
		Category category = new CategoryDao().findOne(UUID.fromString("2E0FBB40-B386-489C-84E1-5A4B7F693386"));
		System.out.println(category.getTenLoai());
	}
}
