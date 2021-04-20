<%@page import="java.text.DecimalFormat"%>
<%@page import="movie.model.vo.MovieInfo"%>
<%@page import="book.model.vo.BookInfo"%>
<%@page import="show.model.vo.ShowInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<ShowInfo> iList = (ArrayList<ShowInfo>)request.getAttribute("iList");
	ArrayList<BookInfo> bList = (ArrayList<BookInfo>)request.getAttribute("bList");
	ArrayList<MovieInfo> mList = (ArrayList<MovieInfo>)request.getAttribute("mList");
	
	
 	String postAllCount = (String)request.getAttribute("postAllCount");  
 	String memberAllCount = (String)request.getAttribute("memberAllCount");
 	String companyAllCount = (String)request.getAttribute("companyAllCount");
 	String donateAllCount = (String)request.getAttribute("donateAllCount");
 	
 	DecimalFormat formatter = new DecimalFormat("###,###");
%>
<%@include file="/header.jsp"%>

<script type="text/javascript"	src="/assets/js/index-ready.js"></script>
<script>
</script> 
<!-- ======= Hero Section ======= -->
<section id="hero" class="hero d-flex align-items-center">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 d-flex flex-column justify-content-center">
				<h1 data-aos="fade-up">문화나눔, 혜윰</h1>
				<h2 data-aos="fade-up" data-aos-delay="400">[혜윰 : 생각이라는 순 우리말]</h2>
				<div data-aos="fade-up" data-aos-delay="600">
					<div class="text-center text-lg-start">
						<a href="/member/enroll"
							class="btn-get-started scrollto d-inline-flex align-items-center justify-content-center align-self-center">
							<span>회원가입</span> <i class="bi bi-arrow-right"></i>
						</a>
					</div>
				</div>
			</div>
			<div class="col-lg-6 hero-img" data-aos="zoom-out"
				data-aos-delay="200">
				<img src="/assets/img/hero-img.png" class="img-fluid" alt="">
			</div>
		</div>
	</div>
</section>
<!-- End Hero -->

<%if(iList == null) {%>
					<script type="text/javascript">indexReady()</script>
				<% }else{%>
<!-- ======= Counts Section ======= -->
<section id="counts" class="counts">
	<div class="container" data-aos="fade-up">

		<div class="row gy-4">

			<div class="col-lg-3 col-md-6">
				<div class="count-box">
					<i class="bi bi-emoji-heart-eyes"></i>
					<div>
						<span data-purecounter-start="0" data-purecounter-end="<%= memberAllCount %>"
							data-purecounter-duration="1" data-purecounter-once = "false" class="purecounter"></span>
						<p>참여자 수</p>
					</div>
				</div>
			</div>

			<div class="col-lg-3 col-md-6">
				<div class="count-box">
					<i class="bi bi-journal-check" style="color: #ee6c20;"></i>
					<div>
						<span data-purecounter-start="0" data-purecounter-end="<%= postAllCount %>"
							data-purecounter-duration="1" data-purecounter-once = "false" class="purecounter"></span>
						<p>게시글 수</p>
					</div>
				</div>
			</div>

			<div class="col-lg-3 col-md-6">
				<div class="count-box">
					<i class="bi bi-gift" style="color: #15be56;"></i>
					<div>
						<span id = "donate" data-purecounter-start="0" data-purecounter-end="<%= donateAllCount %>"
							data-purecounter-duration="1" data-purecounter-once = "false" data-purecounter-decimals="" class="purecounter"><%= donateAllCount %></span>
						<p>총 기부금</p>
					</div>
				</div>
			</div>

			<div class="col-lg-3 col-md-6">
				<div class="count-box">
					<i class="bi bi-people" style="color: #bb0852;"></i>
					<div>
						<span data-purecounter-start="0" data-purecounter-end="<%= companyAllCount %>"
							data-purecounter-duration="1" data-purecounter-once = "false" class="purecounter"></span>
						<p>제휴기업</p>
					</div>
				</div>
			</div>

		</div>

	</div>
</section>
<!-- End Counts Section -->
 <link href="/assets/css/chart/chart.css" rel="stylesheet">

<main id="main">
	<!--  ============ Chart ============== -->
	<div style="text-align: center;">
	<header class="section-header">
				<h2>chart</h2>
				<p>혜윰의 성과</p>
			</header>
		<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<figure class="highcharts-figure">
  <div id="container"></div>
  <p class="highcharts-description">
   
  </p>
</figure>
	</div>

	<!--  ============ End Chart ============== -->

	<!-- ======= Portfolio Section ======= -->
	 <section id="portfolio" class="portfolio">

		<div class="container" data-aos="fade-up">

			<header class="section-header">
				<h2>Monthly Contents</h2>
				<p>이달의 컨텐츠</p>
			</header>

			<div class="row" data-aos="fade-up" data-aos-delay="100">
				<div class="col-lg-12 d-flex justify-content-center">
					<ul id="portfolio-flters">
						<li data-filter="*" class="filter-active">전체</li>
						<li data-filter=".filter-book">도서</li>
						<li data-filter=".filter-movie">영화</li>
						<li data-filter=".filter-show">공연</li>
					</ul>
				</div>
			</div>

			<div class="row gy-4 portfolio-container" data-aos="fade-up"
				data-aos-delay="200"  id="showInfo" style="height: 100%">
				
				
<%for(BookInfo info : bList) {%>

<div class="col-lg-4 col-md-6 portfolio-item filter-book">
					<div class="portfolio-wrap">
						<img src="/upload/info/book/<%=info.getFileName() %>" class="img-fluid"
							alt="">
						<div class="portfolio-info">
							<h4><%=info.getBookName() %></h4>
							<p><%=info.getAuthor() %></p>
							<div class="portfolio-links">
								<a href="/upload/info/book/<%=info.getFileName() %>"
									data-gallery="portfolioGallery" class="portfokio-lightbox"
									title="<%=info.getBookName()%>"><i class="bi bi-plus"></i></a> <a
									href="#" title="More Details"><i
									class="bi bi-link"></i></a>
							</div>
						</div>
					</div>
				</div>

<%} %>

<%for(MovieInfo info : mList) {%>
<div class="col-lg-4 col-md-6 portfolio-item filter-movie">
					<div class="portfolio-wrap">
						<img src="/upload/info/movie/<%=info.getFileName() %>" class="img-fluid"
							alt="">
						<div class="portfolio-info">
							<h4><%=info.getMovieName() %></h4>
							<p><%=info.getCast()%></p>
							<div class="portfolio-links">
								<a href="/upload/info/movie/<%=info.getFileName() %>"
									data-gallery="portfolioGallery" class="portfokio-lightbox"
									title="<%=info.getMovieName()%>"><i class="bi bi-plus"></i></a> <a
									href="#" title="More Details"><i
									class="bi bi-link"></i></a>
							</div>
						</div>
					</div>
				</div>
<%} %>


<%for(ShowInfo info : iList) {%>

<div class="col-lg-4 col-md-6 portfolio-item filter-show">
					<div class="portfolio-wrap">
						<img src="/upload/info/show/<%=info.getFileName() %>" class="img-fluid"
							alt="">
						<div class="portfolio-info">
							<h4><%=info.getShowName() %></h4>
							<p><%=info.getTermDate() %></p>
							<div class="portfolio-links">
								<a href="/upload/info/show/<%=info.getFileName() %>"
									data-gallery="portfolioGallery" class="portfokio-lightbox"
									title="<%=info.getShowName()%>"><i class="bi bi-plus"></i></a> <a
									href="/showInfo/detail?no=<%=info.getInfoNo()%>" title="More Details"><i
									class="bi bi-link"></i></a>
							</div>
						</div>
					</div>
				</div>
<%} }%>


				
<!-- 
				<div class="col-lg-4 col-md-6 portfolio-item filter-web">
					<div class="portfolio-wrap">
						<img src="/assets/img/portfolio/portfolio-2.jpg" class="img-fluid"
							alt="">
						<div class="portfolio-info">
							<h4>Web 3</h4>
							<p>Web</p>
							<div class="portfolio-links">
								<a href="/assets/img/portfolio/portfolio-2.jpg"
									data-gallery="portfolioGallery" class="portfokio-lightbox"
									title="Web 3"><i class="bi bi-plus"></i></a> <a
									href="portfolio-details.html" title="More Details"><i
									class="bi bi-link"></i></a>
							</div>
						</div>
					</div>
				</div> -->

				
				 
			</div>
		</div>
	</section>
	<!-- End Portfolio Section -->


    <!-- ======= Pricing Section ======= -->
    <section id="pricing" class="pricing">

      <div class="container" data-aos="fade-up">

        <header class="section-header">
          <h2>goods</h2>
          <p>혜윰굿즈</p>
        </header>

        <div class="row gy-4" data-aos="fade-left">



          <div class="col-lg-12 col-md-12" data-aos="zoom-in" data-aos-delay="200">
            <div class="box">
              <span class="featured">혜윰굿즈</span>
              <h3 style="color: #65c600;">혜윰팔찌</h3>
              <div class="price">15,000<span>원</span></div>
              <img src="/assets/img/product/palzzi4.png" class="img-fluid" alt="">
              <ul>
                <li>혜윰과 함께 불우 이웃 돕기에 동참해주세요!</li>
                <li>불우 이웃 돕기에 동참해주신 분들께 감사 굿즈를 전달 드립니다.</li>
              </ul>
              <a href="/intro/product/productForm.jsp" class="btn-buy">참여하기</a>
            </div>
          </div>


        </div>

      </div>

    </section><!-- End Pricing Section -->


	<!-- ======= Clients Section ======= -->
	<section id="clients" class="clients">
		<div class="container" data-aos="fade-up">
			<header class="section-header">
				<h2>Partner</h2>
				<p>함께하는 친구들</p>
			</header>
			<div class="clients-slider swiper-container">
				<div class="swiper-wrapper align-items-center">
					<div class="swiper-slide">
						<img src="/assets/img/clients/client-1.png" class="img-fluid"
							alt="">
					</div>
					<div class="swiper-slide">
						<img src="/assets/img/clients/client-2.png" class="img-fluid"
							alt="">
					</div>
					<div class="swiper-slide">
						<img src="/assets/img/clients/client-3.png" class="img-fluid"
							alt="">
					</div>
					<div class="swiper-slide">
						<img src="/assets/img/clients/client-4.png" class="img-fluid"
							alt="">
					</div>
					<div class="swiper-slide">
						<img src="/assets/img/clients/client-5.png" class="img-fluid"
							alt="">
					</div>
					<div class="swiper-slide">
						<img src="/assets/img/clients/client-6.png" class="img-fluid"
							alt="">
					</div>
					<div class="swiper-slide">
						<img src="/assets/img/clients/client-7.png" class="img-fluid"
							alt="">
					</div>
					<div class="swiper-slide">
						<img src="/assets/img/clients/client-8.png" class="img-fluid"
							alt="">
					</div>
				</div>
				<div class="swiper-pagination"></div>
			</div>
		</div>

	</section>
	<!-- End Clients Section -->
</main>
<!-- End #main -->
<%@include file="/footer.jsp"%>
<script src="/assets/js/chart/chart-ready.js"></script>