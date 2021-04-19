<%@page import="show.model.vo.ShowReview"%>
<%@page import="movie.model.vo.MovieRecommend"%>
<%@page import="movie.model.vo.MovieReview"%>
<%@page import="book.model.vo.BookShare"%>
<%@page import="book.model.vo.BookReview"%>
<%@page import="member.model.vo.MyPost"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.awt.TrayIcon.MessageType"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<%
ArrayList<MyPost> pList = (ArrayList<MyPost>)request.getAttribute("pList");
String pPageNavi = (String)request.getAttribute("pPageNavi");
String brPageNavi = (String)request.getAttribute("brPageNavi");
String bsPageNavi = (String)request.getAttribute("bsPageNavi");
String mrvPageNavi = (String)request.getAttribute("mrvPageNavi");
String mrcPageNavi = (String)request.getAttribute("mrcPageNavi");
String sPageNavi = (String)request.getAttribute("sPageNavi");
//String pageNavi = (String)request.getAttribute("spageNavi");
SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
ArrayList<BookReview> brList = (ArrayList<BookReview>)request.getAttribute("brList");
ArrayList<BookShare> bsList = (ArrayList<BookShare>)request.getAttribute("bsList");
ArrayList<MovieReview> mrvList = (ArrayList<MovieReview>)request.getAttribute("mrvList");
ArrayList<MovieRecommend> mrcList = (ArrayList<MovieRecommend>)request.getAttribute("mrcList");
ArrayList<ShowReview> srList = (ArrayList<ShowReview>)request.getAttribute("srList");
%>

<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


<style>

a:link.contents {
	color : navy;
}
a:visited.contents {
	color : gray;
}
a:hover.contents {
	font-weight : bold;
}

</style>
	
  <title>문화나눔, 혜윰 </title>
</head>

 <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <ol>
          <li><a href="/index.jsp">Home</a></li>
          <li>마이페이지</li>
        </ol>
        <h2>내가 쓴 글</h2>
		
      </div>
    </section>
    
    <!-- End Breadcrumbs -->
    <!-- ======= Services Section ======= -->
			<section id="services" class="services">

				<div class="container" data-aos="fade-up">
					<div class="inner-page">
						<header class="section-header">
							<h2>MyInfo</h2>
							<p>내가 쓴 글</p>
						</header>
    <!-- ======= 사이드바 ======= -->
  <section id="blog" class="blog" >
							<div class="container" data-aos="fade-up">
								<div class="col-md-12">
									<div class="row">
										<div class="col-md-3">

											<div class="sidebar">


												<h3 class="sidebar-title">쪽지</h3>
												<div class="sidebar-item categories">
													<ul>
														<li><a href="/message/write/page">쪽지 쓰기</a></li>
														<li><a href="/message/receivedList">받은 쪽지함</a></li>
														<li><a href="/message/sentList">보낸 쪽지함</a></li>

													</ul>
													<hr>

													<h3 class="sidebar-title">주문</h3>
													<div class="sidebar-item categories">
														<ul>
															<li><a href="/message/sentList">주문내역</a></li>
														</ul>
														<hr>
													</div>
													<!-- End sidebar tags-->

													<h3 class="sidebar-title">주문</h3>
													<div class="sidebar-item categories">
														<ul>
															<li><a href="/message/sentList">주문내역</a></li>
														</ul>
														<hr>
													</div>
													<!-- End sidebar tags-->

													<h3 class="sidebar-title">주문</h3>
													<div class="sidebar-item categories">
														<ul>
															<li><a href="/message/sentList">주문내역</a></li>
														</ul>
														<hr>
													</div>
													<!-- End sidebar tags-->
													<h3 class="sidebar-title">주문</h3>
													<div class="sidebar-item categories">
														<ul>
															<li><a href="/message/sentList">주문내역</a></li>
															<li><a href="/message/sentList">주문내역</a></li>
														</ul>

													</div>
													<!-- End sidebar tags-->


												</div>
												<!-- End sidebar -->

											</div>
											<!-- End blog sidebar -->
										</div>
										
			<!--============== 여기에 작성하기================================ -->
<div class="col-md-9 info-card">

		<div style = "float : right">
			<form class="row g-3" action = "/message/search/received" method = "get">
			  <div class="col-auto">
			    <select name = "search-category" class="form-select">
			      	<option value = "SENDER" >아이디</option>
			      	<option value= "CONTENTS" >내용</option>
			    </select>
			  </div>
			  <div class="col-auto">
			    <label class="visually-hidden"></label>
			    <input type="text" class="form-control" name="search-keyword">
			  </div>
			  <div class="col-auto">
			    <input type="submit" class="btn btn-primary mb-3" value = "검색" >
			  </div>
			</form>
      	</div>
										
    <div class="container" align = "center">
    
    <form action = "/message/delete/received" method = "get" id = "delete">
    <table class = "table" style = "text-align:center">
    	<tr>
    		<th>제목</th>
    		<th>등록 날짜</th>
    		<th>조회수</th>
    		
    	</tr>
    	
    	<% for( MyPost post: pList) {%>
    		<tr>
    			<td><%= post.getTitle()%></td>
    			<td><%= post.getEnrollDate() %></td>
    			<td><%= post.getHits()%></td>
    			
    		</tr>
    	<% } %>
    
    </table>
<!--     	 <section id="portfolio" class="portfolio">

		<div class="container" data-aos="fade-up"> -->

			<header class="section-header">
				<h2>내가 쓴 글 모아보기</h2>
				<p>내가 쓴 글</p>
			</header>

			<div class="row" data-aos="fade-up" data-aos-delay="100">
				<div class="col-lg-12 d-flex justify-content-center">
					<ul id="portfolio-flters">
						<li data-filter="*" class="filter-active">전체</li>
						<li data-filter=".filter-book">도서</li>
						<li data-filter=".filter-card">영화</li>
						<li data-filter=".filter-show">공연</li>
					</ul>
				</div>
			</div>

<!-- 			<div class="row gy-4 portfolio-container" data-aos="fade-up"
				data-aos-delay="200"  id="showInfo" style="height: 100%">
 -->				
				

<div class="col-lg-4 col-md-6 portfolio-item filter-bookReview">
  <div class="portfolio-wrap">
	<div class="portfolio-info">
	<table class = "table" style = "text-align:center">
    	<tr>
    		<th>제목</th>
    		<th>등록 날짜</th>
    		<th>조회수</th>
    	</tr>
    		
		<%for(BookReview bReview : brList) {%>
    		<tr>
    			<td>
					<h4><%=bReview.getTitle() %></h4>
    			</td>
    			<td>
    				<h4><%=bReview.getEnrollDate() %></h4>
    			</td>
    			<td>
    				<h4><%=bReview.getHits() %></h4>
    			</td>
			</tr>
		<%} %>
		</table>
		</div>
	</div>
  </div>
  <br><br>
    <div align = "center"><%= brPageNavi %></div>
<div class="col-lg-4 col-md-6 portfolio-item filter-bookShare">
  <div class="portfolio-wrap">
	<div class="portfolio-info">
	<table class = "table" style = "text-align:center">
		<%for(BookShare bShare : bsList) {%>
    		<tr>
    			<td>
					<h4><%=bShare.getTitle() %></h4>
    			</td>
    			<td>
    				<h4><%=bShare.getEnrollDate() %></h4>
    			</td>
    			<td>
    				<h4><%=bShare.getHits() %></h4>
    			</td>
		</table>
		<%} %>
		</div>
	</div>
  </div>
  <br><br>
    <div align = "center"><%= bsPageNavi %></div>
<div class="col-lg-4 col-md-6 portfolio-item filter-movieReview">
  <div class="portfolio-wrap">
	<div class="portfolio-info">
	<table class = "table" style = "text-align:center">
    	<tr>
    		<th>제목</th>
    		<th>등록 날짜</th>
    		<th>조회수</th>
    	</tr>
		<%for(MovieReview mReview : mrvList) {%>
    		<tr>
    			<td>
					<h4><%=mReview.getContents()%></h4>
    			</td>
    			<td>
    				<h4><%=mReview.getEnrollDate()%></h4>
    			</td>
    			<td>
    				<h4><%=mReview.getHits() %></h4>
    			</td>
			</tr>
		<%} %>	
		</table>
		</div>
	</div>
</div>
<br><br>
    <div align = "center"><%= mrvPageNavi %></div>
    
<div class="col-lg-4 col-md-6 portfolio-item filter-movieRecommend">
  <div class="portfolio-wrap">
	<div class="portfolio-info">
	<table class = "table" style = "text-align:center">
    	<tr>
    		<th>제목</th>
    		<th>등록 날짜</th>
    		<th>조회수</th>
    	</tr>
		<%for(MovieRecommend recommend : mrcList) {%>
    		<tr>
    			<td>
					<h4><%=recommend.getTitle() %></h4>
    			</td>
    			<td>
    				<h4><%=recommend.getEnrollDate() %></h4>
    			</td>
    			<td>
    				<h4><%=recommend.getHits() %></h4>
    			</td>
		</table>
		<%} %>
		</div>
	</div>
</div>
    <br><br>
    <div align = "center"><%= mrcPageNavi %></div>
    
<div class="col-lg-4 col-md-6 portfolio-item filter-show">
  <div class="portfolio-wrap">
	<div class="portfolio-info">
	<table class = "table" style = "text-align:center">
    	<tr>
    		<th>제목</th>
    		<th>등록 날짜</th>
    		<th>조회수</th>
    	</tr>
		<%for(ShowReview sReview : srList) {%>
    		<tr>
    			<td>
					<h4><%=sReview.getTitle()%></h4>
    			</td>
    			<td>
    				<h4><%=sReview.getEnrollDate()%></h4>
    			</td>
    			<td>
    				<h4><%=sReview.getHits() %></h4>
    			</td>
			</tr>
			</table>
		<%}%>
		</div>
	</div>
</div>
    
    <br><br>
    <div align = "center"><%= sPageNavi %></div>
    </form>
	</div>
										

</div>
			<!--============== 여기에 작성하기 끝================================ -->
									</div>
									<!--  end row  -->
								</div>
							</div>
						</section>
<!-- ----------------------------시작 --------------------------- -->
</div></div>
</section>
  </main><!-- End #main -->

<%@include file="/footer.jsp"%>
<script src="/assets/js/qna/qnaList.js"></script>