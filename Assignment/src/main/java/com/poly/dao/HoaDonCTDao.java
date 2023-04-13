package com.poly.dao;

import com.poly.entity.HoaDon_ChiTiet;

import jakarta.persistence.EntityManager;

public class HoaDonCTDao {

private EntityManager em = JpaUtil.getEntityManager();
	
	public void create(HoaDon_ChiTiet hoaDonCt) {
		try {
			em.getTransaction().begin();
			em.persist(hoaDonCt);
			em.getTransaction().commit();
			System.out.println("Thêm mới Thành công");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Thêm mới thất bại");
		}
	}
}
