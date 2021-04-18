<%@page import="file.model.vo.FileData"%>
<%@page import="book.model.vo.BookInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	BookInfo info = (BookInfo)request.getAttribute("info");
	FileData fileData = (FileData)request.getAttribute("fileData");
%>
<%@include file="/admin/header.jsp"%>


<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<section>
		<div class="container">
			<h1 class="h3 mb-4 text-gray-800">도서 정보 수정</h1>
			<div class="col-lg-12">
				<form action="/admin/bookInfo/write" method="post" enctype="multipart/form-data">

					<div class="col-lg-12">
						<div class="row">
							<div class="swiper-wrapper align-items-center">
								<div class="swiper-slide">
									<img src="/upload/info/book/<%=fileData.getFileName()%>"  <%-- onerror="this.src='/upload/info/book/ --%><%-- <%=file.getFileName()%> --%> alt="">
								</div>
							</div>
							<div class="col-lg-3">
								<div class="form-group">
									<label for="exam1">선택1</label> 
									<select	class="browser-default custom-select" id="info-type" name="info-type" onchange="chnQnaType(this.value)" required>
										<option selected>메뉴 선택</option>
					                    <option value="info">이달의 도서</option>
					                    <option value="genre">장르</option>
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
					<input type="hidden" name="info-no" value="<%=info.getInfoNo()%>">
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
