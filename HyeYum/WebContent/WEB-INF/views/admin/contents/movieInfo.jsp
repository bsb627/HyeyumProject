<%@page import="file.model.vo.FileData"%>
<%@page import="movie.model.vo.MovieInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
 	ArrayList<MovieInfo> mList = (ArrayList<MovieInfo>)request.getAttribute("mList");
	ArrayList<FileData> fList = (ArrayList<FileData>)request.getAttribute("fList");
	
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
								<th>포스터</th> 
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
									class="checkbox_group" name="info-no" value="<%=mInfo.getInfoNo()%>" /></td>
								  <%for(FileData file : fList){ %>
                                 <%if(mInfo.getInfoNo()==file.getNo()){ %>
                                 <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=mInfo.getInfoNo()%>" style="text-align: center"><img src="/upload/info/movie/<%=file.getFileName() %>" height="30px" class="thumbnail"/></td>
                                        	<%} } %>
								<td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=mInfo.getInfoNo()%>"><%= mInfo.getGenre()%></td>
								<td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=mInfo.getInfoNo()%>"><%= mInfo.getMovieName() %></td>
								<td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=mInfo.getInfoNo()%>"><%= mInfo.getCast() %></td>
								<td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=mInfo.getInfoNo()%>"><%= mInfo.getDirector() %></td>
								<td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=mInfo.getInfoNo()%>"><%= mInfo.getEnrollDate() %></td>
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
	
	
	   <!-- Modal -->
                 <% for(MovieInfo mInfo : mList) {%>
                  <%for(FileData file : fList) { %>
                  <%if(mInfo.getInfoNo()==file.getNo()) { %>
<div class="modal fade" id="exampleModalCenter<%=mInfo.getInfoNo()%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle"><strong><%=mInfo.getMovieName() %></strong></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" >
      
      <div class="container">
      <div class="col-ma-12">
      <div class="row"> 
      <div class="col-md-6">
        <img src="/upload/info/movie/<%=file.getFileName() %>" width="100%" class="thumbnail"/>
      </div>
   
      <div class="col-md-6">
      <ul class="list-group">
  <li class="list-group-item active"><strong>공연정보</strong></li>
  <li class="list-group-item"><small>장르</small> <strong><%=mInfo.getGenre() %></strong></li>
  <li class="list-group-item"><small>영화명</small> <strong><%=mInfo.getMovieName() %></strong></li>
  <li class="list-group-item"><small>관람등급</small> <strong><%=mInfo.getAgeGroup() %></strong></li>
  <li class="list-group-item"><small>출연진</small> <strong><%=mInfo.getCast() %></strong></li>
  <li class="list-group-item"><small>감독</small> <strong><%=mInfo.getDirector()%></strong></li>
  <li class="list-group-item"><small>등록일</small> <strong><%=mInfo.getEnrollDate() %></strong></li>

</ul>
      </div>
      </div>
      </div>
      </div>
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
        <a href="/admin/movieInfo/update?infoNo=<%=mInfo.getInfoNo()%>"> <button type="button" class="btn btn-primary">수정</button></a>
      </div>
    </div>
  </div>
</div>
<%} } } %>
	
	
	
	
</div>

</main>

          
<!-- /.container-fluid -->
<%@include file="/admin/footer.jsp"%>
 <script src="/assets/admin/js/show/contents-list.js"></script>