<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<title>문화나눔, 혜윰 - 관람혜윰</title>
<%@include file="/header.jsp"%>
<link href="/assets/css/show-custom.css" rel="stylesheet">
<%
	if (userId == null) {
%>
<script type="text/javascript">
	if (confirm("로그인 후 이용가능합니다.")) {
		location.href="/member/login";
	} else {
		history.back();
	}
</script>
<%
	}
%>
<main id="main">

	<!-- ======= Breadcrumbs ======= -->
	<section class="breadcrumbs">
		<div class="container">

			<ol>
				<li><a href="/index.jsp">Home</a></li>
				<li>공연</li>
			</ol>
			<h2>관람혜윰</h2>

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

        <div class="testimonials-slider swiper-container " data-aos="fade-up" data-aos-delay="200">
          <div class="swiper-wrapper">

           				<div class="swiper-slide">
						<div class="testimonial-item">
							<div class="portfolio-wrap">
								<img src="/assets/img/show-info/show1.jpg" alt=""
									class="img-fluid">
								<div class="portfolio-info">
									<h4>App 1</h4>
									<p>App</p>
									<div class="portfolio-links">
										<a href="/assets/img/show-info/show1.jpg"
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
								<img src="/assets/img/show-info/show1.jpg" alt=""
									class="img-fluid">
								<div class="portfolio-info">
									<h4>App 1</h4>
									<p>App</p>
									<div class="portfolio-links">
										<a href="/assets/img/show-info/show1.jpg"
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
								<img src="/assets/img/show-info/show1.jpg" alt=""
									class="img-fluid">
								<div class="portfolio-info">
									<h4>App 1</h4>
									<p>App</p>
									<div class="portfolio-links">
										<a href="/assets/img/show-info/show1.jpg"
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
								<img src="/assets/img/show-info/show1.jpg" alt=""
									class="img-fluid">
								<div class="portfolio-info">
									<h4>App 1</h4>
									<p>App</p>
									<div class="portfolio-links">
										<a href="/assets/img/show-info/show1.jpg"
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
								<img src="/assets/img/show-info/show1.jpg" alt=""
									class="img-fluid">
								<div class="portfolio-info">
									<h4>App 1</h4>
									<p>App</p>
									<div class="portfolio-links">
										<a href="/assets/img/show-info/show1.jpg"
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
      </div>

    </section><!-- End Testimonials Section -->
 

	 <!-- ======= Recent Blog Posts Section ======= -->
    <section id="recent-blog-posts" class="blog recent-blog-posts">

      <div class="container" data-aos="fade-up">

        <header class="section-header">
          <h2>Photo Review</h2>
          <p>관람 포토 후기</p>
        </header>

  <div class="sidebar">
			
<h3 class="sidebar-title">Search</h3>
              <div class="sidebar-item search-form">
                <form action="">
                  <input type="text">
                  <button type="submit"><i class="bi bi-search"></i></button>
                </form>
              </div><!-- End sidebar search formn-->
              
                <h3 class="sidebar-title">Tags</h3>
              <div class="sidebar-item tags">
                <ul>
                  <li><a href="#">App</a></li>
                  <li><a href="#">IT</a></li>
                  <li><a href="#">Business</a></li>
                  <li><a href="#">Mac</a></li>
                  <li><a href="#">Design</a></li>
                  <li><a href="#">Office</a></li>
                  <li><a href="#">Creative</a></li>
                  <li><a href="#">Studio</a></li>
                  <li><a href="#">Smart</a></li>
                  <li><a href="#">Tips</a></li>
                  <li><a href="#">Marketing</a></li>
                </ul>
              </div><!-- End sidebar tags-->
</div>

        <div class="row">
        

          <div class="post-card col-lg-4">
            <div class="post-box">
              <div class="post-img"><img src="/assets/img/blog/blog-1.jpg" class="img-fluid" alt=""></div>
             
              <span class="post-date"><i class="bi bi-pen">홍길동</i><i class="bi bi-heart"> 11</i><i class="bi bi-chat-square-dots"> 12</i><i class="bi bi-clock"> 2021-04-10</i></span>
              <h3 class="post-title">오늘 오페라의 유령봤다~~꿀잼쓰~~</h3>
              <a href="blog-singe.html" class="readmore stretched-link mt-auto"><span>Read More</span><i class="bi bi-arrow-right"></i></a>
            </div>
          </div>

          <div class="post-card col-lg-4">
            <div class="post-box">
              <div class="post-img"><img src="/assets/img/blog/blog-2.jpg" class="img-fluid" alt=""></div>
              <span class="post-date">Fri, August 28</span>
              <h3 class="post-title">Et repellendus molestiae qui est sed omnis voluptates magnam</h3>
              <a href="blog-singe.html" class="readmore stretched-link mt-auto"><span>Read More</span><i class="bi bi-arrow-right"></i></a>
            </div>
          </div>

          <div class="post-card col-lg-4">
            <div class="post-box">
              <div class="post-img"><img src="/assets/img/blog/blog-3.jpg" class="img-fluid" alt=""></div>
              <span class="post-date">Mon, July 11</span>
              <h3 class="post-title">Quia assumenda est et veritatis aut quae</h3>
              <a href="blog-singe.html" class="readmore stretched-link mt-auto"><span>Read More</span><i class="bi bi-arrow-right"></i></a>
            </div>
          </div>
          
                   <div class="post-card col-lg-4">
            <div class="post-box">
              <div class="post-img"><img src="/assets/img/blog/blog-3.jpg" class="img-fluid" alt=""></div>
              <span class="post-date">Mon, July 11</span>
              <h3 class="post-title">Quia assumenda est et veritatis aut quae</h3>
              <a href="blog-singe.html" class="readmore stretched-link mt-auto"><span>Read More</span><i class="bi bi-arrow-right"></i></a>
            </div>
          </div>
          
                   <div class="post-card col-lg-4">
            <div class="post-box">
              <div class="post-img"><img src="/assets/img/blog/blog-3.jpg" class="img-fluid" alt=""></div>
              <span class="post-date">Mon, July 11</span>
              <h3 class="post-title">Quia assumenda est et veritatis aut quae</h3>
              <a href="blog-singe.html" class="readmore stretched-link mt-auto"><span>Read More</span><i class="bi bi-arrow-right"></i></a>
            </div>
          </div>
          
                   <div class="post-card col-lg-4">
            <div class="post-box">
              <div class="post-img"><img src="/assets/img/blog/blog-3.jpg" class="img-fluid" alt=""></div>
              <span class="post-date">Mon, July 11</span>
              <h3 class="post-title">Quia assumenda est et veritatis aut quae</h3>
              <a href="blog-singe.html" class="readmore stretched-link mt-auto"><span>Read More</span><i class="bi bi-arrow-right"></i></a>
            </div>
          </div>

        </div>
<a href="/showInfo/write"><button class="btn btn-primary btn-write">글쓰기</button></a>
				<div class="blog-pagination">
					<ul class="justify-content-center">
						<li><a href="#">1</a></li>
						<li class="active"><a href="#">2</a></li>
						<li><a href="#">3</a></li>
					</ul>
				</div>
      </div>

           

    </section><!-- End Recent Blog Posts Section -->





</main>
<!-- End #main -->

<%@include file="/footer.jsp"%>