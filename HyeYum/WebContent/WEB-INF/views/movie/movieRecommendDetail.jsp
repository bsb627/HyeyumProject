<%@page import="movie.model.vo.MovieRecommend"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MovieRecommend recommend = (MovieRecommend) request.getAttribute("recommend");
%>

<head>
<title>문화나눔, 혜윰 - 추천 글보기</title>
<%@include file="/header.jsp"%>
<link href="/assets/css/movie/movie-custom.css" rel="stylesheet">
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
							<%=recommend.getTitle()%>
						</h2>

						<hr>

						<div class="entry-meta">
							<ul>
								<li class="d-flex align-items-center"><i
									class="bi bi-person"></i> <%=recommend.getNick()%></li>
								<li class="d-flex align-items-center"><i
									class="bi bi-clock"></i> <%=recommend.getEnrollDate()%><time
										datetime="2020-01-01"></time></li>
								<li class="d-flex align-items-center"><i
									class="bi bi-chat-dots"></i> <a href="blog-single.html">12
										Comments</a></li>
							</ul>
						</div>

						<hr>

						<div class="entry-content">
							<div class="blank-content">
								<%=recommend.getContents()%>
							</div>
						</div>

						<div class="entry-footer">
							<i class="bi bi-folder"></i>
							<ul class="cats">
								<li><a href="#">Business</a></li>
							</ul>

							<i class="bi bi-tags"></i>
							<ul class="tags">
								<li><a href="#">Creative</a></li>
								<li><a href="#">Tips</a></li>
								<li><a href="#">Marketing</a></li>
							</ul>
						</div>

					</article>
					<!-- End blog entry -->



					<div class="blog-comments">

						<h4 class="comments-count">8 Comments</h4>

						<div id="comment-1" class="comment">
							<div class="d-flex">
								<div class="comment-img">
									<img src="/assets/img/blog/comments-1.jpg" alt="">
								</div>
								<div>
									<h5>
										<a href="">Georgia Reader</a> <a href="#" class="reply"><i
											class="bi bi-reply-fill"></i> Reply</a>
									</h5>
									<time datetime="2020-01-01">01 Jan, 2020</time>
									<p>Et rerum totam nisi. Molestiae vel quam dolorum vel
										voluptatem et et. Est ad aut sapiente quis molestiae est qui
										cum soluta. Vero aut rerum vel. Rerum quos laboriosam placeat
										ex qui. Sint qui facilis et.</p>
								</div>
							</div>
						</div>
						<!-- End comment #1 -->

						<div id="comment-2" class="comment">
							<div class="d-flex">
								<div class="comment-img">
									<img src="/assets/img/blog/comments-2.jpg" alt="">
								</div>
								<div>
									<h5>
										<a href="">Aron Alvarado</a> <a href="#" class="reply"><i
											class="bi bi-reply-fill"></i> Reply</a>
									</h5>
									<time datetime="2020-01-01">01 Jan, 2020</time>
									<p>Ipsam tempora sequi voluptatem quis sapiente non. Autem
										itaque eveniet saepe. Officiis illo ut beatae.</p>
								</div>
							</div>


							<div class="reply-form">
								<h4>댓글</h4>
								<p>댓글만 달아도 기부를 할 수 있습니다. 💌
								<p>
								<form action="/reply/write">
									<%--  <div class="row">
                    <div class="col-md-6 form-group">
                      <input name="name" type="text" class="form-control" placeholder="Your Name*" value="<%=userId %>" readonly>
                    </div>
                    <div class="col-md-6 form-group">
                      <input name="email" type="text" class="form-control" placeholder="Your Email*">
                    </div>
                  </div> --%>
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
							</div>

						</div>
						<!-- End blog comments -->

					</div>
					<!-- End blog entries list -->


				</div>

				<div class="col-lg-4">

					<div class="sidebar">

						<h3 class="sidebar-title">조회수/좋아요/넣을거!!</h3>
						<hr>
						<div class="sidebar-item categories">
							<ul>
								<li>조회 수 : 조회수 넣어야함!!</li>
								<li>작성자 : <%=recommend.getNick()%></li>
								<li>작성일 : <%=recommend.getEnrollDate()%></li>
								<li>좋아요</li>
								<li>General</li>
							</ul>
						</div>

					</div>
				</div>

			</div>
	</section>
</main>
<!-- End #main -->
<script src="assets/js/main.js"></script>
<%@include file="/footer.jsp"%>