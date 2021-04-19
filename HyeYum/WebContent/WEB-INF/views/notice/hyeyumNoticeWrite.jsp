<%@page import="java.util.ArrayList"%>
<%@page import="notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Notice> nList = (ArrayList<Notice>) request.getAttribute("nList");

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
				<li>소개</li>
			</ol>
			<h2>혜윰소식</h2>

		</div>
	</section>
	<!-- End Breadcrumbs -->


	<section class="inner-page">
		<div class="container">
			<header class="section-header" style="margin-bottom: 20px;">
				<h2>공지사항</h2>
				<p>글쓰기</p>
			</header>
			
	<div class="d-flex justify-content-center">
	
			<form action="/showReview/write" method="post" enctype="multipart/form-data">

				

					<div class="form-margin">
						<div class="form-outline show-form">
							<input type="text" id="notice-title" class="form-control"
								name="notice-title" autocomplete="off" required maxlength="50" />
							<label class="form-label" for="notice-title">제목</label>
						</div>
					</div>
				
					<div class="form-outline notice-form">
					 <textarea id="summernote" name="notice-content"></textarea>
					</div>
					
					 <label class="form-label notice-form" for="noticecustomFile"></label> <input
						type="file" class="form-control" id="noticecustomFile" name="up-file" required/>
					
					<!-- Submit button(관리자에서만) -->
					<div class="btn-set">
					<a href="/notice/list"><button type="button" class="btn btn-warning" data-mdb-ripple-color="dark">
					  취소
					</button>
					</a>
					<button type="submit" class="btn btn-primary " data-mdb-ripple-color="dark">
					  등록
					</button>
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
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.3.0/mdb.min.js"></script>
<script type="text/javascript"	src="/assets/js/note-ready.js"></script>