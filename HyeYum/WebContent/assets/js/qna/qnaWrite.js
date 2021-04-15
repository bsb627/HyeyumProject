$(document).ready(function() {
		$("#qna-form").submit(function() {
			var title = $("#title");
			var password = $("#qna-pwd");
			var contents = $("#contents");
			var category = $("#category");
			if(title.val() =="") {
				alert("제목을 입력해주세요. ");
				return false;
			}else if (category.val()=="--분류선택--") {
				alert("문의 분류를 선택해 주세요");
				return false;
			}else if(password.val() == "") {
				alert("비밀번호를 입력해주세요.");
				return false;
			}else if (contents.val() == "") {
				alert("내용을 입력해주세요.");
				return false;
			}
			alert("등록하시겠습니까?");
			return true;
		});
	 });