<%@page import="java.util.ArrayList"%>
<%@page import="qna.model.vo.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	Qna qna = (Qna)request.getAttribute("qna");

%>
    <%@include file="/admin/header.jsp"%>
      <!-- Begin Page Content -->
 <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">문의사항 상세보기</h1>
                    <p class="mb-4">문의사항에 답을 잘 하자 </p>
                    <!-- 시작 -->
         <div class="card shadow mb-4">
           <div class="card-header py-3">
             <h6 class="m-0 font-weight-bold text-primary">No.<%= qna.getQnaNo() %>  [<%= qna.getCategory() %>]  <%= qna.getTitle() %></h6>
           </div>
             <div class="card-body">
            작성자 :    <%= qna.getUserId() %> <br>
            작성일자   :   <%= qna.getEnrollDate() %> <br>
            조회수  :    <%= qna.getHits() %><br>
            <hr>
           	<%= qna.getContents() %><br>
            </div>
        </div>
        	<% if (qna.getStep()==0) {%>
            <div class="card mb-4 py-3 border-bottom-primary">
            <div class="card-body">
            <form action = "/admin/qna/write" method = "post">
            <input type = "hidden" value = "<%= qna.getQuestionPwd() %>" name = "qna-pwd">
            <input type = "hidden" value = "<%= qna.getCategory() %>" name = "category">
            <input type = "hidden" value = "<%= qna.getFamily() %>" name = "family">
           	<input type = "hidden" name = "title" class = "form-control">
           	
           	
            답변 : <textarea name = "contents" class = "form-control"></textarea><br><br>
            <input type = "submit" value ="등록" class="btn btn-primary" style = "float : right">
            </form>

			 </div>
            </div>
            <% } %>

            
            

  </div>
<%@include file="/admin/footer.jsp"%>