<%@page import="file.model.vo.FileData"%>
<%@page import="movie.model.vo.MovieRecommend"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MovieRecommend recommend = (MovieRecommend)request.getAttribute("recommend");
	int likes = (int)request.getAttribute("likes");
	//FileData fileData = (FileData)request.getAttribute("fileData");
	
%>

<head>
<title>문화나눔, 혜윰 - 추천 글보기</title>
<%@include file="/header.jsp"%>
<link href="/assets/css/movie/movie-custom.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
</head>
<main id="main">

	<!-- ======= Breadcrumbs ======= -->
	<section class="breadcrumbs">
		<div class="container">

			<ol>
				<li><a href="/index.jsp">Home</a></li>
				<li>영화</li>
			</ol>
			<h2>추천혜윰</h2>

		</div>
	</section>
	<!-- End Breadcrumbs -->


	<!-- ======= Blog Single Section ======= -->
	<section id="blog" class="blog">

		<div class="container" data-aos="fade-up">
			<header class="section-header">
				<h2>MOVIE RECOMMEND</h2>
				<p>이 영화를 추천합니다!</p>
			</header>

			<div class="row">
				<div class="col-lg-8 entries">

					<article class="entry entry-single">

						<!-- <div class="entry-img">
							<img src="/assets/img/blog/blog-1.jpg" alt="" class="img-fluid">
						</div> -->


						<h2 class="entry-title">
							<label>[<%=recommend.getGenre()%>]
							</label>
							<%=recommend.getTitle() %>
						</h2>

						<hr>

						<div class="entry-meta">
							일단 여기 보류 
						</div>

						<hr>
						<%-- <img src="/upload/movie/<%= fileData.getFileName()%>" onerror="this.src='/upload/movie/<%= fileData.getFileName()%>'"alt=""/> --%>
						<div class="entry-content">
							<div class="blank-content">
								<%=recommend.getContents()%>
							</div>
						</div>

						<div class="entry-footer">
						
								<!-- 닉네임, 시간, 조회수 -->
								<div class="d-flex align-items-center">
								<i class="bi bi-person">&nbsp;</i><%=recommend.getNick()%>&nbsp;&nbsp;
								<i class="bi bi-clock"></i>&nbsp;<%=recommend.getEnrollDate()%><time datetime="2020-01-01"></time>&nbsp;&nbsp;
								<i class="bi bi-card-text">&nbsp;</i><%=recommend.getHits()%>&nbsp;&nbsp;&nbsp;&nbsp;
								<!--  좋아요 -->
								<!--  좋아요를 할 때 -->
								 <% if (likes == 0) { %>
								<a href="/movieRecommend/plusLikes?no=<%=recommend.getNo() %>">
								<i class="fa fa-thumbs-o-up fa-2x"></i></a> 
								<!-- 좋아요를 취소할 때  -->
								<% } else { %> 
								<a href="/movieRecommend/minusLikes?no=<%=recommend.getNo() %>">
								<i class="fa fa-thumbs-up fa-2x"></i></a>
								 <% } %> 
								<p><%= recommend.getLikes() %></p>
								<!-- 
								<a href=""><button class="btn btn-sm btn-outline-danger">
										<i class="bi bi-heart-fill" style="color: #dc3545"></i> 좋아요 취소
									</button></a> -->
							</div>
						</div>

					</article>
					<!-- End blog entry -->



					<div class="blog-comments">
 
						<h4 class="comments-count"><!-- 8 Comments --></h4>

						<div id="comment-1" class="comment"></div>
						<!-- End comment #1 -->

						<div id="comment-2" class="comment">



						<%-- 	<div class="reply-form">
								<h4>댓글</h4>
								<p>댓글만 달아도 기부를 할 수 있습니다. 💌
								<p>
								<form action="/reply/write">
									 <div class="row">
                    <div class="col-md-6 form-group">
                      <input name="name" type="text" class="form-control" placeholder="Your Name*" value="<%=userId %>" readonly>
                    </div>
                    <div class="col-md-6 form-group">
                      <input name="email" type="text" class="form-control" placeholder="Your Email*">
                    </div>
                  </div>
									<input type="hidden" name="type" value="show"> <input
										type="hidden" name="review-no" value="<%=recommend.getNo()%>">
									<div class="row">
										<div class="col form-group">
											<textarea rows="6" name="comment" class="form-control"
												placeholder="댓글을 남겨주세요"></textarea>
										</div>
									</div>
									<div align="right">
										<button type="submit" class="btn btn-reply">등록하기</button>
									</div>

								</form>
							</div> --%>

						</div>
						<!-- End blog comments -->

					</div>
					<!-- End blog entries list -->


				</div>

				<div class="col-lg-4">

					<div class="sidebar">

						<div class="portfolio-info">
							<h5>
								<b>정보</b>
							</h5>

							<hr>
							<div class="sidebar-item categories">
								<ul>
									<li><strong>조회수</strong> <%=recommend.getHits()%></li>
									<li><strong>작성자</strong> <%=recommend.getNick()%></li>
									<li><strong>작성일</strong> <%=recommend.getEnrollDate()%></li>
									<li><strong>좋아요</strong> <%=recommend.getLikes()%></li>
									<br>
									
								</ul>
							</div>
							<hr>
							<div align="center">
								<%
									if (recommend.getUserId().equals(userId)) {
								%>
								<a href="/movieRecommend/modify?no=<%=recommend.getNo()%>">
									<input type="button" class="btn btn-primary " value="수정">
								</a> <a href="/movieRecommend/delete?no=<%=recommend.getNo()%>"><input
									type="button" class="btn btn-primary" value="삭제"></a>
								<%
									}
								%>
								<a href="/movieRecommend/list"><input type="submit"
									class="btn btn-primary" value="목록으로"></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</section>
</main>
<!-- End #main -->
<script src="assets/js/main.js"></script>
<%@include file="/footer.jsp"%>