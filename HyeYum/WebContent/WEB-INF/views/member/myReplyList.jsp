<%@page import="reply.model.vo.Reply"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Reply> rList = (ArrayList<Reply>)request.getAttribute("rList");
	String pageNavi = (String)request.getAttribute("pageNavi");
%>

<title>회원 상세 정보</title>
<%@include file="/header.jsp"%>

<!-- ======= Breadcrumbs ======= -->
<section class="breadcrumbs">
	<div class="container">

		<ol>
			<li><a href="/index.jsp">Home</a></li>
			<li>내 정보</li>
		</ol>
		<h2>활동/ 댓글 모아보기</h2>

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
							<h2>Reply</h2>
							<p>댓글 모아보기</p>
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
					
					
									<table class="table" style="text-align: center;">
									<tr>
										<th>번호</th>
										<th>게시판</th>
										<th>댓글내용</th>
										<th>등록날짜</th>
									</tr>
									<% for(Reply reply : rList) {%>
									<tr>
										<td><%=reply.getNum() %></td>
										<td><%=reply.getReplyType() %></td>
										<%if(reply.getReplyType().equals("독서혜윰")) {%>
										<td><a href="/bookReview/detail?review-no=<%=reply.getNo()%>"><%=reply.getContents() %></a></td>
										<%} else if(reply.getReplyType().equals("나눔혜윰")){%>
										<td><a href="/bookShare/detail?share-no=<%=reply.getNo()%>"><%=reply.getContents() %></a></td>
										<%} else if(reply.getReplyType().equals("감상혜윰")){%>
										<td><a href="/moiveRecommend/detail?recommendNo==<%=reply.getNo()%>"><%=reply.getContents() %></a></td>
										<%} else if(reply.getReplyType().equals("관람혜윰")){%>
										<td><a href="/showReview/detail?no=<%=reply.getNo()%>"><%=reply.getContents() %></a></td>
										<%} %>
										<td><%=reply.getEnrollDate()%></td>
									</tr>
									
									<%} %>
									</table>
										<div class="blog-pagination">
				<ul class="justify-content-center">
					<!-- 	<li><a href="#">1</a></li>
						<li class="active"><a href="#">2</a></li>
						<li><a href="#">3</a></li> -->
					<%=pageNavi%>
				</ul>
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