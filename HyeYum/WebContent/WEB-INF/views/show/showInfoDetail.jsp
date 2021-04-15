<%@page import="show.model.vo.ShowInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ShowInfo info = (ShowInfo)request.getAttribute("info");
%>
<title>문화나눔, 혜윰 - Show</title>
<%@include file="/header.jsp"%>
<link href="/assets/css/show-info.css" rel="stylesheet">

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
          <p>언제 혜윰</p>
        </header>


        <!-- Feature Icons -->
        <div class="row feature-icons review-box" data-aos="fade-up">
          <h3><%=info.getShowName() %></h3>

          <div class="row">

            <div class="col-xl-4 text-center" data-aos="fade-right" data-aos-delay="100">
              <img src="/upload/info/show/<%=info.getFileName()%>" class="img-fluid p-4" alt="">
            </div>

            <div class="col-xl-8 d-flex content">
              <div class="row align-self-center gy-4">

                <div class="col-md-6 icon-box" data-aos="fade-up">
                  <i class="ri-line-chart-line"></i>
                  <div>
                    <h4>지역</h4>
                    <p><%=info.getRegion()%></p>
                  </div>
                </div>

                <div class="col-md-6 icon-box" data-aos="fade-up" data-aos-delay="100">
                  <i class="ri-stack-line"></i>
                  <div>
                    <h4>장소</h4>
                    <p><%=info.getPlace()%></p>
                  </div>
                </div>

                <div class="col-md-6 icon-box" data-aos="fade-up" data-aos-delay="200">
                  <i class="ri-brush-4-line"></i>
                  <div>
                    <h4>관람등급</h4>
                    <p><%=info.getAgeGroup()%></p>
                  </div>
                </div>

                <div class="col-md-6 icon-box" data-aos="fade-up" data-aos-delay="300">
                  <i class="ri-magic-line"></i>
                  <div>
                    <h4>관람시간</h4>
                    <p><%=info.getRunTime()%>분</p>
                  </div>
                </div>

                <div class="col-md-6 icon-box" data-aos="fade-up" data-aos-delay="400">
                  <i class="ri-command-line"></i>
                  <div>
                    <h4>기간</h4>
                    <p><%=info.getTermDate()%></p>
                  </div>
                </div>

                <div class="col-md-6 icon-box" data-aos="fade-up" data-aos-delay="500">
                  <i class="ri-radar-line"></i>
                  <div>
                    <h4>가격</h4>
                    <p><%=info.getPrice()%></p>
                  </div>
                </div>
                
                 <div class="col-md-12 icon-box" data-aos="fade-up" data-aos-delay="500">
                  <i class="ri-user-line"></i>
                  <div>
                    <h4>출연진</h4>
                    <p><%=info.getCast()%></p>
                  </div>
                </div>
                

              </div>
            </div>

          </div>

        </div><!-- End Feature Icons -->

					<!--  MAP -->
			 <header class="section-header">
          <h2>MAP</h2>
          <p>어디서 혜윰</p>
        </header>

			<div class="map-set" align="center" >
				    <div id="map" style="width:100%;height:50%;"></div>
			    </div>
			    <!--  MAP END -->

      </div>
		<div class="btn-set">
			<a href="/showInfo/list"><button type="button"
					class="btn btn-outline-dark" data-mdb-ripple-color="dark">
					목록으로</button> </a>
		</div>

	</section><!-- End Features Section -->


</main>
<!-- End #main -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a5b44a57b1aeb822a0e594951bbb5406"></script>
<script src="/assets/js/show-custom.js"></script>
<%@include file="/footer.jsp"%>