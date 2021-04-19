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
        <h2>작성 게시글</h2>
		
      </div>
    </section>
    
    <!-- End Breadcrumbs -->
    <!-- ======= Services Section ======= -->
    <section id="services" class="services">
	<div class="container" data-aos="fade-up">
		<div class="inner-page">
			<header class="section-header">
				<h2>활동</h2>
				<p>작성 게시글</p>
			</header> 

			<!-- ======= 사이드바 ======= -->
			<section id="blog" class="blog">
				<div class="container" data-aos="fade-up">
					<div class="col-md-12">
						<div class="row">
						<div class="col-md-3">

							<div class="sidebar">
							<div class="sidebar-item recent-posts"> 
								<div class="post-item clearfix">
								<!-- <img src="/assets/img/features.png"> -->
								</div>
								<h3 class="sidebar-title">내정보 <i class="bi bi-person-bounding-box"></i></h3>
								<div class="sidebar-item categories">
									<ul>
										<li><a href="#">정보수정</a></li>
									</ul>
									<hr>

									<h3 class="sidebar-title">쪽지 <i class="bi bi-envelope"></i></h3>
									<div class="sidebar-item categories">
										<ul>
											<li><a href="/message/write/page">쪽지 쓰기</a></li>
											<li><a href="/message/receivedList">받은 쪽지함</a></li>
											<li><a href="/message/sentList">보낸 쪽지함</a></li>
										</ul>
										<hr>

										<h3 class="sidebar-title">활동 <i class="bi bi-journals"></i></h3>
										<div class="sidebar-item categories">
											<ul>
												<li><a href="/myPost">작성 게시글</a></li>
												<li><a href="/myReply">작성 댓글</a></li>
											</ul>
											<hr>
										</div>
										<!-- End sidebar tags-->

										<h3 class="sidebar-title">주문 <i class="bi bi-credit-card"></i></h3>
										<div class="sidebar-item categories">
											<ul>
												<li><a href="/order/list">주문 내역</a></li>
											</ul>
											<hr>
										</div>
										<!-- End sidebar tags-->
										<h3 class="sidebar-title">기부 <i class="bi bi-gift"></i></h3>
										<div class="sidebar-item categories">
											<ul>
												<li><a href="/message/sentList">기부 내역</a></li>
											</ul>
											
										</div>
										<!-- End sidebar tags-->
									</div>
								</div>
								</div>
							</div>
							<!-- End blog sidebar -->
						</div>

							<!--============== 사이드바 끝================================ -->

							<!--     	 <section id="portfolio" class="portfolio">-->
						<div class="col-md-9 info-card">
								<table class="table" style="text-align: center;">
									<tr>
										<th>게시판</th>
										<th>제목</th>
										<th>등록 날짜</th>
										<th>조회수</th>
									</tr>
										<%for(BookReview bReview : brList) {%>
									
									<tr>
										<td>독서혜윰</td>
										<td><%=bReview.getTitle() %></td>
										<td><%=bReview.getEnrollDate() %></td>
										<td><%=bReview.getHits() %></td>
									</tr>
									<%} %>
										<%for(BookShare bShare : bsList) {%>
									
									<tr>
										<td>나눔혜윰</td>
										<td><%=bShare.getTitle() %></td>
										<td><%=bShare.getEnrollDate() %></td>
										<td><%=bShare.getHits() %></td>
									</tr>
									<%} %>
										<%for(MovieReview mReview : mrvList) {%>
									
									<tr>
										<td>감상혜윰</td>
										<td><%=mReview.getContents()%></td>
										<td><%=mReview.getEnrollDate() %></td>
										<td><%=mReview.getHits() %></td>
									</tr>
									<%} %>

										<%for(MovieRecommend recommend : mrcList) {%>
									<tr>
										<td>추천혜윰</td>
										<td><%=recommend.getTitle()%></td>
										<td><%=recommend.getEnrollDate() %></td>
										<td><%=recommend.getHits() %></td>
									</tr>
									<%} %>
									<%for(ShowReview sReview : srList) {%>
									<tr>
										<td>관람혜윰</td>
										<td><%=sReview.getTitle()%></td>
										<td><%=sReview.getEnrollDate() %></td>
										<td><%=sReview.getHits() %></td>
									</tr>
									<%} %>
								</table>
							<div class="blog-pagination">
								<ul class="justify-content-center">
									<%-- <%=pageNavi%> --%>
								</ul>	
							</div>
						</div>	
					  </div>
					</div>
				  </div>				
									</section>
									<!-- End Portfolio Section -->


									<!--============== 여기에 작성하기 끝================================ -->

								</div>
								<!--  end row  -->
							</div>
				</section>


</main><!-- End #main -->

<%@include file="/footer.jsp"%>
<script type="text/javascript"	src="/assets/js/index-ready.js"></script>