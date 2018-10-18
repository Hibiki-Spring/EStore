package com.briup.service.Impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.User;
import com.briup.common.exception.UserException;
import com.briup.common.util.MD5;
import com.briup.common.util.MybatisSqlSessionFactory;
import com.briup.dao.IUserDao;
import com.briup.service.IUserService;

public class IUserServiceImpl implements IUserService {

	@Override
	public void registerUser(User user) throws UserException {
		SqlSession session = MybatisSqlSessionFactory.openSession(true);
		IUserDao dao = session.getMapper(IUserDao.class);
		String name = user.getUsername();
		if (dao.findUserByName(name) != null) {
			throw new UserException("用户已存在！");
		} else {
			dao.saveUser(user);
		}
	}

	@Override
	public User loginUser(String name, String password) throws UserException {
		SqlSession session = MybatisSqlSessionFactory.openSession();
		IUserDao dao = session.getMapper(IUserDao.class);
		if (dao.findUserByName(name) != null) {
			User user = dao.findUserByName(name);
			if (user.getPassword().equals(MD5.getMD5Str(password))) {
				return user;
			} else {
				throw new UserException("密码错误！");
			}
		} else {
			throw new UserException("用户不存在！");
		}
	}

	@Override
	public User getUserByName(String name) throws UserException {
		return null;
	}

	@Override
	public void updateUserInfo(User user) throws UserException {
		SqlSession session = MybatisSqlSessionFactory.openSession(true);
		IUserDao dao = session.getMapper(IUserDao.class);
		dao.updateUser(user);
	}

}
