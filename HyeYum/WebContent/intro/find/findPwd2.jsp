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
		//this.contact_number.value = Math.random() * 100000 | 0; 
		document.getElementById('contact-number').value = Math.random() * 100000 | 0;
		// 서비스 id, 이메일 템플릿 
		emailjs.sendForm('service_jqv7wxx', 'template_wq4eb4g', this); 

	}); 
	
	
} 
</script> 

</head>
<body>

<h1>비밀번호 찾기 STEP 02</h1>
<h2>이름과 가입시 입력한 이메일을 입력해주세요.</h2>
<form id = "contact-form" name="contactForm" method="post">
<input type="hidden" name="contact_number" id="contact-number">
이름 : <input type="text" placeholder = "이름을 입력해주세요 " name="user-name" id="name"> <br>
이메일 : <input type="email" placeholder = "이메일을 입력해주세요 " name="user-email" id="email"> <br>
<input type= "hidden" value = "<%= newPwd %>" name="new-pwd" id="new-pwd">
<input type= "submit" id="mail-send" value = "임시비밀번호 발송">

</form>


</body>
</html>