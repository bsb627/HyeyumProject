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
    <link rel="stylesheet" href="/assets/css/member/member.css">
</head>
<body>

    <div class="main">

        <!-- Sing in  Form -->
        <section class="sign-in">
            <div class="container">
            	
             <figure><img src="/assets/img/login/login.jpg" alt="sing up image">  </figure>
           		
           		
           		
           		<div class="signin-content">
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
                            <div class="form-group form-button" style="float:center;">
                                <input type="submit" name="signin" id="signin" class="form-submit" value="로그인"/>
                                <input type="submit" name="signin" id="signin" class="form-submit" value="회원가입"/>
                            </div>

							<div class="form-group">
								<a href="/intro/find/findId.jsp">아이디 찾기</a> <a
									href="/intro/find/findPwd.jsp">비밀번호 찾기</a>

							</div>
							<div class="form-group">
								<a href="/member/enroll" class="signup-image-link">회원가입</a> <a
									href="/index.jsp" class="signup-image-link">메인페이지</a>
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
             
             <div class="signin-content">
                       
				</div>
            
                
				
            
        </section>

    </div>

    <!-- JS -->
     <script src="/assets/vendor/jquery/jquery.min.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>