package com.poly.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.entity.Category;
import com.poly.entity.Product;
import com.poly.service.CategoryService;
import com.poly.service.CategoryServiceImpl;
import com.poly.service.ProductService;
import com.poly.service.ProductServiceImpl;

@WebServlet({"/client/san-pham/hien-thi", "/client/san-pham/detail", "/client/san-pham/category", "/client/san-pham/add-gioHang"})
public class SanPhamController extends HttpServlet {
	
	private ProductService productService = new ProductServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String uri = request.getRequestURI();
		
		if(uri.contains("hien-thi")) {
			this.hienThi(request, response);
		} else if(uri.contains("detail")) {
			this.detailProduct(request, response);
		} else if(uri.contains("category")) {
			this.categoryProduct(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
private void categoryProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Category category = categoryService.findOne(UUID.fromString(id));
		request.setAttribute("listCategory", categoryService.findAll());
		request.setAttribute("listProducts", category.getCategoryList());
		request.getRequestDispatcher("/views/pages/sanPham.jsp").forward(request, response);
	}

private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setAttribute("listCategory", categoryService.findAll());
	request.setAttribute("listProducts", productService.findAll());
	request.getRequestDispatcher("/views/pages/sanPham.jsp").forward(request, response);
	}

private void detailProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("idDetail");
	Product product = productService.findOne(UUID.fromString(id));
	request.getSession().setAttribute("productDetail", product);
	request.getRequestDispatcher("/views/pages/detail.jsp").forward(request, response);
}
}
