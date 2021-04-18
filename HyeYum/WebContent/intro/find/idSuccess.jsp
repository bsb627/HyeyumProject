<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

Member member = (Member)request.getAttribute("member");

%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>아이디 찾기 성공</title>
<style>
@font-face {
    font-family: 'GongGothicMedium';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-10@1.0/GongGothicMedium.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
@import "bourbon";

body {
	background: #eee !important;	
}

.wrapper {	
	margin-top: 50px;
  margin-bottom: 60px;
  text-align :center;
}

.form-signin {
  max-width: 500px;
  padding: 15px 35px 45px;
  margin: 0 auto;
  background-color: #fff;
  border: 1px solid rgba(0,0,0,0.1);  
 	font-family: 'GongGothicMedium';
}

</style>
</head>
<body>
<div class="wrapper"  class="form-signin">
<div class="form-signin">
	<h2 style = "font-family: 'GongGothicMedium';">아이디 찾기 성공</h2><br>
	<p>▽회원님의 아이디▽ <br><br><br>
	<%= member.getUserId() %> 
	</p>
</div>
</div>
</body>
</html>