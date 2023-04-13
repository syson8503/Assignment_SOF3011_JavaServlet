package com.poly.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.entity.Account;

@WebFilter({"/client/detail/add-gio-hang", "/client/gio-hang/*", "/admin/*", "/forgot-password/quen-mat-khau"})
public class AuthFilter extends HttpFilter implements Filter {
    
    public AuthFilter() {
        super();
    }

	public void destroy() {
	}

	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		String uri = request.getRequestURI();
		Account account = (Account) request.getSession().getAttribute("account");
		String error = "";
		if(account == null) {
			error = response.encodeUrl("Vui Lòng đăng nhập!");
		} else if(!account.getChucVu() && uri.contains("/admin/")) {
			error = response.encodeUrl("Vui Lòng đăng nhập với vai trò admin!");
		}
		
		if(!error.isEmpty()) {
			request.getSession().setAttribute("securi", error);
			response.sendRedirect("/Assignment/Log-in");
		} else {
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
