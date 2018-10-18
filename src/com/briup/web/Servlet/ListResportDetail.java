package com.briup.web.Servlet;

import java.io.IOException;
import java.util.SortedSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Report;

/**
 * Servlet implementation class ListResportDetail
 */
@WebServlet("/ListResportDetail")
public class ListResportDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("report_id");
		long id = Long.parseLong(sid);
		Report re = null;
		ServletContext sc = request.getServletContext();
		SortedSet<Report> reports = (SortedSet<Report>) sc.getAttribute("reports");
		for(Report r:reports){
			if(r.getId()==id){
				re=r;
			}
		}
		request.setAttribute("report", re);
		request.getRequestDispatcher("/detail.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
