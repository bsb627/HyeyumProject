<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

Member member = (Member)request.getAttribute("member");

%>
<!DOCTYPE html>
<html>
<head>
<link href="/assets/css/find.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>아이디 찾기 성공</title>
</head>
<body>
<div class="form-signin">
  <div class="wrapper" >
  	<img src= "/assets/img/logo.png" style = "width :40px; height:40px;" >
      <h2 class="form-signin-heading">아이디 찾기 성공</h2><br>
      <p>▽회원님의 아이디▽ <br><br><br>
      <h3><%= member.getUserId() %> </h3>
  </div>
  <div style = "text-align:center">
  <a href = "/member/login"><button class="btn btn-primary">로그인</button></a>
  <a href ="/intro/find/findPwd.jsp"><button class="btn btn-outline-primary">비밀번호 찾기</button></a>
  </div>
</div>
</body>
</html>