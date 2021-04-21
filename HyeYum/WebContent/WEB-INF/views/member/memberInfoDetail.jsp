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

		<section id="blog" class="blog">
			<div class="container" data-aos="fade-up">
				<div class="col-md-12">
					<div class="row">
					<!--  ==================사이드바 =================== -->
						<div class="col-md-3">
							<div class="sidebar">
								<div class="sidebar-item recent-posts">
									<div class="post-item clearfix">
										<!-- <img src="/assets/img/features.png"> -->
									</div>
									<h3 class="sidebar-title"
										style="text-align: center; color: #ff7a00"><%=member.getUserId()%><span
											style="color: 012970;">님</span>
									</h3>
									<h3 class="sidebar-title" style="text-align: center;">환영합니다!</h3>
									<hr>

									<h3 class="sidebar-title">
										내정보 <i class="bi bi-person-bounding-box"></i>
									</h3>
									<div class="sidebar-item categories">
										<ul>
											<li><a href="/member/modify">정보수정</a></li>
										</ul>
										<hr>

										<h3 class="sidebar-title">
											쪽지 <i class="bi bi-envelope"></i>
										</h3>
										<div class="sidebar-item categories">
											<ul>
												<li><a href="/message/write/page">쪽지 쓰기</a></li>
												<li><a href="/message/receivedList">받은 쪽지함</a></li>
												<li><a href="/message/sentList">보낸 쪽지함</a></li>
											</ul>
											<hr>

											<h3 class="sidebar-title">
												활동 <i class="bi bi-journals"></i>
											</h3>
											<div class="sidebar-item categories">
												<ul>
													<li><a href="/myPost">작성 게시글</a></li>
													<li><a href="/myReply">작성 댓글</a></li>
												</ul>
												<hr>
											</div>
											<!-- End sidebar tags-->

											<h3 class="sidebar-title">
												주문 <i class="bi bi-credit-card"></i>
											</h3>
											<div class="sidebar-item categories">
												<ul>
													<li><a href="/order/list">주문 내역</a></li>
												</ul>
												<hr>
											</div>
											<!-- End sidebar tags-->
											<h3 class="sidebar-title">
												기부 <i class="bi bi-gift"></i>
											</h3>
											<div class="sidebar-item categories">
												<ul>
													<li><a href="/donate/list">기부 내역</a></li>
												</ul>

											</div>
											<!-- End sidebar tags-->
										</div>
									</div>
								</div>
							</div>
							<!-- End blog sidebar -->
						</div>

						<!--  ==================사이드바 end =================== -->

						<div class="col-md-1"></div>
						
						<!--  ================== 정보수정 =================== -->

						<div class="col-md-6">
<!-- 						<div class="col-6" style="margin: auto;"> -->

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


									<div class="form-group">
										<!-- 이름 -->
										<fieldset disabled="">
											<label class="control-label" for="disabledInput"><h5>이름</h5>
											</label> <input class="form-control" id="" type="text"
												value="<%=member.getUserName()%>" name="userName" readonly>
										</fieldset>
									</div>


									<div class="form-group has-success">
										<!-- 비밀번호 -->
										<label class="col-form-label" for="inputDefault"><h5>회원 비밀번호</h5></label>
										<input type="password" class="form-control" placeholder=""
											value="" id="user-pwd" name="userPwd"><span style="display: inline-block;" id="check-msg"><p></p></span>
									</div>


									<div class="form-group has-success">
										<!-- 비밀번호 재확인 -->
										<label class="col-form-label" for="inputDefault"><h5>회원 비밀번호
												확인</h5></label> <input type="password" class="form-control"
											placeholder="" value="" id="user-repwd" name="userRePwd"><span style="display: inline-block;" id="recheck-msg"><p></p></span>
											
											
									<!-- 	<div id="alert-success" class="valid-feedback">Success!
											You've done it.</div>
										<div id="alert-danger" class="invalid-feedback">Sorry,
											that username's taken. Try another?</div>
 -->
									</div>


									<div class="form-group">
										<!-- 닉네임 -->
										<fieldset disabled="">
											<label class="control-label" for="disabledInput"><h5>닉네임</h5>
											</label> <input class="form-control" id="" type="text"
												value="<%=member.getUserNick()%>" name="userNick" readonly>
										</fieldset>
									</div>


									<div class="form-group has-success">
										<!-- 전화번호 -->
										<label class="col-form-label" for="inputDefault"><h5>전화번호</h5></label>
										<input type="text" class="form-control" placeholder=""
											value="<%=member.getUserPhone()%>" id="user-phone"
											name="userPhone"><span style="display: inline-block;" id="check-phone-msg"><p></p></span>
									</div>


									<div class="form-group has-success">
										<!-- 이메일 -->
										<label class="col-form-label" for="inputDefault"><h5>이메일</h5></label>
										<input type="text" class="form-control" placeholder=""
											value="<%=member.getUserEmail()%>" id="user-email"
											name="userEmail"><span style="display: inline-block;" id="check-email-msg"><p></p></span>
									</div>


									<div class="form-group has-success">
								<label class="form-control-label" for="inputDefault"><h5>주소</h5></label>
									<label for="address"><i class="zmdi zmdi-email"></i></label> 
									<!-- <input type="text" name="user-address" id="user-address" placeholder="공백 포함하여 주소 입력" required /> --> 
									<input type="text" id="sample4_postcode" placeholder="우편번호"> 
									<input type="button" id="address-btn"  value="우편번호 찾기"><br> 
									<input type="text" class="form-control" id="sample4_roadAddress" placeholder="도로명주소" value="<%= member.getUserAddress() %>" name="userAddress1" size="50" autocomplete="none" required><br>
									
									<input type="hidden" id="sample4_jibunAddress" placeholder="지번주소" size="50"> <span id="guide"
										style="color: #999; display: none"></span> 
										<input type="text"  class="form-control" id="sample4_detailAddress"  placeholder="상세주소" name="userAddress2" size="50" autocomplete="none" required><br>
								</div>


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

						<!--  ================== 정보수정 end =================== -->

							<div class="col-md-2"></div>
							
					</div>
				</div>
			</div>
		</section>
		</div>
		

		<!-- ==================================================================== -->


	</section>
</main>
<!-- End #main -->


<%@include file="/footer.jsp"%>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/assets/js/member/memberInfoDetail.js"></script>
<script src="/assets/js/member/enroll-address.js"></script>