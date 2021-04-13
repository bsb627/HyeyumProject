<%@page import="file.model.vo.FileData"%>
<%@page import="show.model.vo.ShowInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
     ArrayList<ShowInfo> sList = (ArrayList<ShowInfo>)request.getAttribute("sList");
    ArrayList<FileData> fList = (ArrayList<FileData>)request.getAttribute("fList");
    %>
    <%@include file="/admin/header.jsp"%>
    <head>
    <link href="/assets/admin/css/show-custom.css" rel="stylesheet">
    </head>
      <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">공연 컨텐츠 관리</h1>
                    <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">공연 정보</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                        	<th><input type="checkbox"/></th>
                                        	<th>이미지</th>
                                            <th>타입</th>
                                            <th>지역</th>
                                            <th>공연명</th>
                                            <th>기간</th>
                                            <th>가격</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                   <!--  <tfoot>
                                        <tr>
                                            <th>Name</th>
                                            <th>Position</th>
                                            <th>Office</th>
                                            <th>Age</th>
                                            <th>Start date</th>
                                            <th>Salary</th>
                                        </tr>
                                    </tfoot> -->
                                    <tbody>
                                       <% for(ShowInfo info : sList) {%>
                                        <tr>
                                        <td  style="text-align: center"><input type="checkbox"/></td>
                                        <%for(FileData file : fList){ %>
                                        <%if(info.getInfoNo()==file.getNo()){ %>
                                        	<td style="text-align: center"><img src="/upload/info/show/<%=file.getFileName() %>" height="30px"/></td>
                                        	<%} } %>
                                            <td><%=info.getType() %></td>
                                            <td><%=info.getRegion()%></td>
                                            <td><%=info.getShowName()%></td>
                                            <td><%=info.getTermDate()%></td>
                                            <td><%=info.getPrice() %></td>
                                            <td  style="text-align: center"><button class="btn btn-sm btn-success">수정</button></td>
                                        </tr>
                                       <%} %>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
			<div class="btn-set" align="right">
                <a href=""><button class="btn btn-danger">삭제</button></a> <a href="/admin/showInfo/write"><button class="btn btn-primary">등록</button></a>
			</div>
                </div>
                <!-- /.container-fluid -->
<%@include file="/admin/footer.jsp"%>