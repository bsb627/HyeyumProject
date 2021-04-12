<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

 <title>문화나눔, 혜윰 - 영화</title>
  <%@include file="/header.jsp"%>
<link href="/assets/css/movie/movieinfo.css" rel="stylesheet">
 <main id="main">
 
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
	
	 <!-- ======= Testimonials Section ======= -->
    <section id="testimonials" class="testimonials portfolio">

      <div class="container" data-aos="fade-up">

        <header class="section-header">
          <h2>Monthly Contents</h2>
          <p>이 달의 컨텐츠 - 영화</p>
        </header>

        <div class="testimonials-slider swiper-container " data-aos="fade-up" data-aos-delay="200">
          <div class="swiper-wrapper">

           				<div class="swiper-slide">
						<div class="testimonial-item">
							<div class="portfolio-wrap">
								<img src="/assets/img/movie/movieinfo/info1.jpg" alt=""
									class="img-fluid">
								<div class="portfolio-info">
									<h4>App 1</h4>
									<p>App</p>
									<div class="portfolio-links">
										<a href="/assets/img/movie/movieinfo/info1.jpg"
											data-gallery="portfolioGallery" class="portfokio-lightbox"
											title="App 1"><i class="bi bi-plus"></i></a> <a
											href="portfolio-details.html" title="More Details"><i
											class="bi bi-link"></i></a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- End testimonial item -->

					<div class="swiper-slide">
						<div class="testimonial-item">
							<div class="portfolio-wrap">
								<img src="/assets/img/movie/movieinfo/info1.jpg" alt=""
									class="img-fluid">
								<div class="portfolio-info">
									<h4>App 1</h4>
									<p>App</p>
									<div class="portfolio-links">
										<a href="/assets/img/movie/movieinfo/info1.jpg"
											data-gallery="portfolioGallery" class="portfokio-lightbox"
											title="App 1"><i class="bi bi-plus"></i></a> <a
											href="portfolio-details.html" title="More Details"><i
											class="bi bi-link"></i></a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- End testimonial item -->

						<div class="swiper-slide">
						<div class="testimonial-item">
							<div class="portfolio-wrap">
								<img src="/assets/img/movie/movieinfo/info1.jpg" alt=""
									class="img-fluid">
								<div class="portfolio-info">
									<h4>App 1</h4>
									<p>App</p>
									<div class="portfolio-links">
										<a href="/assets/img/movie/movieinfo/info1.jpg"
											data-gallery="portfolioGallery" class="portfokio-lightbox"
											title="App 1"><i class="bi bi-plus"></i></a> <a
											href="portfolio-details.html" title="More Details"><i
											class="bi bi-link"></i></a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- End testimonial item -->

        				<div class="swiper-slide">
						<div class="testimonial-item">
							<div class="portfolio-wrap">
								<img src="/assets/img/movie/movieinfo/info1.jpg" alt=""
									class="img-fluid">
								<div class="portfolio-info">
									<h4>App 1</h4>
									<p>App</p>
									<div class="portfolio-links">
										<a href="/assets/img/movie/movieinfo/info1.jpg"
											data-gallery="portfolioGallery" class="portfokio-lightbox"
											title="App 1"><i class="bi bi-plus"></i></a> <a
											href="portfolio-details.html" title="More Details"><i
											class="bi bi-link"></i></a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- End testimonial item -->

					<div class="swiper-slide">
						<div class="testimonial-item">
							<div class="portfolio-wrap">
								<img src="/assets/img/movie/movieinfo/info1.jpg" alt=""
									class="img-fluid">
								<div class="portfolio-info">
									<h4>App 1</h4>
									<p>App</p>
									<div class="portfolio-links">
										<a href="/assets/img/movie/movieinfo/info1.jpg"
											data-gallery="portfolioGallery" class="portfokio-lightbox"
											title="App 1"><i class="bi bi-plus"></i></a> <a
											href="portfolio-details.html" title="More Details"><i
											class="bi bi-link"></i></a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- End testimonial item -->
					
					<div class="swiper-slide">
						<div class="testimonial-item">
							<div class="portfolio-wrap">
								<img src="/assets/img/movie/movieinfo/info1.jpg" alt=""
									class="img-fluid">
								<div class="portfolio-info">
									<h4>App 1</h4>
									<p>App</p>
									<div class="portfolio-links">
										<a href="/assets/img/movie/movieinfo/info1.jpg"
											data-gallery="portfolioGallery" class="portfokio-lightbox"
											title="App 1"><i class="bi bi-plus"></i></a> <a
											href="portfolio-details.html" title="More Details"><i
											class="bi bi-link"></i></a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- End testimonial item -->

          </div>
         <!--  <div class="swiper-pagination"></div> -->
        </div>

      </div>

    </section><!-- End Testimonials Section -->
    
    
   
	<section>
		
		<div class="container" data-aos="fade-up">

			<header class="section-header">
				<h2>MOVIE REVIEW</h2>
				<p>영화 리뷰</p>
			</header>
		</div>
		<% if (userId == null) { %>
		<div class="container" data-aos="fade-up">
				<strong>잠깐 ! </strong> 해당글은 <a href="/member/login" class="alert-link">로그인</a>후 이용이 가능합니다.
			</div>
		<% } %>
	</section>
	
	<!-- 로그인 할 시 -->
	
	<%	if (userId != null && userId != "") {	%> 
	<section>
		로그인 했으니까 게시판!!!!!
	</section>
	<% } %>	

</main><!-- End #main -->

<%@include file="/footer.jsp"%>