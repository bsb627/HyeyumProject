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
<link rel="stylesheet" href="/assets/css/book/bookTableStyle.css">
<!-- <link rel="stylesheet" href="/assets/css/book/swipterStyle.css"> -->

</head>
<main id="main">

	<!-- ======= Breadcrumbs ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <ol>
          <li><a href="/index.jsp">Home</a></li>
          <li>도서</li>
        </ol>
        <h2>독서혜윰</h2>

      </div>
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

								<% for(BookReview review : bList) { %>
								<tr>
									<td><%= review.getNo() %></td>
									<td><a href="/bookReview/detail?review-no=<%= review.getNo()%>">
										 [<%= review.getDivision() %>]
										<%= review.getTitle() %></a>
									</td>
									<td><%= review.getNick() %></td>
									<td><%= review.getEnrollDate() %></td>
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
	</section>

</main>
<!-- End #main -->

<%@include file="/footer.jsp"%>