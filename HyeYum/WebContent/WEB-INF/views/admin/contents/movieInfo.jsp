<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/admin/header.jsp"%>
      <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">영화 컨텐츠 관리</h1>
                   <!--  <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p> -->

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">영화 정보</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th style="text-align: center"><input type="checkbox" id="check_all"/></th>
                                            <th>포스터</th>
                                            <th>영화명</th>
                                            <th>장르</th>
                                            <th>출연진</th>
                                            <th>감독</th>
                                            <th>관람등급</th>
                                            <th>상영시간</th>
                                            <th>줄거리</th>
                                            <th>등록일</th>
                                        </tr>
                                    </thead>
                               <!--      <tfoot>
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
                                        <tr>
                                            <td>넣을거!</td>
                                            <td>포스터</td>
                                            <td>영화명</td>
                                            <td>장르</td>
                                            <td>출연진</td>
                                            <td>감독</td>
                                            <td>관람등급</td>
                                            <td>상영시간</td>
                                            <td>줄거리</td>
                                            <td>등록일</td>
                                        </tr>
                          <tr>
                                            <td>지울거</td>
                                            <td>포스터222</td>
                                            <td>영화명222</td>
                                            <td>장르222</td>
                                            <td>출연진222</td>
                                            <td>감독222</td>
                                            <td>관람등급222</td>
                                            <td>상영시간222</td>
                                            <td>줄거리222</td>
                                            <td>등록일222</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->
<%@include file="/admin/footer.jsp"%>