<%@page import="show.model.vo.ShowInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int no = (int)request.getAttribute("no");
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
	
	    <!-- ======= Features Section ======= -->
    <section id="features" class="features">

      <div class="container" data-aos="fade-up">

        <header class="section-header">
          <h2>Features</h2>
          <p>어디서 혜윰</p>
        </header>


        <!-- Feature Icons -->
        <div class="row feature-icons" data-aos="fade-up">
          <h3>공연 정보 제목 나올곳</h3>

          <div class="row">

            <div class="col-xl-4 text-center" data-aos="fade-right" data-aos-delay="100">
              <img src="/upload/info/show/공연정보1.jpg" class="img-fluid p-4" alt="">
            </div>

            <div class="col-xl-8 d-flex content">
              <div class="row align-self-center gy-4">

                <div class="col-md-6 icon-box" data-aos="fade-up">
                  <i class="ri-line-chart-line"></i>
                  <div>
                    <h4>지역</h4>
                    <p>Consequuntur sunt aut quasi enim aliquam quae harum pariatur laboris nisi ut aliquip</p>
                  </div>
                </div>

                <div class="col-md-6 icon-box" data-aos="fade-up" data-aos-delay="100">
                  <i class="ri-stack-line"></i>
                  <div>
                    <h4>장소</h4>
                    <p>Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt</p>
                  </div>
                </div>

                <div class="col-md-6 icon-box" data-aos="fade-up" data-aos-delay="200">
                  <i class="ri-brush-4-line"></i>
                  <div>
                    <h4>관람등급</h4>
                    <p>Aut suscipit aut cum nemo deleniti aut omnis. Doloribus ut maiores omnis facere</p>
                  </div>
                </div>

                <div class="col-md-6 icon-box" data-aos="fade-up" data-aos-delay="300">
                  <i class="ri-magic-line"></i>
                  <div>
                    <h4>런타임</h4>
                    <p>Expedita veritatis consequuntur nihil tempore laudantium vitae denat pacta</p>
                  </div>
                </div>

                <div class="col-md-6 icon-box" data-aos="fade-up" data-aos-delay="400">
                  <i class="ri-command-line"></i>
                  <div>
                    <h4>기간</h4>
                    <p>Et fuga et deserunt et enim. Dolorem architecto ratione tensa raptor marte</p>
                  </div>
                </div>

                <div class="col-md-6 icon-box" data-aos="fade-up" data-aos-delay="500">
                  <i class="ri-radar-line"></i>
                  <div>
                    <h4>가격</h4>
                    <p>Est autem dicta beatae suscipit. Sint veritatis et sit quasi ab aut inventore</p>
                  </div>
                </div>
                
                 <div class="col-md-12 icon-box" data-aos="fade-up" data-aos-delay="500">
                  <i class="ri-user-line"></i>
                  <div>
                    <h4>출연진</h4>
                    <p>Est autem dicta beatae suscipit. Sint veritatis et sit quasi ab aut inventore</p>
                  </div>
                </div>
                

              </div>
            </div>

          </div>

        </div><!-- End Feature Icons -->

					<!--  MAP -->
			<div class="row feature-icons" data-aos="fade-up">
				<h3>지도 정보 나올곳</h3>
			</div>

			<div class="map-set" align="center" >
				    <div id="map" style="width:100%;height:50%;"></div>
			    </div>
			    <!--  MAP END -->

      </div>

	
    </section><!-- End Features Section -->


</main>
<!-- End #main -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a5b44a57b1aeb822a0e594951bbb5406"></script>
<script src="/assets/js/show-custom.js"></script>
<%@include file="/footer.jsp"%>