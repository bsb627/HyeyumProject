<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<title>문화나눔, 혜윰 - 영화</title>

<main id="main">

	<!-- ======= Breadcrumbs ======= -->
	<section class="breadcrumbs">
		<button>모달창</button>

		<div class="modal">
			<div class="modal_content" title="클릭하면 창이 닫힙니다.">
				여기에 모달창 내용을 적어줍니다.<br> 이미지여도 좋고 글이어도 좋습니다.
			</div>
		</div>
		<script>
$(function(){ 

	  $("button").click(function(){
	    $(".modal").fadeIn();
	  });
	  
	  $(".modal_content").click(function(){
	    $(".modal").fadeOut();
	  });
	  
	});
</script>
	</section>
	</main>
	<!-- End Breadcrumbs -->