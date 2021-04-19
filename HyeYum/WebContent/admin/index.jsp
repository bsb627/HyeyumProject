<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/admin/header.jsp"%>
<%
	
int bookAllCount = (Integer)request.getAttribute("bookAllCount");
int movieAllCount = (Integer)request.getAttribute("movieAllCount");
int showAllCount = (Integer)request.getAttribute("showAllCount");
int memberAllCount = (Integer)request.getAttribute("memberAllCount");
int total =( bookAllCount + movieAllCount + showAllCount ) *1000;

%>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
  google.charts.load('current', {'packages':['corechart']});
  google.charts.setOnLoadCallback(drawChart);

  function drawChart() {
	  
	var bookAllCount = Number('<%= bookAllCount %>');
  	var showAllCount = Number('<%= showAllCount %>');
  	var movieAllCount = Number('<%= movieAllCount %>');

    var data = google.visualization.arrayToDataTable([
      ['Task', 'Hours per Day'],
      ['도서', bookAllCount],
      ['영화', movieAllCount],
      ['공연', showAllCount],
    ]);

    var options = {
      title: '카테고리별 기부금 현황'
    };

    var chart = new google.visualization.PieChart(document.getElementById('piechart'));

    chart.draw(data, options);
  }
</script>
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">현황</h1>
                        
                    </div>

                    <!-- Content Row -->
                    <div class="row">

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                공연 게시글 수</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><%= showAllCount %>개</div>
                                        </div>
                                        <div class="col-auto">
                                           <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                               도서 게시글 수</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><%= bookAllCount %>개</div>
                                        </div>
                                        <div class="col-auto">
                                           <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-info shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">영화 게시글 수
                                            </div>
                                            <div class="row no-gutters align-items-center">
                                                <div class="col-auto">
                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"><%= movieAllCount %>개</div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Pending Requests Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-warning shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                                전체 회원 수</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><%= memberAllCount %>명</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-comments fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        
                        
                         <div class="col-md-12 mb-4">
                            <div class="card border-left-warning shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2" style = "text-align:center">
                                            <div class="text-s font-weight-bold text-warning text-uppercase mb-1" style = "text-align:center">
                                                총 누적 기부금</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><%= String.format("%,d",total ) %>원</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        
                        
                        
                    </div>
             </div>
             <div id="piechart" style="height:500px;"></div>

                <!-- /.container-fluid -->
<%@include file="/admin/footer.jsp"%>
      