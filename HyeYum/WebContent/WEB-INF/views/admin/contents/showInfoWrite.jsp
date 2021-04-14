<%@page import="show.model.vo.ShowInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/admin/header.jsp"%>


<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<section>
		<div class="container">
			<h1 class="h3 mb-4 text-gray-800">공연 등록</h1>
			<div class="col-lg-12">
				<form action="/admin/showInfo/write" method="post" enctype="multipart/form-data">

					<div class="col-lg-6">
						<div class="form-group">
							<label for="exam1">구분</label><br>

							<div class="btn-group btn-group-toggle" data-toggle="buttons">
								<label class="btn btn-primary"> <input type="radio"
									name="type" id="jb-radio-1" value="연극" required> 연극
								</label> <label class="btn btn-primary"> <input type="radio"
									name="type" id="jb-radio-2" value="콘서트" required> 콘서트
								</label> <label class="btn btn-primary"> <input type="radio"
									name="type" id="jb-radio-3" value="뮤지컬" required> 뮤지컬
								</label> <label class="btn btn-primary"> <input type="radio"
									name="type" id="jb-radio-3" value="마술" required> 마술
								</label> <label class="btn btn-primary"> <input type="radio"
									name="type" id="jb-radio-3" value="클래식" required> 클래식
								</label> <label class="btn btn-primary"> <input type="radio"
									name="type" id="jb-radio-3" value="스포츠" required> 스포츠
								</label>
							</div>
						</div>
					</div>



					<div class="col-lg-12">
						<div class="row">

							<div class="col-lg-3">
								<div class="form-group">
									<label for="exam1">지역</label> <select
										class="browser-default custom-select" name="region" required>
										<option selected>지역</option>
										<option value="서울">서울</option>
										<option value="인천">인천</option>
										<option value="경기">경기</option>
										<option value="대전">대전</option>
										<option value="부산">부산</option>
										<option value="제주">제주</option>
									</select>
								</div>
							</div>

							<div class="col-lg-3">
								<div class="form-group">
									<label for="exam1">관람등급</label> <select
										class="browser-default custom-select" name="age-group" required>
										<option selected>등급</option>
										<option value="전체관람가">전체관람가</option>
										<option value="12세 이상">12세 이상</option>
										<option value="15세 이상">15세 이상</option>
										<option value="청소년관람불가">청소년관람불가</option>
									</select>
								</div>
							</div>
							<div class="col-lg-3">
								<div class="form-group">
									<label for="exam1">관람시간(분)</label> <input type="number"
										class="form-control" id="exam1" name="run-time"
										placeholder="" required>
								</div>
							</div>

							<div class="col-lg-3">
								<div class="form-group">
									<label for="exam1">가격</label> <input type="number"
										class="form-control" id="exam1" name="price"
										placeholder="" required>
								</div>
							</div>


						</div>
					</div>

					<div class="col-lg-12">
						<div class="row">



							<div class="col-lg-6">
								<div class="form-group">
									<label for="exam1">출연진</label> <input type="text"
										class="form-control" id="exam1" name="cast"
										placeholder="" required>
								</div>
							</div>

							<div class="col-lg-3">

								<div class="form-group">
									<label for="exam1">시작 기간</label> <input type="date"
										class="form-control" id="exam1" name="start-date"
										placeholder="" required>
								</div>

							</div>

							<div class="col-lg-3">

								<div class="form-group">
									<label for="exam1">종료 기간</label> <input type="date"
										class="form-control" id="exam1" name="end-date"
										placeholder="" required>
								</div>

							</div>
						</div>
					</div>
					
					<div class="col-lg-12">
						<div class="row">



							<div class="col-lg-6">
								<div class="form-group">
									<label for="exam1">장르</label> <input type="text"
										class="form-control" id="exam1" name="genre"
										placeholder="" required>
								</div>
							</div>
							
							<div class="col-lg-6">
								<div class="form-group">
									<label for="exam1">장소</label> <input type="text"
										class="form-control" id="exam1" name="place"
										placeholder="" required>
								</div>
							</div>
							

							</div>
						</div>
					

					<div class="col-lg-12">
						<div class="form-group">
							<label for="exam1">공연 제목</label> <input type="text"
								class="form-control" id="exam1" name="show-name" placeholder="" required>
						</div>
					</div>

					<div class="col-lg-12">
						<div class="form-group">
							<label for="exampleFormControlFile1">이미지 업로드</label> <input
								type="file" class="form-control-file" name="up-file"
								id="exampleFormControlFile1" required>
						</div>
					</div>
					<div class="btn-set" align="right">
						<a href="/admin/showInfo/list"><input type="button" class="btn btn-warning" value="취소"></a>
						<button type="submit" class="btn btn-primary">등록</button>
					</div>
				</form>
			</div>
		</div>
	</section>
</div>
<!-- /.container-fluid -->
<%@include file="/admin/footer.jsp"%>