<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<title>회원 상세 정보</title>
<%@include file="/header.jsp"%>

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
			
			<!-- ======= Services Section ======= -->
			<section id="services" class="services">

				<div class="container" data-aos="fade-up">
					<div class="inner-page">
						<header class="section-header">
							<h2>ORDER</h2>
							<p>주문 내역</p>
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
										<li><a href="#">정보수정</a></li>
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
												<li><a href="/message/sentList">작성 게시글</a></li>
												<li><a href="/message/sentList">작성 댓글</a></li>
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
												<li><a href="/message/sentList">기부 내역</a></li>
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
					
					
									<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1 class="display-4">Fluid jumbotron</h1>
    <p class="lead">This is a modified jumbotron that occupies the entire horizontal space of its parent.</p>
    <div class="w-25 h-25 p-3" style="background-color: #eee">
    <img src="/assets/img/product/palzzi3.png"/ style="width: 100%; height: 100%;">
</div>
    <h1 class="text-hide" style="background-image: url('/assets/img/product/palzzi3.png'); width: 50px; height: 50px;">Bootstrap</h1>
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