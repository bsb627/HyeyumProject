<%@page import="book.model.vo.BookReview"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="book.model.vo.BookReview"%>
<%
	BookReview review = (BookReview)request.getAttribute("review");
%>
<html lang="ko">
<%@include file="/header.jsp"%>
    <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <!-- meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"/ -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>문화나눔, 혜윰 - 독서혜윰 상세보기</title>
    </head>
    <body>
<%
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
%>
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
        <!-- Start Main -->
        <div class="container">
            <hr/>
            <div class="row">
                <div class="col-md-10">
                    <table class="table table-condensed">
                        <thead>
                            <tr align="center">
                                <th width="10%">제목</th>
                                <th width="60%">[<%=review.getDivision()%>] <%=review.getTitle()%></th>
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

			 <div class="portfolio-description">
				<div class="icon-box">
						<%-- <%if(likes == 0){ %> --%>
						<%-- <a href="/showReview/plusLikes?no=<%=share.getNo()%>"><i
							class="bi bi-heart show-icon" style="color: #333"></i></a> --%>
						<%-- <%} else { %> --%>
						<%-- <a href="/showReview/minusLikes?no=<%=share.getNo()%>"><i
							class="bi bi-heart-fill show-icon" style="color: #dc3545"></i></a> --%>
						<%-- <%} %> --%>
				</div>
					<p>
						<%=review.getContents()%>
					</p>
			</div>
				<hr>
                <span class="form-inline" role="form">
                    <strong>
                        댓글
                    </strong>
                            <textarea id="commentParentText" class="form-control col-lg-12" style="width:100%" rows="4"></textarea>
                    </span>
                    <table class="table table-condensed">
                        <thead>
                            <tr>
                                <td>
                                    <span style='float:right'>
                                        <button type="button" id="modify" class="btn btn-default">취소</button>
                                        <button type="button" id="delete" class="btn btn-default">댓글등록</button>
                                    </span>
                                </td>
                            </tr>
                        </thead>
                    </table>
                    <!-- 하단 버튼 시작 -->
                    <table class="table table-condensed">
                        <thead>
                            <tr>
                                <td>
                                    <span style='float:right'>
				                    <input type="hidden" name="review-no" value="<%=review.getNo()%>">
									<%-- <%if(review.getUserId().equals(userId)) {%> --%>
									<%if(review.getUserId().equals(userId)) {%>
									<a href="/bookReview/delete?no=<%=review.getNo()%>">
									<button type="button" class="btn btn-outline-danger" data-mdb-ripple-color="dark">
									  삭제
									</button>
									</a>
									<%} %>
									<%if(review.getUserId().equals(userId)) {%>
									
									<a href="/bookReview/modify?review-no=<%=review.getNo()%>">
									<button type="button" class="btn btn-outline-primary" data-mdb-ripple-color="dark">
									  수정
									</button></a>
									<%}%>
				                    <a href="/bookReview/list"> <button type="button" id="list" class="btn btn-default">목록</button></a>
                           			 </span>
                                </td>
                            </tr>
                        </thead>
                    </table>
                    <!-- 하단 버튼 끝 -->
                </div>
            </div>
            <hr/>
        </div>
        <%@include file="/footer.jsp"%>    
</section>