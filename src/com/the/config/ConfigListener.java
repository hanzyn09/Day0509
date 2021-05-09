package com.the.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.io.Resources;

import com.the.service.BoardService;

@WebListener
public class ConfigListener implements ServletContextListener {


    @SuppressWarnings("deprecation")
	public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("서버 시작 시 실행되는 메서드...");
         ServletContext sc = sce.getServletContext(); //어플리케이션 컨텍스트 객체
         
         //mybatis인 경우 Resources 객체 제공
         String resource = "/com/the/service/serviceConfig.properties";
         try {
        	 //프로퍼티는 k,v 모두 문자열로 저장된 타입 
			Properties classInfo = Resources.getResourceAsProperties(resource);
			System.out.println(classInfo.size());
			/*
			 * value가 문자열로 되어 있는 클래스 정보
			 * 인스턴스화 시키고 map 저장소에 저장
			 * */
			Map<String, BoardService> serviceMap = new HashMap<>();
			
			//key정보 먼저 획득
			Set<Object> keys = classInfo.keySet(); //key만 읽어와서 set으로 만들었다. 순서는 없다.
			//set은 인덱스가 없다. 이터레이터로 받을 수 있지만 forEach를 이용한다.
			for(Object obj : keys) {
				//map에 저장할 key
				String key = (String)obj;
				String className = (String)classInfo.get(key);
				System.out.println(key + " = " + className);
				
				Class<?> clazz = Class.forName(className); // ? : any class
				
				//map에 저장할 value
				BoardService boardService = (BoardService)clazz.getDeclaredConstructor().newInstance(); //오브젝트로 인스턴스화
				serviceMap.put(key, boardService);
			}//for END
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
         
    }
	
    public void contextDestroyed(ServletContextEvent sce)  { 
       
   }
}
