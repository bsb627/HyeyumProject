<%@page import="notice.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Notice> nList = (ArrayList<Notice>)request.getAttribute("nList");
	String pageNavi = (String)request.getAttribute("pageNavi");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
</head>
<body>
	<h1>공지사항</h1>
	<table border="1">
		<tr>
			<th>글번호</th><th>제목</th>
			<th>작성자</th><th>조회수</th><th>작성일</th>
		</tr>
		<% for(Notice notice : nList)  { %>
		<tr>
			<td><%= notice.getNoticeNo() %></td>
			<td><a href="/notice/detail?noticeNo=<%= notice.getNoticeNo()%>">
				<%= notice.getTitle() %></a>
			</td>
			<td><%= notice.getHits() %></td>
			<td><%= notice.getUserId() %></td>
			<td><%= notice.getEnrollDate() %></td>
		</tr>
		<% } %>
		<tr>
			<td colspan="3" align="center">
				<form action="/notice/search" method="get">
					<input type="text" name="searchKeyword">
					<input type="submit" value="검색">
				</form>
			</td>
			<td>
				<form action="/notice/write" method="get">
					<input type="submit" value="글쓰기">
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<%= pageNavi %>
			</td>
		</tr>
	</table>
</body>
</html>