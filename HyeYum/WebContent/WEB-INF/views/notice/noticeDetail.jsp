<%@page import="notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Notice notice = (Notice)request.getAttribute("notice");
%>
<html lang="ko">

<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<head>
<title>문화나눔,혜윰 - 소개</title>
<link href='//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css'
	rel='stylesheet' type='text/css'>
	<style>
main * {
	font-family: 'Spoqa Han Sans Neo', 'sans-serif';
}
</style>
<link rel="stylesheet" href="/assets/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<main id="main">

	<!-- ======= Breadcrumbs ======= -->
	<section class="breadcrumbs">
		<div class="container">

			<ol>
				<li><a href="/index.jsp">Home</a></li>
				<li>소개</li>
			</ol>
			<h2>혜윰 소식</h2>

		</div>
	</section>
	<!-- End Breadcrumbs -->

	<section class="inner-page">
		<div class="container">
			<!--  ========== 게시판 팝업 ============= -->
			<section id="testimonials" class="testimonials portfolio">
				<div class="container" data-aos="fade-up">
					<header class="section-header">
						<h1>Notice</h1>
						<p class="pcomment">공지사항</p>
					</header>
				</div>
			</section>
         
         <section id="blog" class="blog">
     		 <div class="container" data-aos="fade-up" style ="width : 80%">
          <div class="col-lg-12 entries">
            <article class="entry entry-single">
                <h2 class="entry-title">
                <a href="#"><%= notice.getTitle() %></a>
              </h2>
              <div class="entry-meta">
                <ul>
                <li class="d-flex align-items-center"><i class="bi bi-person"></i>[작성자]  <%= notice.getUserId() %></li>
                <li class="d-flex align-items-center"><i class="bi bi-clock"></i>[작성일]  <%= notice.getEnrollDate() %></li>
                <li class="d-flex align-items-center"><i class="bi bi-chat-dots"></i> [조회수]  <%= notice.getHits() %></li>
                </ul>
                
                <hr>
                </div>
                 <div class="blank-content">
                <%= notice.getContents() %> 
            <%--    <div class="blank-content">
                <%= notice.getContents() %>
                --%>
              </div>
              </div>

             
              <div class="entry-footer">
                <i class="bi bi-folder"></i>
              
              </div>
              </article>
            </div>
      	</div>
    </section>
    </div>
    </section>
     
</main><!-- End #main -->
		<div align = "center">
		<form action="/notice/list" >
			<input type = "submit"  value = "목록" class = "btn btn-primary">
		</form>
		</div>
<%@include file="/footer.jsp"%>


