package com.the.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.the.dto.BoardDto;

public class BoardUpdateService implements BoardService {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//수정할 데이터 확인
		request.setCharacterEncoding("utf-8");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		long no = Long.parseLong(request.getParameter("no"));
				
		BoardDto boardDto = new BoardDto();
		boardDto.setSubject(subject);
		boardDto.setContent(content);
		boardDto.setNo(no);
		
		//db 요청
		boardDao.update(boardDto);
				
		//삭제 완료 후 페이지 이동 list
		response.sendRedirect("list");
		
		return null;
	}

}
