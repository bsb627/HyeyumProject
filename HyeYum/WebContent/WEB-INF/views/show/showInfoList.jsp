<%@page import="show.model.vo.ShowInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
 ArrayList<ShowInfo> iList = (ArrayList<ShowInfo>)request.getAttribute("iList");
ArrayList<String> rList = (ArrayList<String>)request.getAttribute("rList");
%>
<title>문화나눔, 혜윰 - Show</title>
<%@include file="/header.jsp"%>
<link href="/assets/css/show-custom.css" rel="stylesheet">

<main id="main">

	<!-- ======= Breadcrumbs ======= -->
	<section class="breadcrumbs">
		<div class="container">

			<ol>
				<li><a href="/index.jsp">Home</a></li>
				<li>공연</li>
			</ol>
			<h2>언제혜윰</h2>

		</div>
	</section>
	<!-- End Breadcrumbs -->
	
	<!-- ======= Testimonials Section ======= -->
	<section id="testimonials" class="testimonials portfolio">

		<div class="container" data-aos="fade-up">
			<div class="row">
				<header class="section-header">
					<h2>Monthly Contents</h2>
					<p>이달의 컨텐츠</p>
				</header>

				<div class="testimonials-slider swiper-container"
					data-aos="fade-up" data-aos-delay="200">
					<div class="swiper-wrapper">
					
					
						<%for(ShowInfo info : iList){ %>
						<div class="swiper-slide">
							<div class="testimonial-item">
								<div class="portfolio-wrap">
									<img src="/upload/info/show/<%=info.getFileName()%>" alt=""
										class="img-fluid">
									<div class="portfolio-info">
										<h4><%=info.getShowName()%></h4>
										<p><%=info.getTermDate()%></p>
										<div class="portfolio-links">
											<a href="/upload/info/show/<%=info.getFileName()%>" 
												data-gallery="portfolioGallery" class="portfokio-lightbox"
												title="<%=info.getShowName()%>"><i class="bi bi-plus"></i></a> <a
												href="/showInfo/detail?no=<%=info.getInfoNo()%>" title="More Details"><i
												class="bi bi-link"></i></a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<%}%>
						<!-- End testimonial item -->

						

					</div>
					<!--  <div class="swiper-pagination"></div> -->
				</div>

			</div>
		</div>

	</section>
	<!-- End Testimonials Section -->

	<!-- ======= Blog Section ======= -->
	<section id="blog" class="blog portfolio">
		<div class="container" data-aos="fade-up">

			<div class="row">
				<header class="section-header">
					<h2>region contents</h2>
					<p>지역별 컨텐츠</p>
				</header>

				<div class="col-lg-12">


					<div class="row" data-aos="fade-up" data-aos-delay="100">
						<div class="col-lg-12 d-flex justify-content-center">
							<ul id="portfolio-flters">
								<li data-filter="*" class="filter-active">전체</li>
								<!-- <li data-filter=".filter-app">서울</li
								<li data-filter=".filter-card">인천</li>
								<li data-filter=".filter-web">경기도</li> -->
								<%for (String region : rList){ %>
								<li data-filter=".filter-<%=region%>"><%=region%></li>
								<%} %>
							</ul>
						</div>
					</div>

					<!-- End sidebar categories-->

					<!-- End sidebar -->

				</div>
				<!-- End blog sidebar -->

				<div class="col-lg-12 entries">
					<div class="row gy-4 portfolio-container" data-aos="fade-up"
						data-aos-delay="200">
						
						<% for(ShowInfo info : iList) {%>
						<article class="entry row">
							<div class="col-md-3 col-sm-4 col-4 portfolio-item filter-<%=info.getRegion()%>">
								<div class="portfolio-wrap">
									<img src="/upload/info/show/<%=info.getFileName()%>" alt=""
										class="img-fluid">
									<div class="portfolio-info">
										<h4><%=info.getShowName() %></h4>
										<p><%=info.getTermDate() %></p>
										<div class="portfolio-links">
											<a href="/upload/info/show/<%=info.getFileName()%>"
												data-gallery="portfolioGallery" class="portfokio-lightbox"
												title="<%=info.getShowName() %>"><i class="bi bi-plus"></i></a> <a
												href="/showInfo/detail?no=<%=info.getInfoNo()%>" title="More Details"><i
												class="bi bi-link"></i></a>
										</div>
									</div>
								</div>
							</div>
						</article>
						<%} %>

						
					</div>
					<!-- End blog entry -->


				</div>
				<!-- End blog entries list -->
				<!--  <div class="blog-pagination">
					<ul class="justify-content-center">
						<li><a href="#">1</a></li>
						<li class="active"><a href="#">2</a></li>
						<li><a href="#">3</a></li>
					</ul>
				</div>-->


			</div>

		</div>
	</section>
	<!-- End Blog Section -->

</main>
<!-- End #main -->

<%@include file="/footer.jsp"%>