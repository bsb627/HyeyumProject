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
        
     
<div class="card border-light " >
  <div class="card-header">제목 : <%=notice.getTitle() %>
  글쓴이 : <%= notice.getUserId() %> <%= notice.getEnrollDate() %></div>
  <div class="card-body" style= "line-height:50px;" >
    
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
</div>
  </div>

<div class="jumbotron-default" >
  <h2 class="display-3" style="line-height:50%;"> Hello, world!</h2>
  <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
  <hr class="my-4">
  <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
  <p class="lead">
    <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
  </p>
</div>
  
  <table class="table" style="line-height:100px;">
 

    
      <td colspan="1"=>Default</td>
      <td>Column content</td>
      <td>Column content</td>
      <td>Column content</td>
    </tr>
    <tr style="line-height:300px;">
 		<th scope="row">Default</th>
      <td>Column content</td>
      <td>Column content</td>
      <td>Column content</td>
    </tr>
     </tr>
 
</table>
    
	<a href="/notice/list?noticeNo=<%= notice.getNoticeNo()%>">목록</a>


<%@include file="/footer.jsp"%>  
</section>