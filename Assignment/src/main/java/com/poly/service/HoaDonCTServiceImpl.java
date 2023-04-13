package com.poly.service;

import com.poly.dao.HoaDonCTDao;
import com.poly.entity.HoaDon_ChiTiet;

public class HoaDonCTServiceImpl implements HoaDonCTService {

	private HoaDonCTDao ctDao = new HoaDonCTDao();
	
	@Override
	public void create(HoaDon_ChiTiet hoaDonCt) {
		ctDao.create(hoaDonCt);
	}

}
