package com.the.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfig {
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionFactory getInstance() {
		if(sqlSessionFactory == null) new MybatisConfig();
		
		return sqlSessionFactory;
	}
	
	private MybatisConfig() {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("/com/the/mybatis/mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
}
