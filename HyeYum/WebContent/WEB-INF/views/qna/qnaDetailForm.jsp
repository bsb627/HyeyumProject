<%@page import="qna.model.vo.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<%
	Qna qna = (Qna)request.getAttribute("qna"); // detail서블랫애서 샛 해줫음
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
      	<div align = "center" class="hero-img" data-aos="zoom-out" data-aos-delay="200">
			<img src="/assets/img/qna/qna.jpg" class="img-fluid" alt="">
		</div>
		글번호 :
      	<%= qna.getQnaNo() %> <br>
      	문의 분류 :
      	<%= qna.getCategory() %> <br>
      	제목 : 
      	<div class ="form-control" ><%= qna.getTitle() %> </div>
      	내용:
		<div class ="form-control">
		<%= qna.getContents() %>
		</div>

      </div>
    </section>

  </main><!-- End #main -->

<%@include file="/footer.jsp"%>