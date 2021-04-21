<%@page import="java.awt.TrayIcon.MessageType"%>
<%@page import="message.model.vo.Message"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<head>
  <title>문화나눔, 혜윰 </title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

 <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <ol>
          <li><a href="/index.jsp">Home</a></li>
          <li>마이페이지</li>
          <li>내 정보</li>
        </ol>
        <h2>비밀번호 변경</h2>
		
      </div>
    </section><!-- End Breadcrumbs -->
  <!-- ======= Services Section ======= -->
			<section id="services" class="services">

				<div class="container" data-aos="fade-up">
					<div class="inner-page">
						<header class="section-header">
							<h2>password</h2>
							<p>비밀번호 변경</p>
						</header> 
 <section id="blog" class="blog" >
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
										
			<!--============== 여기에 작성하기================================ -->
<div class="col-md-9 info-card">
<article class="entry entry-single">   
<div>
<form action = "/member/changePwd"  method = "post" >
현재 비밀번호 

&nbsp; <input type = "password" class="form-control" id="origin-pass" name = "origin-pass"  style="width:50%; display: inline-block;"> <span style="display: inline-block;" id="check-msg"><p></p></span><br><br>
변경 비밀번호
&nbsp;<input type = "password" class="form-control" id="change-pass" name = "change-pass"  style="width:50%; display: inline-block;"> <span style="display: inline-block;" id="check-msg"><p></p></span><br><br>
비밀번호 확인
&nbsp;<input type = "password" class="form-control" id="change-pass-confirm" name = "change-pass-confirm"  style="width:50%; display: inline-block;"> <span style="display: inline-block;" id="check-msg"><p></p></span><br><br>
<input type = "submit" class ="btn btn-primary">
</form>		
</div>
</article>
</div>
			<!--============== 여기에 작성하기 끝================================ -->
									</div>
									<!--  end row  -->
								</div>
							</div>
						</section>
<!-- ----------------------------시작 --------------------------- -->
  </div></div>
</section>

  </main><!-- End #main -->

<%@include file="/footer.jsp"%>
<script type="text/javascript"	src="/assets/js/change-pwd.js"></script>