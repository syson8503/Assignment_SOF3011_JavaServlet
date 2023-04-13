package com.poly.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.entity.Account;
import com.poly.entity.GioHang;
import com.poly.entity.Product;
import com.poly.service.CategoryService;
import com.poly.service.CategoryServiceImpl;
import com.poly.service.GioHangService;
import com.poly.service.GioHangServiceImpl;
import com.poly.service.ProductService;
import com.poly.service.ProductServiceImpl;

@WebServlet({ "/", "/client/home/hien-thi", "/client/home/detail", "/client/search"})
public class TrangChuController extends HttpServlet {
	private ProductService productService = new ProductServiceImpl();
	private GioHangService gioHangService = new GioHangServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		if (uri.contains("hien-thi")) {
			this.hienThi(request, response);
		} else if (uri.contains("detail")) {
			this.detailProduct(request, response);
		} else if (uri.contains("search")) {
			this.searchProduct(request, response);
		} else if (uri.contains("")) {
			this.hienThi(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		if (uri.contains("")) {
			
		}
	}
	
    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		request.setAttribute("listProducts", productService.findByKeyword(search));
		request.setAttribute("listCategory", categoryService.findAll());
		request.getRequestDispatcher("/views/pages/sanPham.jsp").forward(request, response);
	}

	private void hienThi(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Account account = (Account) request.getSession().getAttribute("account");
		
		if(account != null) {
			request.getSession().setAttribute("slGioHang", gioHangService.findByAccount(account).size());
		} else {
			request.getSession().setAttribute("slGioHang", 0);
		}
		
		request.setAttribute("listProducts", productService.findAll());
		request.getRequestDispatcher("/views/pages/trangChu.jsp").forward(request, response);
	}

	private void detailProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("idDetail");
		Product product = productService.findOne(UUID.fromString(id));
		request.getSession().setAttribute("productDetail", product);
		request.getRequestDispatcher("/views/pages/detail.jsp").forward(request, response);
	}
}
