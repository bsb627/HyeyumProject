<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<link href="/assets/css/show-custom.css" rel="stylesheet">

<link rel="stylesheet" href="/assets/note/summernote-lite.css">

</head>
<main id="main">
	<section class="breadcrumbs">
		<div class="container">

			<ol>
				<li><a href="/index.jsp">Home</a></li>
				<li>도서</li>
			</ol>
			<h2>도서혜윰</h2>

		</div>
	</section>
	<!-- End Breadcrumbs -->


	<section class="inner-page">
		<div class="container">
			<header class="section-header">
				<h2>Photo Review</h2>
				<p>글쓰기</p>
			</header>

			<form action="/bookReview/enroll" method="post" enctype="multipart/form-data">
				<div class="row border col-md-12">
					
					<div class="col-md-8">
	                   <select name="info-type" id="info-type" onchange="chnQnaType(this.value)"required>
	                       <option hidden="hidden">-- 메뉴 선택 --</option>
	                       <option value="info">이달의 도서</option>
	                       <option value="genre">장르</option>
	                   </select>
	                   <select name="info-no" id="info-no" >
	                   </select>
					</div>
	
<!-- 					<div class="col-md-4">
					<label for="InputSubject1">파일첨부</label>
						<input type="text" id="userfile" name="userfile" disabled="">
						<span class="group-span-filestyle input-group-btn" tabindex="0">
							<a href="/file/upload"><span class="glyphicon fa fa-upload"></span></a>
						</span>
					</div>
 -->

					<div class="form-outline col-md-12">
						<input type="text" id="review-title" class="form-control" name="review-title" autocomplete="off" required/> <label
							class="form-label" for="show-title">제목</label>
					<hr>
					</div>
				

					 <textarea id="summernote" name="review-content"></textarea>
					<br>
				

					<!-- Submit button -->
					<div class="btn-set">
					<a href="/bookReview/list"><button type="button" class="btn btn-outline-warning" data-mdb-ripple-color="dark">
					  취소
					</button>
					</a>
					<button type="submit" class="btn btn-outline-primary " data-mdb-ripple-color="dark">
					  등록
					</button>
					</div>
					
				</div>
			</form>


		</div>
	</section>

</main>
<!-- End #main -->

<%@include file="/footer.jsp"%>
<script src="/assets/js/book/book-write.js"></script>
<script type="text/javascript"	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.3.0/mdb.min.js"></script>
<script src="/assets/note/summernote-lite.js"></script>
<script src="/assets/note//lang/summernote-ko-KR.js"></script>