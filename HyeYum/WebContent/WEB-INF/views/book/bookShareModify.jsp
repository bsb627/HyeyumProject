<%@page import="book.model.vo.BookShare"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="book.model.vo.BookShare"%>
<%
	BookShare share = (BookShare)request.getAttribute("share");
%>
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
<link rel="stylesheet" href="/assets/note/summernote-lite.css">
</head>
<main id="main">
	<section class="breadcrumbs">
		<div class="container">

			<ol>
				<li><a href="/index.jsp">Home</a></li>
				<li>도서</li>
			</ol>
			<h2>나눔혜윰</h2>

		</div>
	</section>
	<!-- End Breadcrumbs -->


	<section class="inner-page">
		<div class="container">
			<header class="section-header">
				<h2>Photo Review</h2>
				<p>수정하기</p>
			</header>

			<form action="/bookShare/modify" method="post" enctype="multipart/form-data">

				<div class="row border col-md-12">

					<div class="form-outline col-md-12">
						<label class="form-label" for="show-title">
						<input type="text" id="share-title" class="form-control" name="share-title" autocomplete="off" value="<%=share.getTitle()%>" required/>
						</label> 
					<hr>
					</div>
					<input type="hidden" name="share-no" value="<%=share.getNo()%>"/>
					<div class="col-md-8">
	                   <select name="region" id="region">
	                       <option hidden="hidden">-- 판매지역 선택 --</option><%=share.getRegion()%>
	                       <option value="서울/경기">서울/경기</option>
	                       <option value="인천">인천</option>
	                       <option value="강원">강원</option>
	                       <option value="충북">충북</option>
	                       <option value="충남">충남</option>
	                       <option value="경북">경북</option>
	                       <option value="경남">경남</option>
	                       <option value="전북">전북</option>
	                       <option value="전남">전남</option>
	                       <option value="제주">제주</option>
	                   </select>
					</div>
					<!-- 파일첨부 -->
					<!-- <div>
					 <label class="form-label" for="customFile"></label> 
					 	<input type="file" class="form-control" id="customFile" />
					 	<input type="submit" class="form-control" value="업로드" onclick="javascript: form.action='/file/upload'"><br>
						<input type="reset" class="form-control" value="취소">
					</div> -->
						<div class="col-md-4">
						<label for="InputSubject1">파일첨부</label>
							
							<input type="text" id="userfile" name="userfile" disabled="">
							<span class="group-span-filestyle input-group-btn" tabindex="0">
								<a href="/file/upload"><span class="glyphicon fa fa-upload"></span></a>
									
								
							</span>
						</div>

					 <textarea id="summernote" name="share-content"><%=share.getContents()%></textarea>
					<br>
				

					<!-- Submit button -->
					<div class="btn-set">
					<a href="/bookShare/list"><button type="button" class="btn btn-outline-warning" data-mdb-ripple-color="dark">
					  취소
					</button>
					</a>
					<button type="submit" class="btn btn-outline-primary " data-mdb-ripple-color="dark">
					  수정완료
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