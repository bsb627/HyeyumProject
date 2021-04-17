<%@page import="movie.model.vo.MovieInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
 	ArrayList<MovieInfo> mList = (ArrayList<MovieInfo>)request.getAttribute("mList");
	
 %>
<%@include file="/admin/header.jsp"%>


<!-- Begin Page Content -->
<main>
<div class="container-fluid">
	<form action="/admin/movieInfo/delete" method="get">
		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">영화 컨텐츠 관리</h1>
		<!--  <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p> -->

		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">영화 정보</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered table-hover" id="dataTable" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th style="text-align: center"><input type="checkbox"
									id="check_all" /></th>
								<!-- <th>포스터</th> -->
								<th>장르</th>
								<th>영화명</th>
								<th>출연진</th>
								<th>감독</th>
								<th>등록일</th>
								<th>조회 및 수정</th>
							</tr>
						</thead>
						<!--      <tfoot>
                                        <tr>
                                            <th>Name</th>
                                            <th>Position</th>
                                            <th>Office</th>
                                            <th>Age</th>
                                            <th>Start date</th>
                                            <th>Salary</th>
                                        </tr>
                                    </tfoot> -->
						<tbody>
							<% for (MovieInfo mInfo : mList) { %>
							<tr>
								<td style="text-align: center"><input type="checkbox"
									class="checked-no" name="info-no" value="<%=mInfo.getInfoNo()%>" /></td>
								<!-- <td>포스터</td> -->
								<td><%= mInfo.getGenre()%></td>
								<td><%= mInfo.getMovieName() %></td>
								<td><%= mInfo.getCast() %></td>
								<td><%= mInfo.getDirector() %></td>
								<td><%= mInfo.getEnrollDate() %></td>
								
								
								
								<td style="text-align: center"><a href="/admin/movieInfo/modify?infoNo=<%=mInfo.getInfoNo()%>"><button type="button" style="color:black;" 
									class="btn btn-outline-warning">수정</button></a></td>
							
									
							</tr>
							<% } %>

							<%-- 수정페이지로 : <a href="/admin/movieInfo/modify?infoNo=<%=mInfo.getInfoNo()%>"></a> --%>

						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="btn-set" align="right">
			<button type="submit" class="btn btn-outline-danger">삭제</button>
			<a href="/admin/movieInfo/write"><button type="button" class="btn btn-outline-primary">등록</button></a>
		</div>
	</form>
</div>

</main>

          
<!-- /.container-fluid -->
<%@include file="/admin/footer.jsp"%>