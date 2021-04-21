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


function msgPop(receiveId) {
	
	console.log(receiveId);
	window.open("/message/write/pop?receiveId=" + receiveId , "메시지 보내기", "width=500, height=400"); 
}
