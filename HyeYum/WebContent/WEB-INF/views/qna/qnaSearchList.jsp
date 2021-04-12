<%@page import="qna.model.vo.Qna"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Qna> qnaList = (ArrayList<Qna>)request.getAttribute("searchList");
	String pageNavi = (String)request.getAttribute("pageNavi");
%>
<%@include file="/header.jsp"%>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

	<!-- <script>
	$('#exampleModal').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget) // Button that triggered the modal
		  var recipient = button.data('') // Extract info from data-* attributes
		  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
		  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
		  var modal = $(this)
		  modal.find('.modal-title').text('New message to ' + recipient)
		  modal.find('.modal-body input').val(recipient)
		})
	</script> -->

  <title>문화나눔, 혜윰 - QnA</title>

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
		
		<div class = "col-7" style = "float : left">
		<form action = "/question/write" method = "get" class = "form-inline">
			<input type = "submit" value = "문의 등록" class ="btn btn-primary mb-3" >
		</form>
		</div>
		<div  style = "float : left" class = "col-auto" align = "right">
			<form class="row g-3" class = "form-inline"" action ="/qna/search" method = "get">
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
      				<td><a href="/qna/detail?qnaNum=<%= qna.getQnaNo() %>" ><%= qna.getTitle()%></a></td>
      				<td><%= qna.getUserId()%></td>
      				<td><%= qna.getEnrollDate()%></td>
      				<td><%= qna.getHits() %></td>

			</tr>
      		<% } %>
      		</table>
      		<div align = "center"><%= pageNavi %></div>
      	</div>
      <!--===============================비밀번호 모달 창==========================================  -->
<!-- 
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">비밀번호를 입력해주세요.</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
       <form action = "#" method = "post">
     	 <div class="modal-body form-group" align = "center">
     	 	<img src = "/assets/img/qna/pwd.png">
     	 	<br>
         	<input type="text" class="form-control" id="qna-pwd" name = "qna-pwd">
        <div class="modal-footer">
        	<button type="reset" class="btn btn-secondary" data-dismiss="modal">취소</button>
        	<button type="submit" class="btn btn-primary">확인</button>
        </div>    
       </div>
      </form>  
    </div>
  </div>
</div> -->
      
    </section>

  </main><!-- End #main -->

<%@include file="/footer.jsp"%>