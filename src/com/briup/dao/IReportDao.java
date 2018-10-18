package com.briup.dao;
import java.util.SortedSet;

import com.briup.bean.Report;


public interface IReportDao {
	public SortedSet<Report> listAllReport();
}