package com.briup.service.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Category;
import com.briup.common.util.MybatisSqlSessionFactory;
import com.briup.dao.ICategoryDao;
import com.briup.service.ICategoryService;

public class ICategoryServiceImpl implements ICategoryService{

	@Override
	public List<Category> listCategory() {
		SqlSession session = MybatisSqlSessionFactory.openSession();
		ICategoryDao dao = session.getMapper(ICategoryDao.class);
		List<Category> list = dao.listAllCates();
		return list;
	}

	@Override
	public void saveCategory(Category category) {
	}

	@Override
	public void delCategory(Long categoryId) {
	}

}
