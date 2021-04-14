<%@page import="java.util.ArrayList"%>
<%@page import="qna.model.vo.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	ArrayList<Qna> qnaList = (ArrayList<Qna>)request.getAttribute("qnaList");

%>
    <%@include file="/admin/header.jsp"%>
    
<script type="text/javascript">

/* $(document).ready(function() {
	var inputTags = $("td").find("input[type=checkbox]");
		$(".check-all").on("change", function() {
		    if($(this).is(":checked")) {
		        inputTags.prop("checked", true);
		    }else{
		        inputTags.prop("checked", false);
	    	}
		});
	}); */

</script>
      <!-- Begin Page Content -->
                <div class="container-fluid">
					  <form action = "/admin/qna/delete" method = "get">
                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Tables</h1>
                    <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p>
                           
                                <table class ="table" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                        	<th><input type = "checkbox" class = "check-all" name = "checkbox"></th>
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
						  					<td><input type = "checkbox" value = "<%= qna.getQnaNo() %>" name = "checkbox"></td>
						      				<td><%= qna.getQnaNo()%></td>
						      				<td><%= qna.getCategory() %> </td>
						      				<td>
						      				
						      				<a href="/admin/qna/detail?qnaNo=<%= qna.getQnaNo() %>&family=<%= qna.getFamily() %>" ><%= qna.getTitle()%></a>
						      				
						      				</td>
						      				<td><%= qna.getUserId()%></td>
						      				<td><%= qna.getEnrollDate()%></td>
						      				<td><%= qna.getHits() %></td>
						      				
						      				
						      				
						      				<td>
						      				
						      				<% if(qna.getStep() !=0) {%>
						      				<a href = "/admin/qna/modify?qnaNo=<%= qna.getQnaNo() %>&family=<%= qna.getFamily() %>"><input type = "button" value = "수정" class = "btn btn-success"></a>
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