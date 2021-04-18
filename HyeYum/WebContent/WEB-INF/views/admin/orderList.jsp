<%@page import="order.model.vo.Order"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
     ArrayList<Order> oList = (ArrayList<Order>)request.getAttribute("oList");
    %>
    <%@include file="/admin/header.jsp"%>
    <head>
    <link href="/assets/admin/css/admin-show.css" rel="stylesheet">
    </head>
      <!-- Begin Page Content -->
                <div class="container-fluid">
 				 <form action="/order/delete" method="get">
                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">주문 관리</h1>
                    <!-- <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p> -->

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">주문 정보</h6>
                        </div>
                        <div class="card-body">
                      
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                        	<th style="text-align: center"><input type="checkbox" id="check_all"/></th>
                                        	<th>주문번호</th>
                                            <th>아이디</th>
                                            <th>주문수량</th>
                                            <th>가격</th>
                                            <th>주문날짜</th>
                                            <th>상태</th>
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
                                       <% for(Order order : oList) {%>
                                        <tr >
                                        <td  style="text-align: center"><input type="checkbox" class="checkbox_group" name="order-no" value="<%=order.getOrderNO()%>"/></td>
                                        	<td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=order.getOrderNO()%>" onclick="getSelected('<%=order.getShippingState() %>')"><%=order.getOrderNO()%></td>
                                        	<td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=order.getOrderNO()%>" onclick="getSelected('<%=order.getShippingState() %>')"><%=order.getUserId()%></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=order.getOrderNO()%>" onclick="getSelected('<%=order.getShippingState() %>')"><%=order.getQuantity()%></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=order.getOrderNO()%>" onclick="getSelected('<%=order.getShippingState() %>')"><%=order.getPrice()%></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=order.getOrderNO()%>" onclick="getSelected('<%=order.getShippingState() %>')"><%=order.getOrderDate()%></td>
                                            <td class="show-cursor" data-toggle="modal" data-target="#exampleModalCenter<%=order.getOrderNO()%>" onclick="getSelected('<%=order.getShippingState() %>')"><%=order.getShippingState()%></td>
                                        </tr>
                                       <%} %>
                                        
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
                 <% for(Order order : oList) {%>
<div class="modal fade" id="exampleModalCenter<%=order.getOrderNO()%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle"><strong>주문 번호 <%=order.getOrderNO()%></strong></h5>
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
  <li class="list-group-item"><small>주문번호</small> <strong><%=order.getOrderNO()%></strong></li>
  <li class="list-group-item"><small>주문수량</small> <strong><%=order.getQuantity()%></strong></li>
  <li class="list-group-item"><small>가격</small> <strong><%=order.getPrice()%></strong></li>
  <li class="list-group-item"><small>주문날짜</small> <strong><%=order.getOrderDate()%></strong></li>
  <li class="list-group-item"><small>아이디</small> <strong><%=order.getUserId()%></strong></li>
  <li class="list-group-item"><small>이름</small> <strong><%=order.getUserName()%></strong></li>
  <li class="list-group-item"><small>닉네임</small> <strong><%=order.getNick()%></strong></li>
  <li class="list-group-item"><small>주소</small> <strong><%=order.getAddress()%></strong></li>
  <li class="list-group-item"><small>번호</small> <strong><%=order.getUserPhone()%></strong></li>
  <li class="list-group-item"><small>이메일</small> <strong><%=order.getEmail()%></strong></li>
  <li class="list-group-item"><small>상태</small> <strong><%=order.getShippingState()%></strong></li>
  <li class="list-group-item"><small>상태</small> <select id="selectShipping" name="selectShipping" onchange="chageShipping(<%=order.getOrderNO() %>, this.value)"><option value="주문완료">주문완료</option><option value="배송시작">배송시작</option><option value="배송완료">배송완료</option><option value="주문취소">주문취소</option></select></li>
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
 <script src="/assets/admin/js/order/contents-update.js"></script>