<%@page import="movie.model.vo.MovieInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MovieInfo mInfo = (MovieInfo)request.getAttribute("mInfo");
%>
<title>문화나눔, 혜윰 - 이달의 영화 정보</title>
<%@include file="/header.jsp"%>
<link href="/assets/css/show-info.css" rel="stylesheet">

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
	
	    <!-- ======= Features Section ======= -->
    <section id="features" class="features">

      <div class="container" data-aos="fade-up">

        <header class="section-header">
          <h2>Let me Introduce this Month's movie</h2>
          <p>이 달의 영화를 소개합니다</p>
        </header>


        <!-- Feature Icons -->
        <div class="row feature-icons review-box" data-aos="fade-up">
          <h3>영화 소개</h3>

          <div class="row">

            <div class="col-xl-4 text-center" data-aos="fade-right" data-aos-delay="100">
              <img src="/upload/info/movie/<%=mInfo.getFileName()%>" class="img-fluid p-4" alt="">
            </div>
            
               <div class="col-lg-8 mt-5 mt-lg-0 d-flex">
            <div class="row align-self-center gy-4">

              <div class="col-md-6" data-aos="zoom-out" data-aos-delay="200">
                <div class="feature-box d-flex align-items-center">
                  <i class="bi bi-check"></i>
                  <h4><%= mInfo.getMovieName() %></h4>
                </div>
              </div>

              <div class="col-md-6" data-aos="zoom-out" data-aos-delay="300">
                <div class="feature-box d-flex align-items-center">
                  <i class="bi bi-check"></i>
                  <h4><%= mInfo.getGenre() %></h4>
                </div>
              </div>

              <div class="col-md-6" data-aos="zoom-out" data-aos-delay="400">
                <div class="feature-box d-flex align-items-center">
                  <i class="bi bi-check"></i>
                  <h4><%= mInfo.getCast() %></h4>
                </div>
              </div>

              <div class="col-md-6" data-aos="zoom-out" data-aos-delay="500">
                <div class="feature-box d-flex align-items-center">
                  <i class="bi bi-check"></i>
                  <h4><%= mInfo.getAgeGroup()%></h4>
                </div>
              </div>

              <div class="col-md-6" data-aos="zoom-out" data-aos-delay="600">
                <div class="feature-box d-flex align-items-center">
                  <i class="bi bi-check"></i>
                  <h4><%= mInfo.getDirector() %></h4>
                </div>
              </div>

              <div class="col-md-6" data-aos="zoom-out" data-aos-delay="700">
                <div class="feature-box d-flex align-items-center">
                  <i class="bi bi-check"></i>
                  <h4>상영시간 : <%= mInfo.getRunTime() %></h4>
                </div>
              </div>

            </div>
          </div>
          
          
          <section id="recent-blog-posts" class="recent-blog-posts">

      <div class="container" data-aos="fade-up">

        <header class="section-header">
          <h3>시놉시스</h3>
          
        </header>

        <div class="row">

          <div class="col-lg-2">
          <!--   <div class="post-box">
              <div class="post-img"><img src="assets/img/blog/blog-1.jpg" class="img-fluid" alt=""></div>
              <span class="post-date">Tue, September 15</span>
              <h3 class="post-title">Eum ad dolor et. Autem aut fugiat debitis voluptatem consequuntur sit</h3>
              <a href="blog-singe.html" class="readmore stretched-link mt-auto"><span>Read More</span><i class="bi bi-arrow-right"></i></a>
            </div> -->
          </div>

          <div class="col-lg-8">
            <div class="post-box">
              <div class="post-img"><img src="/assets/img/movie/review.jpg" class="img-fluid" alt=""></div>
              <span class="post-date"><%= mInfo.getSynopsis() %></span>
              <!-- <h3 class="post-title">Et repellendus molestiae qui est sed omnis voluptates magnam</h3> -->
              <a href="/movieReview/list" class="readmore stretched-link mt-auto"><span data-toggle="modal" data-target="#writeModal"
						data-whatever="@getbootstrap" id="write-button">리뷰 작성하기</span><i class="bi bi-arrow-right"></i></a>
            </div>
          </div>

          <div class="col-lg-2">
            <!-- <div class="post-box">
              <div class="post-img"><img src="assets/img/blog/blog-3.jpg" class="img-fluid" alt=""></div>
              <span class="post-date">Mon, July 11</span>
              <h3 class="post-title">Quia assumenda est et veritatis aut quae</h3>
              <a href="blog-singe.html" class="readmore stretched-link mt-auto"><span>Read More</span><i class="bi bi-arrow-right"></i></a>
            </div> -->
          </div>

        </div>

      </div>

    </section><!-- End Recent Blog Posts Section -->
          

      </div>
		<div class="btn-set">
			<a href="/index.jsp"><button type="button"
					class="btn btn-outline-dark" data-mdb-ripple-color="dark">
					메인으로</button> </a>
		</div>

	</section><!-- End Features Section -->


</main>
<!-- End #main -->

<%@include file="/footer.jsp"%>