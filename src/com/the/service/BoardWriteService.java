package com.the.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.the.dao.BoardDao;
import com.the.dto.BoardDto;

public class BoardWriteService implements BoardService {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//1. 웹에서 입력된 데이터 확인
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		BoardDto boardDto = new BoardDto();
		boardDto.setSubject(subject);
		boardDto.setContent(content);
		
		//2. db에 저장
		int result = boardDao.save(boardDto);
		System.out.println(result+"개의 게시글을 등록하였습니다.");
		
		//3. 페이지 이동(list 페이지)
		//현재 url 정보를 list로 수정한다. write -> list
		//요청은 write였는데, 컨트롤러에 리스트로 돌아가게 하는 기능을 구현했으므로 url 변경시킴)
		response.sendRedirect("list");
		return null;
	}

}
