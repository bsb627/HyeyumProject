<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="book.model.vo.BookReview"%>
<%
	BookReview review = (BookReview)request.getAttribute("review");
%>
<html lang="ko">
    <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <!-- meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"/ -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>문화나눔, 혜윰 - 관람혜윰</title>

        <!-- Bootstrap -->
        <link href="/assets/css/book/contents.css" rel="stylesheet" type="text/css"/>
        <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
        <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
    </head>
    <body>
<%@include file="/header.jsp"%>
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
        <!-- 좌우측의 공간 확보 -->
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
                            <tr>
                                <td colspan="2">
                                    <%=review.getContents()%>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <table id="commentTable" class="table table-condensed"></table>
                    <table class="table table-condensed">
                        <tr>
                            <td>
                                <span class="form-inline" role="form">
                                    <p>
<!--                                         <div class="form-group">
                                            <input type="text" id="commentParentName" name="commentParentName" class="form-control col-lg-2" data-rule-required="true" placeholder="이름" maxlength="10">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" id="commentParentPassword" name="commentParentPassword" class="form-control col-lg-2" data-rule-required="true" placeholder="패스워드" maxlength="10">
                                        </div> -->
<!--                                         <div class="form-group">
                                            <button type="button" id="commentParentSubmit" name="commentParentSubmit" class="btn btn-default">확인</button>
                                        </div> -->
                                        댓글
                                    </p>
                                        <textarea id="commentParentText" class="form-control col-lg-12" style="width:100%" rows="4"></textarea>
                                </span>
                            </td>
                        </tr>
                    </table>
                    <table class="table table-condensed">
                        <thead>
                            <tr>
                                <td>
                                    <span style='float:right'>
                                        <button type="button" id="modify" class="btn btn-default">취소</button>
                                        <button type="button" id="delete" class="btn btn-default">댓글등록</button>
                                       <a href="/bookReview/list"> <button type="button" id="list" class="btn btn-default">목록</button></a>
                                        <!-- <button type="button" id="write" class="btn btn-default">글쓰기</button>  -->
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
    </body>
</html>