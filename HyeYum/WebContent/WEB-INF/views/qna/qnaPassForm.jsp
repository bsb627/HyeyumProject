<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<%

int qnaNo = (int)request.getAttribute("qnaNo");

%>
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
<!--       	<div align = "center" class="hero-img" data-aos="zoom-out" data-aos-delay="200">
			<img src="/assets/img/qna/qna.jpg" class="img-fluid" alt="">
		</div> -->
		
		<div align = "center">
		<img src = "/assets/img/qna/pwd.png">
		<form action = "/qna/detail" method = "post">
		비밀번호를 입력하세요. <br><br>
		<input type = "hidden" name = "qna-no" value ="<%= qnaNo %>"> <!--!!!!!!!!!!1 여기여기여기여기 !!!!!!!!!!!!-->
		<input type = "password" class="form-control" style = "width : 30%" name ="qna-pass">
		<br>
		<a href = "/qna/list"><input type = "button" class ="btn btn-outline-dark" value = "취소"></a>
		<input type = "submit" class = "btn btn-dark "value = "확인">
		</form>
		</div>
      </div>
    </section>

  </main><!-- End #main -->

<%@include file="/footer.jsp"%>