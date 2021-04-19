<%@page import="java.util.ArrayList"%>
<%@page import="notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Notice> nList = (ArrayList<Notice>) request.getAttribute("nList");
String pageNavi = (String) request.getAttribute("pageNavi");
%>

<%@include file="/header.jsp"%>
<head>
<title>문화나눔, 혜윰 - aboutUs</title>
<link href='//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css'
	rel='stylesheet' type='text/css'>
<style>
main * {
	font-family: 'Spoqa Han Sans Neo', 'sans-serif';
}
</style>
<link rel="stylesheet" href="/assets/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<main id="main">

	<!-- ======= Breadcrumbs ======= -->
	<section class="breadcrumbs">
		<div class="container">

			<ol>
				<li><a href="/index.jsp">Home</a></li>
				<li>소개</li>
			</ol>
			<h2>혜윰 소식</h2>

		</div>
	</section>
	<!-- End Breadcrumbs -->

	<section class="inner-page">
		<div class="container">
			<!--  ========== 게시판 팝업 ============= -->
			<section id="testimonials" class="testimonials portfolio">
				<div class="container" data-aos="fade-up">
					<header class="section-header">
						<h1>Notice</h1>
						<p class="pcomment">공지사항</p>
					</header>
				</div>
			</section>

			<!-- 검색 : 제목/작성자/내용  -->
			<!-- <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="#"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  
<div class="collapse navbar-collapse" id="navbarColor01">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">
          <span class="sr-only">(current)</span>
        </a>
         </li>
          <li class="nav-item">
        <a class="nav-link" href="#"></a>
      </li>
       -->

			<!-- 검색창 -->
			<div class="col-7" style="float: left">
				<form action="/notice/write" method="get" class="form-inline">

				</form>
			</div>
			<div style="float: left" class="col-auto" align="right">
				<form class="row g-3" class="form-inline"  action="/notice/search"
					method="get">
					
					<div class="col-auto">
						<select name="search-category" class="form-select">
							<option value="TITLE">제목</option>
							<option value="USER_ID">작성자</option>
							<option value="CONTENTS">내용</option>
						</select>
						
					</div>
					<div class="col-auto">
						<label class="visually-hidden"></label> 
						<input type="text" class="form-control" name="search-keyword" type="text"
							placeholder="제목/작성자/내용">
					</div>
					
					<div class="col-auto">
						<input type="submit" class="btn btn-primary mb-3" value="검색">
					</div>
				</form>
			</div>


			<!--  공지사항 글 목록 -->

			<table class="table table-hover" style="text-align: center">
				<thead>
					<tr class="table-primary">
						<th scope="col">글번호</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">작성일</th>
						<th scope="col">조회수</th>
					</tr>
				</thead>
				<tbody>


					<%
						for (Notice notice : nList) {
					%>
					<tr>

						<td><%=notice.getNoticeNo()%></td>
						<td><a
							href="/notice/detail?noticeNo=<%=notice.getNoticeNo()%>"> <%=notice.getTitle()%></a></td>
						<td><%=notice.getUserId()%></td>
						<td><%=notice.getEnrollDate()%></td>
						<td><%=notice.getHits()%></td>
					</tr>
					<%
						}
					%>

				</tbody>
			</table>
		</div>



		<!--페이징  -->

		<div class="container">

			
	<div style="float: right">
				<a href="/hyeyumNotice/write"><button
						class="btn btn-primary btn-right">글쓰기</button></a>
			</div>
			<ul class="pagination  justify-content-center">
				<!-- <li class="page-item disabled"><a class="page-link" href="#">&laquo;</a>
					</li>
					<li class="page-item active"><a class="page-link" href="#">1</a>
					</li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">4</a></li>
					<li class="page-item"><a class="page-link" href="#">5</a></li>


					<li class="page-item"><a class="page-link" href="#">&raquo;</a>
					</li> -->
				<%=pageNavi%>



			</ul>
		</div>
	</section>

</main>
<!-- End #main -->

<%@include file="/footer.jsp"%>