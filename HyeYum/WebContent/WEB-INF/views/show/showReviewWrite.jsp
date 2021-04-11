<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<title>문화나눔, 혜윰 - 글쓰기</title>
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
<%@include file="/header.jsp"%>
<!-- MDB -->
<link href="/assets/css/show-custom.css" rel="stylesheet">
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.3.0/mdb.min.js"></script>
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



			<form>


				<div class="row border col-md-12">


					<div class="form-outline col-md-6">
						<input type="text" id="typeText" class="form-control" /> <label
							class="form-label" for="typeText">작성자</label>
						<hr>
					</div>


					<div class="form-outline col-md-6">
						<input type="text" id="typeText" class="form-control" /> <label
							class="form-label" for="typeText">SNS</label>
						<hr>
					</div>

					<div class="form-outline">
						<input type="text" id="typeText" class="form-control" /> <label
							class="form-label" for="typeText">예매 일련번호</label>
					</div>
					<hr>

					<div class="form-outline">
						<input type="text" id="typeText" class="form-control" /> <label
							class="form-label" for="typeText">제목</label>
					</div>
					<hr>

					<!-- SmartEditor2 -->
					<div class="jsx-2303464893 editor">
						<div class="fr-box fr-basic fr-top" role="application">
							<div class="fr-wrapper show-placeholder" dir="auto"
								style="overflow: hidden;">
								<textarea name="notice_content" id="smartEditor"
									style="width: 100%; height: 412px;"></textarea>
							</div>
						</div>
					</div>
					<br>
					<div>
					 <label class="form-label" for="customFile"></label> <input
						type="file" class="form-control" id="customFile" />
					</div>


					<!-- Submit button -->
					<div class="btn-set">
					<a href="/showReview/list"><button type="button" class="btn btn-outline-warning" data-mdb-ripple-color="dark">
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