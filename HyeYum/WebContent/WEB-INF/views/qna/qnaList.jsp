<%@page import="qna.model.vo.Qna"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Qna> qnaList = (ArrayList<Qna>)request.getAttribute("qnaList");
	String pageNavi = (String)request.getAttribute("pageNavi");
%>
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
		
		<!--  시작  -->
		
		<div>
		<form action = "/question/write" method = "get">
			<input type = "submit" value = "문의 등록" class ="btn btn-primary mb-3" >
		</form>
		</div>
		<div  style = "float : right">
			<form class="row g-3">
			  <div class="col-auto">
			    <select name = "qna-category" class="form-select">
			      	<option>작성자</option>
			      	<option>제목</option>
			    </select>
			  </div>
			  <div class="col-auto">
			    <label class="visually-hidden"></label>
			    <input type="text" class="form-control" name="search-keyword">
			  </div>
			  <div class="col-auto">
			    <input type="submit" class="btn btn-primary mb-3" value = "검색">
			  </div>
			</form>
      	</div>
      
      	
      	
      	
      		<table class ="table table-hover" style = "text-align : center">
      			<tr>
      				<th>글번호</th>
      				<th>문의분류</th>
      				<th>제목</th>
      				<th>작성자</th>
      				<th>작성일</th>
      				<th>조회수</th>
      			</tr>
      		<% for ( Qna qna : qnaList) { %>
      			<tr>
      				<td><%= qna.getQnaNo()%></td>
      				<td><%= qna.getCategory() %> </td>
      				<td><%= qna.getTitle()%></td>
      				<td><%= qna.getNick()%></td>
      				<td><%= qna.getEnrollDate()%></td>
      				<td><%= qna.getHits() %>5</td>
      			</tr>
      		<% } %>
      		</table>
      	</div>
      </div>
    </section>

  </main><!-- End #main -->

<%@include file="/footer.jsp"%>