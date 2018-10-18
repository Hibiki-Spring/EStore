package com.briup.web.Listener;

import java.util.List;
import java.util.SortedSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.briup.bean.Category;
import com.briup.bean.Report;
import com.briup.common.exception.ReportException;
import com.briup.service.ICategoryService;
import com.briup.service.IReportService;
import com.briup.service.Impl.ICategoryServiceImpl;
import com.briup.service.Impl.IReportServiceImpl;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0)  { 
    	
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
    	ServletContext sc = arg0.getServletContext();
    	ICategoryService service = new ICategoryServiceImpl();
    	List<Category> list = service.listCategory();
    	sc.setAttribute("categorys", list);
    	//
    	IReportService reser = new IReportServiceImpl();
    	try {
			SortedSet<Report> reports = reser.listReport();
			sc.setAttribute("reports", reports);
		} catch (ReportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
