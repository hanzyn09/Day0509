package com.the.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardDeleteService implements BoardService {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//삭제할 대상
		long no = Long.parseLong(request.getParameter("no"));
		
		//db에서 삭제 요청
		boardDao.delete(no);
		
		//삭제 완료 후 페이지 이동 list
		response.sendRedirect("list");
		return null;
	}

}
