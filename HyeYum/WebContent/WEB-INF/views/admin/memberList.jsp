<%@page import="member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
     ArrayList<Member> mList = (ArrayList<Member>)request.getAttribute("mList");
    %>
    <%@include file="/admin/header.jsp"%>
    <head>
    <!-- <link href="/assets/admin/css/admin-show.css" rel="stylesheet"> -->
    </head>
      <!-- Begin Page Content -->
                <div class="container-fluid">
 				 <form action="/order/delete" method="get">
                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">회원 관리</h1>
                    <!-- <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p> -->

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">회원 정보</h6>
                        </div>
                        <div class="card-body">
                      
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                        	<th>아이디</th>
                                            <th>이름</th>
                                            <th>닉네임</th>
                                            <th>번호</th>
                                            <th>이메일</th>
                                            <th>주소</th>
                                            <th>가입일</th>
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
                                       <% for(Member member : mList) {%>
                                        <tr >
                                        	<td class="show-cursor"><%=member.getUserId()%></td>
                                        	<td class="show-cursor"><%=member.getUserName()%></td>
                                            <td class="show-cursor"><%=member.getUserNick()%></td>
                                            <td class="show-cursor"><%=member.getUserPhone()%></td>
                                            <td class="show-cursor"><%=member.getUserEmail()%></td>
                                            <td class="show-cursor"><%=member.getUserAddress()%></td>
                                            <td class="show-cursor"><%=member.getRegDate()%></td>
                                        </tr>
                                       <%} %>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
			<!-- <div class="btn-set" align="right">
                <button type="submit" class="btn btn-danger">삭제</button>
			</div> -->
                </form>
                
 
                </div>
                <!-- /.container-fluid -->
                
                
                
<%@include file="/admin/footer.jsp"%>
 <!-- <script src="/assets/admin/js/order/contents-update.js"></script> -->