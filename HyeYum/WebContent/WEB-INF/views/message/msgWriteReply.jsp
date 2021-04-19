<%@page import="java.awt.TrayIcon.MessageType"%>
<%@page import="message.model.vo.Message"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<% 
	String receiveId = (String)request.getAttribute("receiveId");
%>
<head>
  <title>문화나눔, 혜윰 </title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script>
 $(document).ready(function() {
		$("#msg-write-page").submit(function() {

			var contents = $("#contents");
			var receiveId = $("#receiveId");
			if(contents.val() =="") {
				alert("내용을 입력해주세요. ");
				return false;
			}else if (receiveId.val() == "") {
				alert("받는사람을 입력해주세요");
				return false;
			}
			alert("전송하시겠습니까?");
			return true;
		});
	 });
 
 </script>
</head>

 <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <ol>
          <li><a href="/index.jsp">Home</a></li>
          <li>마이페이지</li>
          <li>쪽지</li>
        </ol>
        <h2>쪽지 쓰기</h2>
		
      </div>
    </section><!-- End Breadcrumbs -->
			<section id="services" class="services">

				<div class="container" data-aos="fade-up">
					<div class="inner-page">
						<header class="section-header">
							<h2>Message</h2>
							<p>답장 쓰기</p>
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
										
	<form action ="/message/send/page" method = "post" id ="msg-write-page">
	
	<i class="bi bi-person-fill"></i>  받는 사람 : <%= receiveId %><br>
	<i class="bi bi-chat-left-text"></i>  내용 : <br>
	<textarea name = "contents" class = "form-control" rows ="20" id="contents"> </textarea><br>
	
	<input type = "hidden" name = "receiveId" class = "form-control inline" id="receiveId" value ="<%= receiveId %>">
	<input type = "submit" value = "전송" style = "float: right" class = "btn btn-primary">
	</form>
					
					
					
	         
		

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
