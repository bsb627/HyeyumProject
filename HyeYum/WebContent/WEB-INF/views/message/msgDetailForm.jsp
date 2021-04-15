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
        </ol>
        <h2>보낸쪽지함</h2>
		
      </div>
    </section><!-- End Breadcrumbs -->
 
<!-- ----------------------------시작 --------------------------- -->
    <section class="inner-page">
    <div class="container" align = "center">

	<form action = "#">

	보낸 사람 : <%= message.getSender() %> <br>
	받는 사람 : <%= message.getReceiver() %> <br>
	내용 : <%= message.getContents() %> <br>
	
	<input type = "submit" value = "답장">
	</form>
	
	</div>
    </section>

  </main><!-- End #main -->

<%@include file="/footer.jsp"%>
<script src="/assets/js/qna/qnaList.js"></script>