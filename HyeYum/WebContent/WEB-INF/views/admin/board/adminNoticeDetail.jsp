<%@page import="notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%Notice notice =(Notice)request.getAttribute("notice"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/admin/notice/update" method="post">
제목<%=notice.getNoticeNo() %><%=notice.getTitle() %>
<input type="hidden" name="noticeNo" value="<%=notice.getNoticeNo() %>">
<input type="text" name="notice-title" value="<%=notice.getTitle() %>">
<textarea name="notice-contents" ><%=notice.getContents() %></textarea>
<input type="submit" value="전송" >
</form>



</body>
</html>