package com.the.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.the.service.BoardService;


@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, BoardService> serviceMap;

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletContext = config.getServletContext();
		serviceMap = (Map<String, BoardService>) servletContext.getAttribute("serviceMap"); 
		//저장하게되면 object로 저장되므로 형변환 필요
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println("URI : " + uri);
		String[] strs = uri.split("[/]");
		String key = strs[strs.length-1];
		
		String path = null;
		System.out.println("serviceMap.size() : " + serviceMap.size());
		
		//비지니스 로직은 service를 통해서 합니다.
		BoardService boardService = serviceMap.get(key);
	
		//서비스 실행
		if(boardService != null) {
			path = boardService.process(request, response);
		}
	
		//view
		if(path != null) {
			System.out.println("jsp로 이동...");
			request.getRequestDispatcher(path).forward(request, response);
		}
	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
