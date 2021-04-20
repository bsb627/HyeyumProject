<%@page import="company.model.vo.Company"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
     ArrayList<Company> cList = (ArrayList<Company>)request.getAttribute("cList");
    %>
    <%@include file="/admin/header.jsp"%>
    <head>
    <link href="/assets/admin/css/admin-show.css" rel="stylesheet">
    </head>
      <!-- Begin Page Content -->
                <div class="container-fluid">
 				 <form action="/company/delete" method="get" id="my-form">
                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">기업 관리</h1>
                    <!-- <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p> -->

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">기업 정보</h6>
                        </div>
                        <div class="card-body">
                      
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                        	<th style="text-align: center"><input type="checkbox" id="check_all"/></th>
                                        	<th>회사코드</th>
                                            <th>회사명</th>
                                            <th>사업자번호</th>
                                            <th>번호</th>
                                            <th>주소</th>
                                            <th>이메일</th>
                                            <th>등록일</th>
                                            <th>제휴여부</th>
                                            <th>제휴</th>
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
                                       <% for(Company company : cList) {%>
                                        <tr >
                                        <td  style="text-align: center"><input type="checkbox" class="checkbox_group" name="company-no" value="<%=company.getCompanyCode()%>"/></td>
                                        	<td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=company.getCompanyCode()%>"><%=company.getCompanyCode()%></td>
                                        	<td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=company.getCompanyCode()%>"><%=company.getCompanyName()%></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=company.getCompanyCode()%>"><%=company.getCompanyNumber()%></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=company.getCompanyCode()%>"><%=company.getPhone()%></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=company.getCompanyCode()%>"><%=company.getAddress()%></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=company.getCompanyCode()%>"><%=company.getEmail()%></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=company.getCompanyCode()%>"><%=company.getEnrollDate()%></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=company.getCompanyCode()%>"><%=company.getPartnership()%></td>
                                            <%if(company.getPartnership().equals("N")){ %>
                                            <td class="show-cursor"><a href="/company/modify?state=<%=company.getPartnership()%>&no=<%=company.getCompanyCode()%>"><input type="button" class="btn btn-success" value="승인"></a></td>
                                            <%} else{%>
                                            <td class="show-cursor"><a href="/company/modify?state=<%=company.getPartnership()%>&no=<%=company.getCompanyCode()%>"><input type="button" class="btn btn-danger" value="승인해제" ></a></td>
                                            
                                            <%} %>
                                        </tr>
                                       <%} %>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
			<div class="btn-set" align="right">
                <button type="submit" class="btn btn-danger" id="delete-btn">삭제</button>
			</div>
                </form>
                
                <!-- Modal -->
                 <% for(Company company : cList) {%>
<div class="modal fade" id="exampleModalCenter<%=company.getCompanyCode()%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle"><strong>회사명 <%=company.getCompanyName()%></strong></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" >
      
      <div class="container">
      <div class="col-ma-12">
      <div class="row"> 
   
      <div class="col-md-12">
      <ul class="list-group">
  <li class="list-group-item active"><strong>상세정보</strong></li>
  <li class="list-group-item"><small>회사코드</small> <strong><%=company.getCompanyCode()%></strong></li>
  <li class="list-group-item"><small>회사명</small> <strong><%=company.getCompanyName()%></strong></li>
  <li class="list-group-item"><small>사업자번호</small> <strong><%=company.getCompanyNumber()%></strong></li>
  <li class="list-group-item"><small>번호</small> <strong><%=company.getPhone()%></strong></li>
  <li class="list-group-item"><small>주소</small> <strong><%=company.getAddress()%></strong></li>
  <li class="list-group-item"><small>이메일</small> <strong><%=company.getEmail()%></strong></li>
  <li class="list-group-item"><small>내용</small> <strong><%=company.getContents()%></strong></li>
  <li class="list-group-item"><small>등록일</small> <strong><%=company.getEnrollDate()%></strong></li>
  <li class="list-group-item"><small>제휴여부</small> <strong><%=company.getPartnership()%></strong></li>
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
<%} %>
               <!--  end modal --> 
                </div>
                <!-- /.container-fluid -->
                
                
                
<%@include file="/admin/footer.jsp"%>
 <script src="/assets/admin/js/show/contents-list.js"></script>