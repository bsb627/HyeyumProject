<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Member member = (Member) request.getAttribute("member");
%>

<title>회원 상세 정보</title>
<%@include file="/header.jsp"%>
<link href="/assets/css/member/beforecheck.css" rel="stylesheet">
<!-- ======= Breadcrumbs ======= -->
<section class="breadcrumbs">
	<div class="container">

		<ol>
			<li><a href="/index.jsp">Home</a></li>
			<li>내 정보</li>
		</ol>
		<h2>정보 수정 / 탈퇴</h2>

	</div>
</section>
<!-- End Breadcrumbs -->

<section class="inner-page">

	<div class="container">

		<form action="/member/modify" method="post">
			<p name="userId">
				들어오는지 체크용 아이디 :
				<%=member.getUserId()%></p>
			<!-- ======= Services Section ======= -->
			<section id="services" class="services">

				<div class="container" data-aos="fade-up">
					<div class="inner-page">
						<header class="section-header">
							<h2>SERVICES</h2>
							<p>개인정보관리</p>
						</header>

						<div class="row gy-4">
							<div class="col-lg-4 col-md-6" data-aos="fade-up"
								data-aos-delay="200">
								<div class="service-box blue">
									<i class="ri-discuss-line icon"></i>
									<h3>회원 정보 수정</h3>
									<!-- <p>Provident nihil minus qui consequatur non omnis maiores.
										Eos accusantium minus dolores iure perferendis tempore et
										consequatur.</p> -->
									<a href="/member/modify"
										class="read-more"><span>자세히 보기</span> <i
										class="bi bi-arrow-right"></i></a>
								</div>
							</div>

							<!-- <div class="col-lg-4 col-md-6" data-aos="fade-up"
								data-aos-delay="300">
								<div class="service-box orange">
									<i class="ri-discuss-line icon"></i>
									<h3>Eosle Commodi</h3>
									<p>Ut autem aut autem non a. Sint sint sit facilis nam
										iusto sint. Libero corrupti neque eum hic non ut nesciunt
										dolorem.</p>
									<a href="#" class="read-more"><span>Read More</span> <i
										class="bi bi-arrow-right"></i></a>
								</div>
							</div>

							<div class="col-lg-4 col-md-6" data-aos="fade-up"
								data-aos-delay="400">
								<div class="service-box green">
									<i class="ri-discuss-line icon"></i>
									<h3>Ledo Markt</h3>
									<p>Ut excepturi voluptatem nisi sed. Quidem fuga
										consequatur. Minus ea aut. Vel qui id voluptas adipisci eos
										earum corrupti.</p>
									<a href="#" class="read-more"><span>Read More</span> <i
										class="bi bi-arrow-right"></i></a>
								</div>
							</div> 

							<div class="col-lg-4 col-md-6" data-aos="fade-up"
								data-aos-delay="500">
								<div class="service-box red">
									<i class="ri-discuss-line icon"></i>
									<h3>Asperiores Commodi</h3>
									<p>Non et temporibus minus omnis sed dolor esse
										consequatur. Cupiditate sed error ea fuga sit provident
										adipisci neque.</p>
									<a href="#" class="read-more"><span>Read More</span> <i
										class="bi bi-arrow-right"></i></a>
								</div>
							</div>-->

							<div class="col-lg-4 col-md-6" data-aos="fade-up"
								data-aos-delay="600">
								<div class="service-box purple">
									<i class="ri-discuss-line icon"></i>
									<h3>비밀번호 변경</h3>
									<a href="#" class="read-more"><span>자세히 보기</span> <i
										class="bi bi-arrow-right"></i></a>
								</div>
							</div> 

							<div class="col-lg-4 col-md-6" data-aos="fade-up"
								data-aos-delay="700">
								<div class="service-box pink">
									<i class="ri-discuss-line icon"></i>
									<h3>회원 탈퇴</h3>
									<a href="#" class="read-more"><span>자세히 보기</span> <i
										class="bi bi-arrow-right"></i></a>
								</div>
							</div>
						</div>
					</div>
				</div>

			</section>


			<!-- End Services Section -->
		</form>
	</div>
</section>










<%@include file="/footer.jsp"%>