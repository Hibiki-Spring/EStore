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

/**
 * Servlet implementation class LoginSer
 */
@WebServlet("/LoginSer")
public class LoginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		IUserService ser = new IUserServiceImpl();
		try {
			User user = ser.loginUser(name, password);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("indexSuccess.jsp").forward(request, response);
		} catch (UserException e) {
			//带消息给login.jsp
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);
//			System.out.println("错误："+e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
