<%@page import="java.util.ArrayList"%>
<%@page import="qna.model.vo.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	Qna qna = (Qna)request.getAttribute("qna"); //나 
	Qna parentQna = (Qna)request.getAttribute("parentQna");
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
            [작성자]<%= parentQna.getUserId() %> <br>
            [작성일자]<%= parentQna.getEnrollDate() %> <br>
            [조회수] <%= parentQna.getHits() %><br>
            <hr>
           	<%= parentQna.getContents() %><br>
            </div>
        </div>
            <div class="card mb-4 py-3 border-left-info">
            <div class="card-body">
            <form action = "/admin/qna/modify" method = "post">

            <input type = "hidden" value = "<%= qna.getQnaNo() %>" name = "qnaNo">		          	
            답변 : <textarea name = "contents" class = "form-control" name = "contents"><%= qna.getContents() %></textarea><br><br>
            <input type = "submit" value ="수정" class="btn btn-info" style = "float : right">
            </form>

			 </div>
            </div>

            
            

  </div>
<%@include file="/admin/footer.jsp"%>