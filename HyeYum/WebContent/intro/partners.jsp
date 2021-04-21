<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<head>
<title>문화나눔, 혜윰 - aboutUs</title>

<link href="/assets/css/show-custom.css" rel="stylesheet">
</head>
<main id="main">
	<!-- ======= Breadcrumbs ======= -->
	<section class="breadcrumbs">
		<div class="container">

			<ol>
				<li><a href="/index.jsp">Home</a></li>
				<li>소개</li>
			</ol>
			<h2>혜윰 벗</h2>

		</div>
	</section>
	<!-- End Breadcrumbs -->

	<section class="inner-page contact">
		<div class="container">
			<p>

			
				<!-- ======= Contact Section ======= -->

					<div class="container" data-aos="fade-up">

						

    <!-- ======= Clients Section ======= -->
    <section id="clients" class="clients">
    
    <img src="/assets/img/intro/company.jpg" class="img-fluid" alt="Responsive image">
 

      <div class="container" data-aos="fade-up">

        <header class="section-header">
          <h2>partners</h2>
          <p>함께하는 기업</p>
        </header>

        <div class="clients-slider swiper-container">
          <div class="swiper-wrapper align-items-center">
            <div class="swiper-slide"><img src="/assets/img/clients/client-1.png" class="img-fluid" alt=""></div>
            <div class="swiper-slide"><img src="/assets/img/clients/client-2.png" class="img-fluid" alt=""></div>
            <div class="swiper-slide"><img src="/assets/img/clients/client-3.png" class="img-fluid" alt=""></div>
            <div class="swiper-slide"><img src="/assets/img/clients/client-4.png" class="img-fluid" alt=""></div>
            <div class="swiper-slide"><img src="/assets/img/clients/client-5.png" class="img-fluid" alt=""></div>
            <div class="swiper-slide"><img src="/assets/img/clients/client-6.png" class="img-fluid" alt=""></div>
            <div class="swiper-slide"><img src="/assets/img/clients/client-7.png" class="img-fluid" alt=""></div>
            <div class="swiper-slide"><img src="/assets/img/clients/client-8.png" class="img-fluid" alt=""></div>
          </div>
          <div class="swiper-pagination"></div>
        </div>
      </div>

    </section><!-- End Clients Section -->
<br>
						<header class="section-header">
							<h2>HYEYUM PARTNERS</h2>
							<p>제휴 문의</p>
						</header>

						<div class="col-lg-12" style="background: #fafbff;  padding: 30px;">
							<!--  가로너비 -->
							<form action="/company/enroll" method="post">
								<div class="row gy-4">
									<!--세로간격  -->

									<div class="col-md-5">
										<!-- 칸 길이 조절 -->
										
										<!-- <lable for ="company name">기업명: -->
										<!-- <label for="exampleInputEmail1">Email address</label> -->
										<input type="text" name="company-name" class="form-control"
											placeholder="기업명" required>
									</div>
										<!-- 사업자번호1 -->
									<div class="col-md-6 ">
										<input type="email" class="form-control" name="email"
											placeholder="이메일을 입력해주세요 "  required>  
									</div>
										<!-- 사업자번호2 -->
									<div class="col-md-3">
										<!-- 칸 길이 조절 -->
										<input type="number" name="company-number" class="form-control"
											placeholder="사업자번호"  required>
									</div>
									
									
									<div class="col-md-5">
										<!-- 칸 길이 조절 -->
										<input type="number" name="phone" class="form-control"
											placeholder="전화번호 " required>
									</div>


									<div class="col-md-12">
										<input type="text" class="form-control" name="address"
											placeholder="주소" required>
									</div>

									<div class="col-md-12">
										<textarea class="form-control" name="contents" rows="6"
											placeholder="내용을 입력해주세요" required></textarea>
									</div>

									<div class="col-md-12 text-center">
										

										<button type="submit" class="btn btn-primary">전송</button>
									</div>

								</div>
							</form>

						</div>

					</div>
		</div>
	</section>
	<!-- End Contact Section -->

	

</main>
<!-- End #main -->

<%@include file="/footer.jsp"%>