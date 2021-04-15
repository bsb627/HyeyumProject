<%@page import="book.model.vo.BookShare"%>
<%@page import="file.model.vo.FileData"%>
<%@page import="reply.model.vo.Reply"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="book.model.vo.BookShare"%>
<%
	BookShare share = (BookShare)request.getAttribute("share");
	/* int likes = (int)request.getAttribute("likes"); */
	FileData fileData = (FileData)request.getAttribute("fileData");
%>
<html lang="ko">
<%@include file="/header.jsp"%>
    <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <!-- meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"/ -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>문화나눔, 혜윰 - 나눔혜윰 상세보기</title>

        <!-- Bootstrap -->
        <link href="/assets/css/book/contents.css" rel="stylesheet" type="text/css"/>
        <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
        <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
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
			<h2>나눔혜윰</h2>

		</div>
	</section>
	<!-- End Breadcrumbs -->
    <section>
        <!-- 좌우측의 공간 확보 -->
        <div class="container">
            <hr/>
            <div class="row">
                <div class="col-md-10">
                    <table class="table table-condensed">
                        <thead>
                            <tr align="center">
                                <th width="10%">제목</th>
                                <th width="60%">[<%=share.getRegion()%>] <%=share.getTitle()%></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>작성일
                                </td>
                                <td>
                                <%=share.getEnrollDate()%>
                                </td>
                            </tr>
                            <tr>
                                <td>작성자
                                </td>
                                <td>
                                <%=share.getNick()%> <span style='float:right'>조회 : <%=share.getHits()%></span>
                                </td>
                            </tr>
                        </tbody>
                       </table>
<div class="col-lg-12  show-box">
					<div class="portfolio-details-slider swiper-container">
						<div class="swiper-wrapper align-items-center">
							<div class="swiper-slide">
								
								<img src="/upload/book/<%=fileData.getFileName()%>"  onerror="this.src='/upload/info/book/<%-- <%=file.getFileName()%> --%>'" alt="">
							</div>
						</div>
						<!-- <div class="swiper-pagination"></div> -->
					</div>

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
							<%=share.getContents()%>
						</p>
					</div>

					<div class="reply-box">
						<h6 class="comments-count">
							<strong>댓글 
							<%-- <%=totalCount %>개 --%>
							</strong>
						</h6>

						<%-- <% for(Reply reply : rList){ %> --%>
						<div id="" class="show-reply">
							<div class="">
								<div class="show-contents">
									<h6>
										<strong> <a href="#" style="color:#333"><%-- <%=reply.getNick() %> --%></a> 
										</strong>
										<%-- <%=reply.getContents() %> --%>
									</h6>
								</div>
								
							</div>
						</div>
						<!-- End comment #1 -->
						<%-- <%} %> --%>
						<form action="/reply/write" method="get">
							<div class="reply-form">
								<input type="hidden" name="type" value="show"> <input
									type="hidden" name="review-no" value="<%=share.getNo()%>">
								<input type="text" class="form-control " name="comment"
									placeholder="댓글달기">
								<button type="submit" class="btn btn-reply">
									<small><strong>등록</strong></small>
								</button>
							</div>
						</form>
					</div>


				</div>

                    <table class="table table-condensed">
                        <thead>
                            <tr>
                                <td>
                                    <span style='float:right'>
                    <input type="hidden" name="share-no" value="<%=share.getNo()%>">
					<%-- <%if(review.getUserId().equals(userId)) {%> --%>
					<%if(share.getUserId().equals(userId)) {%>
					<a href="/bookShare/delete?share-no=<%=share.getNo()%>">
					<button type="button" class="btn btn-outline-danger" data-mdb-ripple-color="dark">
					  삭제
					</button>
					</a>
					<%} %>
					<%if(share.getUserId().equals(userId)) {%>
					
					<a href="/bookShare/modify?share-no=<%=share.getNo()%>">
					<button type="button" class="btn btn-outline-primary" data-mdb-ripple-color="dark">
					  수정
					</button></a>
					<%}%>
                    <a href="/bookShare/list"> <button type="button" id="list" class="btn btn-default">목록</button></a>
                            </span>
                                </td>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
            <hr/>
        </div>
        <%@include file="/footer.jsp"%>    
</section>