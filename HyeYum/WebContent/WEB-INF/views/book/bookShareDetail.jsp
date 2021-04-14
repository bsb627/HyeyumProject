<%@page import="book.model.vo.BookShare"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="book.model.vo.BookShare"%>
<%
	BookShare share = (BookShare)request.getAttribute("share");
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
                            <tr>
                                <td colspan="2">
                                    <%=share.getContents()%>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                        <tr>
                            <td>
                                <span class="form-inline" role="form">
                                    <p>
                                        댓글
                                    </p>
                                        <textarea id="commentParentText" class="form-control col-lg-12" style="width:100%" rows="4"></textarea>
                                </span>
                            </td>
                        </tr>
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
                                       <table class="table table-condensed">
                        <thead>
                            <tr>
                                <td>
                                    <span style='float:right'>
                    <input type="hidden" name="share-no" value="<%=share.getNo()%>">
					<%-- <%if(review.getUserId().equals(userId)) {%> --%>
					<%if(share.getUserId().equals(userId)) {%>
					<a href="/bookShare/delete?no=<%=share.getNo()%>">
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