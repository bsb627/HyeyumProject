<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<style>
@font-face {
    font-family: 'GongGothicMedium';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-10@1.0/GongGothicMedium.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
@import "bourbon";

body {
	background: #eee !important;	
}

.wrapper {	
	margin-top: 50px;
  margin-bottom: 60px;
  text-align :center;
}

.form-signin {
  max-width: 500px;
  padding: 15px 35px 45px;
  margin: 0 auto;
  background-color: #fff;
  border: 1px solid rgba(0,0,0,0.1);  
 font-family: 'GongGothicMedium';
  .form-signin-heading,
	.checkbox {
	  margin-bottom: 30px;
	 
	}

	.checkbox {
	  font-weight: normal;
	}

	.form-control {
	  position: relative;
	  font-size: 16px;
	  height: auto;
	  padding: 10px;
		@include box-sizing(border-box);

		&:focus {
		  z-index: 2;
		}
	}

	input[type="text"] {
	  margin-bottom: -1px;
	  border-bottom-left-radius: 0;
	  border-bottom-right-radius: 0;
	}

	input[type="password"] {
	  margin-bottom: 20px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
}
</style>
</head>
<body>



<form id = "contact-form" action = "/member/find/id" method = "get" class="form-signin">




  <div class="wrapper" >
  	<img src= "/assets/img/logo.png" style = "width :40px; height:40px;" >
      <h2 class="form-signin-heading">아이디 찾기</h2><br>
      이름을 입력해주세요.
      <input type = "text" name = "name" class="form-control"><br> 
      가입시 입력한 이메일을 입력해 주세요.
     <input type = "email" name = "email" class="form-control"><br>
	입력한 이메일 주소와 이름이 같아야 찾을 수 있습니다.<br><br>
     <input type = "submit" value ="찾기" class = "btn btn-primary"> 
 
  </div>
</form>
</body>
</html>