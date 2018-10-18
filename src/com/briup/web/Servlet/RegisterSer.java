package com.briup.web.Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.User;
import com.briup.common.exception.UserException;
import com.briup.common.util.MD5;
import com.briup.service.IUserService;
import com.briup.service.Impl.IUserServiceImpl;
@WebServlet("/RegisterSer")
public class RegisterSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String passwd=request.getParameter("password");
		String zip=request.getParameter("zip");
		String address=request.getParameter("address");
		String phone=request.getParameter("telephone");
		String email=request.getParameter("email");
		String password = MD5.getMD5Str(passwd);
		User user = new User();
		user.setUsername(name);
		user.setPassword(password);
		user.setZip(zip);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);
		user.setDob(new Date());
		IUserService ser=new IUserServiceImpl();
		try {
			ser.registerUser(user);
//			System.out.println("调用注册方法");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} catch (UserException e) {
			System.out.println(e.getMessage());
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
