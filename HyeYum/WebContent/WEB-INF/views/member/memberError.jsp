<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Member member = (Member) request.getAttribute("member");
%>

<title>회원 상세 정보</title>
  <%@include file="/header.jsp"%>  
<link href="/assets/css/member/beforecheck.css" rel="stylesheet">

<main id="main">

	<!-- <!-- ======= Breadcrumbs ======= -->
	<section class="breadcrumbs">
		<div class="container">

			<ol>
				<li><a href="/index.jsp">Home</a></li>
				<li></li>
			</ol>
			<h2>로그인 오류</h2>

		</div>
	</section>
	<!--End Breadcrumbs -->

	<!--  ========== 추천게시판 팝업 ============= -->
	<section id="testimonials" class="testimonials portfolio">
		<div class="container" data-aos="fade-up">
			<header class="section-header">
				<h2>PLEASE LOGIN AGAIN</h2>
				<!-- 	<p class="pcomment">이 영화를 추천합니다!</p> -->

				<p>
					<i class="bi bi-emoji-dizzy"></i>&nbsp; 로그인을 실패하였습니다.
				</p>
				<br>
				<div class="form-group">
					<a href="/member/login">로그인하기</a>&nbsp
					<a href="/intro/find/findId.jsp">아이디 찾기</a>&nbsp <a
						href="/intro/find/findPwd.jsp">비밀번호 찾기</a>
				</div>

		
				<div class="hero-img" data-aos="zoom-out" data-aos-delay="100">
					<img src="/assets/img/member/loginError.jpg"
						style="width: 550px; height: 500px;" class="img-fluid" alt="">

				</div>
				

			</header>

		</div>
	</section>
</main>




<%@include file="/footer.jsp"%> 