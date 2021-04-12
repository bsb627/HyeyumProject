<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<head>
<title>문화나눔, 혜윰 - 추천혜윰</title>
<!-- <link href="/assets/css/movie/movieRecommendList.css" rel="stylesheet">  -->
</head>
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
				<p class="pcomment">이 영화를 추천합니다!</p>
			</header>
		</div>
	</section>
	
	<!--  ============= 추천 게시판 글 목록 =========== -->
	<div class="container">
	<section class="inner-page">

			<!-- <div class="input-group"> -->
			<div style="float: right">
				<div class="row">
					<div class="col-auto">
						<form action="" method="get">
							
							<div class="input-group">
							<select name="search" id="" class="form-select">
								<option value="user-nick">작성자</option>
								<option value="title">제목</option>
								<option value="content">내용</option>
							</select>
								<!-- aria-label="Search" -->
								<div class="col-auto">
								<input type="search" class="form-control rounded"
									placeholder="Search" aria-describedby="search-addon" />
									</div>
								<button type="button" class="btn btn-primary">search</button>
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
					<table class="table table-hover" style="text-align: center">
						<thead>
							<tr>
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
							<tr class="table-light">
								<th>1</th>
								<td>판타지/SF</td>
								<td>어벤져스 진짜 대박 강추해요 아이언맨 찌통의 대명사</td>
								<td>우헤헤</td>
								<td>21/04/11</td>
								<td>22</td>
								<td>07</td>
							</tr>
							<tr>
								<th scope="row">Default</th>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
							</tr>
							<tr class="table-light">
								<th scope="row">Light</th>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
							</tr>
							<tr>
								<th scope="row">Default</th>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
							</tr>
							<tr class="table-light">
								<th scope="row">Light</th>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
							</tr>
							<tr>
								<th scope="row">Default</th>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
							</tr>
							<tr class="table-light">
								<th scope="row">Light</th>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
							</tr>

						</tbody>
					</table>
				</div>
				<form action="/movieRecommend/write" method="get">
				<div style="float: right">
					<input type="submit" class="btn btn-primary" value="글쓰기">
					</div>
				</form>
		</section>
		</div>
	
</main>
<!-- End #main -->




<%@include file="/footer.jsp"%>