<%@page import="order.model.vo.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Order> oList = (ArrayList<Order>)request.getAttribute("oList");
	String pageNavi = (String)request.getAttribute("pageNavi");
	int orderCount = (int)request.getAttribute("orderCount");
%>

<title>회원 상세 정보</title>
<%@include file="/header.jsp"%>
<link href="/assets/css/order-custom.css" rel="stylesheet">
<!-- ======= Breadcrumbs ======= -->
<section class="breadcrumbs">
	<div class="container">

		<ol>
			<li><a href="/index.jsp">Home</a></li>
			<li>내 정보</li>
		</ol>
		<h2>주문/ 주문내역</h2>

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
					
		

					<!-- order -->
					<section>
					<article>
					<div class="order-count">
					<h4><strong>총 <%=orderCount %>건</strong></h4>
					</div>
					<hr>
					</article>
					<% for(Order order : oList){ %>
						<article>
							<div class="order-box">
								<div class="order-info">
									<h6><strong>주문번호 <%=order.getOrderNO() %></strong></h6>
									<sub><%=order.getOrderDate() %></sub>
								</div>
								<div class="order-contents">
									<div class="order-img">
									 <img src="/assets/img/product/palzzi3.png">
									</div>
									<div class="order-product">
									 혜윰팔찌<br>
									 <%=order.getTotalPrice() %>원/ <%=order.getQuantity() %>개
									 <div class="order-state">
									 <sub><%=order.getShippingState() %></sub>
									 </div>
									</div>
								</div>
							
							</div>
								<hr>
						</article>
						<%} %>
						<div class="blog-pagination">
				<ul class="justify-content-center">
					<!-- 	<li><a href="#">1</a></li>
						<li class="active"><a href="#">2</a></li>
						<li><a href="#">3</a></li> -->
					<%=pageNavi%>
				</ul>
			</div>
						
					</section>
					
					<!--  order end -->
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