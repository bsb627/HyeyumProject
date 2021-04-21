$(document).ready(function(){
	
	$("#origin-pass").on("change keyup paste", function() {
  	 originCheck();

});

	

	 $("form").on("submit", function() {
		var orginPwd = $("#origin-pass").val();
		var changePwd = $("#change-pass").val();
		var changeConfirm = $("#change-pass-confirm").val();
		var checkMsg = $("#check-msg").text();
		if(orginPwd==""){
			 alert('현재 비밀번호를 입력해주세요');
			return false;
		}else if(checkMsg=="비밀번호 불일치"){
			 alert('현재 비밀번호를 확인해주세요');
			return false;
		}else if(changePwd==""){
			alert('변경할 비밀번호를 입력해주세요');
			return false;
		}else if(changeConfirm==""){
			alert('변경할 비밀번호 확인을 입력해주세요');
			return false;
		}else if(changePwd != changeConfirm){
			alert('변경할 비밀번호가 일치하지 않습니다.');
			return false;
		}else{
				 if (!confirm("정말 변경하시겠습니까?")) {
	        // 취소(아니오) 버튼 클릭 시 이벤트
				return false;
		    } else {
		        // 확인(예) 버튼 클릭 시 이벤트
		    }
		}
    });


});




function originCheck(){
	var originPwd = $("#origin-pass").val();
	  // json 형식으로 데이터 set
            var params = {
                    password : originPwd
            };
                console.log(params);
            // ajax 통신
            $.ajax({
                type : "POST",            // HTTP method type(GET, POST) 형식이다.
                url : "/member/checkPwd",      // 컨트롤러에서 대기중인 URL 주소이다.
                data : params,            // Json 형식의 데이터이다.
                success : function(result){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
                    // 응답코드 > 0000
                   
					console.log(result);
					if(result > 0){
						$("#check-msg").html("<p class='text-success'>비밀번호 일치</p>");
					}else{
						$("#check-msg").html("<p class='text-danger'>비밀번호 불일치</p>");
						
					}
                },
                error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                    alert("통신 실패.")
                }
            });
        
}


