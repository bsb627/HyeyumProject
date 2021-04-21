$(document).ready(function(){

	 $("form").on("submit", function() {
		var orginPwd = $("#origin-pass").val();
		var changePwd = $("#change-pass").val();
		var changeConfirm = $("#change-pass-confirm").val();
		if(orginPwd==""){
			 alert('현재 비밀번호를 입력해주세요');
			return false;
		}else if(changePwd=""){
			alert('변경할 비밀번호를 입력해주세요');
		}else if(changeConfirm=""){
			alert('변경할 비밀번호 확인을 입력해주세요');
		}else{
				 if (!confirm("정말 삭제하시겠습니까?")) {
	        // 취소(아니오) 버튼 클릭 시 이벤트
				return false;
		    } else {
		        // 확인(예) 버튼 클릭 시 이벤트
		    }
		}
    });


});
