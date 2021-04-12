<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<head>
  <title>문화나눔, 혜윰 - QnA</title>

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

    <section class="inner-page">
    			
      <div class="container">
      	<div align = "center" class="hero-img" data-aos="zoom-out" data-aos-delay="200">
			<img src="/assets/img/qna/qna.jpg" class="img-fluid" alt="">
		</div>
		
		<form action = "qna/detail/qnaNum=" method = "post">
		비밀번호를 입력하세요.
		<input type = "password" name = "qna-passs">
		<input type = "submit" value = "확인">
		</form>
      	
      </div>
    </section>

  </main><!-- End #main -->

<%@include file="/footer.jsp"%>