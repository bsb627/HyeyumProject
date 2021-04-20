<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Member member = (Member) request.getAttribute("member");
%>
<title><%=member.getUserName()%> 님 정보 관리</title>
<%@include file="/header.jsp"%>
<link href="/assets/css/member/memberInfoDetail.css" rel="stylesheet">
<!-- ======= Breadcrumbs ======= -->
<main id="main">
	<section class="breadcrumbs">
		<div class="container">

			<ol>
				<li><a href="/index.jsp">Home</a></li>
				<li>내 정보</li>
			</ol>
			<h2>회원 정보</h2>

		</div>
	</section>
	<!-- End Breadcrumbs -->

	<section class="inner-page">
		<div class="container">
			<header class="section-header">
				<h2>MY INFORMATION</h2>
				<p>회원 정보 수정</p>
			</header>
			<form action="/member/delete" method="get">
				<p name="userId">
					아이디 :
					<%=member.getUserId()%></p>
			</form>
		</div>

		<!-- ======= Blog Section ======= -->


		<section id="blog" class="blog">
			<div class="container" data-aos="fade-up">

				<div class="row">
					<div class="col-6" style="margin: auto;">

						<article class="entry">

							<!-- ============ 폼 내용 ============= -->
							<!-- 보여지는 정보 : USER_ID, USER_PWD, USER_NAME, NICK, USER_PHONE, EMAIL, ADDRESS, ENROLL_DATE, OUT_DATE, OUT_STATE, OUT_REASON 
										수정 가능한 것 : USER_PWD , USER_PHONE, EMAIL, ADDRESS  -->
							<h2 class="entry-title" style="color: navy;">회원 정보 수정</h2>

							<form action="/member/modify" method="post">
								<div class="form-group">
									<!-- 아이디 -->
									<fieldset disabled="">
										<label class="control-label" for="disabledInput"><h5>아이디</h5>
										</label> <input class="form-control" id="" type="text"
											value="<%=member.getUserId()%>" name="userId" readonly>
									</fieldset>
								</div>

								<hr>

								<div class="form-group">
									<!-- 이름 -->
									<fieldset disabled="">
										<label class="control-label" for="disabledInput"><h5>이름</h5>
										</label> <input class="form-control" id="" type="text"
											value="<%=member.getUserName()%>" name="userName" readonly>
									</fieldset>
								</div>

								<hr>

								<div class="form-group-pwd">
									<!-- 비밀번호 -->
									<label class="col-form-label" for="inputDefault"><h5>비밀번호</h5></label>
									<input type="password" class="form-control" placeholder=""
										value="" id="inputDefault-pwd" name="userPwd"><span>비밀번호
										유효성 조건</span>
								</div>

								<hr>

								<div class="form-group-pwd">
									<!-- 비밀번호 재확인 -->
									<label class="col-form-label" for="inputDefault"><h5>비밀번호
											확인</h5></label> <input type="password" class="form-control" placeholder=""
										value="" id="inputDefault-repwd" name="userRePwd">
									<div id="alert-success" class="valid-feedback">Success!
										You've done it.</div>
									<div id="alert-danger" class="invalid-feedback">Sorry,
										that username's taken. Try another?</div>

								</div>

								<hr>

								<div class="form-group">
									<!-- 닉네임 -->
									<fieldset disabled="">
										<label class="control-label" for="disabledInput"><h5>닉네임</h5>
										</label> <input class="form-control" id="" type="text"
											value="<%=member.getUserNick()%>" name="userNick" readonly>
									</fieldset>
								</div>

								<hr>

								<div class="form-group">
									<!-- 전화번호 -->
									<label class="col-form-label" for="inputDefault"><h5>전화번호</h5></label>
									<input type="text" class="form-control" placeholder=""
										value="<%=member.getUserPhone()%>" id="inputDefault"
										name="userPhone">
								</div>

								<hr>

								<div class="form-group">
									<!-- 이메일 -->
									<label class="col-form-label" for="inputDefault"><h5>이메일</h5></label>
									<input type="text" class="form-control" placeholder=""
										value="<%=member.getUserEmail()%>" id="inputDefault"
										name="userEmail">
								</div>

								<hr>



								<div class="form-group">
								<label class="col-form-label" for="inputDefault"><h5>주소</h5></label>
									<label for="address"><i class="zmdi zmdi-email"></i></label> 
									<input type="text" class="form-control" 
										value="<%=member.getUserAddress() %> " id="inputDefault"
										name="userAddress" required readonly> 
									<!-- <input type="text" name="user-address" id="user-address" placeholder="공백 포함하여 주소 입력" required /> --> 
									<input type="text" id="sample4_postcode" placeholder="우편번호"> 
									<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br> 
									<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="userAddress1" size="60"><br>
									
									<input type="hidden" id="sample4_jibunAddress" placeholder="지번주소" size="60"> <span id="guide"
										style="color: #999; display: none"></span> 
										<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="userAddress2" size="60"><br>
								</div>

								<hr>
								<!-- 기입란 end -->
							<!-- 	<h3>지울거</h3>
								<div class="form-group">
									<fieldset>
										<label class="control-label" for="readOnlyInput">Readonly
											input</label> <input class="form-control" id="readOnlyInput"
											type="text" placeholder="Readonly input here..." readonly="">
									</fieldset>
								</div>

								<div class="form-group has-success">
									<label class="form-control-label" for="inputValid">Valid
										input</label> <input type="text" value="correct value"
										class="form-control is-valid" id="inputValid">
									<div class="valid-feedback">Success! You've done it.</div>
								</div>

								<div class="form-group has-danger">
									<label class="form-control-label" for="inputInvalid">Invalid
										input</label> <input type="text" value="wrong value"
										class="form-control is-invalid" id="inputInvalid">
									<div class="invalid-feedback">Sorry, that username's
										taken. Try another?</div>
								</div>

								<div class="form-group">
									<label class="col-form-label col-form-label-lg"
										for="inputLarge">Large input</label> <input
										class="form-control form-control-lg" type="text"
										placeholder=".form-control-lg" id="inputLarge">
								</div>

								<div class="form-group">
									<label class="col-form-label" for="inputDefault">Default
										input</label> <input type="text" class="form-control"
										placeholder="Default input" id="inputDefault">
								</div>

								<div class="form-group">
									<label class="col-form-label col-form-label-sm"
										for="inputSmall">Small input</label> <input
										class="form-control form-control-sm" type="text"
										placeholder=".form-control-sm" id="inputSmall">
								</div>

 -->

								<div class="entry-content" style="text-align: center">
									<div class="out">
										<br>
										<h5>
											<strong> 상기와 같이 <%= member.getUserNick() %> 님의 정보를
												변경합니다.
											</strong>
										</h5>
									</div>

									<div class="in" style="float: center">
										<button type="submit" class="btn btn-primary btn-sm">수정</button>
										<a href="/index.jsp"><button type="button"
												class="btn btn-primary btn-sm">메인으로</button></a>
										<!-- 	<div class="read-more" style="display: inline-block">
											<a href="/index.jsp">메인으로</a> -->
									</div>
								</div>
							</form>
						</article>
					</div>

					<!-- End blog entry -->



				</div>
			</div>

		</section>
		<!-- End Blog Section -->

	</section>
</main>
<!-- End #main -->
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


<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/assets/js/memberInfoDatail.js"></script>
<%@include file="/footer.jsp"%>