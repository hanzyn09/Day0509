package com.the.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.the.dto.BoardDto;
import com.the.mybatis.MybatisConfig;

public class BoardDao {
	private static SqlSessionFactory sqlSessionFactory;
	
	public BoardDao() {
		sqlSessionFactory = MybatisConfig.getInstance();
	}
	
	public List<BoardDto> getList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//검색 쿼리 실행						namespace.id로 mapper안의 문장을 실행시킨다.
		List<BoardDto> result = sqlSession.selectList("boardMapper.list");
		
		
		sqlSession.close();
		return result;
	}

	public int save(BoardDto boardDto) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//삽입한 data의 row 수를 리턴해준다.
		int result = sqlSession.insert("boardMapper.save", boardDto);
		
		sqlSession.commit();
		sqlSession.close();
		
		return 0;
	}

	public BoardDto detail(long no) {
		
		return null;
	}

}
