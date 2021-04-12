<%@page import="book.model.vo.BookReview"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<% 
	String pageNavi = (String)request.getAttribute("pageNavi");
	ArrayList<BookReview> bList = (ArrayList<BookReview>)request.getAttribute("bList");
%>
<head>
<title>문화나눔, 혜윰 - aboutUs</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet prefetch'	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>
<link rel='stylesheet prefetch'	href='https://s3-us-west-2.amazonaws.com/s.cdpn.io/123941/rwd.table.min.css'>
<link rel="stylesheet" href="/assets/css/book/bookTableStyle.css">
<!-- <link rel="stylesheet" href="/assets/css/book/swipterStyle.css"> -->

</head>
<main id="main">

	<!-- ======= Breadcrumbs ======= -->
	<section class="breadcrumbs">
			<ol>
				<li><a href="/index.jsp">Home</a></li>
				<li>도서</li>
				<li>독서혜윰</li>
			</ol>
			<!-- <h2>독서혜윰</h2> -->
	</section>
	<!-- End Breadcrumbs -->

	<section class="inner-page">
	<div class="container2">
		<%@include file="/WEB-INF/views/book/bookInfoList.jsp"%>
	</div>
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<div class="table-responsive" data-pattern="priority-columns">
						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>번호</th>
									<th data-priority="1">제목</th>
									<th data-priority="2">작성자</th>
									<th data-priority="3">작성일</th>
									<th data-priority="4">조회수</th>
									<th data-priority="5">좋아요</th>
								</tr>
							</thead>
							<tbody>
<%-- 								<tr>
									<td>Argentina</td>
									<td>Spanish (official), English, Italian, German, French</td>
									<td>41,803,125</td>
									<td>31.3</td>
									<td>2,780,387</td>
									<td>2,780,387</td>
								</tr>
								<tr>
									<td>Australia</td>
									<td>English 79%, native and other languages</td>
									<td>23,630,169</td>
									<td>37.3</td>
									<td>7,739,983</td>
									<td>7,739,983</td>
								</tr>
								<tr>
									<td>Greece</td>
									<td>Greek 99% (official), English, French</td>
									<td>11,128,404</td>
									<td>43.2</td>
									<td>131,956</td>
									<td>131,956</td>
								</tr>
								<tr>
									<td>Luxembourg</td>
									<td>Luxermbourgish (national) French, German (both
										administrative)</td>
									<td>536,761</td>
									<td>39.1</td>
									<td>2,586</td>
									<td>2,586</td>
								</tr>
								<tr>
									<td>Russia</td>
									<td>Russian, others</td>
									<td>142,467,651</td>
									<td>38.4</td>
									<td>17,076,310</td>
									<td>17,076,310</td>
								</tr>
								<tr>
									<td>Sweden</td>
									<td>Swedish, small Sami- and Finnish-speaking minorities</td>
									<td>9,631,261</td>
									<td>41.1</td>
									<td>449,954</td>
									<td>449,954</td>
									<%= bList %>
								</tr> --%>
								<% for(BookReview review : bList) { %>
								<tr>
									<td><%= review.getNo() %></td>
									<td><a href="/bookReview/detail?no==<%= review.getNo()%>">
										 [<%= review.getDivision() %>]
										<%= review.getTitle() %></a>
									</td>
									<td><%= review.getNick() %></td>
									<td><%= review.getEnrollDate() %></td>
									<td><%= review.getHits() %></td>
     								<td><%= review.getHits() %></td>
								</tr>
								<% } %>
							<div>
								<a href="/bookReview/enroll"><button	class="btn btn-primary btn-write">글쓰기</button></a>
							</div>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="6" class="text-center"><%=pageNavi%>
									</td>
								</tr>
							</tfoot>
						</table>
					</div>
					<!--end of .table-responsive-->
				</div>
			</div>
		</div>
		<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
		<script	src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.2/js/bootstrap.min.js'></script>
		<script	src='https://s3-us-west-2.amazonaws.com/s.cdpn.io/123941/rwd-table-patterns.js'></script>
	</section>

</main>
<!-- End #main -->

<%@include file="/footer.jsp"%>