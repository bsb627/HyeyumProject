<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Member member = (Member) request.getAttribute("member");
%>

<title><%=member.getUserName()%> 님 상세 정보</title>
<%@include file="/header.jsp"%>
<!-- ======= Breadcrumbs ======= -->
<main id="main">
	<section class="breadcrumbs">
		<div class="container">

			<ol>
				<li><a href="/index.jsp">Home</a></li>
				<li>내 정보</li>
			</ol>
			<h2>회원 정보 수정</h2>

		</div>
	</section>
	<!-- End Breadcrumbs -->

	<section class="inner-page">
		<div class="container">
			<header class="section-header">
				<h2>MY INFORMATION</h2>
				<p>회원 정보 수정</p>
			</header>
			<form action="/member/modify" method="post">
				<p name="userId">
					아이디 :
					<%=member.getUserId()%></p>
			</form>
		</div>

		<!-- ======= Blog Section ======= -->


		<section id="blog" class="blog">
			<div class="container" data-aos="fade-up">

				<div class="row">
					<div class="col-8" style="margin: auto;">

						<article class="entry">

								<!-- ============ 폼 내용 ============= -->
							<h2 class="entry-title">
								<a href="blog-single.html">여기에다 뭐 적을깡</a></h2>


							<div class="form-group">
								<fieldset disabled="">
									<label class="control-label" for="disabledInput">아이디
										</label> <input class="form-control" id="disabledInput"
										type="text" placeholder="<%= member.getUserId() %>" disabled="">
								</fieldset>
							</div>
							<hr>
							
							<div class="form-group">
								<fieldset disabled="">
									<label class="control-label" for="disabledInput"><p>이름</p>
										</label> <input class="form-control" id="disabledInput"
										type="text" placeholder="<%= member.getUserName() %>" disabled="">
								</fieldset>
							</div>
							<hr>
							<div class="form-group">
								<fieldset>
									<label class="control-label" for="readOnlyInput">Readonly
										input</label> <input class="form-control" id="readOnlyInput"
										type="text" placeholder="Readonly input here..." readonly="">
								</fieldset>
							</div>

							<div class="form-group has-success">
								<label class="form-control-label" for="inputValid">Valid
									input</label> <input type="text" value="correct value"
									class="form-control is-valid" id="inputValid">
								<div class="valid-feedback">Success! You've done it.</div>
							</div>

							<div class="form-group has-danger">
								<label class="form-control-label" for="inputInvalid">Invalid
									input</label> <input type="text" value="wrong value"
									class="form-control is-invalid" id="inputInvalid">
								<div class="invalid-feedback">Sorry, that username's
									taken. Try another?</div>
							</div>

							<div class="form-group">
								<label class="col-form-label col-form-label-lg" for="inputLarge">Large
									input</label> <input class="form-control form-control-lg" type="text"
									placeholder=".form-control-lg" id="inputLarge">
							</div>

							<div class="form-group">
								<label class="col-form-label" for="inputDefault">Default
									input</label> <input type="text" class="form-control"
									placeholder="Default input" id="inputDefault">
							</div>

							<div class="form-group">
								<label class="col-form-label col-form-label-sm" for="inputSmall">Small
									input</label> <input class="form-control form-control-sm" type="text"
									placeholder=".form-control-sm" id="inputSmall">
							</div>



							<div class="entry-content" style="text-align: center">
								<div class="out">
									<br>
									<p><strong> 상기와 같이 <%=member.getUserId()%> 님의 정보를
											변경합니다.</strong></p>
								</div>
								<div class="in" style="float: center">
									<div class="read-more" style="display: inline-block">
										<a href="#">수정</a>
									</div>
									<div class="read-more" style="display: inline-block">
										<a href="/index.jsp">메인으로</a>
									</div>
								</div>
							</div>

						</article><!-- End blog entry -->
							
								
						
						<!-- End blog entry -->



						<!-- End blog entries list -->

					</div>
				</div>
			</div>
		</section>
		<!-- End Blog Section -->

	</section>
</main>
<!-- End #main -->




<%@include file="/footer.jsp"%>