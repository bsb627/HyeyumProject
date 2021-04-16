<%@page import="show.model.vo.ShowInfo"%>
<%@page import="file.model.vo.FileData"%>
<%@page import="reply.model.vo.Reply"%>
<%@page import="java.util.ArrayList"%>
<%@page import="show.model.vo.ShowReview"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ShowReview review = (ShowReview)request.getAttribute("review");
	/* String pageNavi = (String)request.getAttribute("pageNavi");
	ArrayList<Reply> replyList = (ArrayList<Reply>)request.getAttribute("replyList"); */
	ArrayList<Reply> rList = (ArrayList<Reply>)request.getAttribute("rList");
	int totalCount = (int)request.getAttribute("totalCount");
	int likes = (int)request.getAttribute("likes");
	FileData fileData = (FileData)request.getAttribute("fileData");
	ShowInfo info = (ShowInfo)request.getAttribute("info");
	
%>
<%@include file="/header.jsp"%>

<head>
<title>문화나눔, 혜윰 - 디테일</title>
<link href="/assets/css/show-custom.css" rel="stylesheet">

</head>
<main id="main">

	<!-- ======= Breadcrumbs ======= -->
	<section class="breadcrumbs">
		<div class="container">

			<ol>
				<li><a href="/index.jsp">Home</a></li>
				<li>공연</li>
			</ol>
			<h2>관람혜윰</h2>

		</div>
	</section>
	<!-- End Breadcrumbs -->

	<!-- ======= Portfolio Details Section ======= -->
	<section id="portfolio-details" class="portfolio-details blog">
		<div class="container">
			<header class="section-header">
				<h2>Photo Review</h2>
				<p>관람 포토 후기</p>
			</header>
			<div class="row gy-4  review-box">


				<div class="col-lg-8  show-box">
					<div class="portfolio-details-slider swiper-container">
						<div class="swiper-wrapper align-items-center">
							<div class="swiper-slide">
								
								<img src="/upload/show/<%=fileData.getFileName()%>"  onerror="this.src='/upload/info/show/<%=info.getFileName() %>'" alt="">
							</div>
						</div>
						<!-- <div class="swiper-pagination"></div> -->
					</div>

					<div class="portfolio-description">
						<div class="icon-box">
							<%if(likes == 0){ %>
							<a href="/showReview/plusLikes?no=<%=review.getNo()%>"><i
								class="bi bi-heart show-icon heart-like" ></i></a>
							<%} else { %>
							<a href="/showReview/minusLikes?no=<%=review.getNo()%>"><i
								class="bi bi-heart-fill show-icon heart-hate"></i></a>
							<%} %>
							
							
							<span data-toggle="modal"
	data-target="#exampleModal"><i class="bi bi-envelope-open direct show-icon"></i></span>
							
							 
							<a href="<%=review.getSnsLink() %>" target="_blank"><i
								class="bi bi-instagram instargram show-icon"
								></i></a>
						</div>
						<h2><%=review.getTitle()%></h2>
						<p>
							<%=review.getContents()%>
						</p>
					</div>

					<div class="reply-box">
						<h6 class="comments-count">
							<strong>댓글 <%=totalCount %>개
							</strong>
						</h6>

						<% for(Reply reply : rList){ %>
						<div id="" class="show-reply">
							<div class="">
								<div class="show-contents">
									<h6>
										<strong> <a href="#" style="color:#333"><%=reply.getNick() %></a> 
										</strong>
										<%=reply.getContents() %>
									</h6>
								</div>
								
							</div>
						</div>
						<!-- End comment #1 -->
						<%} %>
						<form action="/reply/write" method="get">
							<div class="reply-form">
								<input type="hidden" name="type" value="show"> <input
									type="hidden" name="review-no" value="<%=review.getNo()%>">
								<input type="text" class="form-control " name="comment"
									placeholder="댓글달기" required>
								<button type="submit" class="btn btn-reply">
									<small><strong>등록</strong></small>
								</button>
							</div>
						</form>
					</div>


				</div>

				<div class="col-lg-4">
					<div class="user-box ">
					<div class="container">
						<div class="blog-comments">
							<div id="comment-1" class="comment">
								<div class="btn-set">
									<%
										if (review.getUserId().equals(userId)) {
									%>
									<a href="/showReview/delete?no=<%=review.getNo()%>"><button
											type="button" class="btn btn-sm btn-outline-danger"
											data-mdb-ripple-color="dark">삭제</button> </a>
									<%
										}
									%>
									<%
										if (review.getUserId().equals(userId)) {
									%>
									<a href="/showReview/update?no=<%=review.getNo()%>"><button
											type="button" class="btn btn-sm btn-outline-primary"
											data-mdb-ripple-color="dark">수정</button> </a>
									<%
										}
									%>
									<a href="/showReview/list"><button type="button"
											class="btn btn-sm btn-outline-dark"
											data-mdb-ripple-color="dark">목록</button> </a>

								</div>


								<div class="d-flex">
									<div class="comment-img">
										<img src="/assets/img/blog/comments-2.jpg" alt="">
									</div>
									<div class="comment-form">
										<h5>
											<a href=""><%=review.getNick()%></a>
										</h5>

										<time datetime="2020-01-01"><%=review.getEnrollDate()%></time>

									</div>
								</div>
								<span class="post-date">
							<i class="bi bi-eye"> <%=review.getHits()%></i>							
							<i class="bi bi-chat-square-dots"> <%=review.getReplys() %></i>
							<i class="bi bi-heart"> <%=review.getLikes() %></i>
						</span>
							</div>
							<!-- End comment #1 -->
							</div>
						</div>
					</div>


					<div class="portfolio-info">

						<div class="container">
							<div class="row">

								<div class="col-md-6">
									<a href="/showInfo/detail?no=<%=info.getInfoNo()%>"><img
										src="/upload/info/show/<%=info.getFileName() %>"
										height="150px" /></a>

								</div>
								<div class="col-md-6">

									<ul>
										<li><small><strong><%=info.getType() %></strong></small></li>
										<li><h3>
												<a href="/showInfo/detail?no=<%=info.getInfoNo()%>"><strong><%=info.getShowName() %></strong></a>
											</h3></li>
										<li><strong><%=info.getRegion() %></strong></li>
										<li><strong><%=info.getPlace()%> </strong></li>

									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

</main>
<!--  modal -->
<!-- Trigger the modal with a button -->


<!-- Modal -->
<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">쪽지 보내기</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body"><input type="text" class="form-control" placeholder="메세지 입력" required/></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
				<button type="button" class="btn btn-primary">전송</button>
			</div>
		</div>
	</div>
</div>
<!-- End #main -->

<%@include file="/footer.jsp"%>
<script src="/assets/js/show-detail.js"></script>