<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<head>
  <title>문화나눔, 혜윰 - 참여</title>

</head>
 <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <ol>
          <li><a href="/index.jsp">Home</a></li>
          <li>마당</li>
        </ol>
        <h2>참여혜윰</h2>

      </div>
    </section><!-- End Breadcrumbs -->

<section id="portfolio-details" class="portfolio-details">
      <div class="container">

        <div class="row gy-4">

          <div class="col-lg-8">
            <div class="portfolio-details-slider swiper-container">
              <div class="swiper-wrapper align-items-center">

                <div class="swiper-slide">
                  <img src="/assets/img/product/palzzi.png" alt="">
                </div>

                <div class="swiper-slide">
                  <img src="/assets/img/product/palzzi2.jpg" alt="">
                </div>

                <div class="swiper-slide">
                  <img src="/assets/img/product/palzzi3.png" alt="">
                </div>

              </div>
              <div class="swiper-pagination"></div>
            </div>
          </div>

          <div class="col-lg-4">
            <div class="portfolio-info">
              <h3>혜윰 팔찌</h3>
              <ul>
                <li><strong>가격</strong>: 15,000</li>
                <li><strong>재질</strong>: 소가죽 </li>

              </ul>
            </div>
            <div class="portfolio-description">
              <h2>제품 소개</h2>
              <p>
                 <br>
               혜윰 팔찌 구매로 생긴 수익금 전액은<br>
               도움이 필요한 우리 이웃들에게 기부됩니다. <br>
              </p>
            </div>
            
            <div>
            <button class="btn btn-primary col-12"  id="kakao-order" >참여하기</button>
            </div>
            
            
          </div>

        </div>

      </div>
    </section><!-- End Portfolio Details Section -->


  </main><!-- End #main -->

<%@include file="/footer.jsp"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript" src="/assets/js/pay/import-pay.js"></script>
