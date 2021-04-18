<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

Member member = (Member)request.getAttribute("member");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 실패</title>
</head>
<body>
	<h1>아이디 찾기 실패</h1>
	아이디와 이메일이 일치하는 회원 찾기에 실패했습니다. <br>
	다시 확인해주세요. 
	<a href = "findId.jsp">확인</a>
</body>
</html>