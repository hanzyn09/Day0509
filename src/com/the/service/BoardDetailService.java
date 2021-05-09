package com.the.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.the.dto.BoardDto;

public class BoardDetailService implements BoardService {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String _no = request.getParameter("no"); //db에선 long 형인데 파라미터로 받으면 문자열이므로 형변환 필요
		
		long no = Long.parseLong(_no);
		BoardDto result = boardDao.detail(no);
		
		return null;
	}

}
