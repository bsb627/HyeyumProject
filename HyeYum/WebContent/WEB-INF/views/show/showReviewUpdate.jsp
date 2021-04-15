<%@page import="show.model.vo.ShowInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="show.model.vo.ShowReview"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ShowReview review = (ShowReview) request.getAttribute("review");
ArrayList<ShowInfo> iList = (ArrayList<ShowInfo>) request.getAttribute("iList");
%>
<head>
<title>문화나눔, 혜윰 - 글쓰기</title>
<%@include file="/header.jsp"%>
<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.3.0/mdb.min.css"
	rel="stylesheet" />
<!-- MDB -->
<link href="/assets/css/show-custom.css" rel="stylesheet">

<link rel="stylesheet" href="/assets/note/summernote-lite.css">

</head>
<main id="main">

	<!-- ======= Breadcrumbs ======= -->
	<section class="breadcrumbs">
		<div class="container">

			<ol>
				<li><a href="/index.jsp">Home</a></li>
				<li>공연</li>
			</ol>
			<h2>관람혜윰</h2>

		</div>
	</section>
	<!-- End Breadcrumbs -->


	<section class="inner-page">
		<div class="container">
			<header class="section-header">
				<h2>Photo Review</h2>
				<p>글쓰기</p>
			</header>

			<div class="d-flex justify-content-center">

				<form action="/showReview/update" method="post"
					enctype="multipart/form-data">

					<div class="form-margin">
						<select class="form-select" name="info-no" required>
							<option value="" hidden="hidden">공연을 선택해주세요</option>
							<%
								for (ShowInfo info : iList) {
							%>
							<option value="<%=info.getInfoNo()%>"
								style="background-image:url(/upload/info/show/<%=info.getFileName()%>)"><%=info.getShowName()%></option>
							<%
								}
							%>
						</select>
					</div>


					<div class="row mb-4">
						<div class="col">
							<div class="form-outline">
								<input type="text" id="sns-link" class="form-control"
									name="sns-link" value="<%=review.getSnsLink()%>"
									autocomplete="off" required /> <label class="form-label"
									for="sns-link">SNS</label>
							</div>
						</div>

						<div class="col">
							<div class="form-outline">
								<input type="text" id="ticket-number" class="form-control"
									name="ticket-number" value="<%=review.getTicketNumber()%>"
									autocomplete="off" required /> <label class="form-label"
									for="ticket-number">예매 일련번호</label>
							</div>
						</div>
					</div>

					<div class="form-margin">
						<div class="form-outline">
							<input type="text" id="show-title" class="form-control"
								name="show-title" value="<%=review.getTitle()%>"
								autocomplete="off" required maxlength="50" /> <label
								class="form-label" for="show-title">제목</label>
						</div>
					</div>

					<div class="form-outline">
						<textarea id="summernote" name="show-content"><%=review.getContents()%></textarea>
					</div>

					<label class="form-label" for="customFile"></label> <input
						type="file" class="form-control" id="customFile" name="up-file" /> 
						<input type="hidden" name="no" value="<%=review.getNo()%>" />
					<!-- Submit button -->
					<div class="btn-set">
						<a href="/showReview/list"><button type="button"
								class="btn btn-warning" data-mdb-ripple-color="dark">
								취소</button> </a>
						<button type="submit" class="btn btn-primary "
							data-mdb-ripple-color="dark">등록</button>
					</div>

				</form>
			</div>


		</div>
	</section>

</main>
<!-- End #main -->

<%@include file="/footer.jsp"%>
<script src="/assets/note/summernote-lite.js"></script>
<script src="/assets/note//lang/summernote-ko-KR.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.3.0/mdb.min.js"></script>
<script type="text/javascript" src="/assets/js/note-ready.js"></script>