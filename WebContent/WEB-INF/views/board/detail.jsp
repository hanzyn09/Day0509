<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/common/menu.jsp"/>
	<h1>상세 페이지</h1>
	<a href="list">게시글 목록</a>
	<form action="update" method="post">
	<table border="1">
		<tr>
			<td>글번호</td>
			<td colspan="3">${detail.no }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${detail.writer }</td>
			<td>작성일</td>
			<td>${detail.created_date }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="3">
				<input type="text" value="${detail.subject }" name="subject">
				(${detail.read_count })</td>
		</tr>
		<tr>
			<td>내용</td>
			<td colspan="3">
				<textarea rows="5" cols="40" name="content">${detail.content }</textarea>
				${detail.content } 
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<input type="hidden" name ="no" value="${detail.no }">
				<button type="submit">수정</button>
				<a href="delete?no=${detail.no }">
					<button type="button">삭제</button>
				</a>
			</td>
		</tr>
	</table>
	</form>
	
</body>
</html>