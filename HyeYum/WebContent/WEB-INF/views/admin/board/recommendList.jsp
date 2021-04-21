<%@page import="movie.model.vo.MovieRecommend"%>
<%@page import="movie.model.vo.MovieInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
 	ArrayList<MovieRecommend> mList = (ArrayList<MovieRecommend>)request.getAttribute("mList");
	
 %>
<%@include file="/admin/header.jsp"%>



  
<!-- Begin Page Content -->
<main>
<div class="container-fluid">
	<form action="/admin/recommend/delete" method="get">
		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">추천혜윰 관리</h1>
		<!--  <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p> -->

		<!-- DataTales Example -->
		 <div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">글 목록</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered table-hover" id="dataTable" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th style="text-align: center"><input type="checkbox"
									id="check_all" /></th>
								<th>장르</th>
								<th>제목</th>
								<th>아이디</th>
								<th>작성자</th>
								<th>작성일</th>
								<th></th>
							</tr>
						</thead>
						     <!-- <tfoot>
                                        <tr>
                                            <th>Name</th>
                                            <th>Position</th>
                                            <th>Office</th>
                                            <th>Age</th>
                                            <th>Start date</th>
                                            <th>Salary</th>
                                        </tr>
                                    </tfoot>  -->
						<tbody>
							<% for (MovieRecommend recommend : mList) { %>
							<tr>
								<td style="text-align: center"><input type="checkbox"
									class="checkbox_group" name="rowNo" value="<%=recommend.getRowNo() %>" /></td>
								<!-- <td>포스터</td> -->
								<td><%= recommend.getGenre() %></td>
							 	<td><%= recommend.getTitle() %></td>
								<td><%= recommend.getUserId() %></td>
								<td><%= recommend.getNick() %></td>
								<td><%= recommend.getEnrollDate() %></td>
								<td style="text-align: center"><a href="/admin/recommend/detail?rowNo=<%=recommend.getRowNo()%>"><button type="button" style="color:black;" 
									class="btn btn-outline-warning">상세보기</button></a></td>
							
							</tr>
							<% } %>


							</tbody>
					</table>
				</div>
			</div>
		</div> 
		<div class="btn-set" align="right">
			<button type="submit" class="btn btn-outline-danger">삭제</button>
			<!-- <a href="/admin/movieInfo/write"><button type="button" class="btn btn-outline-primary">등록</button></a> -->
		</div>
	</form>
</div>

</main>

  
<!-- /.container-fluid -->
<%@include file="/admin/footer.jsp"%>
 <script src="/assets/admin/js/show/contents-list.js"></script>