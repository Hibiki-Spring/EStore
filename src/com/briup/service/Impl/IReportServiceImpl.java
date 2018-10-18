package com.briup.service.Impl;

import java.util.SortedSet;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Report;
import com.briup.common.exception.ReportException;
import com.briup.common.util.MybatisSqlSessionFactory;
import com.briup.dao.IReportDao;
import com.briup.service.IReportService;

public class IReportServiceImpl implements IReportService{

	@Override
	public void saveReport(Report report) throws ReportException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateReport(Report report) throws ReportException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delReport(Long reportId) throws ReportException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SortedSet<Report> listReport() throws ReportException {
		SqlSession session = MybatisSqlSessionFactory.openSession();
		IReportDao dao = session.getMapper(IReportDao.class);
		SortedSet<Report> report = dao.listAllReport();
		return report;
	}

}
