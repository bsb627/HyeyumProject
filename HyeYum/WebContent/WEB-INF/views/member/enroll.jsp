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
 <script>
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
</script>
	<div class="main">

		<!-- Sign up form -->
		<section id="blog" class="blog">
			<div class="container" data-aos="fade-up">

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
								<div class="form-group">
									<!-- 아이디 -->
									<label class="control-label" for="disabledInput"><h5>아이디</h5>
									</label> <input class="form-control" name="user-id" id="user-id"
										placeholder="아이디 입력(영어소문자로 시작하며 숫자포함 4~12자리)" required>
								</div>

								<hr>

								<div class="form-group">
									<!-- 이름 -->
									<label class="control-label" for="disabledInput"><h5>이름</h5>
									</label> <input class="form-control" name="user-name" id="user-name"
										placeholder="이름 입력" required>

								</div>

								<hr>

								<div class="form-group-pwd">
									<!-- 비밀번호 -->
									<label class="col-form-label" for="inputDefault"><h5>비밀번호</h5></label>
									<input type="password" class="form-control" name="user-pwd"
										id="user-pwd" placeholder="비밀번호(숫자,영어대소문자 조합 8~12자리)" required />
									<!-- <span>비밀번호 유효성 조건</span> -->
								</div>

								<hr>

								<div class="form-group-pwd">
									<!-- 비밀번호 재확인 -->
									<label class="col-form-label" for="inputDefault"><h5>비밀번호
											확인</h5></label> <input type="password" class="form-control"
										name="user-repwd" id="user-repwd" placeholder="비밀번호 확인"
										required />
									<div id="alert-success" class="valid-feedback">Success!
										You've done it.</div>
									<div id="alert-danger" class="invalid-feedback">Sorry,
										that username's taken. Try another?</div>

								</div>

								<hr>

								<div class="form-group">
									<!-- 닉네임 -->
									<label class="control-label" for="disabledInput"><h5>닉네임</h5>
									</label> <input class="form-control" name="user-nick" id="user-nick"
										placeholder="닉네임 입력(한글,영문,숫자 조합 최소2자~최대10자)" required />

								</div>

								<hr>

								<div class="form-group">
									<!-- 전화번호 -->
									<label class="col-form-label" for="inputDefault"><h5>전화번호</h5></label>
									<input type="text" class="form-control" name="user-phone"
										id="user-phone" placeholder="-없이 연락 가능한 전화번호 입력(010포함 필수)"
										required />
								</div>

								<hr>

								<div class="form-group">
									<!-- 이메일 -->
									<label class="col-form-label" for="inputDefault"><h5>이메일</h5></label>
									<input type="text" class="form-control" name="user-email"
										id="user-email"
										placeholder="@포함하여 이메일 입력 (ex_ hyeyum@gmail.com)" required />
								</div>

								<hr>
								
									<!-- 주소 -->
											
								<div class="form-group">
								<label class="col-form-label" for="inputDefault"><h5>주소</h5></label>
									<label for="address"><i class="zmdi zmdi-email"></i></label> 
									<!-- <input type="text" name="user-address" id="user-address" placeholder="공백 포함하여 주소 입력" required /> --> 
									<input type="text" id="sample4_postcode" placeholder="우편번호"> 
									<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br> 
									<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="user-address1" size="60"><br>
									
									<input type="hidden" id="sample4_jibunAddress" placeholder="지번주소" size="60"> <span id="guide"
										style="color: #999; display: none"></span> 
										<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="user-address2" size="60"><br>
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
	<script src="/assets/js/member/enroll.js"></script>
	<script src="/assets/vendor/jquery/jquery.min.js"></script>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
         
                document.getElementById("sample4_engAddress").value = data.addressEnglish;
                       
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>



<%@include file="/footer.jsp"%>