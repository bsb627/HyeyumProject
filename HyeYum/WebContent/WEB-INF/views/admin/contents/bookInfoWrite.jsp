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
			<h1 class="h3 mb-4 text-gray-800">도서 정보 등록</h1>
			<div class="col-lg-12">
				<form action="/admin/bookInfo/write" method="post" enctype="multipart/form-data">
					<div class="col-lg-12">
						<div class="row">

							<div class="col-lg-3">
								<div class="form-group">
									<label for="exam1">장르</label> 
									<select	class="browser-default custom-select" id="genre" name="genre" required>
										<option selected>장르 선택</option>
					                    <option value="인문/사회">인문/사회</option>
					                    <option value="소설">소설</option>
					                    <option value="에세이">에세이</option>
					                    <option value="시">시</option>
					                    <option value="자기계발">자기계발</option>
					                    <option value="건강/다이어트">건강/다이어트</option>
					                    <option value="생활/취미">생활/취미</option>
									</select>
								</div>
							</div>
							<div class="col-lg-3">
								<div class="form-group">
									<label for="exam1">책 제목</label> <input type="text"
										class="form-control" id="exam1" name="book-name"
										placeholder="" required>
								</div>
							</div>
						</div>
					</div>

					<div class="col-lg-12">
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<label for="exam1">책 소개</label> <input type="text"
										class="form-control" id="exam1" name="intro"
										placeholder="" required>
								</div>
							</div>
							<br>
							<div class="col-lg-3">	
								<div class="form-group">
									<label for="exam1">출판사</label> 
									<input type="text" class="form-control" id="exam1" name="publisher"	placeholder="" required>
								</div>
							</div>
							<div class="col-lg-3">	
								<div class="form-group">
									<label for="exam1">작가</label> 
									<input type="text"	class="form-control" id="exam1" name="author" placeholder="" required>
								</div>
							</div>
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
						<a href="/admin/bookInfo/list"><input type="button" class="btn btn-warning" value="취소"></a>
						<button type="submit" class="btn btn-primary">등록</button>
					</div>
				</form>
			</div>
		</div>
	</section>
</div>
<!-- /.container-fluid -->
<%@include file="/admin/footer.jsp"%>
