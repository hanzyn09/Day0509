<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/common/menu.jsp"/>
	<h1>게시판 페이지</h1>
	<a href="write-page">글쓰기</a>
	<table>
		<tr>
			<td>글 번호</td>
			<td>제목</td>
			<td>조회수</td>
			<td>작성자</td>
			<td>작성일</td>
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.no }</td>
				<td><a href="detail?no=${dto.no}">${dto.subject }</a></td>
				<td>${dto.read_count }</td>
				<td>${dto.writer }</td>
				<td>${dto.created_date }</td>
			</tr>
		</c:forEach>
		<c:if test="${empty list }">
			<tr>
				<td colspan="5">게시글이 존재하지 않습니다.</td>
			</tr>
		</c:if>
	</table>
</body>
</html>