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

              <h3 class="sidebar-title">Search</h3>
              
              <h3 class="sidebar-title">쪽지</h3>
              <div class="sidebar-item categories">
                <ul>
                  <li><a href="#">보낸 쪽지함</a></li>
                  <li><a href="#">받은 쪽지함</a></li>
                  <li><a href="#">쪽지 쓰기</a></li>
                  <hr>
                  <li>으어ㅓㅓㅓ여기 내비두기</li>
                  <li><a href="#">Design <span>(22)</span></a></li>
                  <li><a href="#">Creative <span>(8)</span></a></li>
                  <li><a href="#">Educaion <span>(14)</span></a></li>
                </ul>
              </div><!-- End sidebar categories-->

              <h3 class="sidebar-title">Recent Posts</h3>
              <div class="sidebar-item recent-posts">
                <div class="post-item clearfix">
                  <img src="assets/img/blog/blog-recent-1.jpg" alt="">
                  <h4><a href="blog-single.html">Nihil blanditiis at in nihil autem</a></h4>
                  <time datetime="2020-01-01">Jan 1, 2020</time>
                </div>

                <div class="post-item clearfix">
                  <img src="assets/img/blog/blog-recent-2.jpg" alt="">
                  <h4><a href="blog-single.html">Quidem autem et impedit</a></h4>
                  <time datetime="2020-01-01">Jan 1, 2020</time>
                </div>

                <div class="post-item clearfix">
                  <img src="assets/img/blog/blog-recent-3.jpg" alt="">
                  <h4><a href="blog-single.html">Id quia et et ut maxime similique occaecati ut</a></h4>
                  <time datetime="2020-01-01">Jan 1, 2020</time>
                </div>

                <div class="post-item clearfix">
                  <img src="assets/img/blog/blog-recent-4.jpg" alt="">
                  <h4><a href="blog-single.html">Laborum corporis quo dara net para</a></h4>
                  <time datetime="2020-01-01">Jan 1, 2020</time>
                </div>

                <div class="post-item clearfix">
                  <img src="assets/img/blog/blog-recent-5.jpg" alt="">
                  <h4><a href="blog-single.html">Et dolores corrupti quae illo quod dolor</a></h4>
                  <time datetime="2020-01-01">Jan 1, 2020</time>
                </div>

              </div><!-- End sidebar recent posts-->

              <h3 class="sidebar-title">Tags</h3>
              <div class="sidebar-item tags">
                <ul>
                  <li><a href="#">App</a></li>
                  <li><a href="#">IT</a></li>
                  <li><a href="#">Business</a></li>
                  <li><a href="#">Mac</a></li>
                  <li><a href="#">Design</a></li>
                  <li><a href="#">Office</a></li>
                  <li><a href="#">Creative</a></li>
                  <li><a href="#">Studio</a></li>
                  <li><a href="#">Smart</a></li>
                  <li><a href="#">Tips</a></li>
                  <li><a href="#">Marketing</a></li>
                </ul>
              </div><!-- End sidebar tags-->

            </div><!-- End sidebar -->

          </div><!-- End blog sidebar -->

					
        </div><!--  end row  -->
		</div>
      	</div>
      </section>
      
<!--  ==================사이드바끝 =================== -->



				</div>
		</div>
	
			</section>


			<!-- End Services Section -->
		</form>
	</div>
</section>




<%@include file="/footer.jsp"%>