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
	<div class="container" data-aos="fade-up">
		<div class="inner-page">
			<header class="section-header">
				<h2>Message</h2>
				<p>보낸 쪽지함</p>
			</header>

			<!-- ======= 사이드바 ======= -->
			<section id="blog" class="blog">
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

							<!--============== 사이드바 끝================================ -->

							<!--     	 <section id="portfolio" class="portfolio">-->
							<div class="col-md-9 info-card">
								<div style="float: center">
									<section id="portfolio" class="portfolio">

										<div class="container" data-aos="fade-up">
											<div class="row" data-aos="fade-up" data-aos-delay="100">
												<div class="col-lg-12 d-flex justify-content-center">
													<ul id="portfolio-flters">
														<li data-filter="*" class="filter-active">모두</li>
														<li data-filter=".filter-book">도서</li>
														<li data-filter=".filter-moview">영화</li>
														<li data-filter=".filter-show">공연</li>
													</ul>
												</div>
											</div>

											<div class="row gy-4 portfolio-container" data-aos="fade-up"
												data-aos-delay="200">
												<div class="col-lg-12 portfolio-item filter-book">
													<div class="portfolio-wrap">
														<!-- 도서리뷰 -->
														<h2 style="text-align: center">독서혜윰</h2>
														<div class="container fluid" align="center">
															<table class="table" style="text-align: center">
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
														<br>
														<br>
														<hr>
													</div>
												</div>

												<div class="col-lg-12 portfolio-item filter-book">
													<div class="portfolio-wrap">
														<h2 style="text-align: center">나눔혜윰</h2>
														<div class="container fluid">
															<table class="table" style="text-align: center">
																<tr>
																	<th>제목</th>
																	<th>등록 날짜</th>
																	<th>조회수</th>
																</tr>
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
																</tr>
																<%} %>
															</table>
														</div>
														<br>
														<br>
														<hr>
													</div>
												</div>


												<div class="col-lg-12 portfolio-item filter-moview">
													<div class="portfolio-wrap">
														<h2 style="text-align: center">감상혜윰</h2>
														<div class="container fluid">
															<table class="table" style="text-align: center">
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
												<br>
												<br>
												<hr>
												<div class="col-lg-12 portfolio-item filter-moview">
													<div class="portfolio-wrap">
														<h2 style="text-align: center">추천혜윰</h2>
														<div class="container fluid">
															<table class="table" style="text-align: center">
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
																</tr>
																<%
																	}
																%>
															</table>
														</div>
													</div>
												</div>
												<br>
												<br>
												<hr>

												<div class="col-lg-12 portfolio-item filter-show">
													<div class="portfolio-wrap">
														<h2 style="text-align: center">관람혜윰</h2>
														<div class="container fluid">
															<table class="table" style="text-align: center">
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
																<%}%>
															</table>
														</div>
													</div>
												</div>
												<br>
												<br>
												<hr>
											</div>
										</div>
									</section>
									<!-- End Portfolio Section -->


									<!--============== 여기에 작성하기 끝================================ -->

								</div>
								<!--  end row  -->
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>

</main><!-- End #main -->

<%@include file="/footer.jsp"%>
<script type="text/javascript"	src="/assets/js/index-ready.js"></script>