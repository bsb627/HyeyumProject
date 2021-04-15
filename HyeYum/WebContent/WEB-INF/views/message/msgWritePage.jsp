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
  <script>

  function close()
  {
    window.open('','_self').close();     
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
        </ol>
        <h2>보낸쪽지</h2>
		
      </div>
    </section><!-- End Breadcrumbs -->
 
<!-- ----------------------------시작 --------------------------- -->
    <section class="inner-page">
    <div class="container" align = "center">

	<form action ="/message/send" method = "post">

	받는 사람 : <input type = "text" name = "receiveId" class = "form-control"><br>
	내용 : <br>
	<textarea name = "contents" class = "form-control" rows ="30"></textarea>
	<input type = "submit" value = "전송" onclick = "close()">
	</form>
	
	</div>
    </section>

  </main><!-- End #main -->

<%@include file="/footer.jsp"%>
<script src="/assets/js/qna/qnaList.js"></script>