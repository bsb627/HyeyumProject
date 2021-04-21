<%@page import="java.util.ArrayList"%>
<%@page import="book.model.vo.BookShare"%>
<%@page import="file.model.vo.FileData"%>
<%@page import="reply.model.vo.Reply"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="book.model.vo.BookShare"%>
<%
	BookShare share = (BookShare)request.getAttribute("share");
	int likes = (int)request.getAttribute("likes"); 
	FileData fileData = (FileData)request.getAttribute("fileData");
	ArrayList<Reply> rList=(ArrayList<Reply>)request.getAttribute("rList");
	int totalCount = (int)request.getAttribute("totalCount");
%>
<html lang="ko">
<%@include file="/header.jsp"%>
    <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <!-- meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"/ -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>문화나눔, 혜윰 - 나눔혜윰 상세보기</title>
    <link href="/assets/css/book/book-custom.css" rel="stylesheet">
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
	
<!--Start Main -->
<section id="portfolio-details" class="portfolio-details blog">
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
                                	<span style='float:right'>
	                                     조회 <%=share.getHits()%> 
	                                </span>
                                </td>
                            </tr>
                            <tr>
                               <td>작성자

                                </td>
                                <td>
									
                               	<%=share.getNick()%> 
                               	<span style='float:right'>
								<%-- <i class="bi bi-eye"> <%=share.getHits()%></i> --%>							
								<%-- <i class="bi bi-chat-square-dots"> <%=share.getReplys() %></i> --%>
									<%if(likes == 0){ %>
									<a href="/bookShare/plusLikes?share-no=<%=share.getNo()%>">
									<i class="bi bi-heart show-icon" style="color: #333"></i></a>
									<%} else { %>
									<a href="/bookShare/minusLikes?share-no=<%=share.getNo()%>">
									<i class="bi bi-heart-fill show-icon" style="color: #dc3545"></i></a> 
									<%}%> <%=likes%>
                                </span>
                                </td>
                            </tr>
                        </tbody>
	                </table>

			<div class="col-lg-12  show-box">
				<div class="portfolio-details-slider swiper-container">
					<div class="swiper-wrapper align-items-center">
						<div class="swiper-slide">
							<img src="/upload/book/<%=fileData.getFileName()%>"  onerror="this.src='/upload/info/book/<%-- <%=file.getFileName()%> --%>'" alt="">
							<p>
								<%=share.getContents()%>
							</p>
						</div>
					</div>
					<!-- <div class="swiper-pagination"></div> -->
				</div>
			</div>
			</div>
			<!-- Start comment #1 -->
			<!-- 좋아요 시작  -->
			       <div class="icon-box" style='float:right'>

					</div>
					</div>
			<!-- 좋아요 끝  -->	
					<div class="reply-box">
						<h6 class="comments-count">
							<strong>댓글 <%=totalCount%>개
							</strong>
						</h6>

						<form action="/bookShareReply/write" method="get">
							<div class="reply-form">
								<!-- <input type="hidden" name="type" value="share"> --> 
								<input type="hidden" name="share-no" value="<%=share.getNo()%>">
								<input type="text" class="form-control " name="comment"	placeholder="댓글달기" required>
								<button type="submit" class="btn btn-reply">
									<small><strong>등록</strong></small>
								</button>
							</div>
						</form>

				 <% for(Reply reply : rList){ %>
						<div id="" class="show-reply">
							<div class="show-contents">
								<h6>
									<a href="#" style="color:#333"><%=reply.getNick() %></a> 
									<small><strong> 
									<%=reply.getContents()%> <time datetime="2020-01-01" style='float:right'><%=share.getEnrollDate()%></time>
									</strong></small>
								</h6>
							</div>
						</div>
						<%} %>

			<!-- 하단 버튼 시작-->
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
			                    <%} %>
								</button></a>
			                    <a href="/bookShare/list"> <button type="button" id="list" class="btn btn-default">목록</button></a>
                           		</span>
                               </td>
                           </tr>
                       </thead>
                   </table>
                   <!-- 하단 버튼 끝 -->
				</div>
	<!-- End Main -->
</section>
<%@include file="/footer.jsp"%>    
