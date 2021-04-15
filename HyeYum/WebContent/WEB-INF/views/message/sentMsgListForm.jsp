<%@page import="java.awt.TrayIcon.MessageType"%>
<%@page import="message.model.vo.Message"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<%
ArrayList<Message> sentMsgList = (ArrayList<Message>)request.getAttribute("sentMsgList");
String pageNavi = (String)request.getAttribute("pageNavi");
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
    <table class = "table">
    	<tr>
    		<th><input type = "checkbox" name = "msg-check"></th>
    		<th>내용</th>
    		<th>받는 사람</th>
    		<th>보낸 날짜</th>
    		<th>읽음 여부</th>
    	</tr>
    	
    	<% for( Message message : sentMsgList) {%>
    		<tr>
    			<td><input type = "checkbox" name = "msg-check">
    			<td>
    			<a href = "/message/detail?msgNo=<%= message.getMessageNo() %>">
    			<%= message.getContents() %></a>
    			</td>
    			<td><%= message.getReceiver() %></td>
    			<td><%= message.getSendTime() %></td>
    			<td><%= message.getReadState() %></td>
    		</tr>
    	<% } %>
    
    </table>
    <div align = "center"><%= pageNavi %></div>
    
	</div>
    </section>

  </main><!-- End #main -->

<%@include file="/footer.jsp"%>
<script src="/assets/js/qna/qnaList.js"></script>