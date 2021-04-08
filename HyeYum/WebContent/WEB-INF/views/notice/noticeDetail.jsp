<%@page import="notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Notice notice = (Notice)request.getAttribute("notice");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
</head>
<body>
	<h2>제목 : <%=notice.getTitle() %></h2>
	<h6>글번호 : <%=notice.getNoticeNo() %> / 작성자 : <%= notice.getUserId() %> / 
	작성일 : <%= notice.getEnrollDate() %></h6>
	<h6>조회수 :  <%=notice.getHits() %></h6>
	<h3>글내용</h3>
	<div>
		<%= notice.getContents() %>
	</div>
</body>
</html>