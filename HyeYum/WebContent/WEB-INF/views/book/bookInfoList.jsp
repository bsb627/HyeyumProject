<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이달의 도서</title>
</head>
	<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
<script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<link rel="stylesheet" href="/assets/css/book/swiperStyle.css">

										
<body>
<!-- Swiper -->
  <div class="swiper-container">
    <div class="swiper-wrapper">
      <div class="swiper-slide" style="background-image:url(./images/nature-1.jpg)"></div>
      <div class="swiper-slide" style="background-image:url(./images/nature-2.jpg)"></div>
      <div class="swiper-slide" style="background-image:url(./images/nature-3.jpg)"></div>
      <div class="swiper-slide" style="background-image:url(./images/nature-4.jpg)"></div>
      <div class="swiper-slide" style="background-image:url(./images/nature-5.jpg)"></div>
      
    </div>
    <!-- Add Pagination -->
    <div class="swiper-pagination"></div>
  </div>

  <!-- Swiper JS -->
  <script src="../package/swiper-bundle.min.js"></script>

  <!-- Initialize Swiper -->
  <script>
    var swiper = new Swiper('.swiper-container', {
      initialSlide: 2,
      effect: 'coverflow',
      grabCursor: true,
      centeredSlides: true,
      slidesPerView: 'auto',
      coverflowEffect: {
        rotate: 50,
        stretch: 0,
        depth: 100,
        modifier: 1,
        slideShadows: true,
      },
      pagination: {
        el: '.swiper-pagination',
      },
    });
  </script>
</body>
</html>