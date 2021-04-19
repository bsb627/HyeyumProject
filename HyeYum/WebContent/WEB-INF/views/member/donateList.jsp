<%@page import="java.awt.TrayIcon.MessageType"%>
<%@page import="message.model.vo.Message"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<% 
	int bookCount = (Integer)request.getAttribute("bookCount");
	int movieCount = (Integer)request.getAttribute("movieCount");
	int showCount = (Integer)request.getAttribute("showCount");
	int total =( bookCount + movieCount + showCount ) *1000;
%>
<head>
  <title>문화나눔, 혜윰 </title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    
    window.onload = function() { 
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
    	var bookCount = Number('<%= bookCount %>');
    	var showCount = Number('<%= showCount %>');
    	var movieCount = Number('<%= movieCount %>');
    	
    	console.log(bookCount);
        var data = google.visualization.arrayToDataTable([
          ['count', 'count per category'],
          ['도서', bookCount],
          ['공연', showCount ],
          ['영화', movieCount ],
        ]);

        var options = {
          title: '분야별 기부금',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }
    }
    </script>
</head>

 <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <ol>
          <li><a href="/index.jsp">Home</a></li>
          <li>마이페이지</li>
          <li>기부</li>
        </ol>
        <h2>기부내역</h2>
		
      </div>
    </section><!-- End Breadcrumbs -->
  <!-- ======= Services Section ======= -->
			<section id="services" class="services">

				<div class="container" data-aos="fade-up">
					<div class="inner-page">
						<header class="section-header">
							<h2>Donate</h2>
							<p>기부내역</p>
						</header> 
 <section id="blog" class="blog" >
							<div class="container" data-aos="fade-up">
								<div class="col-md-12">
									<div class="row">
										<div class="col-md-3">

							<div class="sidebar">
							<div class="sidebar-item recent-posts"> 
								<div class="post-item clearfix">
								<!-- <img src="/assets/img/features.png"> -->
								</div>
								<h3 class="sidebar-title">내정보 <i class="bi bi-person-bounding-box"></i></h3>
								<div class="sidebar-item categories">
									<ul>
										<li><a href="/member/modify">정보수정</a></li>
									</ul>
									<hr>

									<h3 class="sidebar-title">쪽지 <i class="bi bi-envelope"></i></h3>
									<div class="sidebar-item categories">
										<ul>
											<li><a href="/message/write/page">쪽지 쓰기</a></li>
											<li><a href="/message/receivedList">받은 쪽지함</a></li>
											<li><a href="/message/sentList">보낸 쪽지함</a></li>
										</ul>
										<hr>

										<h3 class="sidebar-title">활동 <i class="bi bi-journals"></i></h3>
										<div class="sidebar-item categories">
											<ul>
												<li><a href="/myPost">작성 게시글</a></li>
												<li><a href="/myReply">작성 댓글</a></li>
											</ul>
											<hr>
										</div>
										<!-- End sidebar tags-->

										<h3 class="sidebar-title">주문 <i class="bi bi-credit-card"></i></h3>
										<div class="sidebar-item categories">
											<ul>
												<li><a href="/order/list">주문 내역</a></li>
											</ul>
											<hr>
										</div>
										<!-- End sidebar tags-->
										<h3 class="sidebar-title">기부 <i class="bi bi-gift"></i></h3>
										<div class="sidebar-item categories">
											<ul>
												<li><a href="/donate/list">기부 내역</a></li>
											</ul>
											
										</div>
										<!-- End sidebar tags-->
									</div>
								</div>
								</div>
							</div>
											<!-- End blog sidebar -->
										</div>
										
			<!--============== 여기에 작성하기================================ -->
<div class="col-md-9 info-card">
<article class="entry entry-single col-6" style = "text-align:center; float:left">   
<i class="bi bi-bookmark-heart-fill" style = "font-size : 50px"></i>
<div style = "flot:left">
나의 기부 게시글 수 <br>
<%= bookCount + movieCount + showCount %> 개
</div>

</article>
<article class="entry entry-single col-6" style = "text-align:center; float:left">   
<i class="ri-hand-heart-line" style = "font-size : 50px"></i>
<div style = "flot:left">
나의 총 기부액 <br>
<%= String.format("%,d",total ) %>원
</div>

</article><br>
<br><br><br><br><br><br><br><br><br><br>
<div id="donutchart" style="width: 900px; height: 500px;"></div>
</div>
			<!--============== 여기에 작성하기 끝================================ -->
									</div>
									<!--  end row  -->
								</div>
							</div>
						</section>
<!-- ----------------------------시작 --------------------------- -->
  </div></div>
</section>

  </main><!-- End #main -->

<%@include file="/footer.jsp"%>
