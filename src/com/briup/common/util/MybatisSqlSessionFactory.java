package com.briup.common.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSqlSessionFactory {
	private static SqlSessionFactory factory = null;

	private static SqlSessionFactory getFactory() {
		if (factory == null) {
			synchronized (MybatisSqlSessionFactory.class) {
				try {
					if (factory == null) {
						InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
						factory = new SqlSessionFactoryBuilder().build(is);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return factory;
	}
	public static SqlSession openSession(boolean autoCommit){
		//openSession没有传入参数的时候默认false，手动提交
		return getFactory().openSession(autoCommit);
	}
	public static SqlSession openSession(){
		return openSession(false);
	}
}
