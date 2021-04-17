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
								<th></th>
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
									class="check" name="info-no" value="<%=mInfo.getInfoNo()%>" /></td>
								<!-- <td>포스터</td> -->
								<td><%= mInfo.getGenre()%></td>
								<td><%= mInfo.getMovieName() %></td>
								<td><%= mInfo.getCast() %></td>
								<td><%= mInfo.getDirector() %></td>
								<td><%= mInfo.getEnrollDate() %></td>
								<td style="text-align: center"><button type="button" style="color:black;" 
									class="btn btn-outline-warning" data-toggle="modal" data-target="exampleModalCenter<%= mInfo.getInfoNo() %>>" data-whatever="@fat">수정<%=mInfo.getInfoNo()%> </button></td>
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
			<button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#insertModalLabel" data-whatever="@fat">등록</button>
		</div>
	</form>
</div>

</main>
 
<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".InsertModalLabel" data-whatever="@fat">Open modal for @fat</button> -->

<!--  ================================== 영화정보 등록 ==================================  -->

<div class="modal fade bd-example-modal-lg" id="insertModalLabel"
	tabindex="-1" role="dialog" aria-labelledby="insertModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<form action="/movieInfo/write" method="post">
				<div class="modal-header">
					<h5 class="modal-title" id="insertModalLabel">영화 정보 등록</h5>
					<!-- 영화제목, 장르, 캐스트(배우), 감독, 연령대, 상영소요시간, 줄거리 , 등록일 표기-->
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">
					<div class="col-lg-12">
						<div class="row">
							<div class="col-lg-6">
							<div class="form-group">
								<label for="recipient-name" class="col-form-label">영화 제목:</label> 
								<input type="text" class="form-control" id="recipient-name" name="movieName"> 
								<label for="recipient-name" class="col-form-label">장르:</label>
								 <select class="custom-select" name="genre" required> 
										<option selected>장르</option>
										<option value="드라마">드라마</option>
										<option value="로맨스">로맨스</option>
										<option value="코믹/액션">코믹/액션</option>
										<option value="SF/판타지">SF/판타지</option>
										<option value="애니메이션">애니메이션</option>
										<option value="스릴러">스릴러</option>
										<option value="기타">기타</option>
									</select>
									<!-- <input type="text" class="form-control" id="cast"> -->
								<label for="recipient-name" class="col-form-label">출연진:</label>
								<input type="text" class="form-control" id="recipient-name" name="cast">
							</div>
						</div>

						<div class="col-lg-6">
							<div class="form-group">
								<label for="recipient-name" class="col-form-label">연출 및 감독:</label>
								<input type="text" class="form-control" id="recipient-name" name="director">
								<label for="recipient-name" class="col-form-label">관람등급:</label>
								 <select class="custom-select" name="ageGroup" required>
										<option selected>관람등급</option>
										<option value="전체관람가">전체관람가</option>
										<option value="12세 이상">12세 이상</option>
										<option value="15세 이상">15세 이상</option>
										<option value="청소년관람불가">청소년관람불가</option>
									</select>
								<label for="recipient-name" class="col-form-label">소요시간:</label>
								<input type="text" class="form-control" id="recipient-name" name="runTime">
							</div>
						</div>


						<div class="container">
							<div class="form-group">
								<label for="message-text" class="col-form-label">시놉시스:</label>
								<textarea class="form-control" id="message-text" name="synopsis"></textarea>
							</div>
						</div>


					</div>
				</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary">등록하기</button>
				</div>
			</form>
		</div>
	</div>
</div>

<!--  ================================== 영화정보 등록 end ==================================  -->


<!--  ================================== 영화정보 수정 ==================================  -->
<!-- 
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#updateModal" data-whatever="@fat">이건 등록할 때 ?</button> -->

<%-- <% for(MovieInfo mInfo : mList) { %>

<div class="modal fade bd-example-modal-lg" id="modifyModalLabel<%=mInfo.getInfoNo() %>"
	tabindex="-1" role="dialog" aria-labelledby="modifyModal"
	aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
		<form action="/movieInfo/modify" method="post">
			<div class="modal-header">
				<h5 class="modal-title" id="modifyModal">영화 정보 수정</h5>
				<!-- 영화제목, 장르, 캐스트(배우), 감독, 연령대, 상영시간, 줄거리 , 등록일 표기-->
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="col-lg-12">
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="recipient-name" class="col-form-label">영화
									제목:</label> <input type="text" class="form-control" id="recipient-name"
									name="movieName" value="<%= mInfo.getMovieName()%>"> <label for="recipient-name"
									class="col-form-label">장르:</label> <select
									class="custom-select" name="genre" required>
									<option selected>장르</option>
									<option value="드라마">드라마</option>
									<option value="로맨스">로맨스</option>
									<option value="코믹/액션">코믹/액션</option>
									<option value="SF/판타지">SF/판타지</option>
									<option value="애니메이션">애니메이션</option>
									<option value="스릴러">스릴러</option>
									<option value="기타">기타</option>
								</select>
								<!-- <input type="text" class="form-control" id="cast"> -->
								<label for="recipient-name" class="col-form-label">출연진:</label>
								<input type="text" class="form-control" id="recipient-name"
									name="cast" value="<%= mInfo.getCast()%>">
							</div>
						</div>

						<div class="col-lg-6">
							<div class="form-group">
								<label for="recipient-name" class="col-form-label">연출 및
									감독:</label> <input type="text" class="form-control" id="recipient-name"
									name="director" value="<%= mInfo.getDirector()%>"> 
									<label for="recipient-name" class="col-form-label">관람등급:</label> <select
									class="custom-select" name="ageGroup" required>
									<option selected>관람등급</option>
									<option value="전체관람가">전체관람가</option>
									<option value="12세 이상">12세 이상</option>
									<option value="15세 이상">15세 이상</option>
									<option value="청소년관람불가">청소년관람불가</option>
								</select> <label for="recipient-name" class="col-form-label">소요시간:</label>
								<input type="text" class="form-control" id="recipient-name"
									name="runTime" value="<%= mInfo.getRunTime()%>">
							</div>
						</div>


						<div class="container">
							<div class="form-group">
								<label for="message-text" class="col-form-label">시놉시스:</label>
								<textarea class="form-control" id="message-text" name="synopsis"><%=mInfo.getSynopsis() %>></textarea>
							</div>
						</div>


					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
				<button type="submit" class="btn btn-primary">수정</button>
			</div>
			</form>
		</div>
	</div>
</div>
<% } %> --%>
<!--  ================================== 영화정보 수정 end ==================================  -->

    <!-- Modal -->
    <div>
      <% for(MovieInfo mInfo : mList ) {  %>       
<div class="modal fade" id="exampleModalCenter<%=mInfo.getInfoNo()%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle"><strong>수정수정</strong></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" >
      
   <%--    <div class="container">
      <div class="col-ma-12">
      <div class="row"> 
      <div class="col-md-6">
        <img src="/upload/info/show/<%=file.getFileName() %>" width="100%" class="thumbnail"/>
      </div>
   
      <div class="col-md-6">
      <ul class="list-group">
  <li class="list-group-item active"><strong>공연정보</strong></li>
  <li class="list-group-item"><small>타입</small> <strong><%=info.getType() %></strong></li>
  <li class="list-group-item"><small>지역</small> <strong><%=info.getRegion() %></strong></li>
  <li class="list-group-item"><small>장소</small> <strong><%=info.getPlace() %></strong></li>
  <li class="list-group-item"><small>장르</small> <strong><%=info.getGenre() %></strong></li>
  <li class="list-group-item"><small>관람연령</small> <strong><%=info.getAgeGroup() %></strong></li>
  <li class="list-group-item"><small>관람시간</small> <strong><%=info.getRunTime() %></strong></li>
  <li class="list-group-item"><small>출연진</small> <strong><%=info.getCast() %></strong></li>
  <li class="list-group-item"><small>가격</small> <strong><%=info.getPrice() %></strong></li>
  <li class="list-group-item"><small>기간</small> <strong><%=info.getTermDate() %></strong></li>
</ul>
      
      </div>
      </div>
      </div>
      </div>
        --%>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter<%= mInfo.getInfoNo()%>">수정</button>
      </div>
    </div>
  </div>
</div>
<% } %>
                
                </div>
<!-- /.container-fluid -->
<%@include file="/admin/footer.jsp"%>