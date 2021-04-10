<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<title>문화나눔, 혜윰 - 관람혜윰</title>
<%@include file="/header.jsp"%>
<link href="/assets/css/show-custom.css" rel="stylesheet">
<%
	if (userId == null) {
%>
<script type="text/javascript">
	if (confirm("로그인 후 이용가능합니다.")) {
		history.back();
	} else {
		history.back();
	}
</script>
<%
	}
%>
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
	</section>
	<!-- End Breadcrumbs -->

	<!-- ======= Blog Section ======= -->
	<section id="blog" class="blog portfolio">
		<div class="container" data-aos="fade-up">

			<div class="row">
				<header class="section-header">
					<h2>A photo review</h2>
					<p>관람 포토 후기</p>
				</header>

				<div class="col-lg-12">

					<div class="sidebar">
						<!-- End sidebar categories-->

						<h3 class="sidebar-title">검색</h3>
						<div class="sidebar-item search-form">
							<form action="">
								<input type="text">
								<button type="submit">
									<i class="bi bi-search"></i>
								</button>
							</form>
						</div>
						<!-- End sidebar search formn-->

						<h3 class="sidebar-title">태그</h3>
						<div class="sidebar-item tags">
							<ul>
								<li><a href="#">콘서트</a></li>
								<li><a href="#">연극</a></li>
								<li><a href="#">뮤지컬</a></li>
								<li><a href="#">마술</a></li>
								<li><a href="#">클래식</a></li>
								<li><a href="#">전시/행사</a></li>
								<li><a href="#">레저</a></li>
								<li><a href="#">가족</a></li>
								<li><a href="#">스포츠</a></li>
							</ul>
						</div>
						<!-- End sidebar tags-->

					</div>
					<!-- End sidebar -->

				</div>
				<!-- End blog sidebar -->

				<div class="col-lg-12 entries">
					<div class="row gy-4 portfolio-container" data-aos="fade-up"
						data-aos-delay="200">
						<article class="entry row">

							<div class="col-md-6 col-sm-6 col-6 portfolio-item filter-app">
								<article class="entry">

									<div class="entry-img">
										<img src="/assets/img/blog/blog-4.jpg" alt=""
											class="img-fluid">
									</div>

									<h2 class="entry-title">
										<a href="blog-single.html">Non rem rerum nam cum quo
											minus. Dolor distinctio deleniti explicabo eius
											exercitationem.</a>
									</h2>

									<div class="entry-meta">
										<ul>
											<li class="d-flex align-items-center"><i
												class="bi bi-person"></i> <a href="blog-single.html">John
													Doe</a></li>
											<li class="d-flex align-items-center"><i
												class="bi bi-clock"></i> <a href="blog-single.html"><time
														datetime="2020-01-01">Jan 1, 2020</time></a></li>
											<li class="d-flex align-items-center"><i
												class="bi bi-chat-dots"></i> <a href="blog-single.html">12
													Comments</a></li>
										</ul>
									</div>

									<div class="entry-content">
										<div class="read-more">
											<a href="blog-single.html">Read More</a>
										</div>
									</div>

								</article>
								<!-- End blog entry -->

							</div>

							<div class="col-md-6 col-sm-6 col-6 portfolio-item filter-app">
								<article class="entry">

									<div class="entry-img">
										<img src="/assets/img/blog/blog-4.jpg" alt=""
											class="img-fluid">
									</div>

									<h2 class="entry-title">
										<a href="blog-single.html">Non rem rerum nam cum quo
											minus. Dolor distinctio deleniti explicabo eius
											exercitationem.</a>
									</h2>

									<div class="entry-meta">
										<ul>
											<li class="d-flex align-items-center"><i
												class="bi bi-person"></i> <a href="blog-single.html">John
													Doe</a></li>
											<li class="d-flex align-items-center"><i
												class="bi bi-clock"></i> <a href="blog-single.html"><time
														datetime="2020-01-01">Jan 1, 2020</time></a></li>
											<li class="d-flex align-items-center"><i
												class="bi bi-chat-dots"></i> <a href="blog-single.html">12
													Comments</a></li>
										</ul>
									</div>

									<div class="entry-content">
										<p>Aspernatur rerum perferendis et sint. Voluptates
											cupiditate voluptas atque quae. Rem veritatis rerum enim et
											autem. Saepe atque cum eligendi eaque iste omnis a qui. Quia
											sed sunt. Ea asperiores expedita et et delectus voluptates
											rerum. Id saepe ut itaque quod qui voluptas nobis porro
											rerum. Quam quia nesciunt qui aut est non omnis. Inventore
											occaecati et quaerat magni itaque nam voluptas. Voluptatem
											ducimus sint id earum ut nesciunt sed corrupti nemo.</p>
										<div class="read-more">
											<a href="blog-single.html">Read More</a>
										</div>
									</div>

								</article>
								<!-- End blog entry -->

							</div>
							
							<div class="col-md-6 col-sm-6 col-6 portfolio-item filter-app">
								<article class="entry">

									<div class="entry-img">
										<img src="/assets/img/blog/blog-4.jpg" alt=""
											class="img-fluid">
									</div>

									<h2 class="entry-title">
										<a href="blog-single.html">Non r explicabo eius
											exercitationem.</a>
									</h2>

									<div class="entry-meta">
										<ul>
											<li class="d-flex align-items-center"><i
												class="bi bi-person"></i> <a href="blog-single.html">John
													Doe</a></li>
											<li class="d-flex align-items-center"><i
												class="bi bi-clock"></i> <a href="blog-single.html"><time
														datetime="2020-01-01">Jan 1, 2020</time></a></li>
											<li class="d-flex align-items-center"><i
												class="bi bi-chat-dots"></i> <a href="blog-single.html">12
													Comments</a></li>
										</ul>
									</div>

									<div class="entry-content">
										<p>Aspernatuunt qui aut est non omnis. Inventore
											occaecati et quaerat magni itaque nam voluptas. Voluptatem
											ducimus sint id earum ut nesciunt sed corrupti nemo.</p>
										<div class="read-more">
											<a href="blog-single.html">Read More</a>
										</div>
									</div>

								</article>
								<!-- End blog entry -->

							</div>
							
							<div class="col-md-6 col-sm-6 col-6 portfolio-item filter-app">
								<article class="entry">

									<div class="entry-img">
										<img src="/assets/img/blog/blog-4.jpg" alt=""
											class="img-fluid">
									</div>

									<h2 class="entry-title">
										<a href="blog-single.html">Non rem rerum nam cum quo
											minus. Dolor distinctio deleniti explicabo eius
											exercitationem.</a>
									</h2>

									<div class="entry-meta">
										<ul>
											<li class="d-flex align-items-center"><i
												class="bi bi-person"></i> <a href="blog-single.html">John
													Doe</a></li>
											<li class="d-flex align-items-center"><i
												class="bi bi-clock"></i> <a href="blog-single.html"><time
														datetime="2020-01-01">Jan 1, 2020</time></a></li>
											<li class="d-flex align-items-center"><i
												class="bi bi-chat-dots"></i> <a href="blog-single.html">12
													Comments</a></li>
										</ul>
									</div>

									<div class="entry-content">
										<p>Aspernatur rerum perferendis et sint. Voluptates
											cupiditate voluptas edita et et delectus voluptates
											rerum. ui aut est non omnis. Inventore
											occaecati et quaerat magni itaque nam voluptas. Voluptatem
											ducimus sint id earum ut nesciunt sed corrupti nemo.</p>
										<div class="read-more">
											<a href="blog-single.html">Read More</a>
										</div>
									</div>

								</article>
								<!-- End blog entry -->

							</div>

					</article>
					</div>



				</div>
				<!-- End blog entries list -->


					<div class="blog-pagination">
						<ul class="justify-content-center">
							<li><a href="#">1</a></li>
							<li class="active"><a href="#">2</a></li>
							<li><a href="#">3</a></li>
						</ul>
					</div>

			</div>

		</div>
	</section>
	<!-- End Blog Section -->

</main>
<!-- End #main -->

<%@include file="/footer.jsp"%>