<%@page import="book.model.vo.BookShare"%>
<%@page import="file.model.vo.FileData"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%
     ArrayList<BookShare> rList = (ArrayList<BookShare>)request.getAttribute("rList");
    ArrayList<FileData> fList = (ArrayList<FileData>)request.getAttribute("fList");
    %>
    <%@include file="/admin/header.jsp"%>
    <head>
    <link href="/assets/admin/css/admin-show.css" rel="stylesheet">
    </head>
      <!-- Begin Page Content -->
               
                <div class="container-fluid">
 				 <form action="/admin/share/delete" method="get">
                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">도서 나눔 관리</h1>
                    <!-- <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p> -->

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">후기 정보</h6>
                        </div>
                        <div class="card-body">
                      
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                        	<th style="text-align: center"><input type="checkbox" id="check_all"/></th>
                                            <th>제목</th>
                                            <th>아이디</th>
                                            <th>닉네임</th>
                                            <th>조회수</th>
                                            <th>등록일</th>
                                        	<!-- <th>이미지</th> -->
                                         
                                        </tr>
                                    </thead>

                                    <tbody>
                                       <% for(BookShare re : rList) {%>
                                       <%-- <% if(review.getNo()==file.getNo()){ %> --%>
                                        <tr >
                                        <td  style="text-align: center"><input type="checkbox" class="checkbox_group" name="share-no" value="<%=re.getNo()%>"/></td>
                                        	<td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=re.getNo()%>"><%=re.getTitle() %></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=re.getNo()%>"><%=re.getUserId() %></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=re.getNo()%>"><%=re.getNick()%></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=re.getNo()%>"><%=re.getHits()%></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=re.getNo()%>"><%=re.getEnrollDate()%></td>
                                        <%-- <%for(FileData file : fList){ %>
                                       <%--  	<td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=review.getNo()%>" style="text-align: center"><img src="/upload/book/<%=file.getFileName() %>" height="30px" class="thumbnail" /></td> --%>
                                       <%}%>
                                      	<%-- <%} } %> --%>
                                            
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
			<div class="btn-set" align="right">
                <button type="submit" class="btn btn-danger">삭제</button>
			</div>
                </form>
      <!-- Modal -->
 <% for(BookShare share: rList) {%>
  <%-- <%if(review.getNo()==file.getNo()){ %> --%>
<div class="modal fade" id="exampleModalCenter<%=share.getNo()%>"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<strong><%=share.getTitle()%></strong>
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="container">
					<div class="col-ma-12">
						<div class="row">
							<div class="col-md-6">
								<ul class="list-group">
									<li class="list-group-item active"><strong>후기정보</strong></li>
									<li class="list-group-item"><small>지역</small> <strong><%=share.getRegion()%></strong></li>
									<li class="list-group-item"><small>제목</small> <strong><%=share.getTitle()%></strong></li>
									<li class="list-group-item review-contents"><small>내용</small>
										<strong><%=share.getContents()%></strong></li>
									<li class="list-group-item"><small>아이디</small> <strong><%=share.getUserId()%></strong></li>
									<li class="list-group-item"><small>닉네임</small> <strong><%=share.getNick()%></strong></li>
									<li class="list-group-item"><small>조회수</small> <strong><%=share.getHits()%></strong></li>
									<li class="list-group-item"><small>등록일</small> <strong><%=share.getEnrollDate()%></strong></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>
<%}   %> -
<!--  end modal --> 

                </div>
                <!-- /.container-fluid -->
                
                
                
<%@include file="/admin/footer.jsp"%>
 <script src="/assets/admin/js/show/contents-list.js"></script>




 