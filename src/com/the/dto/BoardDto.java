package com.the.dto;

import java.sql.Timestamp;

public class BoardDto {
	private long no;
	private String subject;
	private String content;
	private int read_count;
	private String writer;
	private Timestamp created_date;
	
	public long getNo() {
		System.out.println("getNo() 실행");
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRead_count() {
		return read_count;
	}
	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Timestamp getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}
	
	 
}
