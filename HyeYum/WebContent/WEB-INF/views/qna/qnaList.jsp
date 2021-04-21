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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script> -->
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" /> -->
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

.box{
   list-style:none;
   padding:0;
   margin:0;
   }
.msgbox {
	
	position : absolute;
	background : white;
	border:1px solid #ddd;
	border-radius: 5px;
	box-shadow: 2px 2px 5px 0 rgba(0, 0, 0, 0.2);
}
.msgbox:hover {
	color: gray !important;
}



a:visited.contents {
	color : gray;
}
a:hover.contents {
	font-weight : bold;
}


/* #kakao {
 	position: fixed;
    width: 50px;
    height: 50px;
    top: 450px;
    right: 10px;
} */
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
    		<div class="container" data-aos="fade-up">
			<header class="section-header">
				<h2>QnA</h2>
				<p class="pcomment">문의 게시판</p>
			</header>
			</div>
    
    
      <div class="container">
      	<div align = "center" class="hero-img" data-aos="zoom-out" data-aos-delay="200">
			<img src="/assets/img/qna/qna.jpg" class="img-fluid" alt="">
		</div>
		
		<!--  시작  -->
<!-- 		<div id="ex1" class="modal" style = "width:500px; height:500px; text-align: center ">
  		<h2>QR코드를 스캔해 주세요</h2>
  
  		<img src = "/assets/img/qna/myqr.jpg" style = "width:300px; height:300px;"><br>
  		<h3 style = "color:orange"><i class="bi bi-person-plus"></i>  문화나눔, 혜윰 고객센터</h3>
  		<a href="#" rel="modal:close"><button class = "btn btn-primary">닫기</button></a>
		</div>
		<p><a href="#ex1" rel="modal:open"><img src = "/assets/img/qna/kakao.jpg" id = "kakao" ></a></p> -->






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
      				<img src = "/assets/img/qna/qnaQQ.png"/>
      				<a class = "contents" href="/qna/detail?qnaNo=<%= qna.getQnaNo() %>" ><%= qna.getTitle()%></a>
      				<% } else { %>
      				<a class = "contents" href="/qna/detail?qnaNo=<%= qna.getQnaNo() %>" ><%= qna.getTitle()%></a>
      				<% } %>
      				</td>
   
      				<td>
      					
      					<ul class = "box">
							<li style = "text-align : left"><a onclick ="msg(event)"><%= qna.getUserId()%></a></li>
							<% if(!qna.getUserId().equals("admin")) {%>
							<li class = "msgbox" id="sendMsg" style="display:none;" onclick ="msgPop('<%= qna.getUserId() %>')">쪽지 보내기</li>
							<% } %>
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