<%@page import="qna.model.vo.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<%
	Qna qna = (Qna)request.getAttribute("qna"); // detail서블랫애서 샛 해줫음
%>
<head>

	<script>
	 $(document).ready(function() {
		$("#delete-form").submit(function() {
			alert("삭제 하시겠습니까? ");
			return true;
		});
		
		$("#modify-form").submit(function() {
			alert("수정 하시겠습니까? ");
			return true;
		});

	 });
		
	</script>
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
		
		
		<table class = "table">
			<tr>
				<td>글 번호  :</td>
				<td><%= qna.getQnaNo() %></td>
				<td>문의 분류 :</td>
				<td><%= qna.getCategory() %></td>
			</tr>
			<tr>
				<td>제목 : </td>
			</tr>
			<tr>
				<td><%= qna.getTitle() %></td>
			</tr>
			<tr>
				<td>내용 : </td>
			</tr>
			<tr>
				<td><%= qna.getContents() %></td>
			</tr>
		</table>
		
		<div align = "right">
		<form action="/qna/modify" method = "get" id = "modify-form">
			<input type = "hidden" name = "qna-no" value = "<%= qna.getQnaNo() %>">
			<input type = "hidden" name = "qna-pwd" value ="<%= qna.getQuestionPwd() %>" >
			<input type = "submit" value = "수정" class= "btn btn-primary" id = "modify">
		</form>     
		<form action = "/qna/delete" method = "post" id = "delete-form" >
			<input type = "hidden" name = "qna-no" value = "<%= qna.getQnaNo() %>">
			<input type = "submit" value = "삭제" class = "btn btn-outline-primary" id="delete">
		</form>
		</div>
		<br>
		<div align = "center">
		<form action="/qna/list" >
			<input type = "submit"  value = "목록" class = "btn btn-primary">
		</form>
		</div>

      </div>
    </section>

  </main><!-- End #main -->

<%@include file="/footer.jsp"%>