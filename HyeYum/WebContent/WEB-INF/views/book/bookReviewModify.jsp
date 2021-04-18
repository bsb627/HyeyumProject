<%@page import="book.model.vo.BookReview"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="book.model.vo.BookReview"%>
<%
	BookReview review = (BookReview)request.getAttribute("review");
%>
<head>
<title>문화나눔, 혜윰 - 독서혜윰 수정하기</title>
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge"/> -->
<!-- meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"/ -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.3.0/mdb.min.css"
	rel="stylesheet" />
<%@include file="/header.jsp"%>
<!-- MDB -->
<link href="/assets/css/show-custom.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/note/summernote-lite.css">

</head>
    
    <body>
    <!-- 로그인 체크는 어차피 디테일 들어오면서 체크하므로 필요없음 -->
<%-- <%
if (userId == null) {
%>
	<script type="text/javascript">
		if (confirm("로그인 후 이용가능합니다.")) {
			location.href="/member/login";
		} else {
			history.back();
		}
	</script>
<%
	}
%> --%>
	<!-- ======= Breadcrumbs ======= -->
	<section class="breadcrumbs">
		<div class="container">

			<ol>
				<li><a href="/index.jsp">Home</a></li>
				<li>도서</li>
			</ol>
			<h2>독서혜윰</h2>

		</div>
	</section>
	<!-- End Breadcrumbs -->
    <section>
        <!-- 좌우측의 공간 확보 -->
        <div class="container">
            <hr/>
			<form action="/bookReview/modify" method="post" enctype="multipart/form-data">
				<div class="row border col-md-12">
					
					<div class="col-md-8">
	                   <select name="info-type" id="info-type" onchange="chnQnaType(this.value)" required>
	                       <option hidden="hidden">-- 메뉴 선택 --</option>
	                       <option value="info">이달의 도서</option>
	                       <option value="genre">장르</option>
	                   </select>
	                   <select name="info-no" id="info-no" >
	                   </select>
					</div>
	
					<div class="col-md-4">
					<label for="InputSubject1">파일첨부</label>
						<input type="text" id="userfile" name="userfile" disabled="">
						<span class="group-span-filestyle input-group-btn" tabindex="0">
							<a href="/file/upload"><span class="glyphicon fa fa-upload"></span></a>
						</span>
					</div>
				
                <div class="col-md-12">
                    <table class="table table-condensed">
                        <thead>
                            <tr align="center">
                                <th width="10%">						
								<label class="form-label" for="review-title">제목</label></th>
                                <th width="60%">
                                <input type="text" id="review-title" class="form-control active" name="review-title" value="<%=review.getTitle()%>"	autocomplete="off" required maxlength="50" /> 
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>작성일
                                </td>
                                <td>
		                        <%=review.getEnrollDate()%>
                                </td>
                            </tr>
                            <tr>
                                <td>작성자
                                </td>
                                <td>
                                <%=review.getNick()%> <span style='float:right'>조회 : <%=review.getHits()%></span>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <textarea id="summernote" name="review-content"><%=review.getContents()%></textarea>
					<br>

                    <table class="table table-condensed">
                        <thead>
                            <tr>
                                <td>
					
                    <span style='float:right'>
					<%-- <%if(review.getUserId().equals(userId)) {%> --%>
						<a href="/bookReview/list"><button type="button"
								class="btn btn-outline-warning" data-mdb-ripple-color="dark">
								취소</button> </a>
						<button type="submit" class="btn btn-outline-primary "
							data-mdb-ripple-color="dark">수정완료</button>
                    </span>
                                </td>
                            </tr>
                        </thead>
                    </table>
                    <input type="hidden" name="review-no" value="<%=review.getNo()%>"/>
                </div>
              </div>
            <hr/>
           </form>
        </div>
</section>
<%@include file="/footer.jsp"%>    
<script src="/assets/js/book/book-write.js"></script>
<script type="text/javascript"	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.3.0/mdb.min.js"></script>
<script src="/assets/note/summernote-lite.js"></script>
<script src="/assets/note//lang/summernote-ko-KR.js"></script>