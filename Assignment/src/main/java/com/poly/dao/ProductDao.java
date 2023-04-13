package com.poly.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.poly.entity.Category;
import com.poly.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ProductDao {

	private EntityManager em = JpaUtil.getEntityManager();

	public List<Product> findAll() {
		String jpql = "SELECT p FROM Product p";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		List<Product> list = query.getResultList();
		return list;
	}
	
	public List<Product> findByKeyword(String keyword) {
		String jpql = "SELECT p FROM Product p WHERE p.tenSP LIKE :keyword OR p.gioiThieu LIKE :keyword";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		query.setParameter("keyword", "%" + keyword + "%");
		List<Product> list = query.getResultList();
		return list;
	}
//	
//	public List<Product> findAllByPage(int soTrang) {
//		String jpql = "SELECT p FROM Product p";
//		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
//		query.setFirstResult(1 + soTrang);
//		query.setMaxResults(12);
//		List<Product> list = query.getResultList();
//		return list;
//	}
	
	public Product findOne(UUID id) {
		Product product = em.find(Product.class, id);
		return product;
	}
	
	public void create(Product product) {
		try {
			em.getTransaction().begin();
			em.persist(product);
			em.getTransaction().commit();
			System.out.println("Thêm mới Thành công");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Thêm mới thất bại");
		}
	}
	
	public void update(Product product) {
		try {
			em.getTransaction().begin();
			em.merge(product);
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
			Product product = em.find(Product.class, id);
			em.remove(product);
			em.getTransaction().commit();
			System.out.println("Xoá Thành công");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Xoá Thất bại");
			e.printStackTrace(System.out);
		}
	}
	
	public static void main(String[] args) {
		Product product = new Product(null, "halo", BigDecimal.valueOf(2022), 10, "halo", "halo", null);
		new ProductDao().create(product);
		
//		for (Product i : new ProductDao().findAll()) {
//			System.out.println(i.getTenSP());
//		}
		
	}
}
