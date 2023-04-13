package com.poly.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.entity.Category;
import com.poly.service.CategoryService;
import com.poly.service.CategoryServiceImpl;

@WebServlet({ "/admin/category/hien-thi", "/admin/category/add", "/admin/category/update", "/admin/category/delete", "/admin/category/detail" })
public class CategoryController extends HttpServlet {

	private CategoryService categoryService = new CategoryServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		if (uri.contains("hien-thi")) {
			this.hienThi(request, response);
		} else if (uri.contains("delete")) {
			this.deleteCategory(request, response);
		} else if (uri.contains("detail")) {
			this.detailCategory(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		if(uri.contains("add")) {
			this.addCategory(request, response);
		} else if(uri.contains("update")) {
			this.updateCategory(request, response);
		}
	}

	private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category category = (Category) request.getSession().getAttribute("categoryEdit");
		String name = request.getParameter("nameCategory");
		
		int loi = 0;
		 if(name.length() == 0) {
			 request.setAttribute("errorName", "Không được để trống tên loại");
			 loi++;
		 }
		 
		 if(loi != 0) {
			 hienThi(request, response);
		 } else {
			 category.setTenLoai(name);
				categoryService.update(category);
				hienThi(request, response);
		 }
		
	}

	private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("nameCategory");
		
		int loi = 0;
		 if(name.length() == 0) {
			 request.setAttribute("errorName", "Không được để trống tên loại");
			 loi++;
		 }
		 
		 if(loi != 0) {
			 hienThi(request, response);
		 } else {
			 Category category = new Category(null, name);
				categoryService.create(category);
				hienThi(request, response);
		 }
		
	}

	private void detailCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String id = request.getParameter("idLoai");
			Category category = categoryService.findOne(UUID.fromString(id));
			request.setAttribute("categoryForm", category);
			request.getSession().setAttribute("categoryEdit", category);
			hienThi(request, response);
		
	}

	private void deleteCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String id = request.getParameter("idLoai");
			categoryService.delete(UUID.fromString(id));
			hienThi(request, response);
		
	}

	private void hienThi(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("listCategory", categoryService.findAll());
		request.getRequestDispatcher("/views/pages/category.jsp").forward(request, response);
	}

}
