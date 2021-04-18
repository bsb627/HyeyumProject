<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>

<!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/emailjs-com@2/dist/email.min.js"></script>
<script type="text/javascript">
(function() {
emailjs.init("user_6A0xYDbD9AoTXZ7Gfppe6");
})();
</script>


<script type="text/javascript">
window.onload = function() { 
	// form id, #contact-form 안에 있는 것들 전송 
	document.getElementById('contact-form').addEventListener('submit', function(event) {
		event.preventDefault(); this.contact_number.value = Math.random() * 100000 | 0; 
		// 서비스 id, 이메일 템플릿 
		emailjs.sendForm('contact_service', 'contact_template', this); 
		}); 
	} 
</script> -->

</head>
<body>

<h1>비밀번호 찾기 STEP 01</h1>
<h2>비밀번호를 찾고자 하는 아이디를 입력해주세요.</h2>
<form action = "/member/find/pwd" method = "get">
아이디 : <input type = "text" placeholder = "아이디를 입력해주세요 " name = "user-id"> <br>
<input type = "submit" value = "다음">
</form>



</body>
</html>