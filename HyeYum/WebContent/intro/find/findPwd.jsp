<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="/assets/css/find.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<script type="text/javascript">
window.onload = function() { 
	
	document.getElementById('contact-form').addEventListener('submit', function(event) {
		if(document.getElementById('id').value.length === 0){
	        alert('아이디를 입력해주세요');
	        event.preventDefault(); 
	    } 
	    
	}); 
} 
</script> 

</head>
<body>
<div class="form-signin">
  <div class="wrapper" >
  	<img src= "/assets/img/logo.png" style = "width :40px; height:40px;" >
      <h2 class="form-signin-heading">비밀번호 찾기</h2><br>
      <span>1. 아이디 입력 </span> >> 
      <span style = "color:lightgray">2. 이름, 이메일 입력</span> 
      <span style = "color:lightgray">>> 3. 임시 비밀번호 전송</span><br><br>
      <span style = "color:red">※찾을 비밀번호의 아이디를 입력해주세요※</span><br><br>
      <form action = "/member/find/pwd" method = "get" id="contact-form">
		<input type = "text" placeholder = "아이디 " name = "user-id" id="id"> <br><br>
				<input type = "submit" value = "다음" class="btn btn-primary">
	</form>
  </div>

</div>



</body>
</html>