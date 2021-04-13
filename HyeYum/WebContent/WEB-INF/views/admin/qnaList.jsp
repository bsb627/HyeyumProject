<%@page import="java.util.ArrayList"%>
<%@page import="qna.model.vo.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	ArrayList<Qna> list = (ArrayList<Qna>)request.getAttribute("qnaList");

%>
    <%@include file="/admin/header.jsp"%>
      <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Tables</h1>
                    <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>글 번호 </th>
                                            <th>문의분류</th>
                                            <th>제목</th>
                                            <th>작성자</th>
                                            <th>작성일</th>
                                            <th>조회수</th>
                                        </tr>
                                    </thead>
                                    
                                    <tbody>
                                     	<% for (Qna qna : list) { %>
						  				<tr>
						      				<td><%= qna.getQnaNo()%></td>
						      				<td><%= qna.getCategory() %> </td>
						      				<td><a href="/qna/detail?qnaNo=<%= qna.getQnaNo() %>" ><%= qna.getTitle()%></a></td>
						      				<td><%= qna.getUserId()%></td>
						      				<td><%= qna.getEnrollDate()%></td>
						      				<td><%= qna.getHits() %></td>
										</tr>
								      <% } %>
                                    
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->
<%@include file="/admin/footer.jsp"%>