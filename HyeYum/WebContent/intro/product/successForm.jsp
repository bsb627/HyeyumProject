<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% Date date = new Date(); 



SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
 
Calendar cal = Calendar.getInstance();

%>
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

 <!-- ======= Pricing Section ======= -->
    <section id="pricing" class="pricing">

      <div class="container" data-aos="fade-up">

        <header class="section-header">
          <h2>order</h2>
          <p>주문 완료</p>
        </header>

        <div class="row gy-4" data-aos="fade-left" style="display: flex; justify-content: center;">

          <div class="col-lg-6 col-md-6" data-aos="zoom-in" data-aos-delay="100">
            <div class="box">
              <img src="/assets/img/order/order.jpg" class="img-fluid" alt="">
              <ul>
                <sub>결제일시</sub><li><strong><%= sdf.format(cal.getTime()) %></strong></li>
                <sub>제품명</sub><li><strong>혜윰팔찌</strong></li>
              </ul>
              <div class="price">15,000<span>원</span></div>
              <h3 style="color: #4f52ff;">결제가 완료되었습니다.</h3>
              <a href="/order/list" class="btn-buy">주문 내역으로</a>
            </div>
          </div>

         

        </div>

      </div>

    </section><!-- End Pricing Section -->



  </main><!-- End #main -->

<%@include file="/footer.jsp"%>

