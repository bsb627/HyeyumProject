<%@page import="file.model.vo.FileData"%>
<%@page import="book.model.vo.BookInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
     ArrayList<BookInfo> bList = (ArrayList<BookInfo>)request.getAttribute("bList");
    ArrayList<FileData> fList = (ArrayList<FileData>)request.getAttribute("fList");
    %>
    <%@include file="/admin/header.jsp"%>
    <head>
    <link href="/assets/admin/css/admin-show.css" rel="stylesheet">
    </head>
      <!-- Begin Page Content -->
                <div class="container-fluid">
 				 <form action="/admin/bookInfo/delete" method="get">
                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">도서 컨텐츠 관리</h1>
                    <!-- <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p> -->

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">도서 정보</h6>
                        </div>
                        <div class="card-body">
                      
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                        	<th style="text-align: center"><input type="checkbox" id="check_all"/></th>
                                        	<th>이미지</th>
                                            <th>장르</th>
                                            <th>작가</th>
                                            <th>도서명</th>
                                            <th>소개</th>
                                            <th>출판사</th>
                                            <th></th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                       <% for(BookInfo info : bList) {%>
                                        <tr >
                                        <td  style="text-align: center"><input type="checkbox" class="checkbox_group" name="info-no" value="<%=info.getInfoNo()%>"/></td>
                                        <%for(FileData file : fList){ %>
                                        <%if(info.getInfoNo()==file.getNo()){ %>
                                        	<td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=info.getInfoNo()%>" style="text-align: center"><img src="/upload/info/book/<%=file.getFileName() %>" height="30px" class="thumbnail"/></td>
                                        	<%} } %>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=info.getInfoNo()%>"><%=info.getGenre()%></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=info.getInfoNo()%>"><%=info.getAuthor()%></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=info.getInfoNo()%>"><%=info.getBookName()%></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=info.getInfoNo()%>"><%=info.getIntro()%></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=info.getInfoNo()%>"><%=info.getPublisher()%></td>
                                            <td  style="text-align: center"><a href="/admin/bookInfo/update?info-no=<%=info.getInfoNo()%>"><input type="button" class="btn btn-sm btn-success" value="수정"></a></td>
											
                                            
                                        </tr>
                                       <%} %>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
			<div class="btn-set" align="right">
                <button type="submit" class="btn btn-danger">삭제</button><a href="/admin/bookInfo/write"><input type="button" class="btn btn-primary" value="등록"></a>
			</div>
                </form>
                
                <!-- Modal -->
                 <% for(BookInfo info : bList) {%>
                  <%for(FileData file : fList){ %>
                  <%if(info.getInfoNo()==file.getNo()){ %>
<div class="modal fade" id="exampleModalCenter<%=info.getInfoNo()%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle"><strong><%=info.getBookName() %></strong></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" >
      
      <div class="container">
      <div class="col-ma-12">
      <div class="row"> 
      <div class="col-md-6">
        <img src="/upload/info/book/<%=file.getFileName() %>" width="100%" class="thumbnail"/>
      </div>
   
      <div class="col-md-6">
      <ul class="list-group">
  <li class="list-group-item active"><strong>도서정보</strong></li>
  <li class="list-group-item"><small>장르</small> <strong><%=info.getGenre()%></strong></li>
  <li class="list-group-item"><small>작가</small> <strong><%=info.getAuthor() %></strong></li>
  <li class="list-group-item"><small>도서명</small> <strong><%=info.getBookName() %></strong></li>
  <li class="list-group-item"><small>소개</small> <strong><%=info.getIntro() %></strong></li>
  <li class="list-group-item"><small>출판사</small> <strong><%=info.getPublisher() %></strong></li>
</ul>
      
      </div>
      </div>
      </div>
      </div>
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
        <a href="/admin/bookInfo/update?info-no=<%=info.getInfoNo()%>"> <button type="button" class="btn btn-primary">수정</button></a>
      </div>
    </div>
  </div>
</div>
<%} } } %>
                
                </div>
                <!-- /.container-fluid -->
                
                
                
<%@include file="/admin/footer.jsp"%>
 <script src="/assets/admin/js/show/contents-list.js"></script>