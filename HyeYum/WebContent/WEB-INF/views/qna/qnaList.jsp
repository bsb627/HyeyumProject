<%@page import="qna.model.vo.Qna"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Qna> qnaList = (ArrayList<Qna>)request.getAttribute("qnaList");
	String pageNavi = (String)request.getAttribute("pageNavi");
%>
<%@include file="/header.jsp"%>
<head>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%
	if (userId == null) {
%>
<script type="text/javascript">
	if (confirm("로그인 후 이용가능합니다.")) {
		location.href="/member/login";
	} else {
		history.back();
	}
</script>
<%
	}
%>

<script>

function msg(e)  {
	 var sendMsgElement = $(e.currentTarget).parent().next();
	 if ( sendMsgElement.css("display") === 'none' ){
		 sendMsgElement.css("display", "block"); 
	} else { 
		 sendMsgElement.css("display", "none"); 
	}
}

function msgPop(receiveId) {
	console.log(receiveId);
	window.open("/message/write/pop?receiveId=" + receiveId , "메시지 보내기", "width=500, height=400"); 
}
</script>
	
  <title>문화나눔, 혜윰 - QnA</title>
<style>

ul{
   list-style:none;
   padding:0;
   margin:0;
   }

</style>
</head>
 <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <ol>
          <li><a href="/index.jsp">Home</a></li>
          <li>마당</li>
        </ol>
        <h2>문의혜윰</h2>

      </div>
    </section><!-- End Breadcrumbs -->

    <section class="inner-page">
      <div class="container">
      	<div align = "center" class="hero-img" data-aos="zoom-out" data-aos-delay="200">
			<img src="/assets/img/qna/qna.jpg" class="img-fluid" alt="">
		</div>
		
		<!--  시작  -->
		

		<div style = "float : right">
			<form class="row g-3" action = "/qna/search" method = "get">
			  <div class="col-auto">
			    <select name = "search-category" class="form-select">
			      	<option value = "USER_ID" >아이디</option>
			      	<option value="TITLE" >제목</option>
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

      		<table class ="table table-hover" style = "text-align : center">
      			<tr>
      				<th>
      				<th>글번호</th>
      				<th>문의분류</th>
      				<th>제목</th>
      				<th>작성자</th>
      				<th>작성일</th>
      				<th>조회수</th>
      			</tr>
      		<% for (Qna qna : qnaList) { %>
      		<tr>
      				
      				<td><%= qna.getQnaNo()%></td>
      				<td><%= qna.getCategory() %> </td>		
      				<td style = "text-align : left">
      				
 					<% if( qna.getStep() !=0) {%>
      				<img src = "/assets/img/qna/qqq.gif"/>
      				<a href="/qna/detail?qnaNo=<%= qna.getQnaNo() %>" ><%= qna.getTitle()%></a>
      				<% } else { %>
      				<a href="/qna/detail?qnaNo=<%= qna.getQnaNo() %>" ><%= qna.getTitle()%></a>
      				<% } %>
      				</td>
   
      				<td>
      					<ul>
							<li><a onclick ="msg(event)"><%= qna.getUserId()%></a></li>
							<li id="sendMsg" style="display:none;" onclick ="msgPop('<%= qna.getUserId() %>')">쪽지보내기</a></li>
							
      					</ul>
						
      				</td>
      				
      				<td><%= qna.getEnrollDate()%></td>
      				<td><%= qna.getHits() %></td>

			</tr>
      		<% } %>
      		</table>
      		<div align = "center"><%= pageNavi %></div>
      		
      		<div style = "float : right">
				<form action = "/question/write" method = "get" >
					<input type = "submit" value = "문의 등록" class ="btn btn-primary mb-3" >
				</form>
			</div>
      	</div>
    </section>

  </main><!-- End #main -->

<%@include file="/footer.jsp"%>