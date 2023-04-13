package com.poly.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.entity.Account;
import com.poly.entity.Product;
import com.poly.service.AccountService;
import com.poly.service.AccountServiceImpl;
import com.poly.service.ProductService;
import com.poly.service.ProductServiceImpl;

@WebServlet({"/Log-in", "/Register", "/forgot-password", "/Log-in/dang-nhap", "/Register/dang-ky", "/forgot-password/quen-mat-khau"})
public class TaiKhoanController extends HttpServlet {
	private AccountService accountService = new AccountServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.contains("Log-in")) {
			request.getRequestDispatcher("/views/pages/dangNhap.jsp").forward(request, response);
		} else if(uri.contains("Register")) {
			request.getRequestDispatcher("/views/pages/dangKy.jsp").forward(request, response);
		} else if(uri.contains("forgot-password")) {
			request.getRequestDispatcher("/views/pages/quenMatKhau.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.contains("dang-nhap")) {
			this.dangNhap(request, response);
		} else if(uri.contains("dang-ky")) {
			this.dangKy(request, response);
		} else if(uri.contains("quen-mat-khau")) {
			this.quenMatKhau(request, response);
		}
	}

	private void quenMatKhau(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String newPW = request.getParameter("newPW");
		String confirm = request.getParameter("confirm");
		
		int loi = 0;
		if(username.length() == 0) {
			request.setAttribute("errorUName", "Username không được để trống");
			loi++;
		}
		if(password.length() == 0) {
			request.setAttribute("errorPW", "Password không được để trống");
			loi++;
		}
		if(newPW.length() == 0) {
			request.setAttribute("errorNewPW", "New Password không được để trống");
			loi++;
		}
		if(confirm.length() == 0) {
			request.setAttribute("errorConfirm", "Confirm không được để trống");
			loi++;
		}
		Account account = accountService.findById(username, password);
		if(account == null) {
			request.setAttribute("error", "Tài khoản mật khẩu sai");
			loi++;
		}
		if (!newPW.equalsIgnoreCase(confirm)) {
			request.setAttribute("error", "New password và Confirm phải trùng nhau");
			loi++;
		}
		
		if(loi != 0) {
			request.getRequestDispatcher("/views/pages/quenMatKhau.jsp").forward(request, response);
		} else {
			account.setMatKhau(newPW);
			accountService.update(account);
			request.setAttribute("error", "Thay đổi mật khẩu thành công");
			request.getRequestDispatcher("/views/pages/quenMatKhau.jsp").forward(request, response);
		}
	}

	private void dangKy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("nameAcc");
		String birthday = request.getParameter("birthday");
		String sdt = request.getParameter("sdt");
		Boolean gioiTinh = Boolean.parseBoolean(request.getParameter("gioiTinh"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		Boolean tinhTrang = true;
		Boolean chucVu = false;
		
		int loi = 0;
        if(username.length() == 0) {
        	request.setAttribute("errorUname", "Username không được để trống");
        	loi++;
        }
        if(password.length() == 0) {
        	request.setAttribute("errorPW", "Password không được để trống");
        	loi++;
        }
        if(name.length() == 0) {
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
        if(loi != 0) {
        	request.getRequestDispatcher("/views/pages/dangKy.jsp").forward(request, response);
        } else {
        	Date ngaySinh = Date.valueOf(birthday);
        	Account account = new Account(username, password, name, ngaySinh, gioiTinh, sdt, email, address, tinhTrang, chucVu);
        	accountService.create(account);
        	request.setAttribute("error", "Tạo mới tài khoản thành công");
        	request.getRequestDispatcher("/views/pages/dangKy.jsp").forward(request, response);
        }
	}

	private void dangNhap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		int loi = 0;
		if(username.length() == 0) {
			request.setAttribute("errorUName", "Username không được trống");
			loi++;
		}
		if(password.length() == 0) {
			request.setAttribute("errorPW", "Password không được trống");
			loi++;
		}
		Account account = accountService.findById(username, password);
		try {
			if(account == null) {
				request.setAttribute("error", "Đăng nhập thất bại");
				loi++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(loi != 0) {
			request.getRequestDispatcher("/views/pages/dangNhap.jsp").forward(request, response);
		} else {
			if(account.getChucVu()) {
				request.getSession().setAttribute("account", account);
				response.sendRedirect("/Assignment/admin/product/hien-thi");
			} else {
				request.getSession().setAttribute("account", account);
				response.sendRedirect("/Assignment/client/home/hien-thi");
			}
		}
	}

}
