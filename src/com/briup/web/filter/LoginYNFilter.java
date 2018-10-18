package com.briup.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.briup.bean.User;

/**
 * Servlet Filter implementation class LoginYNFilter
 */
@WebFilter("/user/*")
public class LoginYNFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if(user!=null){
			chain.doFilter(request, response);
		}else{
			req.setAttribute("msg", "please login!");
			req.getRequestDispatcher("/login.jsp").forward(req, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
