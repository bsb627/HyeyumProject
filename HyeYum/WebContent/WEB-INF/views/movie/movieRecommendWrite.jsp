<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<head>
  <title>문화나눔, 혜윰 - 추천글쓰기</title>
  
</head>
 <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <ol>
          <li><a href="/index.jsp">Home</a></li>
          <li>영화</li>
        </ol>
        <h2>추천혜윰</h2>

      </div>
    </section><!-- End Breadcrumbs -->

    <section class="inner-page">
      <div class="container">
      	<form action = "/question/write" method = "post">
		  <div class="col-12">
		    <label for="title" class="form-label">제목</label>
		    <input type="text" class="form-control" id="title" name = "title">
		  </div>
		  <!-- <div class="col-12">
		    <label for="password" class="form-label">비밀번호</label>
		    <input type="password" class="form-control" id="password" name = "password">
		  </div> -->
		  <div class="col-12">
		    <label for="category" class="form-label">장르</label>
		    <select id="category" class="form-select" name = "category">
		      <option selected>드라마/로맨스</option>
		      <option>판타지/SF</option>
		      <option>스릴러</option>
		      <option>코믹/액션</option>
		      <option>애니메이션</option>
		      <option>기타</option>
		    </select>
		  </div>
		  <div class="col-12">
		    <label for="contents" class="form-label">내용</label>
		    <!-- SmartEditor2 -->
			<div class="jsx-2303464893 editor">
				<div class="fr-box fr-basic fr-top" role="application">
					<div class="fr-wrapper show-placeholder" dir="auto"
						style="overflow: scroll;">
						<textarea name="notice_content" id="smartEditor"
							style="width: 100%; height: 412px;"></textarea>
					</div>
				</div>
			</div>
		  </div>
		  <div class="col-12">
		    <label for="file" class="form-label">첨부파일</label>
		    <input type="file" class="form-control" id="file" name = "file">
		  </div>
		 
		
		  <div class="col-12" > <br>
		    <input type="submit" style = "float : right" class="btn btn-primary" value = "등록">
		  </div>
		</form>
			

		</div>
    </section>

  </main><!-- End #main -->

<%@include file="/footer.jsp"%>