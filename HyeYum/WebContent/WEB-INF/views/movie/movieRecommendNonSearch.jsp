<%@page import="movie.model.vo.MovieRecommend"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<MovieRecommend> recommend = (ArrayList<MovieRecommend>) request.getAttribute("recommend");
	String pageNavi = (String) request.getAttribute("pageNavi");
%>


<title>문화나눔, 혜윰 - 추천혜윰</title>
<%@include file="/header.jsp"%>
<link href="/assets/css/style.css" rel="stylesheet">


<%
	if (userId == null) {
%>
<script type="text/javascript">
	if (confirm("로그인 후 이용가능합니다.")) {
		location.href = "/member/login";
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
				<h2>PLEASE SEARCH AGAIN</h2>
				<!-- 	<p class="pcomment">이 영화를 추천합니다!</p> -->

				<div class="hero-img" data-aos="zoom-out" data-aos-delay="100">
					<img src="/assets/img/movie/11000.jpg"
						style="width: 600px; height: 450px;" class="img-fluid" alt="">

				</div>
				<p>
					<i class="bi bi-emoji-dizzy"></i>&nbsp; 검색 결과를 찾을 수 없습니다.
				</p>
				<br>
				<div style="width: 35%; float:none; margin:0 auto">
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
				</div>

			</header>
			<section class="inner-page blog">

				<!-- <div class="input-group"> -->

				<div style="float: right">
					<a href="/movieRecommend/write"><button
							class="btn btn-primary btn-write">글쓰기</button></a>
				</div>

			</section>



		</div>
	</section>
		</main>




	<%@include file="/footer.jsp"%>