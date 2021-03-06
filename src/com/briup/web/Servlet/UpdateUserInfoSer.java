package com.briup.web.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.User;
import com.briup.common.exception.UserException;
import com.briup.service.IUserService;
import com.briup.service.Impl.IUserServiceImpl;

@WebServlet("/UpdateUserInfoSer")
public class UpdateUserInfoSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String zip = request.getParameter("zip");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		User user = new User();
		user.setUsername(name);
		user.setPassword(password);
		user.setZip(zip);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);
		IUserService ser = new IUserServiceImpl();
		try {
			ser.updateUserInfo(user);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.setAttribute("msg", "Update UserInfo Success!");
//			response.sendRedirect("user/userinfo.jsp");
			request.getRequestDispatcher("user/userinfo.jsp").forward(request, response);
		} catch (UserException e) {
			request.setAttribute("msg", "Update UserInfo failed!");
			request.getRequestDispatcher("user/userinfo.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
