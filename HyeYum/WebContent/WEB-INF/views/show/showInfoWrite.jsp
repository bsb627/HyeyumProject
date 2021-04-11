<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<head>
  <title>문화나눔, 혜윰 - 글쓰기</title>
</head>
 <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <ol>
          <li><a href="/index.jsp">Home</a></li>
          <li>공연</li>
        </ol>
        <h2>관람혜윰</h2>

      </div>
    </section><!-- End Breadcrumbs -->

    <section class="inner-page">
      <div class="container">
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
    </section>

  </main><!-- End #main -->

<%@include file="/footer.jsp"%>