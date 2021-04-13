<%@page import="movie.model.vo.MovieRecommend"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MovieRecommend recommend = (MovieRecommend)request.getAttribute("recommend");
%>
<head>
<title>문화나눔, 혜윰 - 추천 글쓰기</title>

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
$(document).ready(function() {
	//여기 아래 부분
	$('#summernote').summernote({
		  height: 300,                 // 에디터 높이
		  minHeight: null,             // 최소 높이
		  maxHeight: null,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정		  
		  toolbar: [
		    // [groupName, [list of button]]
		    ['style', ['bold', 'italic', 'underline', 'clear']],
		    ['font', ['strikethrough', 'superscript', 'subscript']],
		    ['fontsize', ['fontsize']],
		    ['color', ['color']],
		    ['para', ['ul', 'ol', 'paragraph']],
		    ['height', ['height']]
		  ]
	});
			
});
</script>

<!-- 	<script th:inline="javascript">    
	var genre = [[${genre}]];
	
	if(genre == '#1') {
		$('#1').attr('selected','selected');
		} else if { $('#2').attr('selected','selected');
		} else if { $('#3').attr('selected','selected');
		} else if { $('#4').attr('selected','selected');
		} else if { $('#5').attr('selected','selected');
		} else if { $('#6').attr('selected','selected');
		}
	</script>  -->
<!-- 	
<script>
	$(document).ready(function () {
		  genre_val = $('select#genre').attr('data-type');
		  $('select.fruit option[value=' + fruit_val + ']').attr('selected', 'selected');
		});
</script> -->


	<!-- ======= Breadcrumbs ======= -->
	<section class="breadcrumbs">
		<div class="container">

			<ol>
				<li><a href="/index.jsp">Home</a></li>
				<li>영화</li>
			</ol>
			<h2>추천혜윰</h2>

		</div>
	</section>
	<!-- End Breadcrumbs -->

	<section class="inner-page">
		<div class="container">
			<header class="section-header">
				<h2>MOVIE RECOMMEND</h2>
				<p>글쓰기</p>
			</header>


			<!-- 파일 할 때 enctype="multipart/form-data" 작성 -->
			<form action="/movieRecommend/modify" method="post" >

	

				<div class="row border col-md-12">

					<div class="col-md-4">
						<label class="form-label" for="title">장르</label>
						
						<select class="form-select" id="genre" name="genre" required>
							<option value="" hidden="hidden">장르를 선택해주세요</option>
							
							<option id="1" value="드라마/로맨스">드라마/로맨스</option>
							<option id="2" value="판타지/SF">판타지/SF</option>
							<option id="3" value="스릴러">스릴러</option>
							<option id="4" value="코믹/액션">코믹/액션</option>
							<option id="5" value="애니메이션">애니메이션</option>
							<option id="6" value="기타">기타</option>
						</select>
						<hr>
					</div>

					<div class="form-outline col-md-12">
					<label class="form-label" for="movie-title">제목</label>
						<input type="text" id="movie-title" class="form-control"
							name="movie-title" value="<%= recommend.getTitle() %>" autocomplete="off" required maxlength="50" />
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
					<textarea id="summernote" name="content"><%= recommend.getContents() %></textarea>
					<br>
					<div>
						<label class="form-label" for="customFile"></label> <input
							type="file" class="form-control" id="customFile" />
					</div>

					<input type="hidden" name="no" value="<%=recommend.getNo()%>" />
					<!-- Submit button -->
					<div class="btn-set">
						<a href="/movieRecommend/list"><button type="button"
								class="btn btn-outline-warning" data-mdb-ripple-color="dark">
								취소</button> </a>
						<button type="submit" class="btn btn-outline-primary"
							data-mdb-ripple-color="dark">등록</button>
					</div>

				</div>
			</form>


		</div>
	</section>

</main>
<!-- End #main -->

<%@include file="/footer.jsp"%>