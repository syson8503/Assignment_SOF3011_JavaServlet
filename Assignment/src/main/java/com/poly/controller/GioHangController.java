package com.poly.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.entity.Account;
import com.poly.entity.GioHang;
import com.poly.entity.HoaDon;
import com.poly.service.AccountService;
import com.poly.service.AccountServiceImpl;
import com.poly.service.GioHangService;
import com.poly.service.GioHangServiceImpl;
import com.poly.service.HoaDonCTService;
import com.poly.service.HoaDonCTServiceImpl;
import com.poly.service.HoaDonService;
import com.poly.service.HoaDonServiceImpl;

@WebServlet({ "/client/gio-hang/hien-thi", "/client/gio-hang/delete", "/client/gio-hang/tao-hoa-don",  "/client/thanh-toan"})
public class GioHangController extends HttpServlet {
	GioHangService gioHangService = new GioHangServiceImpl();
	HoaDonService hoaDonService = new HoaDonServiceImpl();
	HoaDonCTService ctService = new HoaDonCTServiceImpl();
	private AccountService accountService = new AccountServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		if (uri.contains("hien-thi")) {
			this.hienThi(request, response);
		} else if (uri.contains("delete")) {
			this.deleteGioHang(request, response);
		} else if (uri.contains("thanh-toan")) {
			this.thanhToan(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		if (uri.contains("tao-hoa-don")) {
			this.taoHoaDon(request, response);
		}
	}
	
private void thanhToan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String[] listGioHangs = (String[]) request.getSession().getAttribute("listGioHangs");
	
	for (String i : listGioHangs) {
		gioHangService.delete(UUID.fromString(i));
	}
	
	request.setAttribute("errorTT", "Thanh Toán thành công!!!");
	hienThi(request, response);
//	Account account = (Account) request.getSession().getAttribute("account");
//	Account account2 = accountService.findOne(account.getUsername());
//	request.getSession().setAttribute("slGioHang", account2.getListGioHang().size());
//	request.setAttribute("listGioHang", account2.getListGioHang());
//	request.getRequestDispatcher("/views/pages/gioHang.jsp").forward(request, response);
	}

	private void taoHoaDon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] listGioHangs = request.getParameterValues("chkChon");
	    
	    if(listGioHangs.length == 0) {
	    	request.setAttribute("error", "Vui lòng chọn sản phẩm");
	    	hienThi(request, response);
	    } else {
	    	List<GioHang> gioHangs = new ArrayList<>();
	    	for (String i : listGioHangs) {
				GioHang gioHang = gioHangService.findOne(UUID.fromString(i));
				gioHangs.add(gioHang);
			}
	    	
	    	BigDecimal tong = BigDecimal.valueOf(0);
		    for (GioHang gioHang : gioHangs) {
				tong = tong.add(gioHang.getTong());
			}
		    request.getSession().setAttribute("listGioHangs", listGioHangs);
		    request.setAttribute("listThanhToan", gioHangs);
		    request.setAttribute("tongTien", tong);
		    request.getRequestDispatcher("/views/pages/thanhToan.jsp").forward(request, response);
	    }
	    
	}

	private void hienThi(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Account account = (Account) request.getSession().getAttribute("account");
		List<GioHang> list = gioHangService.findByAccount(account);
		request.getSession().setAttribute("slGioHang", list.size());
		request.setAttribute("listGioHang", list);
		request.getRequestDispatcher("/views/pages/gioHang.jsp").forward(request, response);
	}

	private void deleteGioHang(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		gioHangService.delete(UUID.fromString(id));
		hienThi(request, response);
	}

}
