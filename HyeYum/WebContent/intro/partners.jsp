<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>
<head>
<title>문화나눔, 혜윰 - aboutUs</title>
</head>
<main id="main">

	<!-- ======= Breadcrumbs ======= -->
	<section class="breadcrumbs">
		<div class="container">

			<ol>
				<li><a href="/index.jsp">Home</a></li>
				<li>소개</li>
			</ol>
			<h2>혜윰 벗</h2>

		</div>
	</section>
	<!-- End Breadcrumbs -->

	<section class="inner-page">
		<div class="container">
			<p>

				기업들 하단엔 제휴문의폼 넣기 상단 제휴문의 버튼 클릭하면 이 페이지로 이동하게끔 만들기.

				<!-- ======= Contact Section ======= -->
				<section id="contact" class="contact">

					<div class="container" data-aos="fade-up">

						<header class="section-header">
							<h2>HYEYUM PARTNERS</h2>
							<p>제휴 문의</p>
						</header>





						<div class="col-lg-12">
							<!--  가로너비 -->
							<form action="forms/contact.php" method="post"
								class="php-email-form">
								<div class="row gy-4">
									<!--세로간격  -->

									<div class="col-md-5">
										<!-- 칸 길이 조절 -->
										
										<!-- <lable for ="company name">기업명: -->
										<!-- <label for="exampleInputEmail1">Email address</label> -->
										<input type="text" name="name" class="form-control"
											placeholder="기업명" required>
									</div>
										<!-- 사업자번호1 -->
									<div class="col-md-6 ">
										<input type="email" class="form-control" name="email"
											placeholder="이메일을 입력해주세요 "  required>  
									</div>
										<!-- 사업자번호2 -->
									<div class="col-md-3">
										<!-- 칸 길이 조절 -->
										<input type="text" name="name" class="form-control"
											placeholder="사업자번호"  required>
									</div>
									
										<!-- 사업자번호3 -->
									<div class="col-md-3">
										<!-- 칸 길이 조절 -->
										<input type="text" name="name" class="form-control"
											placeholder="입력" required>
									</div>

									<div class="col-md-3">
										<!-- 칸 길이 조절 -->
										<input type="text" name="name" class="form-control"
											placeholder="해주세요" required>
									</div>
									
										<div class="col-md-4">
										<!-- 칸 길이 조절 -->
										<input type="text" name="name" class="form-control"
											placeholder="대표자명 " required>
									</div>
									
									<div class="col-md-5">
										<!-- 칸 길이 조절 -->
										<input type="text" name="name" class="form-control"
											placeholder="전화번호 " required>
									</div>


									<div class="col-md-12">
										<input type="text" class="form-control" name="subject"
											placeholder="주소" required>
									</div>

									<div class="col-md-12">
										<textarea class="form-control" name="message" rows="6"
											placeholder="내용을 입력해주세요" required></textarea>
									</div>

									<div class="col-md-12 text-center">
										<div class="loading">Loading</div>
										<div class="error-message"></div>
										<div class="sent-message">전송되었습니다.
											Thank you!</div>

										<button type="submit">등록!!!!!</button>
									</div>

								</div>
							</form>

						</div>

					</div>
		</div>

	</section>
	<!-- End Contact Section -->

	</p>
	</div>
	</section>

</main>
<!-- End #main -->

<%@include file="/footer.jsp"%>