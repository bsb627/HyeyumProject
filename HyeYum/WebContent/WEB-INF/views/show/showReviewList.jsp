<%@page import="show.model.vo.ShowInfo"%>
<%@page import="file.controller.FileListServlet"%>
<%@page import="file.model.vo.FileData"%>
<%@page import="show.model.vo.ShowData"%>
<%@page import="show.model.vo.ShowReview"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<ShowReview> showList = (ArrayList<ShowReview>)request.getAttribute("showList");
/* ArrayList<ShowData> replyCount = (ArrayList<ShowData>)request.getAttribute("replyCount");
ArrayList<ShowData> likesCount = (ArrayList<ShowData>)request.getAttribute("likesCount"); */
ArrayList<FileData> fileList = (ArrayList<FileData>)request.getAttribute("fList");
String pageNavi = (String)request.getAttribute("pageNavi");
ArrayList<ShowInfo> iList = (ArrayList<ShowInfo>)request.getAttribute("iList");
%>
<title>문화나눔, 혜윰 - 관람혜윰</title>
<%@include file="/header.jsp"%>
<link href="/assets/css/show-custom.css" rel="stylesheet">
<%
	if (userId == null) {
%>
<script type="text/javascript">
	if (confirm("로그인 후 이용가능합니다.")) {
		location.href="/member/login";
	} else {
		history.back();
	}
</script>
<%
	}
%>
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


	


	<!-- ======= Recent Blog Posts Section ======= -->
	<section id="recent-blog-posts" class="blog recent-blog-posts portfolio">

		<div class="container" data-aos="fade-up">

			<header class="section-header">
				<h2>Photo Review</h2>
				<p>관람 포토 후기</p>
			</header>

			<div class="sidebar">

				<h3 class="sidebar-title">Search</h3>
				<div class="sidebar-item search-form">
					<form action="/showReview/search" method="get">
						<input type="text" name="search" autocomplete="off">
						<button type="submit">
							<i class="bi bi-search"></i>
						</button>
					</form>
				</div>
				<!-- End sidebar search formn-->

				<!-- <h3 class="sidebar-title">Tags</h3>
				<div class="sidebar-item tags">
					<ul id="portfolio-flters">
						<li ><a href="#">App</a></li>
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
				</div> -->
				<!-- End sidebar tags-->
			</div>

			<div class="row">
			
			
			<%for(ShowReview review : showList){ %>
				<div class="post-card col-lg-4">
					<div class="post-box">
					    <%for (ShowInfo info : iList){ %>
						<%if(review.getInfoNo() == info.getInfoNo()){ %>
							<%for (FileData fd : fileList){ %>
							<%if(review.getNo() == fd.getNo()){ %>
							<div class="review-img">
								<img src="/upload/show/<%=fd.getFileName() %>" onerror="this.src='/upload/info/show/<%=info.getFileName() %>'" class="img-fluid"  alt=""></figure>
							</div>
							<%} }%>
						
						<div class="post-info">
						<span class="post-type">[<%=info.getType()%>]<%=info.getShowName()%></span>
						<%} }%>

						<span class="post-date">
							<i class="bi bi-eye"> <%=review.getHits()%></i>							
							<i class="bi bi-chat-square-dots"> <%=review.getReplys() %></i>
							<i class="bi bi-heart"> <%=review.getLikes() %></i>
						</span>
							
							<!-- <a class="readmore stretched-link mt-auto"><span class="">[타입]제목</span></a> -->
							
						<h3 class="post-title"> <%=review.getTitle() %></h3>
						<a href="/showReview/hitsCount?no=<%=review.getNo() %>" class="readmore stretched-link mt-auto"></a>
						
						<span class="post-date-right">
						
							<i class="bi bi-pen"> <%=review.getNick() %></i><br>
							<i class="bi bi-clock"> <%=review.getEnrollDate() %></i>
						</span>
						</div>
					</div>
				</div>
				
			<%} %>

			<%-- 	<%for(ShowReview review : showList){ %>
				<div class="post-card col-lg-4">
					<div class="post-box">
						<%for (FileData fd : fileList){ %>
						<%if(review.getNo() == fd.getNo()){ %>
						<div class="post-img">
							<img src="/upload/show/<%=fd.getFileName() %>" class="img-fluid" alt="">
						</div>
						<%} }%>

						<span class="post-date"><i class="bi bi-pen"><%=review.getNick()%></i>
							<i class="bi bi-clock"> <%=review.getEnrollDate() %></i><br>
							<i class="bi bi-eye"> <%=review.getHits() %></i>
							<%for(ShowData reply : replyCount){ %>
							<%if(review.getNo() == reply.getShowNo()){ %>
							<i class="bi bi-chat-square-dots"> <%=reply.getTotalCount()%></i>
							<%} }%>
							<%for(ShowData likes : likesCount) {%>
							<%if(review.getNo() == likes.getShowNo()) {%>
							<i class="bi bi-heart"> <%=likes.getLikesCount() %></i></span>
							<%} }%>
						<h3 class="post-title"> <%=review.getTitle() %></h3>
						<a href="/showReview/hitsCount?no=<%=review.getNo() %>" class="readmore stretched-link mt-auto"></a>
					</div>
				</div>

				<%} %> --%>



				<div>
					<a href="/showReview/write"><button
							class="btn btn-primary btn-write">글쓰기</button></a>
				</div>
			</div>
			<div class="blog-pagination">
				<ul class="justify-content-center">
					<!-- 	<li><a href="#">1</a></li>
						<li class="active"><a href="#">2</a></li>
						<li><a href="#">3</a></li> -->
					<%=pageNavi%>
				</ul>
			</div>
		</div>



	</section>
	<!-- End Recent Blog Posts Section -->





</main>
<!-- End #main -->

<%@include file="/footer.jsp"%>