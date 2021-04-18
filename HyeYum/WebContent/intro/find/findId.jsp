<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="/assets/css/find.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>아이디 찾기</title>


<script type="text/javascript">
window.onload = function() { 
	
	document.getElementById('contact-form').addEventListener('submit', function(event) {
		if(document.getElementById('name').value.length === 0){
	        alert('이름을 입력해주세요');
	        event.preventDefault(); 
	    } else if(document.getElementById('email').value.length === 0){
	        alert('이메일을 입력해주세요');
	        event.preventDefault(); 
	    }
	}); 
} 
</script> 
</head>
<body>



<form id = "contact-form" action = "/member/find/id" method = "get" class="form-signin">
  <div class="wrapper" >
  	<img src= "/assets/img/logo.png" style = "width :40px; height:40px;" >
      <h2 class="form-signin-heading">아이디 찾기</h2><br>
      <input type = "text" name = "name" class="form-control" placeholder="이름" id ="name"><br> 
     <input type = "email" name = "email" class="form-control" placeholder="이메일" id="email"><br>
	<span style = "color:red">※가입시 입력한 이메일 주소와 이름을 입력해주세요.※</span><br><br>
     <input type = "submit" value ="찾기" class = "btn btn-primary"> 
  </div>
</form>
</body>
</html>