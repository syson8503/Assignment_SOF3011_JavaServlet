package com.poly.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.entity.Account;
import com.poly.service.AccountService;
import com.poly.service.AccountServiceImpl;

@WebServlet({"/admin/account/hien-thi", "/admin/account/delete", "/admin/account/detail", "/admin/account/update", "/admin/account/add"})
public class AccountController extends HttpServlet {
	
	private AccountService accountService = new AccountServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();

		if (uri.contains("hien-thi")) {
			this.hienThi(request, response);
		} else if (uri.contains("delete")) {
			this.deleteProduct(request, response);
		} else if (uri.contains("detail")) {
			this.detailProduct(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();

		if (uri.contains("add")) {
			this.addProduct(request, response);
		} else if (uri.contains("update")) {
			this.updateProduct(request, response);
		}
	}

	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account account = getAccount(request, response);
		if(account == null) {
			hienThi(request, response);
		} else {
			accountService.update(account);
			hienThi(request, response);
		}
	}

	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account account = getAccount(request, response);
		if(account == null) {
			hienThi(request, response);
		} else {
			accountService.create(account);
			hienThi(request, response);
		}
	}
	
	private Account getAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nameAcc = request.getParameter("nameAcc");
        String birthday = request.getParameter("birthday");
        String sdt = request.getParameter("sdt");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Boolean gioiTinh = Boolean.parseBoolean(request.getParameter("gioiTinh"));
        Boolean trangThai = Boolean.parseBoolean(request.getParameter("trangThai"));
        Boolean chucVu = Boolean.parseBoolean(request.getParameter("chucVu"));
        
        int loi = 0;
        if(username.length() == 0) {
        	request.setAttribute("errorUname", "Username không được để trống");
        	loi++;
        }
        if(password.length() == 0) {
        	request.setAttribute("errorPW", "Password không được để trống");
        	loi++;
        }
        if(nameAcc.length() == 0) {
        	request.setAttribute("errorName", "Name không được để trống");
        	loi++;
        }
        if(birthday.length() == 0) {
        	request.setAttribute("errorNgaySinh", "Ngày sinh không được để trống");
        	loi++;
        }
        if(sdt.length() == 0) {
        	request.setAttribute("errorSDT", "SDT không được để trống");
        	loi++;
        }
        if(email.length() == 0) {
        	request.setAttribute("errorEmail", "Email không được để trống");
        	loi++;
        }
        if(address.length() == 0) {
        	request.setAttribute("errorDiaChi", "Địa chỉ không được để trống");
        	loi++;
        }
        
        Date ngaySinh = Date.valueOf(birthday);
        if(loi != 0) {
        	return null;
        }
		Account account = new Account(username, password, nameAcc, ngaySinh, gioiTinh, sdt, email, address, trangThai, chucVu);
		return account;
	}

	private void detailProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("uname");
		Account account = accountService.findOne(id);
		request.setAttribute("accountForm", account);
		request.getSession().setAttribute("accountEdit", account);
		hienThi(request, response);
	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("uname");
		accountService.delete(id);
		hienThi(request, response);
	}

	private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listAccount", accountService.findAll());
		request.getRequestDispatcher("/views/pages/account.jsp").forward(request, response);
	}


}
