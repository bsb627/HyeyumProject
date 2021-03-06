<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String receiveId = (String)request.getAttribute("receiveId");
%>
<!DOCTYPE html>
<html>
<head>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
.msg-form {
padding : 5% 10% 10% 5%;
}
@font-face {
  font-family: 'LotteMartHappy';
  font-style: normal;
  font-weight: 700;
  src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartHappy/LotteMartHappyBold.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartHappy/LotteMartHappyBold.woff') format('woff');
}
body {
 background-color:#edf6f9;

}
@font-face {
    font-family: 'Cafe24Oneprettynight';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Oneprettynight.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		var contents = $("#contents");
		if( contents = "")f {
			alert("메시지를 입력해주세요");
		}
		

	});
</script>
<meta charset="UTF-8">
<title>메시지 보내기</title>
</head>
<body>
<div class = "msg-form">
	<form action = "/message/send/pop" method ="post">
	<img src= "/assets/img/logo.png" style = "width :40px; height:40px;" >
		<h2 style = " text-align :center; font-family : 'LotteMartHappy' ">【 쪽지 쓰기 】</h2>  
		<span style = "font-family : 'LotteMartHappy'">받는 사람 : <%= receiveId %></span><br>
		
		<textarea style = "font-family: 'Cafe24Oneprettynight'; "class="form-control" rows ="10" id="contents" name = "contents"></textarea><br>
		
		<input type = "hidden" name = "receiveId" value ="<%= receiveId %>" >
		<input type = "submit" value = "전송" class = "btn btn-primary" style = "float:right" onclick="close()">
	</form>
</div>
</body>
</html>