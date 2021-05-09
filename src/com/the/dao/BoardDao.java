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
		
		sqlSession.commit(); //db변경 시 커밋 필수
		sqlSession.close();
		
		return 0;
	}

	public BoardDto detail(long no) {
		//select(커밋 필요 없음)
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//mapper에 넘겨주는 인자(파라미터 변수에 입력되는 데이터)는 한개로 넘겨주세요.
		BoardDto result = sqlSession.selectOne("boardMapper.detail", no);
		
		sqlSession.update("boardMapper.count", no);
		sqlSession.commit();
		
		sqlSession.close();
		
		return result;
	}

	public void delete(long no) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true); 
									//넘겨주는 정보가 1개이므로 true : auto commit
		sqlSession.delete("boardMapper.delete", no);
		sqlSession.close();		
	}

	public void update(BoardDto boardDto) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true); 
		sqlSession.update("boardMapper.update", boardDto);
		sqlSession.close();	
	}

}
