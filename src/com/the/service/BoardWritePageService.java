package com.the.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardWritePageService implements BoardService {

	public String process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		return "/WEB-INF/views/board/write.jsp";
	}

}
