package com.the.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.the.dao.BoardDao;

public interface BoardService {
	BoardDao boardDao = new BoardDao();

	String process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	
}
