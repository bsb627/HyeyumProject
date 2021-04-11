<%@page import="show.model.vo.ShowReview"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ShowReview review = (ShowReview)request.getAttribute("review");
%>
<%@include file="/header.jsp"%>
<head>
  <title>문화나눔, 혜윰 - 디테일</title>
</head>
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
    </section><!-- End Breadcrumbs -->

   <!-- ======= Portfolio Details Section ======= -->
    <section id="portfolio-details" class="portfolio-details">
      <div class="container">

        <div class="row gy-4">

          <div class="col-lg-8">
            <div class="portfolio-details-slider swiper-container">
              <div class="swiper-wrapper align-items-center">

                <div class="swiper-slide">
                  <img src="/assets/img/portfolio/portfolio-1.jpg" alt="">
                </div>

                <div class="swiper-slide">
                  <img src="/assets/img/portfolio/portfolio-2.jpg" alt="">
                </div>

                <div class="swiper-slide">
                  <img src="/assets/img/portfolio/portfolio-3.jpg" alt="">
                </div>

              </div>
              <div class="swiper-pagination"></div>
            </div>
          </div>

          <div class="col-lg-4">
            <div class="portfolio-info">
              <h3>정보</h3>
              <ul>
                <li><strong>조회수 </strong>: <%=review.getHits() %></li>
                <li><strong>작성자 </strong>: <%=review.getNick() %></li>
                <li><strong>작성일 </strong>: <%=review.getEnrollDate() %></li>
                <li><strong>SNS 링크</strong>: <a href="#"><%=review.getSnsLink() %></a></li>
              </ul>
            </div>
            <div class="portfolio-description">
              <h2><%=review.getTitle() %></h2>
              <p>
                <%=review.getContents() %>
              </p>
            </div>
          </div>

        </div>

      </div>
    </section><!-- End Portfolio Details Section -->
  </main><!-- End #main -->

<%@include file="/footer.jsp"%>