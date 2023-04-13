package com.poly.controller;

import java.io.IOException;
import java.math.BigDecimal;
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

@WebServlet({ "/admin/product/hien-thi", "/admin/product/detail", "/admin/product/add", "/admin/product/update", "/admin/product/delete" })
public class ProductController extends HttpServlet {
	private ProductService productService = new ProductServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		if (uri.contains("hien-thi")) {
			this.hienThi(request, response);
		} else if (uri.contains("delete")) {
			this.deleteProduct(request, response);
		} else if (uri.contains("detail")) {
			this.detailProduct(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		if (uri.contains("add")) {
			this.addProduct(request, response);
		} else if (uri.contains("update")) {
			this.updateProduct(request, response);
		}
	}

	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product p = getProduct(request, response);
		if(p == null) {
        	hienThi(request, response);
        } else {
        	Product product = (Product) request.getSession().getAttribute("productEdit");
    		
    		product.setTenSP(p.getTenSP());
    		product.setPrice(p.getPrice());
    		product.setQuantity(p.getQuantity());
    		product.setHinhAnh(p.getHinhAnh());
    		product.setGioiThieu(p.getGioiThieu());
    		product.setCategory(p.getCategory());
    		productService.update(product);
    		hienThi(request, response);
        }
	}

	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        Product product = getProduct(request, response);
        if(product == null) {
        	hienThi(request, response);
        } else {
        	productService.create(product);
    		hienThi(request, response);
        }		
	}

	private Product getProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("nameProduct");
        String priceStr = request.getParameter("priceProduct");
        String soLuongStr = request.getParameter("slProduct");
        String image = request.getParameter("imageProduct");
        String note = request.getParameter("desProduct");
        String idCategory = request.getParameter("categorySP");
        
        int loi = 0;
        
        if(name.length() == 0) {
        	request.setAttribute("errorName", "Không được để trống tên");
        	loi++;
        }
        if(priceStr.length() == 0) {
        	request.setAttribute("errorPrice", "Không được để trống đơn giá");
        	loi++;
        } 
        if(soLuongStr.length() == 0) {
        	request.setAttribute("errorSoLuong", "Không được để trống Số lượng");
        	loi++;
        }
        if(image.length() == 0) {
        	request.setAttribute("errorImage", "Không được để trống image");
        	loi++;
        }
        if(note.length() == 0) {
        	request.setAttribute("errorDesc", "Không được để trống Ghi chú");
        	loi++;
        }
        int price = 0;
        try {
			price = Integer.parseInt(priceStr);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorPrice", "Đơn giá phải là số");
        	loi++;
		}
        int soLuong = 0;
        try {
        	soLuong = Integer.parseInt(soLuongStr);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorSoLuong", "Số lượng phải là số");
        	loi++;
		}
        
        if(loi != 0) {
        	return null;
        } else {
        	Category category = categoryService.findOne(UUID.fromString(idCategory));
            
    		Product product = new Product(null, name, BigDecimal.valueOf(price), soLuong, note, image, category);
    		return product;
        }
	}

	private void hienThi(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("listCategory", categoryService.findAll());
		request.setAttribute("listProduct", productService.findAll());
		request.getRequestDispatcher("/views/pages/product.jsp").forward(request, response);
	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idSP");
		productService.delete(UUID.fromString(id));
		hienThi(request, response);
	}

	private void detailProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idSP");
		Product product = productService.findOne(UUID.fromString(id));
		request.setAttribute("productForm", product);
		request.getSession().setAttribute("productEdit", product);
		hienThi(request, response);
	}

}
