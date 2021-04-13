<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    Member member = (Member)request.getAttribute("member");
    %>

<title><%= member.getUserName()%> 님 상세 정보</title>
	<%@include file="/header.jsp"%>
	<!-- ======= Breadcrumbs ======= -->
	<section class="breadcrumbs">
		<div class="container">

			<ol>
				<li><a href="/index.jsp">Home</a></li>
				<li>영화</li>
			</ol>
			<h2>감상혜윰</h2>

		</div>
	</section>
	<!-- End Breadcrumbs -->
	
	<section class="inner-page">
		<div class="container">
			<header class="section-header">
				<h2>MOVIE RECOMMEND</h2>
				<p>글쓰기</p>
			</header>
			<form action="/member/modify" method="post">
			<p name="userId"> 아이디 : <%= member.getUserId() %>
			</form>
			</div>
			</section>
			









<%@include file="/footer.jsp"%>