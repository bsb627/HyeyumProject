<%@page import="java.util.ArrayList"%>
<%@page import="qna.model.vo.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	ArrayList<Qna> qnaList = (ArrayList<Qna>)request.getAttribute("qnaList");
%>
<%@include file="/admin/header.jsp"%>
    
<script type="text/javascript">
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
	if( $(".checkbox").is(":checked") == false) {
		alert("삭제할 항목을 선택해 주세요");
		return false;
	}
	alert("삭제하시겠습니까?");
	return true;
});
});
</script>
<style>
a:visited.user{
	font-wieght:normal;
	color : gray;
}
a:link.admin{
	color : gray;	
}
a:visited.admin {
	color : gray;
}

</style>
      <!-- Begin Page Content -->
                <div class="container-fluid">
					  <form action = "/admin/qna/delete" method = "get" id="delete">
                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">QNA</h1>
                   <p class="mb-4">고객문의<a target="_blank"
                            href="https://datatables.net"></a></p>
                           
                                <table class ="table" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                        	<th><input type = "checkbox" id = "check-all" ></th>
                                            <th>글 번호 </th>
                                            <th>문의분류</th>
                                            <th>제목</th>
                                            <th>작성자</th>
                                            <th>작성일</th>
                                            <th>조회수</th>
                                            
                                            <th>수정</th>
                                        </tr>
                                    </thead>
                                    
                                    <tbody>
                                    
                                    
                                     	<% for (Qna qna : qnaList) { %>
						  				<tr>
						  					<td><input type = "checkbox" value = "<%= qna.getQnaNo() %>" name = "checkbox" class="checkbox"></td>
						      				<td><%= qna.getQnaNo()%></td>
						      				<td><%= qna.getCategory() %> </td>
						      				<td>
						      				<% if( qna.getStep() !=0) {%>
      										<img src = "/assets/img/qna/qqq.gif"/>
      										<a class = "admin" href="/admin/qna/detail?qnaNo=<%= qna.getQnaNo() %>&family=<%= qna.getFamily() %>" ><%= qna.getTitle()%></a>
      										<% } else { %>
      										<a class = "user" href="/admin/qna/detail?qnaNo=<%= qna.getQnaNo() %>&family=<%= qna.getFamily() %>" ><%= qna.getTitle()%></a>
      										<% } %>
						      				<%-- <a href="/admin/qna/detail?qnaNo=<%= qna.getQnaNo() %>&family=<%= qna.getFamily() %>" ><%= qna.getTitle()%></a> --%>
						      				</td>
						      				<td><%= qna.getUserId()%></td>
						      				<td><%= qna.getEnrollDate()%></td>
						      				<td><%= qna.getHits() %></td>
						      				
						      				<td>
						      				<% if(qna.getStep() !=0) {%>
						      				<a href = "/admin/qna/modify?qnaNo=<%= qna.getQnaNo() %>&family=<%= qna.getFamily() %>"><input type = "button" value = "수정" class = "btn btn-success btn-sm"></a>
						      				<% } %>
						      				</td>
										</tr>
								      <% } %>
                                    
                                    </tbody>
                                </table>
                                
                                 <div class="btn-set" align="right">
                					<input type="submit" class="btn btn-danger" value = "삭제">
							     </div>
                                </form>
                            </div>
                        
                

                
                <!-- /.container-fluid -->
<%@include file="/admin/footer.jsp"%>