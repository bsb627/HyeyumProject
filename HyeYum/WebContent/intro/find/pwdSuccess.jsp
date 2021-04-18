<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	Random random = new Random();
	String newPwd = Integer.toString(random.nextInt(100000));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link href="/assets/css/find.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/emailjs-com@2/dist/email.min.js"></script>


</head>
<body>

<div class="form-signin" >
	<div class="wrapper" >
	<img src= "/assets/img/logo.png" style = "width :40px; height:40px;" >
	  <h2 class="form-signin-heading">비밀번호 찾기</h2><br>
	  <span style = "color:lightgray">1. 아이디 입력 >></span>
      <span style = "color:lightgray">2. 이름, 이메일 입력 >> </span> 
      <span > 3. 임시 비밀번호 전송</span><br><br>
	<img src = "/assets/img/qna/sendMsg.png" style = "width : 300px; height:300px"><br>
	입력하신 이메일 주소로 임시비밀번호가 전송되었습니다. <br><br>
	<a href="/member/login"><button class = "btn btn-primary">로그인</button></a>
	</div>
</div>

</body>
</html>