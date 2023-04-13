package com.poly.service;

import com.poly.dao.HoaDonDao;
import com.poly.entity.HoaDon;

public class HoaDonServiceImpl implements HoaDonService {
	private HoaDonDao dao = new HoaDonDao();

	@Override
	public void create(HoaDon hoaDon) {
		dao.create(hoaDon);
	}

	@Override
	public void update(HoaDon hoaDon) {
		dao.update(hoaDon);
	}

}
