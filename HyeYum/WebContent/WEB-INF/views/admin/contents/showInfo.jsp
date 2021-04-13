<%@page import="show.model.vo.ShowInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
     ArrayList<ShowInfo> sList = (ArrayList<ShowInfo>)request.getAttribute("sList");
    %>
    <%@include file="/admin/header.jsp"%>
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
                                            <th>타입</th>
                                            <th>장르</th>
                                            <th>지역</th>
                                            <th>공연명</th>
                                            <th>기간</th>
                                            <th>가격</th>
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
                                            <td><%=info.getType() %></td>
                                            <td><%=info.getRegion()%></td>
                                            <td><%=info.getPlace()%></td>
                                            <td><%=info.getShowName()%></td>
                                            <td><%=info.getTermDate()%></td>
                                            <td><%=info.getPrice() %></td>
                                        </tr>
                                       <%} %>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->
<%@include file="/admin/footer.jsp"%>