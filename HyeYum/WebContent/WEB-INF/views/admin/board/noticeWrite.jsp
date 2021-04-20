<%@page import="notice.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@include file="/admin/header.jsp"%>


<!-- Begin Page Content -->
<div class="container-fluid">

   <!-- Page Heading -->
   <section>
      <div class="container">
         <h1 class="h3 mb-4 text-gray-800">글쓰기</h1>
         <div class="col-lg-12">
            <form action="/admin/notice/write" method="post">
               <div class="col-lg-12">
                  <div class="row">

                     
                     <div class="col-lg-12">
                        <div class="form-group">
                           <label for="exam1">제목</label> <input type="text"
                              class="form-control" id="exam1" name="title"
                              placeholder="" required>
                        </div>
                     </div>
                  </div>
               </div>

               <div class="col-lg-12">
                  <div class="row">
                     <div class="col-lg-12">
                        <div class="form-group">
                           <label for="exam1">내용</label> <input type="text"
                              class="form-control" id="exam1" name="contents"
                              placeholder="" required>
                        </div>
                     </div>
                     <br>
                    

		</div>
		</div>
			<input type = "submit" value = "등록" class="btn btn-primary">
            </form>
         </div>
      </div>
   </section>
</div>
<!-- /.container-fluid -->
<%@include file="/admin/footer.jsp"%>