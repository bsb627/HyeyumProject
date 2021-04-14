
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
<script src="/assets/note/summernote-lite.js"></script>
<script src="/assets/note//lang/summernote-ko-KR.js"></script>

<link rel="stylesheet" href="/assets/note/summernote-lite.css">
</head>
<main id="main">
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							//여기 아래 부분
							$('#summernote')
									.summernote(
											{
												height : 300, // 에디터 높이
												minHeight : null, // 최소 높이
												maxHeight : null, // 최대 높이
												focus : true, // 에디터 로딩후 포커스를 맞출지 여부
												lang : "ko-KR", // 한글 설정
												placeholder : '최대 3000자까지 쓸 수 있습니다', //placeholder 설정		  
												toolbar : [
														// [groupName, [list of button]]
														[
																'style',
																[
																		'bold',
																		'italic',
																		'underline',
																		'clear' ] ],
														[
																'font',
																[
																		'strikethrough',
																		'superscript',
																		'subscript' ] ],
														[ 'fontsize',
																[ 'fontsize' ] ],
														[ 'color', [ 'color' ] ],
														[
																'para',
																[ 'ul', 'ol',
																		'paragraph' ] ],
														[ 'height',
																[ 'height' ] ] ]
											});

						});
	</script>
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
			<header class="section-header">
				<h2>혜윰소식</h2>
				<p>글쓰기</p>
			</header>



			<!-- 파일 할 때 enctype="multipart/form-data" 작성 -->
			<form action="/hyeyumNotice/write" method="post">
				<!--  enctype="multipart/form-data">-->

				<div class="row border col-md-12">
					<div class="form-outline col-md-12">
						<input type="text" id="show-title" class="form-control"
							name="show-title" autocomplete="off" required maxlength="50" />
						<label class="form-label" for="show-title">제목</label>


						<hr>
					</div>

					<!-- SmartEditor2 -->
					<!-- 	<div class="jsx-2303464893 editor">
						<div class="fr-box fr-basic fr-top" role="application">
							<div class="fr-wrapper show-placeholder" dir="auto"
								style="overflow: hidden;">
								<textarea name="show-content" id="smartEditor"
									style="width: 100%; height: 412px;"></textarea>
							</div>
						</div>
					</div> -->
					<textarea id="summernote" name="show-content"></textarea>
					<br>

				<!-- 파일 -->
					<div>
						<label class="form-label" for="customFile"></label> <input
							type="file" class="form-control" id="customFile" name="up-file"
							required />
					</div>
					


					<!-- Submit button -->
					<div class="btn-set">
						<a href="/notice/list"><button type="button"
								class="btn btn-outline-warning" data-mdb-ripple-color="dark">
								취소</button> </a>
						<button type="submit" class="btn btn-outline-primary "
							data-mdb-ripple-color="dark">등록</button>
					</div>

				</div>
			</form>

		</div>
	</section>

</main>
<!-- End #main -->


<%@include file="/footer.jsp"%>