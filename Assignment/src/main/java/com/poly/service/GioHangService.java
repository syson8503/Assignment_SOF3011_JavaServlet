package com.poly.service;

import java.util.List;
import java.util.UUID;

import com.poly.entity.Account;
import com.poly.entity.GioHang;

public interface GioHangService {

	public List<GioHang> findAll();
	public void create(GioHang gioHang);
	public void delete(UUID id);
	public GioHang findOne(UUID id);
	public List<GioHang> findByAccount(Account account);
}
