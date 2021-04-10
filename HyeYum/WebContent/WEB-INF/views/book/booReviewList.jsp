<%@page import="book.model.vo.BookReview"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = (String)session.getAttribute("userId");
	out.write("로그인 ID는 : "+userId+"입니다");
	ArrayList<BookReview> bList = (ArrayList<BookReview>)request.getAttribute("bList");
	String pageNavi = (String)request.getAttribute("pageNavi");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 리뷰 리스트</title>
</head>
<body>
<table class="table table-hover" width="100%" cellpadding="0" cellspacing="0" border="1">

	<tr>
		<td>
			<form action="/bookReview/enroll" method="post">
				<button type="submit" class="button" value="글쓰기"></button>
			</form>
		</td>
		<td>
			<input type="text">
		</td>
		<td colspan="3" align="center">
			<input type="text">
		</td>
		<td>
			<button class="button">검색</button>
		</td>	
	</tr>
	<thread>
		<tr>
			<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th><th>좋아요</th>
		</tr>
	</thread>
	<% for(BookReview review : bList) { %>
	<tr>
		<td><%=review.getNo() %></td>
		<td><%=review.getDivision() %></td>
		<td><%=review.getTitle() %></td>
		<td><%=review.getNick() %></td>
		<td><%=review.getEnrollDate() %></td>
		<td><%=review.getHits() %></td>
		<td><%=review.getLikes() %></td>
	</tr>
	<% } %>
</table>
<table>
	<tr>
		<td>
			<%= pageNavi %>
		</td>
	</tr>
</table>
</body>
</html>