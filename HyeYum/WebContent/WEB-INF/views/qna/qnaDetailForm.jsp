<%@page import="qna.model.vo.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<%
	Qna qna = (Qna)request.getAttribute("qna"); // detail서블랫애서 샛 해줫음
%>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

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
    	<div class="container" data-aos="fade-up">
			<header class="section-header">
				<h2>QnA</h2>
				<p class="pcomment">문의 게시판</p>
			</header>
			</div>
      	<div align = "center" class="hero-img" data-aos="zoom-out" data-aos-delay="200">
			<img src="/assets/img/qna/qna.jpg" class="img-fluid" alt="">
		</div>
		
		
		 <section id="blog" class="blog">
     		 <div class="container" data-aos="fade-up" style ="width : 80%">
          <div class="col-lg-12 entries">
            <article class="entry entry-single">
                <h2 class="entry-title">
                <a href="#"><%= qna.getTitle() %></a>
              </h2>
              <div class="entry-meta">
                <ul>
                <li class="d-flex align-items-center"><i class="bi bi-person"></i>[작성자]  <%= qna.getUserId() %></li>
                <li class="d-flex align-items-center"><i class="bi bi-tag"></i> [문의분류]  <%= qna.getCategory() %></li>
                <li class="d-flex align-items-center"><i class="bi bi-clock"></i>[등록일]  <%= qna.getEnrollDate() %></li>
                <li class="d-flex align-items-center"><i class="bi bi-chat-dots"></i> [조회수]  <%= qna.getHits() %></li>
                </ul>
              </div>

              <div class="entry-content">
               <%= qna.getContents() %>
              </div>
              <div class="entry-footer">
                <i class="bi bi-folder"></i>
                <ul class="cats">
                  <li><a href="#">첨부파일</a></li>
                  </ul>
              </div>
              </article>
            </div>
      	</div>
    </section>
		

		
		<div align = "right" style = "width:90%">
		<% if(qna.getStep()==0) {%>
		<form action="/qna/modify" method = "get" id = "modify-form" style = "float:right">
			<input type = "hidden" name = "qna-no" value = "<%= qna.getQnaNo() %>">
			<input type = "hidden" name = "qna-pwd" value ="<%= qna.getQuestionPwd() %>" >
			<input type = "submit" value = "수정" class= "btn btn-primary" id = "modify">
		</form>
		
		

		<form action = "/qna/delete" method = "post" id = "delete-form" style ="float:right">
			<input type = "hidden" name = "family" value = "<%= qna.getFamily() %>">
			
			<input type = "submit" value = "삭제" class = "btn btn-outline-primary" id="delete">
		</form>
		<% } %>

		</div>
		<br>


      
    </section>

  </main><!-- End #main -->
		<div align = "center">
		<form action="/qna/list" >
			<input type = "submit"  value = "목록" class = "btn btn-primary">
		</form>
		</div>
<%@include file="/footer.jsp"%>