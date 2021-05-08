package com.the.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.the.dao.BoardDao;
import com.the.dto.BoardDto;

public class BoardListService implements BoardService {

	public String process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//DB 처리는 DAO 객체에서 처리한다.
		BoardDao boardDao = new BoardDao();
		List<BoardDto> result = boardDao.getList();
		
		request.setAttribute("list", result);
		
		return "/WEB-INF/views/board/list.jsp";
	}

}
