<%@page import="notice.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
 <%Notice notice =(Notice)request.getAttribute("notice"); %> 
<%@include file="/admin/header.jsp"%>


<!-- Begin Page Content -->
<div class="container-fluid">


   
   <!-- ------------------------------------ -->
   
   
     <!-- Page Heading -->
   <section>
      <div class="container">
         <h1 class="h3 mb-4 text-gray-800">수정</h1>
         <div class="col-lg-12">
            <form action="/admin/notice/update" method="post">
               <div class="col-lg-12">
                  <div class="row">
					<input type="hidden" name="noticeNo" value="<%=notice.getNoticeNo() %>">

                     <div class="col-lg-12">
                        <div class="form-group">
                           <label for="exam1">제목</label> <input type="text"
                              class="form-control" id="exam1" name="notice-title"
                              placeholder=""  value="<%=notice.getTitle() %>" required>
                        </div>
                     </div>
                  </div>
               </div>

               <div class="col-lg-12">
                  <div class="row">
                     <div class="col-lg-12">
                        <div class="form-group">
                           <label for="exam1">내용</label> 
                           <textarea name="notice-contents" class="form-control" rows="20" cols=""><%=notice.getContents() %></textarea>


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
   
   <!-- ------------------------------------- -->
   
   
</div>
<!-- /.container-fluid -->
<%@include file="/admin/footer.jsp"%>