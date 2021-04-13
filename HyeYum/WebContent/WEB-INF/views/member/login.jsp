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

    <!-- Main css -->
    <link rel="stylesheet" href="/assets/css/member/member.css">
</head>
<body>

    <div class="main">

        <!-- Sing in  Form -->
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="/assets/img/login/signin-image.jpg" alt="sing up image"></figure>
                        <a href="/member/enroll" class="signup-image-link">회원가입</a><a href="/index.jsp" class="signup-image-link">메인페이지</a><br>
                    </div>

                    <div class="signin-form">
                        <h2 class="form-title">로그인</h2>
                        <form action="/member/login" method="POST" class="register-form" id="login-form">
                            <div class="form-group">
                                <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="user-id" id="your_name" placeholder="Your ID"/>
                            </div>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="user-pwd" id="your_pass" placeholder="Password"/>
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
                                <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signin" id="signin" class="form-submit" value="로그인"/>
                            </div>
                        </form>
                       <!--  <div class="social-login">
                            <span class="social-label">SNS 계정으로 로그인</span>
                            <ul class="socials">
                                <li><a href="/WEB-INF/views/member/kakaoLogin.html"><i class="display-flex-center zmdi zmdi-naver"></i></a></li>
                                <li><a href="/WEB-INF/views/member/kakaoLogin.html"><i class="display-flex-center zmdi zmdi-kakao"></i></a></li>
                                <li><a href="#"><i class="display-flex-center zmdi zmdi-google"></i></a></li>
                            </ul>
                        </div> -->
                    </div>
                </div>
            </div>
        </section>

    </div>
<!-- 	<a href="javascript:kakaoLogin()"><img src="https://play-lh.googleusercontent.com/8_0SDfkFXAFm12A7XEqkyChCdGC055J6fC8JR7qynNuO3qNOczIoNHo4U4lad8xYMJOL" style="height:60px;width:auto;"></a>
   <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
   <script>
   //9af5bb49e91b4be276f23399b1d13feb
   window.Kakao.init("9af5bb49e91b4be276f23399b1d13feb");
   
   function kakaoLogin() { 
	   window.Kakao.Auth.login({
		  scope:'profile, account_email,gender',
		  success : funtion(auth0bj) {
			  console.log(auth0bj);
			  window.Kakao.API.request({
				  url:'/v2/user/me',
				  success : res => {
					  const kakao_account = res.kakao_account;
					  console.log(kakao_account);
				  }
			  });
		  }
	   });
   }
   </script> -->
    <!-- JS -->
     <script src="/assets/vendor/jquery/jquery.min.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>