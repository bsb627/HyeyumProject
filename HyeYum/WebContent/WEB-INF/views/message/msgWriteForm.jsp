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
</style>
<script type="text/javascript">
	$(document).ready(function() {
		var contents = $("#contents");
		if( contents = "")f {
			alert("메시지를 입력해주세요");
		}
		
		function close()
		 {
		  window.open('','_self').close(); 
		}
	});
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class = "msg-form">
	<form action = "/message/send" method ="post">
		<span>받는사람 : <%= receiveId %></span><br>
		
		<textarea class="form-control" rows ="10" id="contents" name = "contents"></textarea><br>
		
		<input type = "hidden" name = "receiveId" value ="<%= receiveId %>" id>
		<input type = "submit" value = "전송" class = "btn btn-primary" style = "float:right" onclick="close()">
	</form>
</div>
</body>
</html>