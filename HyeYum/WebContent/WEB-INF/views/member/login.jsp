<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>문화나눔, 혜윰 - 로그인</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Montserrat&family=Nanum+Gothic&family=Roboto+Condensed&display=swap" rel="stylesheet">
    <!-- Main css -->
    <!-- <link rel="stylesheet" href="/assets/css/member/member.css"> -->
    <link rel="stylesheet" href="/assets/css/member/member-custom.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	 $(document).ready(function() {
		$("#login-form").submit(function() {
			var id = $("#your_id");
			var pass = $("#your_pass");
			
			if(id.val() =="") {
				alert("아이디를 입력해주세요. ");
				return false;
			}else if(pass.val() == "") {
				alert("비밀번호를 입력해주세요.");
				return false;
			}
			return true;
		});
	 });
		
	</script>
</head>
<body>

    <div class="main">

        <!-- Sing in  Form -->
        <section class="sign-in">
            <div class="container">
            	
   <form action="/member/login" method="post">
<div class="container" onclick="onclick">
  <div class="top"></div>
  <div class="bottom"></div>
  <div class="center">
    <h2>HYEYUM LOGIN</h2>
    <input type="text"  name="user-id" placeholder="ID"/>
    <input type="password" name="user-pwd" placeholder="PASSWORD"/>
    <h2>&nbsp;</h2>
    <button class="login-btn">LOG IN</button>
  </div>
</div>
   </form> 
				</div>
            
        </section>

    </div>

    <!-- JS -->
     <script src="/assets/vendor/jquery/jquery.min.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>