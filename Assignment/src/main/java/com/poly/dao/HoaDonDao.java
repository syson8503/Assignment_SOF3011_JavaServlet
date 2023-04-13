package com.poly.dao;

import java.sql.Date;
import java.util.List;

import com.poly.entity.HoaDon;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class HoaDonDao {

	private EntityManager em = JpaUtil.getEntityManager();
	
	public void create(HoaDon hoaDon) {
		try {
			em.getTransaction().begin();
			em.persist(hoaDon);
			em.getTransaction().commit();
			System.out.println("Thêm mới Thành công");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Thêm mới thất bại");
		}
	}
	
	public void update(HoaDon hoaDon) {
		try {
			em.getTransaction().begin();
			em.merge(hoaDon);
			em.getTransaction().commit();
			System.out.println("Cập nhật Thành công");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Cập nhật thất bại");
		}
	}
	
	public HoaDon findOne(Date ngayTao, String idKH, Boolean trangThai) {
		String jpql = "SELECT h FROM HoaDon h WHERE h.ngayTao =:ngayTao AND h.khachHang.id = :idKH AND h.trangThai =:trangThai";
		TypedQuery<HoaDon> query = em.createQuery(jpql, HoaDon.class);
		query.setParameter("ngayTao", ngayTao);
		query.setParameter("idKH", idKH);
		query.setParameter("trangThai", trangThai);
		HoaDon hoaDon = query.getSingleResult();
		return hoaDon;
	}
}
