<%@page import="file.model.vo.FileData"%>
<%@page import="reply.model.vo.Reply"%>
<%@page import="java.util.ArrayList"%>
<%@page import="show.model.vo.ShowReview"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ShowReview review = (ShowReview)request.getAttribute("review");
	String pageNavi = (String)request.getAttribute("pageNavi");
	int totalCount = (int)request.getAttribute("totalCount");
	ArrayList<Reply> replyList = (ArrayList<Reply>)request.getAttribute("replyList");
	int likes = (int)request.getAttribute("likes");
	FileData fileData = (FileData)request.getAttribute("fileData");
%>
<%@include file="/header.jsp"%>
<head>
  <title>문화나눔, 혜윰 - 디테일</title>
  <link href="/assets/css/show-custom.css" rel="stylesheet">
  <script src="/assets/js/show-custom.js"></script>
</head>
 <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <ol>
          <li><a href="/index.jsp">Home</a></li>
          <li>공연</li>
        </ol>
        <h2>관람혜윰</h2>

      </div>
    </section><!-- End Breadcrumbs -->

   <!-- ======= Portfolio Details Section ======= -->
    <section id="portfolio-details" class="portfolio-details blog">
      <div class="container">

        <div class="row gy-4">

          <div class="col-lg-8">
            <div class="portfolio-details-slider swiper-container">
              <div class="swiper-wrapper align-items-center">

             <!--    <div class="swiper-slide">
                  <img src="/assets/img/portfolio/portfolio-1.jpg" alt="">
                </div>

                <div class="swiper-slide">
                  <img src="/assets/img/portfolio/portfolio-2.jpg" alt="">
                </div>

                <div class="swiper-slide">
                  <img src="/assets/img/portfolio/portfolio-3.jpg" alt="">
                </div> -->
                
			<div class="swiper-slide">
	                  <img src="/upload/show/<%=fileData.getFileName() %>" alt="">
	                </div>
              </div>
              <div class="swiper-pagination"></div>
            </div>
          </div>

          <div class="col-lg-4">
            <div class="portfolio-info">
              <h3>정보</h3>
              <ul>
                <li><strong>조회수 </strong>: <%=review.getHits() %></li>
                <li><strong>작성자 </strong>: <%=review.getNick() %></li>
                <li><strong>작성일 </strong>: <%=review.getEnrollDate() %></li>
                <li><strong>SNS 링크</strong>: <a href="#"><%=review.getSnsLink() %></a></li>
                <%if(likes == 0){ %>
                <li><a href="/showReview/plusLikes?no=<%=review.getNo()%>"><button class="btn btn-sm btn-outline-danger"><i class="bi bi-heart"></i> 좋아요</button></a></li>
                <%} else { %>
                <li><a href="/showReview/minusLikes?no=<%=review.getNo()%>"><button class="btn btn-sm btn-outline-danger"><i class="bi bi-heart-fill" style="color:#dc3545"></i> 좋아요 취소</button></a></li>
                <%} %>
              </ul>
            </div>
            <div class="portfolio-description">
              <h2><%=review.getTitle() %></h2>
              <p>
                <%=review.getContents() %>
              </p>
            </div>
          </div>

        </div>
        
               <div class="blog-comments">

              <h4 class="comments-count"><%=totalCount %> Comments</h4>

			<% for(Reply reply : replyList){ %>
			 <div id="comment-1" class="comment"> 
                <div class="d-flex"> 
                  <div class="comment-img"><img src="/assets/img/blog/comments-2.jpg" alt=""></div>
                  <div>
                    <h5><a href="#"><%=reply.getNick() %></a> 
                    <%if(reply.getUserId().equals(userId)){ %>
                    <button class="btn btn-sm btn-outline-success">수정</button> <a href="/reply/delete?replyNo=<%=reply.getReplyNo() %>&reviewNo=<%=reply.getNo() %>&type=show"><button class="btn btn-sm btn-outline-danger">삭제</button></a>
                    <%} %>
                    </h5> 
                    <time datetime="2020-01-01"><%=reply.getEnrollDate() %></time>
                    <p>
                      <%=reply.getContents() %>
                    </p>
                  </div>
                </div>
              </div><!-- End comment #1 -->
			<%} %>
             
					<div class="blog-pagination">
									<ul class="justify-content-center">
										<!-- 	<li><a href="#">1</a></li>
											<li class="active"><a href="#">2</a></li>
											<li><a href="#">3</a></li> -->
										<%=pageNavi%>
									</ul>
								</div>
              <div class="reply-form">
                <h4>댓글</h4>
                <p>댓글만 달아도 기부를 할 수 있습니다. 💌<p>
                <form action="/reply/write">
                 <%--  <div class="row">
                    <div class="col-md-6 form-group">
                      <input name="name" type="text" class="form-control" placeholder="Your Name*" value="<%=userId %>" readonly>
                    </div>
                    <div class="col-md-6 form-group">
                      <input name="email" type="text" class="form-control" placeholder="Your Email*">
                    </div>
                  </div> --%>
				<input type="hidden" name="type" value="show">                
				<input type="hidden" name="review-no" value="<%=review.getNo()%>">                
                  <div class="row">
                    <div class="col form-group">
                      <textarea rows="6" name="comment" class="form-control" placeholder="댓글을 남겨주세요"></textarea>
                    </div>
                  </div>
                  <div align="right">
                  <button type="submit" class="btn btn-reply">등록하기</button>
                  </div>

                </form>
              </div>
					<div class="btn-set">
					<%if(review.getUserId().equals(userId)) {%>
					<a href="/showReview/update?no=<%=review.getNo()%>"><button type="button" class="btn btn-outline-primary" data-mdb-ripple-color="dark">
					  수정
					</button>
					</a>
					<%} %>
					<a href="/showReview/list"><button type="button" class="btn btn-outline-dark" data-mdb-ripple-color="dark">
					  목록으로
					</button>
					</a>
					
					</div>

            </div><!-- End blog comments -->

      </div>
    </section><!-- End Portfolio Details Section -->
  </main><!-- End #main -->

<%@include file="/footer.jsp"%>