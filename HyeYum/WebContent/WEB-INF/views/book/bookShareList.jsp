<%@page import="book.model.vo.BookShare"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<% 
	String pageNavi = (String)request.getAttribute("pageNavi");
	ArrayList<BookShare> sList = (ArrayList<BookShare>)request.getAttribute("sList");
%>
<head>
  <title>문화나눔, 혜윰 - aboutUs</title>
      <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
</head>
 <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <ol>
          <li><a href="/index.jsp">Home</a></li>
          <li>도서</li>
        </ol>
        <h2>나눔혜윰</h2>

      </div>
    </section><!-- End Breadcrumbs -->

    <section class="inner-page">
      <div class="container">
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
	
								<% for(BookShare share : sList) { %>
								<tr>
									<td><%=share.getNo() %></td>
									<td><a href="/bookShare/addHits?share-no=<%=share.getNo()%>">
										 [<%=share.getRegion() %>]
										<%=share.getTitle()%></a>
									</td>
									<td><%=share.getNick() %></td>
									<td><%=share.getEnrollDate() %></td>
									<td><%=share.getHits() %></td>
									<td><%=share.getLikes() %></td>
								</tr>
								<% } %>
							<div>
								<a href="/bookShare/enroll?share-no"><button	class="btn btn-primary btn-write">글쓰기</button></a>
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
    </section>

  </main><!-- End #main -->

<%@include file="/footer.jsp"%>