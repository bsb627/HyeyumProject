<%@page import="movie.model.vo.MovieInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%
	MovieInfo mInfo = (MovieInfo) request.getAttribute("mInfo");
%> --%>
<%@include file="/admin/header.jsp"%>
<!-- Begin Page Content -->
	<head>
   <link href="/assets/admin/css/admin-movie.css" rel="stylesheet">
   </head>

<!-- 
                    Page Heading -->
<h1 class="h3 mb-4 text-gray-800 text-center">영화 정보 등록</h1>

<div class="contaioner">
	<form action="/admin/movieInfo/write" method="post">
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-3"></div>
				<div class="col-lg-3">
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">영화 제목:</label>
						<input type="text" class="form-control" id="recipient-name"
							name="movieName" required>
					</div>
					<div class="form-group">
						<input type="hidden" id="genre" />
						<label for="recipient-name" class="col-form-label">장르:</label> <select
							class="browser-default custom-select" id="selectGenre" name="genre" required>
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
							required>
					</div>
				</div>


				<div class="col-lg-3">
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">연출 및
							감독:</label> <input type="text" class="form-control" id="recipient-name"
							name="director" required>
					</div>
					<div class="form-group">
					<input type="hidden" id="ageGroup" value="" />
						<label for="recipient-name" class="col-form-label">관람등급:</label> <select
							class="browser-default custom-select" id="ageGroup" name="ageGroup" onchange="SetSelectBox();" required>
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
							name="runTime" required>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-6" style="margin: auto;">
					<div class="container">
						<div class="form-group-lg">
							<label for="message-text" class="col-form-label">시놉시스:</label>
							<textarea class="form-control sys" id="message-text" name="synopsis" required></textarea>
						</div>
					</div>
				</div>
				<br><br>
					<div class="form-group">
					<input type="hidden" name="infoNo"
						value="">
					<div class="btn-set" align="center">
						<a href="/admin/movieInfo/list"><button type="button"
								class="btn btn-secondary">취소</button></a>
						<button type="submit" class="btn btn-primary">등록하기</button>
						</div>
					</div>
				</div>

			</div>
		



	</form>

</div>




<%@include file="/admin/footer.jsp"%>