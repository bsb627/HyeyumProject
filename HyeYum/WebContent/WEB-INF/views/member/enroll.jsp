<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<title>회원 가입</title>
<%@include file="/header.jsp"%>

<!-- ======= Breadcrumbs ======= -->
<section class="breadcrumbs">
	<div class="container">

		<ol>
			<li><a href="/index.jsp">Home</a></li>
			<li>회원 가입</li>
		</ol>
		<h2>회원 가입</h2>

	</div>
</section>
<!-- End Breadcrumbs -->
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
		<section id="blog" class="blog">

				<div class="row">
					<div class="col-6" style="margin: auto;">

						<article class="entry">

							<!-- ============ 폼 내용 ============= -->
							<!-- 보여지는 정보 : USER_ID, USER_PWD, USER_NAME, NICK, USER_PHONE, EMAIL, ADDRESS, ENROLL_DATE, OUT_DATE, OUT_STATE, OUT_REASON 
										수정 가능한 것 : USER_PWD , USER_PHONE, EMAIL, ADDRESS  -->
							<h2 class="entry-title" style="color: navy;">회원 가입</h2>
							<p style="color: red;">기입란은 모두 필수사항입니다.</p>
							<br> <br>

							<form action="/member/enroll" method="POST" class="register-form" id="register-form">
								<div class="form-group has-success">
									<!-- 아이디 -->
									
									<label class="form-control-label" for="user-id"><h5>아이디</h5>
									</label> <input class="form-control " name="user-id" id="user-id"
										placeholder="아이디 입력(영어소문자로 시작하며 숫자포함 4~12자리)" autocomplete="none" >
										<span id="check-id-msg"></span>
										
									
										
								</div>


								<div class="form-group">
									<!-- 이름 -->
									<label class="control-label" for="disabledInput"><h5>이름</h5>
									</label> <input class="form-control" name="user-name" id="user-name"
										placeholder="이름 입력" autocomplete="none">
										<span id="check-name-msg"></span>

								</div>


								<div class="form-group">
									<!-- 비밀번호 -->
									<label class="col-form-label" for="inputDefault"><h5>비밀번호</h5></label>
									<input type="password" class="form-control" name="user-pwd"
										id="user-pwd" placeholder="비밀번호(숫자,영어대소문자 조합 8~12자리)" autocomplete="none"  />
										<span id="check-pwd-msg"></span>
									<!-- <span>비밀번호 유효성 조건</span> -->
								</div>


								<div class="form-group">
									<!-- 비밀번호 재확인 -->
									<label class="col-form-label" for="inputDefault"><h5>비밀번호
											확인</h5></label> <input type="password" class="form-control"
										name="user-repwd" id="user-repwd" placeholder="비밀번호 확인" autocomplete="none"
										/>
									<span id="check-repwd-msg"></span>

								</div>

								<div class="form-group">
									<!-- 닉네임 -->
									<label class="control-label" for="disabledInput"><h5>닉네임</h5>
									</label> <input class="form-control" name="user-nick" id="user-nick"
										placeholder="닉네임 입력(한글,영문,숫자 조합 최소2자~최대10자)" autocomplete="none" />
									<span id="check-nick-msg"></span>
								</div>
								
								


								<div class="form-group">
									<!-- 전화번호 -->
									<label class="col-form-label" for="inputDefault"><h5>전화번호</h5></label>
									<input type="text" class="form-control" name="user-phone"
										id="user-phone" placeholder="-없이 연락 가능한 전화번호 입력(010포함 필수)" autocomplete="none"/>
										 <span id="check-phone-msg"></span>
								</div>


								<div class="form-group">
									<!-- 이메일 -->
									<label class="col-form-label" for="inputDefault"><h5>이메일</h5></label>
									<input type="email" class="form-control" name="user-email"
										id="user-email"
										placeholder="@포함하여 이메일 입력 (ex_ hyeyum@gmail.com)" autocomplete="none" required/>
								</div>

								
									<!-- 주소 -->
											
								<div class="form-group">
								<label class="col-form-label" for="inputDefault"><h5>주소</h5></label>
									<label for="address"><i class="zmdi zmdi-email"></i></label> 
									<!-- <input type="text" name="user-address" id="user-address" placeholder="공백 포함하여 주소 입력" required /> --> 
									<input type="text" id="sample4_postcode" placeholder="우편번호"> 
									<input type="button" id="address-btn"  value="우편번호 찾기"><br> 
									<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="user-address1" size="60" autocomplete="none" required><br>
									
									<input type="hidden" id="sample4_jibunAddress" placeholder="지번주소" size="60"> <span id="guide"
										style="color: #999; display: none"></span> 
										<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="user-address2" size="60" autocomplete="none" required><br>
								</div>
								

								<hr>
								<!-- 기입란 end -->
								<div class="entry-content" style="text-align: center">
									<div class="out">
										<br>
										<h5>
											<strong> [문화나눔, 혜윰]의 회원 가입에 동의합니다. </strong>
										</h5>
									</div>

									<div class="in" style="float: center">
										<button type="submit" class="btn btn-outline-primary"
											name="signup" id="signup">회원가입</button>
										<a href="/index.jsp"><button type="button"
												class="btn btn-outline-warning">메인으로</button></a>
										<!-- 	<div class="read-more" style="display: inline-block">
											<a href="/index.jsp">메인으로</a> -->
									</div>
								</div>


							</form>

<!-- 
							<a href="/member/login" class="signup-image-link">로그인</a> <a
								href="/index.jsp" class="signup-image-link">메인페이지</a> -->
						</article>
					</div>
				</div>

				<!-- End blog entry -->
			</div>

		</section>
	</div>


	<!-- 
   
                        <p>기입란은 모두 필수사항입니다.</p><br><br>
                        <form action="/member/enroll" method="POST" class="register-form" id="register-form">
                            <div class="form-group">
                                <label for="id"><h5>아이디</h5></label>
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
                                <label for="address"><i class="zmdi zmdi-email"></i></label> <input type="text" name="user-address"
									id="user-address" placeholder="공백 포함하여 주소 입력" required /> <input
									type="text" id="sample4_postcode" placeholder="우편번호"> <input
									type="button" onclick="sample4_execDaumPostcode()"
									value="우편번호 찾기"><br> <input type="text"
									id="sample4_roadAddress" placeholder="도로명주소" size="60"><br> <input
									type="hidden" id="sample4_jibunAddress" placeholder="지번주소"
									size="60"> <span id="guide" style="color: #999; display: none"></span> <input type="text" id="sample4_detailAddress"
									placeholder="상세주소" size="60"><br>
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
                        figure><img src="/assets/img/login/signup-image.jpg" alt="sing up image"></figure>
                        <a href="/member/login" class="signup-image-link">로그인</a>
                        <a href="/index.jsp" class="signup-image-link">메인페이지</a>
                    </div>
                </div>
            </div>
        </section>
		


    </div>
 -->
	<!-- JS -->
	

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>



<%@include file="/footer.jsp"%>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/assets/js/member/enroll.js"></script>
<script src="/assets/js/member/enroll-address.js"></script>