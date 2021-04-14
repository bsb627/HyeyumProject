<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = (String)session.getAttribute("userId");
%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>문화나눔, 혜윰</title>
  <meta content="" name="description">

  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="/assets/img/favicon.png" rel="icon">
  <link href="/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
  <!-- <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themezs/smoothness/jquery-ui.css"> -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <!-- Vendor CSS Files -->
  <link href="/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="/assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
  <link href="/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="/assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: FlexStart - v1.2.0
  * Template URL: https://bootstrapmade.com/flexstart-bootstrap-startup-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top ">
    <div class="container-fluid container-xl d-flex align-items-center justify-content-between">

      <a href="/index.jsp" class="logo d-flex align-items-center">
        <img src="/assets/img/logo.png" alt="">
        <span>문화나눔, 혜윰</span>
      </a>

      <nav id="navbar" class="navbar">
        <ul>
                  <li class="dropdown"><a href="#counts"><span>소개</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="/intro/aboutUs.jsp">혜윰이란?</a></li>
              <li><a href="/intro/partners.jsp">혜윰 벗</a></li>
              <li><a href="/notice/list">혜윰소식</a></li>
            </ul>
          </li>
           <li class="dropdown"><a href="#portfolio" ><span id="navBook">도서</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="/bookReview/list">독서혜윰</a></li>
              <li><a href="/bookShare/list">나눔혜윰</a></li>
            </ul>
          </li>
		  <li class="dropdown"><a href="#portfolio"><span>영화</span> <i class="bi bi-chevron-down"></i></a>
            <ul> <% if(userId == null) {  %>
              <li><a href="/movieInfo/list">감상혜윰</a></li>
              <% } %>
              <% if (userId != null && userId !="") { %>
              <li><a href="/movieReview/list">감상혜윰</a></li>
              <% } %>
              <li><a href="/movieRecommend/list">추천혜윰</a></li>
            </ul>
          </li>
		 <li class="dropdown"><a href="#portfolio"><span>공연</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="/showInfo/list">언제혜윰</a></li>
              <li><a href="/showReview/list">관람혜윰</a></li>
            </ul>
          </li>
           <li class="dropdown"><a href="#pricing"><span>마당</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="/qna/list">문의혜윰</a></li>
              <li><a href="/intro/product/productForm.jsp">참여혜윰</a></li>
            </ul>
          </li>
          <% if(userId == null) {  %>
          <li><a class="nav-link scrollto" href="/member/login">로그인</a></li>
          <% } %>
          <% if(userId != null && userId !="") { %>
            <li class="dropdown"><a href="#"><span>내정보</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="/member/myInfo">마이페이지</a></li>
              <li><a href="/member/logout">로그아웃</a></li>
            </ul>
          </li>
          <% } %>
          <li><a class="getstarted scrollto" href="#">제휴문의</a></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

    </div>
  </header><!-- End Header -->