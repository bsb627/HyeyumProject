<%@page import="file.model.vo.FileData"%>
<%@page import="movie.model.vo.MovieInfo"%>
<%@page import="movie.model.vo.MovieReview"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<MovieReview> review = (ArrayList<MovieReview>)request.getAttribute("review");
	String pageNavi = (String) request.getAttribute("pageNavi");
	ArrayList<MovieInfo> mList = (ArrayList<MovieInfo>)request.getAttribute("mList");
	ArrayList<FileData> fList = (ArrayList<FileData>)request.getAttribute("fList");
	
%>
<head>
<title>문화나눔, 혜윰 - 영화</title>

<%@include file="/header.jsp"%>
<link rel="stylesheet" href="/assets/note/summernote-lite.css">
<link href="/assets/css/movie/movieinfo.css" rel="stylesheet">
</head>


	<!-- <script src="/assets/js/movieInfo.js"></script> -->

	<main id="main">



		<!-- ======= Breadcrumbs ======= -->
		<section class="breadcrumbs">
			<div class="container">

				<ol>
					<li><a href="/index.jsp">Home</a></li>
					<li>영화</li>
				</ol>
				<h2>감상혜윰</h2>

			</div>
		</section>
		<!-- End Breadcrumbs -->

		<!-- ======= Testimonials Section ======= -->
		<section id="testimonials" class="testimonials portfolio">

			<div class="container" data-aos="fade-up">

				<header class="section-header">
					<h2>MONTHLY CONTENTS</h2>
					<p>이 달의 컨텐츠 - 영화</p>
				</header>

				<div class="testimonials-slider swiper-container "
					data-aos="fade-up" data-aos-delay="200">
					<div class="swiper-wrapper">

					 <% for(MovieInfo mInfo : mList) { %>
					 
						<div class="swiper-slide">
							<div class="testimonial-item">
								<div class="portfolio-wrap">
									<img src="/upload/info/movie/<%=mInfo.getFileName()%>" alt=""
										class="img-fluid">
									<div class="portfolio-info">
										<h4><%=mInfo.getMovieName()%></h4>
										<p><%=mInfo.getGenre() %></p>
										<div class="portfolio-links">
											<a href="/upload/info/movie/<%=mInfo.getFileName()%>"
												data-gallery="portfolioGallery" class="portfokio-lightbox"
												title="<%=mInfo.getMovieName()%>"><i class="bi bi-plus"></i></a> <a
												href="/movieInfo/detail?no=<%=mInfo.getInfoNo()%>" title="More Details"><i
												class="bi bi-link"></i></a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<% } %>
						<!-- End testimonial item -->
						

					</div>
					<!--  <div class="swiper-pagination"></div> -->
				</div>

			</div>

		</section>
		<!-- End Testimonials Section -->


	 	<section>

			<div class="container" data-aos="fade-up">

				<!-- <header class="section-header">
					<h2>MOVIE REVIEW</h2>
					<p>영화 리뷰</p>
				</header> -->

				 <%
					if (userId == null) {
				%>
				
				<div class="container" data-aos="fade-up">
				<header class="section-header">
					<h2>MOVIE REVIEW</h2>
					<p>영화 리뷰</p>
				
					<strong>잠깐 ! </strong> 해당글은 <a href="/member/login"
						class="alert-link">로그인</a>후 이용이 가능합니다.
				
				<div class="hero-img" data-aos="zoom-out" data-aos-delay="100">
					<img src="/assets/img/movie/review2.jpg"
						style="width: 600px; height: 450px;" class="img-fluid" alt="">

				</div>
				</header>
				</div>
				<%
					}
				%> 

				<!-- 로그인 할 시 -->

				<%
					if (userId != null && userId != "") {
				%> 
					<!-- ========= 글쓰기 버튼 Button trigger modal ========= -->
					<header class="section-header">
					<h2>MOVIE REVIEW</h2>
					<p>영화 리뷰</p>
					</header>
				<div style="text-align: center;">
				
					<button type="button" class="btn btn-primary btn-write"
						data-toggle="modal" data-target="#writeModal"
						data-whatever="@getbootstrap" id="write-button">글쓰기</button>
				</div>
	


			</div>
		</section>
</main>
	<!-- End #main -->
		<section id="blog" class="blog">
			<div class="container" data-aos="fade-up">

				<!-- ========== 리뷰글 ========== -->


				<div class="row">

					<%
						for (MovieReview mReview : review) {
					%>
				

					<div class="col-8" style="margin: auto;">
						<!-- col-lg-8 entries -->
						<article class="entry entry-single">

							<h2 class="entry-title">
							<input type="hidden" name="review-no" value="<%= mReview.getReNo() %>" />
								<label>[<%=mReview.getGenre()%>]
								</label>
								<%=mReview.getMovieName()%></h2>
								
							
							<hr>
							<div class="entry-meta">
								<ul>

									<!-- 닉네임, 시간, 조회수 -->
									<li class="d-flex align-items-center"><i
										class="bi bi-person"></i><%=mReview.getNick()%></li>
									<li class="d-flex align-items-center"><i
										class="bi bi-clock"></i> <time datetime="2020-01-01"></time><%=mReview.getEnrollDate()%></li>
									<li class="d-flex align-items-center"><i class="bi bi-star"></i><b><%=mReview.getStarRating()%> 점을 주었습니다!</b></b></li>

								</ul>
							</div>
							<hr>

							<div class="entry-content">
								<div class="blank-content"><%=mReview.getContents()%></div>
							</div>

					<div class="entry-footer">
						<i class="bi bi-camera-reels-fill"></i>
						 <a href="/movieInfo/detail?no=<%=mReview.getInfoNo()%>" title="More Details">영화 정보 보기</a>
	
						

						<!-- <i class="bi bi-tags"></i>
						<ul class="tags">
							<li><a href="#">Creative</a></li>
							<li><a href="#">Tips</a></li>
							<li><a href="#">Marketing</a></li>
						</ul> -->
						<div style="float: right">
						
							<%
								if (mReview.getUserId().equals(userId)) {
							%>

							<button type="button" class="btn btn-primary btn-write"
								data-toggle="modal"
								data-target="#modifyModal<%=mReview.getInfoNo()%>"
								data-whatever="@getbootstrap">수정하기</button>
								
								<a href="/movieReview/delete?no=<%=mReview.getReNo()%>"><input
									type="button" class="btn btn-primary" value="삭제"></a>
							<%
								}
							%>
						</div>
					</div>


				</article>
						

						<!-- End blog entry -->
					</div>
					<%
						}
					%>
				</div>

				<br> <br> <br>

				<!-- 페이징 처리 할 곳 !! -->
				<div class="blog-pagination">
					<ul class="justify-content-center">
						<%=pageNavi%>
					</ul>
				</div>
			</div>
		</section>





	

<!--   ============== 글쓰기 모달창 ============ -->

<div class="modal fade" id="writeModal" tabindex="-1" role="dialog"
	aria-labelledby="writeModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
		<form action="/movieReview/write" method="post"  >
			<div class="modal-header">
				<h5 class="modal-title" id="writeModalLabel">영화 리뷰 등록</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
				<div class="modal-body">
					<label class="form-label" for="title">제목</label> <select
						class="form-select" name="info-no" required>
						
						<option value="" hidden="hidden">영화를 선택해주세요</option>
						<% for(MovieInfo mInfo : mList) { %>
						<option value="<%= mInfo.getInfoNo()%>"><%=mInfo.getMovieName() %></option>
						<!-- <option value="2">info2</option>
						<option value="3">info3</option>
						<option value="4">info4</option>
						<option value="5">info5</option>
						<option value="6">info6</option> -->
						<% } %>
					</select>

					<div class="form-group">
						<label for="recipient-name" class="col-form-label">별점</label>
						<input type="number" min="1" max="5" class="form-control" id="recipient-name" name="star-rating">
					</div>

					<!-- <div class="form-group"> -->
						<label for="message-text" class="col-form-label"><b>감상평</b></label>
						<!-- <textarea class="form-control" id="review-content" name="content" > </textarea> -->
							<div class="form-outline show-form">
						<textarea id="summernote" name="content" required></textarea>
						</div>
					<!-- </div> -->

					<div class="form-group">
						<label for="recipient-name" class="col-form-label">예매일련번호</label>
						<input type="text" class="form-control" id="ticket-number" name="ticket-number" required>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">취소</button>
						<button type="submit" class="btn btn-primary"  id="write-btn">등록</button>
					</div>
				</div>
				</form>
		</div>
		
	</div>

</div>

<!-- 글쓰기 모달 end  -->

						<!--   ============== 글수정 모달창 ============ -->

<%
	for (MovieReview mReview : review ) { 
	%>
<div class="modal fade" id="modifyModal<%= mReview.getInfoNo() %>" tabindex="-1" role="dialog"
	aria-labelledby="modifyModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
		<form action="/movieReview/modify" method="post" >
			<div class="modal-header">
				<h5 class="modal-title" id="modifyModalLabel">영화 리뷰 수정</h5>
				<input type="hidden" name="review-no" value="<%= mReview.getReNo() %>" />
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			
			
				<div class="modal-body">
					<label class="form-label" for="title">제목</label> <select
						class="form-select" name="info-no" required>
						
						<option value="" hidden="hidden">영화를 선택해주세요</option>
						<% for(MovieInfo mInfo : mList) { %>
						<option value="<%= mInfo.getInfoNo()%>"><%=mInfo.getMovieName() %></option>
						<!-- <option value="2">info2</option>
						<option value="3">info3</option>
						<option value="4">info4</option>
						<option value="5">info5</option>
						<option value="6">info6</option> -->
						<% } %>
					</select>


					<div class="form-group">
						<label for="recipient-name" class="col-form-label">별점</label>
						<input type="number" min="1" max="5" class="form-control" id="recipient-name" name="star-rating" value="<%= mReview.getStarRating() %>" >
					</div>

					<!-- <div class="form-group"> -->
						<label for="message-text" class="col-form-label"><b>감상평</b></label>
						<%-- <textarea class="form-control" id="message-text" name="content"><%= mReview.getContents() %></textarea> --%>
							<div class="form-outline show-form">
						<textarea id="summernote-modify" name="content" required><%= mReview.getContents() %></textarea>
						</div>
					<!-- </div> -->

					<div class="form-group">
						<label for="recipient-name" class="col-form-label">예매일련번호</label>
						<input type="text" class="form-control" id="recipient-name" name="ticket-number" value="<%= mReview.getTicketNumber() %>" readonly>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">취소</button>
						<button type="submit" id="modify-btn" class="btn btn-primary">수정</button>
					</div>
				</div>
				</form>
		</div>
		
	</div>

</div>
<% } %>
<% } %>


<%@include file="/footer.jsp"%>
<script src="/assets/note/summernote-lite.js"></script>
<script src="/assets/note//lang/summernote-ko-KR.js"></script>
<script type="text/javascript"	src="/assets/js/note-ready.js"></script>
 <script type="text/javascript"	src="/assets/js/movieInfo.js"></script> 
