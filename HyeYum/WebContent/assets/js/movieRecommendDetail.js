$(document).ready(function() {

	 $("#recommend-delete-btn").on("click",function(){
		 if (!confirm("삭제하시겠습니까?")) {
			 // 취소
					return false;
		 		} else {
		     // 확인
		 		}
	 		});

});