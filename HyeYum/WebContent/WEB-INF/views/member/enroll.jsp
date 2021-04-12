<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <title>문화나눔, 혜윰 - 회원가입</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="/assets/css/member/member.css">
</head>
<body>
<!-- <script>
	$(function() {
		userId = $("#user-id");
		userPwd = $("#user-pwd");
		userRePwd = $("#user-repwd");
		userName = $("#user-name");
		userNick = $("#user-nick");
		userEmail = $("#user-email");
		userPhone = $("#user-phone");
		userAddress = $("#user-address");
		
		$("form").on("submit", function() {
			message.html("");
			
			var regExpId = /^[a-z][a-z0-9]{3,11}$/; // ID 입력조건
			var regExpPwd = /[a-zA-Z0-9]{8,12}$/; // PWD 입력조건
			var regExpName = /[가-힣]+$/; // 이름 입력조건
			var regExpNick = /[a-zA-Z가-힣0-9]{2,10})$/; // 닉네임 입력조건
			var regExpPhone = /^(010)$/;
			var regExpEmail = /[a-zA-Z0-9]{4,12}\@/;
			var regExpAddress = /[가-힣]+$/;
		})
	});
</script> -->
    <div class="main">

        <!-- Sign up form -->
       
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">회원가입</h2>
                        <p>기입란은 모두 필수사항입니다.</p><br><br>
                        <form action="/member/enroll" method="POST" class="register-form" id="register-form">
                            <div class="form-group">
                                <label for="id"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="user-id" id="user-id" placeholder="아이디 입력(영어소문자로 시작하며 숫자포함 4~12자리)" required/>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="user-pwd" id="user-pwd" placeholder="비밀번호(숫자,영어대소문자 조합 8~12자리)" required/>
                            </div>
                            <div class="form-group">
                                <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                <input type="password" name="user-repwd" id="user-repwd" placeholder="비밀번호 확인" required/>
                            </div>
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="user-name" id="user-name" placeholder="이름 입력" required/>
                            </div>
                            <div class="form-group">
                                <label for="nick"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="user-nick" id="user-nick" placeholder="닉네임 입력(한글,영문,숫자 조합 최소2자~최대10자)" required/>
                            </div>
                            <div class="form-group">
                                <label for="text"><i class="zmdi zmdi-email"></i></label>
                                <input type="text" name="user-phone" id="user-phone" placeholder="-없이 연락 가능한 전화번호 입력(010포함 필수)" required/>
                            </div>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input type="email" name="user-email" id="user-email" placeholder="@포함하여 이메일 입력 (ex_ hyeyum@gmail.com)" required/>
                            </div>
                            <div class="form-group">
                                <label for="address"><i class="zmdi zmdi-email"></i></label>
                                <input type="text" name="user-address" id="user-address" placeholder="공백 포함하여 주소 입력" required/>
                            </div>
                            

                            <div class="form-group">
                                <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                                <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signup" id="signup" class="form-submit" value="회원가입"/>
                                <a href="/index.jsp"><input type="reset" class="form-submit" value="취소"/></a>
                            </div>
                            
                        </form>
                    </div>
                    <div class="signup-image">
                        <!-- figure><img src="/assets/img/login/signup-image.jpg" alt="sing up image"></figure> -->
                        <a href="/member/login" class="signup-image-link">로그인</a>
                        <a href="/index.jsp" class="signup-image-link">메인페이지</a>
                    </div>
                </div>
            </div>
        </section>
		


    </div>

    <!-- JS -->
    <script src="/assets/vendor/jquery/jquery.min.js"></script>
   
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>