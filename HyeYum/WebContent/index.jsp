<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
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

<!-- ======= Counts Section ======= -->
<section id="counts" class="counts">
	<div class="container" data-aos="fade-up">

		<div class="row gy-4">

			<div class="col-lg-3 col-md-6">
				<div class="count-box">
					<i class="bi bi-emoji-heart-eyes"></i>
					<div>
						<span data-purecounter-start="0" data-purecounter-end="2567"
							data-purecounter-duration="1" data-purecounter-once = "false" class="purecounter"></span>
						<p>참여자 수</p>
					</div>
				</div>
			</div>

			<div class="col-lg-3 col-md-6">
				<div class="count-box">
					<i class="bi bi-journal-check" style="color: #ee6c20;"></i>
					<div>
						<span data-purecounter-start="0" data-purecounter-end="12789"
							data-purecounter-duration="1" data-purecounter-once = "false" class="purecounter"></span>
						<p>게시글 수</p>
					</div>
				</div>
			</div>

			<div class="col-lg-3 col-md-6">
				<div class="count-box">
					<i class="bi bi-gift" style="color: #15be56;"></i>
					<div>
						<span data-purecounter-start="0" data-purecounter-end="1456321"
							data-purecounter-duration="1" data-purecounter-once = "false" class="purecounter"></span>
						<p>총 기부금</p>
					</div>
				</div>
			</div>

			<div class="col-lg-3 col-md-6">
				<div class="count-box">
					<i class="bi bi-people" style="color: #bb0852;"></i>
					<div>
						<span data-purecounter-start="0" data-purecounter-end="1512"
							data-purecounter-duration="1" data-purecounter-once = "false" class="purecounter"></span>
						<p>제휴기업</p>
					</div>
				</div>
			</div>

		</div>

	</div>
</section>
<!-- End Counts Section -->

<main id="main">
	<!--  ============ Chart ============== -->
	<div style="text-align: center;">
	<h2>문화나눔, 혜윰의 지난해 성과</h2>
		<script src="https://code.highcharts.com/highcharts.js"></script>
		<script src="https://code.highcharts.com/highcharts-3d.js"></script>
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
						<li data-filter=".filter-app">도서</li>
						<li data-filter=".filter-card">영화</li>
						<li data-filter=".filter-web">공연</li>
					</ul>
				</div>
			</div>

			<div class="row gy-4 portfolio-container" data-aos="fade-up"
				data-aos-delay="200">

				<div class="col-lg-4 col-md-6 portfolio-item filter-app">
					<div class="portfolio-wrap">
						<img src="/assets/img/portfolio/portfolio-1.jpg" class="img-fluid"
							alt="">
						<div class="portfolio-info">
							<h4>App 1</h4>
							<p>App</p>
							<div class="portfolio-links">
								<a href="/assets/img/portfolio/portfolio-1.jpg"
									data-gallery="portfolioGallery" class="portfokio-lightbox"
									title="App 1"><i class="bi bi-plus"></i></a> <a
									href="portfolio-details.html" title="More Details"><i
									class="bi bi-link"></i></a>
							</div>
						</div>
					</div>
				</div>

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
				</div>

				<div class="col-lg-4 col-md-6 portfolio-item filter-app">
					<div class="portfolio-wrap">
						<img src="/assets/img/portfolio/portfolio-3.jpg" class="img-fluid"
							alt="">
						<div class="portfolio-info">
							<h4>App 2</h4>
							<p>App</p>
							<div class="portfolio-links">
								<a href="/assets/img/portfolio/portfolio-3.jpg"
									data-gallery="portfolioGallery" class="portfokio-lightbox"
									title="App 2"><i class="bi bi-plus"></i></a> <a
									href="portfolio-details.html" title="More Details"><i
									class="bi bi-link"></i></a>
							</div>
						</div>
					</div>
				</div>

		          <div class="col-lg-4 col-md-6 portfolio-item filter-card">
		            <div class="portfolio-wrap">
		              <img src="assets/img/portfolio/portfolio-4.jpg" class="img-fluid" alt="">
		              <div class="portfolio-info">
		                <h4>Card 2</h4>
		                <p>Card</p>
		                <div class="portfolio-links">
		                  <a href="assets/img/portfolio/portfolio-4.jpg" 
		                  data-gallery="portfolioGallery" class="portfokio-lightbox" title="Card 2"><i class="bi bi-plus"></i></a>
		                  <a href="portfolio-details.html" title="More Details"><i class="bi bi-link"></i></a>
		                </div>
		              </div>
		            </div>
		          </div>

				<div class="col-lg-4 col-md-6 portfolio-item filter-web">
					<div class="portfolio-wrap">
						<img src="/assets/img/portfolio/portfolio-5.jpg" class="img-fluid"
							alt="">
						<div class="portfolio-info">
							<h4>Web 2</h4>
							<p>Web</p>
							<div class="portfolio-links">
								<a href="/assets/img/portfolio/portfolio-5.jpg"
									data-gallery="portfolioGallery" class="portfokio-lightbox"
									title="Web 2"><i class="bi bi-plus"></i></a> <a
									href="portfolio-details.html" title="More Details"><i
									class="bi bi-link"></i></a>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-4 col-md-6 portfolio-item filter-app">
					<div class="portfolio-wrap">
						<img src="/assets/img/portfolio/portfolio-6.jpg" class="img-fluid"
							alt="">
						<div class="portfolio-info">
							<h4>App 3</h4>
							<p>App</p>
							<div class="portfolio-links">
								<a href="/assets/img/portfolio/portfolio-6.jpg"
									data-gallery="portfolioGallery" class="portfokio-lightbox"
									title="App 3"><i class="bi bi-plus"></i></a> <a
									href="portfolio-details.html" title="More Details"><i
									class="bi bi-link"></i></a>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-4 col-md-6 portfolio-item filter-card">
					<div class="portfolio-wrap">
						<img src="/assets/img/portfolio/portfolio-7.jpg" class="img-fluid"
							alt="">
						<div class="portfolio-info">
							<h4>Card 1</h4>
							<p>Card</p>
							<div class="portfolio-links">
								<a href="/assets/img/portfolio/portfolio-7.jpg"
									data-gallery="portfolioGallery" class="portfokio-lightbox"
									title="Card 1"><i class="bi bi-plus"></i></a> <a
									href="portfolio-details.html" title="More Details"><i
									class="bi bi-link"></i></a>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-4 col-md-6 portfolio-item filter-card">
					<div class="portfolio-wrap">
						<img src="/assets/img/portfolio/portfolio-8.jpg" class="img-fluid"
							alt="">
						<div class="portfolio-info">
							<h4>Card 3</h4>
							<p>Card</p>
							<div class="portfolio-links">
								<a href="/assets/img/portfolio/portfolio-8.jpg"
									data-gallery="portfolioGallery" class="portfokio-lightbox"
									title="Card 3"><i class="bi bi-plus"></i></a> <a
									href="portfolio-details.html" title="More Details"><i
									class="bi bi-link"></i></a>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-4 col-md-6 portfolio-item filter-web">
					<div class="portfolio-wrap">
						<img src="/assets/img/portfolio/portfolio-9.jpg" class="img-fluid"
							alt="">
						<div class="portfolio-info">
							<h4>Web 3</h4>
							<p>Web</p>
							<div class="portfolio-links">
								<a href="/assets/img/portfolio/portfolio-9.jpg"
									data-gallery="portfolioGallery" class="portfokio-lightbox"
									title="Web 3"><i class="bi bi-plus"></i></a> <a
									href="portfolio-details.html" title="More Details"><i
									class="bi bi-link"></i></a>
							</div>
						</div>
					</div>
				</div>
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
              <div class="price"><sup>￦</sup>33,000<span> / ko</span></div>
              <img src="assets/img/pricing-starter.png" class="img-fluid" alt="">
              <ul>
                <li>Aida dere</li>
                <li>Nec feugiat nisl</li>
                <li>Nulla at volutpat dola</li>
                <li>Pharetra massa</li>
                <li class="na">Massa ultricies mi</li>
              </ul>
              <a href="#" class="btn-buy">참여하기</a>
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