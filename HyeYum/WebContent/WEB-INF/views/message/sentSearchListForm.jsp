<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.awt.TrayIcon.MessageType"%>
<%@page import="message.model.vo.Message"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<%
ArrayList<Message> searchList = (ArrayList<Message>)request.getAttribute("searchList");
String pageNavi = (String)request.getAttribute("pageNavi");
SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
%>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
$("#check-all").on("click", function () {
	  var checked = $(this).is(":checked");
	
	  if(checked){
	  	$(".checkbox").prop("checked", true);
	  } else {
	  	$(".checkbox").prop("checked", false);
	  }
	});
	
$("#delete").submit(function() {
	alert("삭제하시겠습니까?");
	return true;
});

$("#cancel").submit(function() {
	alert("전송을 취소 하시겠습니까?");
});
});
</script>
<style>

a:link.contents {
	color : navy;
}
a:visited.contents {
	color : gray;
}
a:hover.contents {
	font-weight : bold;
}

</style>


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
        <h2>보낸 쪽지함</h2>
		
      </div>
    </section><!-- End Breadcrumbs -->
 <!-- ======= Services Section ======= -->
			<section id="services" class="services">

				<div class="container" data-aos="fade-up">
					<div class="inner-page">
						<header class="section-header">
							<h2>Message</h2>
							<p>보낸 쪽지 검색 결과</p>
						</header> 
						
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
									
			<div style = "float : right">
			<form class="row g-3" action = "/message/search/received" method = "get">
			  <div class="col-auto">
			    <select name = "search-category" class="form-select">
			      	<option value = "RECEIVER" >아이디</option>
			      	<option value= "CONTENTS" >내용</option>
			    </select>
			  </div>
			  <div class="col-auto">
			    <label class="visually-hidden"></label>
			    <input type="text" class="form-control" name="search-keyword">
			  </div>
			  <div class="col-auto">
			    <input type="submit" class="btn btn-primary mb-3" value = "검색" >
			  </div>
			</form>
      	</div>								
									
									
									
										
    <div class="container" align = "center">
    <form action = "/message/delete/sent" method = "get" id="delete">
    <table class = "table" style = "text-align:center">
    	<tr>
    		<th><input type = "checkbox" id="check-all"></th>
    		<th>내용</th>
    		<th>받는 사람</th>
    		<th>보낸 날짜</th>
    		<th>읽음 여부</th>
    	</tr>
    	
    	<% for( Message message : searchList) {%>
    		<tr>
    			<td><input type = "checkbox" class ="checkbox" name = "checkbox" value = "<%= message.getMessageNo() %>">
    			<td>
    			<% if (message.getContents().length() > 30) { %>
    			<a class="contents" href = "/message/detail/sent?msgNo=<%= message.getMessageNo() %>">
    			<%= message.getContents().substring(0,30) %>  ...</a>
    			<% } else {%>
    			<a class="contents" href = "/message/detail/sent?msgNo=<%= message.getMessageNo() %>">
    			<%= message.getContents() %></a>
    			<% } %>
    			</td>
    			<td><%= message.getReceiver() %></td>
    			<td><%= format1.format(message.getSendTime()) %></td>
    			<td>
    			<% if( message.getReadState().equals("읽음") ) {%>
      					<i class="bi bi-envelope-open"></i>
      				<% } else { %>
      					<i style = "color : navy" class="bi bi-envelope"></i>
      				<% } %>
    			
    			</td>
    		</tr>
    	<% } %>
    
    </table>
   <input type = "hidden" value = "MESSAGE" name = "table">
   <input type = "submit" value="삭제" class = "btn btn-danger" style = "float:right">
   </form>

    <div align = "center"><%= pageNavi %></div>
    
	</div>
										

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