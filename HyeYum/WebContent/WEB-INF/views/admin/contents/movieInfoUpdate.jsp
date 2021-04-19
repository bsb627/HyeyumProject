<%@page import="file.model.vo.FileData"%>
<%@page import="movie.model.vo.MovieInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MovieInfo mInfo = (MovieInfo)request.getAttribute("mInfo");
	FileData file = (FileData)request.getAttribute("file");
%>
<%@include file="/admin/header.jsp"%>
<!-- Begin Page Content -->
<head>
<link href="/assets/admin/css/admin-movie.css" rel="stylesheet">
</head>

<!-- 
                    Page Heading -->
<h1 class="h3 mb-4 text-gray-800 text-center">영화 정보 수정</h1>

<div class="contaioner">
	<form action="/admin/movieInfo/modify" method="post" enctype="multipart/form-data">
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-3"></div>
				<div class="col-lg-3">
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">영화 제목:</label>
						<input type="text" class="form-control" id="recipient-name"
							name="movieName" value="<%=mInfo.getMovieName()%>" required>
					</div>
					<div class="form-group">
						<input type="hidden" id="genre" value="<%=mInfo.getGenre()%>" />
						<label for="recipient-name" class="col-form-label">장르:</label> <select
							class="browser-default custom-select" id="selectGenre"
							name="genre" required>
							<option selected>장르</option>
							<option value="드라마">드라마</option>
							<option value="로맨스">로맨스</option>
							<option value="코믹/액션">코믹/액션</option>
							<option value="SF/판타지">SF/판타지</option>
							<option value="애니메이션">애니메이션</option>
							<option value="스릴러">스릴러</option>
							<option value="기타">기타</option>
						</select>
					</div>
					<!-- <input type="text" class="form-control" id="cast"> -->
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">출연진:</label> <input
							type="text" class="form-control" id="recipient-name" name="cast"
							value="<%=mInfo.getCast()%>" required>
					</div>
				</div>


				<div class="col-lg-3">
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">연출 및
							감독:</label> <input type="text" class="form-control" id="recipient-name"
							name="director" value="<%=mInfo.getDirector()%>" required>
					</div>
					<div class="form-group">
						<input type="hidden" id="ageGroup"
							value="<%=mInfo.getAgeGroup()%>" /> <label for="recipient-name"
							class="col-form-label">관람등급:</label> <select
							class="browser-default custom-select" id="ageGroup"
							name="ageGroup" onchange="SetSelectBox();" required>
							<option selected>관람등급</option>
							<option value="전체관람가">전체관람가</option>
							<option value="12세 이상">12세 이상</option>
							<option value="15세 이상">15세 이상</option>
							<option value="청소년관람불가">청소년관람불가</option>
						</select>
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">소요시간:</label> <input
							type="text" class="form-control" id="recipient-name"
							name="runTime" value="<%=mInfo.getRunTime()%>" required>
					</div>
				</div>
				<div class="col-lg-3"></div>

			</div>

			<div class="col-lg-12">
				<div class="row">
					<div class="col-lg-3"></div>
					<div class="col-lg-6">
						<div class="form-group">
							<label for="exampleFormControlFile1">이미지 업로드</label> <input
								type="file" class="form-control-file" name="up-file"
								id="exampleFormControlFile1" value="<%= mInfo.getFileName() %>">
						</div>
					</div>
					<div class="col-lg-3"></div>
				</div>
			</div>

			<div class="form-group">
				<div class="col-8" style="margin: auto;">
					<div class="container">
						<div class="form-group-lg">
							<label for="message-text" class="col-form-label">시놉시스:</label>
							<textarea class="form-control sys" id="message-text"
								name="synopsis" required><%=mInfo.getSynopsis()%></textarea>
						</div>
					</div>
				</div>
				<br>
				<br>
				<div class="form-group">
					<input type="hidden" name="infoNo" value="<%=mInfo.getInfoNo()%>">
					<div class="btn-set" align="center">
						<a href="/admin/movieInfo/list"><button type="button"
								class="btn btn-secondary">취소</button></a>
						<button type="submit" class="btn btn-primary">수정</button>
					</div>
				</div>
			</div>

		</div>




	</form>

</div>





<!--      </div>
                            </div> -->

<%--   <form action="/movieInfo/modify" method="post">
			<div class="modal-header">
				<h5 class="modal-title" id="modifyModalLabel">영화 정보 수정</h5>
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
                    
                     --%>
<!--      </div>

                </div> -->
<!-- /.container-fluid -->


<%@include file="/admin/footer.jsp"%>