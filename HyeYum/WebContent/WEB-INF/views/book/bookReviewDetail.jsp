<%@page import="reply.model.vo.Reply"%>
<%@page import="java.util.ArrayList"%>
<%@page import="book.model.vo.BookReview"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="book.model.vo.BookReview"%>
<%
	BookReview review = (BookReview)request.getAttribute("review");
	int likes = (int)request.getAttribute("likes"); 
	ArrayList<Reply> rList=(ArrayList<Reply>)request.getAttribute("rList");
	int totalCount = (int)request.getAttribute("totalCount");
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
                                <span style='float:right'>
                                조회 : <%=review.getHits()%>
                                </span>
                                </td>
                            </tr>
                            <tr>
                                <td>작성자
                                </td>
                                <td>
                                <%=review.getNick()%> 
                                <span style='float:right'>
								<%-- <i class="bi bi-eye"> <%=share.getHits()%></i> --%>							
								<%-- <i class="bi bi-chat-square-dots"> <%=share.getReplys() %></i> --%>
								<%if(likes == 0){ %>
								<a href="/bookReview/plusLikes?review-no=<%=review.getNo()%>">
								<i class="bi bi-heart show-icon" style="color: #333"></i></a>
								<%} else { %>
								<a href="/bookReview/minusLikes?review-no=<%=review.getNo()%>">
								<i class="bi bi-heart-fill show-icon" style="color: #dc3545"></i></a> 
								<%}%> <%=totalCount%>
                                </span>
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
					<div class="reply-box">
						<h6 class="comments-count">
							<strong>댓글 <%=totalCount%>개
							</strong>
						</h6>

						<!-- End comment #1 -->
						<form action="/bookReviewReply/write" method="get">
							<div class="reply-form">
								<input type="hidden" name="type" value="review"> 
								<input type="hidden" name="review-no" value="<%=review.getNo()%>">
								<input type="text" class="form-control " name="comment"
									placeholder="댓글달기" required>
								<div class="col-md-12">
								<button type="submit" class="btn btn-light" style='float:right'>
									<small><strong>등록</strong></small>
								</button>
							</div>
						</form>
						<br>
						<span class="post-date">
							<%-- <i class="bi bi-eye"> <%=review.getHits()%></i> --%>							
						</span>
					</div>
					 <% for(Reply reply : rList){ %>
						<div id="" class="show-reply">
							<div class="">
								<div class="show-contents">
									<h6>
										<a href="#" style="color:#333"><%=reply.getNick() %></a> 
										<small><strong> 
										<%=reply.getContents() %> <time datetime="2020-01-01" style='float:right'><%=review.getEnrollDate()%></time>
										</strong></small>
									</h6>
								</div>
								
							</div>
						</div>
						<%} %>
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