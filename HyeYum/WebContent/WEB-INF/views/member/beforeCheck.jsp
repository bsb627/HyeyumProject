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



<!--  ==================사이드바 =================== -->
    <section id="blog" class="blog">
      <div class="container" data-aos="fade-up">
<div class="col-md-12">
        <div class="row">
						<div class="col-md-3">

							<div class="sidebar">
							<div class="sidebar-item recent-posts"> 
								<div class="post-item clearfix">
								<!-- <img src="/assets/img/features.png"> -->
								</div>
								<h3 class="sidebar-title">내정보 <i class="bi bi-person-bounding-box"></i></h3>
								<div class="sidebar-item categories">
									<ul>
										<li><a href="/member/modify">정보수정</a></li>
									</ul>
									<hr>

									<h3 class="sidebar-title">쪽지 <i class="bi bi-envelope"></i></h3>
									<div class="sidebar-item categories">
										<ul>
											<li><a href="/message/write/page">쪽지 쓰기</a></li>
											<li><a href="/message/receivedList">받은 쪽지함</a></li>
											<li><a href="/message/sentList">보낸 쪽지함</a></li>
										</ul>
										<hr>

										<h3 class="sidebar-title">활동 <i class="bi bi-journals"></i></h3>
										<div class="sidebar-item categories">
											<ul>
												<li><a href="/myPost">작성 게시글</a></li>
												<li><a href="/myReply">작성 댓글</a></li>
											</ul>
											<hr>
										</div>
										<!-- End sidebar tags-->

										<h3 class="sidebar-title">주문 <i class="bi bi-credit-card"></i></h3>
										<div class="sidebar-item categories">
											<ul>
												<li><a href="/order/list">주문 내역</a></li>
											</ul>
											<hr>
										</div>
										<!-- End sidebar tags-->
										<h3 class="sidebar-title">기부 <i class="bi bi-gift"></i></h3>
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
										<div class="col-md-9 info-card">
						<div class="row gy-4">
							<div class="col-lg-6 col-md-6" data-aos="fade-up"
								data-aos-delay="200">
								<div class="service-box blue">
									<i class="ri-emotion-line icon"></i>
									<h3>회원 정보 수정</h3>
									<!-- <p>Provident nihil minus qui consequatur non omnis maiores.
										Eos accusantium minus dolores iure perferendis tempore et
										consequatur.</p> -->
									<a href="/member/modify"
										class="read-more"><span>자세히 보기</span> <i class="bi bi-person-lines-fill"></i></a>
								</div>
							</div>

							<!-- <div class="col-lg-4 col-md-6" data-aos="fade-up"
								data-aos-delay="300">
								<div class="service-box purple">
									<i class="ri-discuss-line icon"></i>
									<h3>Eosle Commodi</h3>
									<p>Ut autem aut autem non a. Sint sint sit facilis nam
										iusto sint. Libero corrupti neque eum hic non ut nesciunt
										dolorem.</p>
									<a href="#" class="read-more"><span>Read More</span> <i
										class="bi bi-arrow-right"></i></a>
								</div>
							</div>
-->
							<div class="col-lg-6 col-md-6" data-aos="fade-up"
								data-aos-delay="400">
								<div class="service-box green">
									<i class="ri-lock-2-line icon"></i>
									<h3>비밀번호 변경</h3>
									
									<a href="/member/changePwd" class="read-more"><span>자세히 보기</span> <i class="bi bi-key-fill"></i></a>
								</div>
							</div> 

							<!--<div class="col-lg-4 col-md-6" data-aos="fade-up"
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

						<div class="col-lg-6 col-md-6" data-aos="fade-up"
								data-aos-delay="600">
								<div class="service-box orange">
									<i class="ri-hand-heart-line icon "></i>
									
									<h3>나의 기부내역</h3>
									<a href="/donate/list" class="read-more"><span>자세히 보기</span> <i class="bi bi-bookmark-heart-fill"></i></a>
								</div>
							</div> 

							<div class="col-lg-6 col-md-6" data-aos="fade-up"
								data-aos-delay="700">
								<div class="service-box pink">
									<i class="ri-emotion-sad-line icon"></i>
									<h3>회원 탈퇴</h3>
									<a href="/member/delete" class="read-more"><span>자세히 보기</span> <i class="bi bi-door-open-fill"></i></a>
								</div>
							</div>
						</div>
					</div>
					
        </div><!--  end row  -->
</div>
      </div>
      </section>
      
<!--  ==================사이드바 =================== -->



				</div>
		</div>
	
			</section>


			<!-- End Services Section -->
		</form>
	</div>
</section>




<%@include file="/footer.jsp"%>