package com.poly.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.entity.Account;
import com.poly.entity.GioHang;
import com.poly.entity.Product;
import com.poly.service.AccountService;
import com.poly.service.AccountServiceImpl;
import com.poly.service.GioHangService;
import com.poly.service.GioHangServiceImpl;

@WebServlet({"/client/detail/add-gio-hang"})
public class DetailController extends HttpServlet {
	private GioHangService gioHangService = new GioHangServiceImpl();
	private AccountService accountService = new AccountServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.contains("add-gio-hang")) {
			this.addGioHang(request, response);
		}
	}

	private void addGioHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account account = (Account) request.getSession().getAttribute("account");
		Product product = (Product) request.getSession().getAttribute("productDetail");
		String soLuongStr = request.getParameter("soLuong");
		int soLuong = Integer.parseInt(soLuongStr);
		
		BigDecimal tong = product.getPrice().multiply(BigDecimal.valueOf(soLuong));
		GioHang gioHang = new GioHang(null, product, soLuong, product.getPrice(), tong, account);
		gioHangService.create(gioHang);

		List<GioHang> list = gioHangService.findByAccount(account);
		request.getSession().setAttribute("slGioHang", list.size());
		request.setAttribute("listGioHang", list);
		request.getRequestDispatcher("/views/pages/gioHang.jsp").forward(request, response);
	}

}
