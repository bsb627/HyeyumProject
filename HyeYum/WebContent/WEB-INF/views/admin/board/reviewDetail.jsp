<%@page import="movie.model.vo.MovieReview"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MovieReview review = (MovieReview)request.getAttribute("review");
%>
<%@include file="/admin/header.jsp"%>
<!-- Begin Page Content -->
<head>
<link href="/assets/admin/css/admin-movie.css" rel="stylesheet">
</head>

<!--    Page Heading -->
<div class="container-fluid">
<h1 class="h3 mb-4 text-gray-800 text-center">상세보기</h1>

<form action="/admin/movie/delete" method="get">
	<div class="container">

		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-3"></div>

				<div class="col-lg-6">

					<div class="row">

						<div class="col-lg-4">
							<div class="form-group">
								<label for="recipient-name" class="col-form-label">티켓일련번호:</label> <input
									type="text" class="form-control" id="recipient-name"
									name="ticket-number" value="<%=review.getTicketNumber() %>" readonly>
							</div>
						</div>

						<div class="col-lg-4">
							<div class="form-group">
								<label for="recipient-name" class="col-form-label">아이디:</label>
								<input type="text" class="form-control" id="recipient-name"
									name="userId" value="<%=review.getUserId()%>"
									readonly>
							</div>
						</div>

						<div class="col-lg-4">
							<div class="form-group">
								<label for="recipient-name" class="col-form-label">작성자:</label>
								<input type="text" class="form-control" id="recipient-name"
									name="nick" value="<%=review.getNick()%>" readonly>
							</div>
						</div>

					</div>


				</div>


			</div>
			<div class="col-lg-3"></div>
		</div>


		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-3"></div>
				<div class="col-lg-3">
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">영화명:</label> <input
							type="text" class="form-control" id="recipient-name"
							name="movieName" value="<%=review.getMovieName()%>" readonly>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">작성일:</label> <input
							type="text" class="form-control" id="recipient-name" name="enrollDate"
							value="<%=review.getEnrollDate()%>" readonly>
					</div>
				</div>
				<div class="col-lg-3"></div>
			</div>
		</div>
<%-- 
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-3"></div>
				<div class="col-lg-6">
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">제목:</label> <input
							type="text" class="form-control" id="recipient-name" name="title"
							value="<%=review.getTitle()%>" readonly>
					</div>
				</div>
				<div class="col-lg-3"></div>
			</div>
		</div>

 --%>

		<div class="col-lg-12">

			<div class="row">

				<div class="col-lg-3"></div>

				<div class="col-lg-6" style="margin: auto;">
					<div class="form-group">
						<div class="container">
							<div class="form-group">
								<label for="message-text" class="col-form-label">내용:</label>
								<textarea class="form-control sys" id="message-text"
									name="contents" readonly><%=review.getContents()%></textarea>
							</div>
						</div>
					</div>
					<br>
					<div class="form-group">
						<input type="hidden" name="reNo" value="<%=review.getReNo()%>">
						<div class="btn-set" align="center">
							<a href="/admin/recommend/list"><button type="button"
									class="btn btn-secondary">목록으로</button></a>
							<!-- <button type="submit" class="btn btn-primary">삭제하기</button> -->
						</div>
					</div>

				</div>

				<div class="col-lg-3"></div>

			</div>

		</div>
	</div>
</form>
</div>
<%@include file="/admin/footer.jsp"%>