<%@page import="java.awt.TrayIcon.MessageType"%>
<%@page import="message.model.vo.Message"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<%
	Message message = (Message)request.getAttribute("message");
%>
<head>
  <title>문화나눔, 혜윰 </title>
  

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
        <h2>받은 쪽지</h2>
		
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
										
	    <div class="container" align = "center">

<form action = "/message/write/page/re">
       <article class="entry entry-single">   	
			<ul style = "list-style:none; text-align : left; padding : 0; margin:0; color : navy">
                <li  class="info"><i class="bi bi-person"></i>[작성자] <%= message.getSender() %> </li>     
                <li class="info"><i class="bi bi-clock"></i>[날짜]  <%= message.getSendTime() %></li>
			</ul><hr>
             <div style = "padding : 2%" align = "left">
             	<%= message.getContents() %>
              </div>
         </article>
       <input type = "hidden" value  ="<%= message.getSender() %>" name = "receiveId">
      <input type = "submit" value = "답장" class="btn btn-outline-primary" style = "float: right">
</form>
	<br><br><br><br><br>
		<form action = "/message/receivedList">
		<input type = "submit" value = "목록" class="btn btn-primary" style = "float: center">
	</form>
	</div>					

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
