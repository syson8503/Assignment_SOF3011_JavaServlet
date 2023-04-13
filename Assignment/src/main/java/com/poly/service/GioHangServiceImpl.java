package com.poly.service;

import java.util.List;
import java.util.UUID;

import com.poly.dao.GioHangDao;
import com.poly.entity.Account;
import com.poly.entity.GioHang;

public class GioHangServiceImpl implements GioHangService {

	private GioHangDao dao = new GioHangDao();
	
	@Override
	public List<GioHang> findAll() {
		return dao.findAll();
	}

	@Override
	public void create(GioHang gioHang) {
		dao.create(gioHang);
	}

	@Override
	public void delete(UUID id) {
		dao.delete(id);
	}

	@Override
	public GioHang findOne(UUID id) {
		return dao.findOne(id);
	}

	@Override
	public List<GioHang> findByAccount(Account account) {
		return dao.findByAccount(account);
	}

}
