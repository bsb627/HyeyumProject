<%@page import="notice.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Notice> nList =  (ArrayList<Notice>)request.getAttribute("nList");
    %>
    <%@include file="/admin/header.jsp"%>
      <!-- Begin Page Content -->
                <div class="container-fluid">
					<form action="/admin/notice/delete" method="get">
                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">공지사항 입니다.</h1>
                    <p class="mb-4"> 공지사항 수정 삭제 등록 제가할게요~!  <a target="_blank"
                            href="https://datatables.net"></a></p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">공지사항! </h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                        <th style="text-align: center"><input type="checkbox"
									id="check_all" /></th>
                                            <th>글번호</th>
                                            <th>제목</th>
                                            <th>작성자</th>
                                            <th>작성일</th>
                                            <th>조회수</th>
                                            
                                        </tr>
                                    </thead>
                                  
                                  
                                    <tbody>
                                    <% for(Notice notice : nList)  { %>
                                        <tr>
                                        
                                              <td  style="text-align: center"><input type="checkbox" class="checkbox_group" name="noticeNo" value="<%=notice.getNoticeNo()%>"/></td>
                                               <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=notice.getNoticeNo()%>"><%=notice.getNoticeNo()%></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=notice.getNoticeNo()%>"><%=notice.getTitle()%></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=notice.getNoticeNo()%>"><%=notice.getUserId()%></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=notice.getNoticeNo()%>"><%=notice.getEnrollDate()%></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=notice.getNoticeNo()%>"><%=notice.getHits()%></td>
                                            <td  style="text-align: center"><a href="/admin/notice/detail?noticeNo=<%=notice.getNoticeNo()%>"><input type="button" class="btn btn-sm btn-success" value="수정"></a></td>
                                              
                                        </tr>
                                            <%} %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
<div class="btn-set" align="right">
               <input type="submit" class="btn btn-danger" value="삭제"><a href="/admin/notice/write"><input type="button" class="btn btn-primary" value="등록"></a>
              <!--  꺼진 submit도 다시보자.. -->
                </div>
                </form>
                </div>
                <!-- /.container-fluid -->
<%@include file="/admin/footer.jsp"%>
 <script src="/assets/admin/js/show/contents-list.js"></script>