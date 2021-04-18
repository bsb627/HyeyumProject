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
<script type="text/javascript">
(function() {
emailjs.init("user_6A0xYDbD9AoTXZ7Gfppe6");
})();
</script>


<script type="text/javascript">
window.onload = function() { 
	// form id, #contact-form 안에 있는 것들 전송 
	document.getElementById('contact-form').addEventListener('submit', function(event) {
		document.contactForm.action = '/member/find/pwd/second';
		if(document.getElementById('name').value.length === 0){
	        alert('이름을 입력해주세요');
	        event.preventDefault(); 
	    } else if(document.getElementById('email').value.length === 0){
	        alert('이메일을 입력해주세요');
	        event.preventDefault(); 
	    }
		//event.preventDefault(); 
		
		document.getElementById('contact-number').value = Math.random() * 100000 | 0;
		emailjs.sendForm('service_jqv7wxx', 'template_wq4eb4g', this); 
	}); 
} 
</script> 

</head>
<body>

<form id = "contact-form" name="contactForm" method="post" class="form-signin">
	<div class="wrapper" >
	  <img src= "/assets/img/logo.png" style = "width :40px; height:40px;" >
	  <h2 class="form-signin-heading">비밀번호 찾기</h2><br>
	  <span style = "color:lightgray">1. 아이디 입력 >></span>
      <span >2. 이름, 이메일 입력 >> </span> 
      <span style = "color:lightgray"> 3. 임시 비밀번호 전송</span><br><br>
      <span style = "color:red">※가입시 입력한 이름과 이메일 입력해주세요※</span><br><br>
		<input type="hidden" name="contact_number" id="contact-number">
			<input type="text" placeholder = "이름 " name="user-name" id="name" class="form-control"> <br>
			<input type="email" placeholder = "이메일" name="user-email" id="email" class="form-control"> <br>
			<input type= "hidden" value = "<%= newPwd %>" name="new-pwd" id="new-pwd">
			<input type= "submit" id="mail-send" value = "임시 비밀번호 발송" class = "btn btn-primary">
	</div>
</form>

</body>
</html>