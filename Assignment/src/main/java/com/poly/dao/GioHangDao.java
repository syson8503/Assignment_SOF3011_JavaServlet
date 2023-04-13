package com.poly.dao;

import java.util.List;
import java.util.UUID;

import com.poly.entity.GioHang;
import com.poly.entity.Account;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class GioHangDao {

	private EntityManager em = JpaUtil.getEntityManager();

	public List<GioHang> findAll() {
		String jpql = "SELECT c FROM GioHang c";
		TypedQuery<GioHang> query = em.createQuery(jpql, GioHang.class);
		List<GioHang> list = query.getResultList();
		return list;
	}
	
	public List<GioHang> findByAccount(Account account) {
		String jpql = "SELECT c FROM GioHang c WHERE c.account = :account";
		TypedQuery<GioHang> query = em.createQuery(jpql, GioHang.class);
		query.setParameter("account", account);
		List<GioHang> list = query.getResultList();
		return list;
	}
	
	public GioHang findOne(UUID id) {
		GioHang gioHang = em.find(GioHang.class, id);
		return gioHang;
	}

	public void create(GioHang gioHang) {
		try {
			em.getTransaction().begin();
			em.persist(gioHang);
			em.getTransaction().commit();
			System.out.println("Thêm mới Thành công");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Thêm mới thất bại");
			e.printStackTrace(System.out);
		}
	}
	
	public void delete(UUID id) {
		try {
			em.getTransaction().begin();
			GioHang gioHang = em.find(GioHang.class, id);
			em.remove(gioHang);
			em.getTransaction().commit();
			System.out.println("Xoá Thành công");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Xoá Thất bại");
			e.printStackTrace(System.out);
		}
	}
	
}
