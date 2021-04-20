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
									<!-- 주소 -->
									<div>
									<button type="button" class="btn btn-primary btn-sm"  onclick="sample4_execDaumPostcode()">주소검색</button></div>
									<label class="col-form-label" for="inputDefault"></label>
									<input type="text" class="form-control" 
										value="<%=member.getUserAddress() %> " id="inputDefault"
										name="userAddress" required readonly> 
										
								</div>

								<hr>
								<hr>
								<hr>
								<!-- 기입란 end -->
								<h3>지울거</h3>
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



								<div class="entry-content" style="text-align: center">
									<div class="out">
										<br>
										<h5>
											<strong> 상기와 같이 <%=member.getUserId()%> 님의 정보를
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


<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/assets/js/memberInfoDatail.js"></script>
<%@include file="/footer.jsp"%>