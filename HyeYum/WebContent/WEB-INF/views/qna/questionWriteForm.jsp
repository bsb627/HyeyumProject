<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<head>
<head>
  <title>문화나눔, 혜윰 - QnA</title>

</head>
</head>
 <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <ol>
          <li><a href="/index.jsp">Home</a></li>
          <li>마당</li>
        </ol>
        <h2>문의혜윰</h2>

      </div>
    </section><!-- End Breadcrumbs -->

<!-- ----------------------------시작 --------------------------- -->
    <section class="inner-page">
    			
      <div class="container">
      	<div align = "center" class="hero-img" data-aos="zoom-out" data-aos-delay="200">
			<img src="/assets/img/qna/qna.jpg" class="img-fluid" alt="">
		</div>
      	
	
	
		<form action = "/question/write" method = "post">
		  <div class="col-12">
		    <label for="title" class="form-label">제목</label>
		    <input type="text" class="form-control" id="title" name = "title">
		  </div>
		  <div class="col-12">
		    <label for="password" class="form-label">비밀번호</label>
		    <input type="password" class="form-control" id="password" name = "password">
		  </div>
		  <div class="col-12">
		    <label for="category" class="form-label">문의 분류</label>
		    <select id="category" class="form-select" name = "category">
		      <option selected>도서</option>
		      <option>영화</option>
		      <option>공연</option>
		      <option>기타</option>
		    </select>
		  </div>
		  <div class="col-12">
		    <label for="contents" class="form-label">내용</label>
		    <textarea rows = "10" class="form-control" id="contents" name = "contents"></textarea>
		  </div>
		  <div class="col-12">
		    <label for="file" class="form-label">첨부파일</label>
		    <input type="file" class="form-control" id="file" name = "file">
		  </div>
		 
		
		  <div class="col-12" > <br>
		    <input type="submit" style = "float : right" class="btn btn-primary" value = "등록">
		  </div>
		</form>
		       
       
       
      </div>
    </section>

  </main><!-- End #main -->

<%@include file="/footer.jsp"%>