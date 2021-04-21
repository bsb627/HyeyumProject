<%@page import="movie.model.vo.MovieData"%>
<%@page import="movie.model.vo.MovieRecommend"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<MovieRecommend> recommend = (ArrayList<MovieRecommend>)request.getAttribute("recommend");
	String pageNavi = (String)request.getAttribute("pageNavi");
	ArrayList<MovieData> likesCount = (ArrayList<MovieData>)request.getAttribute("likesCount");
%>


<title>문화나눔, 혜윰 - 추천혜윰</title>
<%@include file="/header.jsp"%>
<link href="/assets/css/style.css" rel="stylesheet">


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
				<li>영화</li>
			</ol>
			<h2>추천혜윰</h2>

		</div>
	</section>
	<!-- End Breadcrumbs -->

	<!--  ========== 추천게시판 팝업 ============= -->
	<section id="testimonials" class="testimonials portfolio">
		<div class="container" data-aos="fade-up">
			<header class="section-header">
				<h2>Movie Recommend</h2>
				<p class="pcomment">이 영화를 추천합니다!</p><br><br>
				
				<div class="hero-img" data-aos="zoom-out" data-aos-delay="50">
					<img src="/assets/img/movie/thumb.jpg"
						style="width: 600px; height: 400px;" class="img-fluid" alt="">
				</div>
			</header>
		</div>
	</section>

	<!--  ============= 추천 게시판 글 목록 =========== -->
	<div class="container" data-aos="fade-up">
		<section class="inner-page blog">

			<!-- <div class="input-group"> -->
			<div style="float: right">
				<div class="row">
					<div class="col-auto">
						<form action="/movieRecommend/search" method="get">

							<div class="input-group">
								<select name="search-category" class="form-select">
									<option value="NICK">작성자</option>
									<option value="TITLE">제목</option>
									<option value="CONTENTS">내용</option>
								</select>
								<!-- aria-label="Search" -->
								<div class="col-auto">
									<input type="text" name="search-keyword"
										class="form-control rounded" placeholder="Search"
										aria-describedby="search-addon" />
								</div>
								<input type="submit" class="btn btn-primary" value="검색">
							</div>
						</form>
					</div>
				</div>
			</div>


			<!-- 
			<div style="float : right">
			<div class="row-g-3">
			<div class="col-auto">
				<form action="" method="get">
					<select name="search" id="" class="form-select">
						<option value="writer">작성자</option>
						<option value="title">제목</option>
						<option value="content">내용</option>
					</select> 
				</div>
				<div>
					<label class="visually-hidden"></label>
					<input type="text" name="searchkeyword" id="search"> 
					<input class="btn btn-primary" type="submit" value="검색">
				</div>
				</form>
			</div>
		</div> -->

			<!-- 검색창 끝 -->



			<!-- 글 목록 시작 -->

			<div class="contaioner">
				<table class="table table-hover table-borderless"
					style="text-align: center;">
					<thead>
						<tr class="table-light">
							<th scope="col">글번호</th>
							<th scope="col">장르</th>
							<th scope="col">제목</th>
							<th scope="col">작성자</th>
							<th scope="col">작성일</th>
							<th scope="col">조회수</th>
							<th scope="col">좋아요</th>
						</tr>
					</thead>
					<tbody>
						<% for(MovieRecommend mRecommend : recommend) {%>
						<tr>
							<th style="vertical-align:center;"><p class="text-center"><%=mRecommend.getRowNo() %></p></th>
							<td valign="middle"><%= mRecommend.getGenre()%></td>
							<td><a
								href="/movieRecommend/detail?recommendNo=<%=mRecommend.getRowNo()%>"><%= mRecommend.getTitle()%></a></td>
							<td><%= mRecommend.getNick() %></td>
							<td><%= mRecommend.getEnrollDate() %></td>
							<td><%= mRecommend.getHits() %></td>
							
							 <td><i class="bi bi-hand-thumbs-up" style="color:navy;"> <%= mRecommend.getLikes() %></i></td>
							
							
							<%--  <%for (MovieData likes : likesCount) { %>
							<% if(mRecommend.getRowNo() == likes.getRecommendNo() && likes.getLikesCount() > 0) { %>  
							<td><i class="bi bi-hand-thumbs-up" style="color:navy;"> <%= likes.getLikesCount()%></i></td>
							<%}else if(mRecommend.getRowNo() == likes.getRecommendNo() && likes.getLikesCount() < 0){ %>
							<td><i class="bi bi-hand-thumbs-up" style="color:navy;">0</i></td>
							
							 <% } } %>    --%>
							
						</tr>
						<% } %>

					</tbody>

				</table>

			</div>



			<div class="contaioner">

				<div style="float: right">
					<a href="/movieRecommend/write"><button
							class="btn btn-primary btn-write">글쓰기</button></a>
				</div>
			</div>
			<br><br><br>
			<!-- 페이징 처리 할 곳 !! -->
			<div class="blog-pagination">
				<ul class="justify-content-center">
					<%= pageNavi%>
				</ul>
			</div>
		</section>
	</div>

</main>
<!-- End #main -->




<%@include file="/footer.jsp"%>