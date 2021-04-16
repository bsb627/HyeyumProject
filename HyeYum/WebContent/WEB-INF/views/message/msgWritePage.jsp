<%@page import="java.awt.TrayIcon.MessageType"%>
<%@page import="message.model.vo.Message"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<% 
	String sendId = (String)request.getAttribute("sendId");
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
 <section id="blog" class="blog" >
							<div class="container" data-aos="fade-up">
								<div class="col-md-12">
									<div class="row">
										<div class="col-md-3">

											<div class="sidebar">


												<h3 class="sidebar-title">쪽지</h3>
												<div class="sidebar-item categories">
													<ul>
														<li><a href="/message/write/page">쪽지 쓰기</a></li>
														<li><a href="/message/receivedList">받은 쪽지함</a></li>
														<li><a href="/message/sentList">보낸 쪽지함</a></li>

													</ul>
													<hr>

													<h3 class="sidebar-title">주문</h3>
													<div class="sidebar-item categories">
														<ul>
															<li><a href="/message/sentList">주문내역</a></li>
														</ul>
														<hr>
													</div>
													<!-- End sidebar tags-->

													<h3 class="sidebar-title">주문</h3>
													<div class="sidebar-item categories">
														<ul>
															<li><a href="/message/sentList">주문내역</a></li>
														</ul>
														<hr>
													</div>
													<!-- End sidebar tags-->

													<h3 class="sidebar-title">주문</h3>
													<div class="sidebar-item categories">
														<ul>
															<li><a href="/message/sentList">주문내역</a></li>
														</ul>
														<hr>
													</div>
													<!-- End sidebar tags-->
													<h3 class="sidebar-title">주문</h3>
													<div class="sidebar-item categories">
														<ul>
															<li><a href="/message/sentList">주문내역</a></li>
															<li><a href="/message/sentList">주문내역</a></li>
														</ul>

													</div>
													<!-- End sidebar tags-->


												</div>
												<!-- End sidebar -->

											</div>
											<!-- End blog sidebar -->
										</div>
										
			<!--============== 여기에 작성하기================================ -->
<div class="col-md-9 info-card">
										
	<form action ="/message/send/page" method = "post" id ="msg-write-page">
	<%-- <i class="bi bi-person"></i>  보내는 사람 : <%= sendId %> <br><br> --%>
	
	<i class="bi bi-person-fill"></i>  받는 사람 : <input type = "text" name = "receiveId" class = "form-control inline" id="receiveId"><br>
	<i class="bi bi-chat-left-text"></i>  내용 : <br>
	<textarea name = "contents" class = "form-control" rows ="20" id="contents"> </textarea><br>
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


  </main><!-- End #main -->

<%@include file="/footer.jsp"%>
