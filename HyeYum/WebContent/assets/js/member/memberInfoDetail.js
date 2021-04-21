$(document).ready(function(){
	$("#user-pwd").on("change keyup paste", function() {
		originCheck();

});
	
	$("#user-repwd").on("change keyup paste", function() {
		reCheck();

	});
	
	
	$("#user-phone").on("change keyup paste", function() {
		phoneCheck();

	});
	
	$("#user-email").on("change keyup paste", function() {
		emailCheck();

	});
	
	$("#sample4_detailAddress").on("change keyup paste", function() {
		addressCheck();

	});
	
});




function originCheck(){
	var originPwd = $("#user-pwd").val();
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
						$("#user-pwd").removeClass('is-invalid');
						$("#user-pwd").addClass('is-valid');
						$("#check-msg").html("<p class='text-success'>비밀번호 일치</p>");
					}else{
						$("#user-pwd").removeClass('is-valid');
						$("#user-pwd").addClass('is-invalid');
						$("#check-msg").html("<p class='text-danger'>비밀번호 불일치</p>");
						
					}
                },
                error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                    alert("통신 실패.")
                }
            });
        
}


function reCheck(){

	var userPw = $("#user-pwd").val();
    var userPwRe = $("#user-repwd").val();
               if(userPw != userPwRe) {
	  					$("#user-repwd").removeClass('is-valid');
						$("#user-repwd").addClass('is-invalid');
						$("#recheck-msg").html("<p class='text-danger'>비밀번호가 일치하지 않습니다.</p>");
						}else if(userPw==""){
							$("#user-repwd").removeClass('is-invalid');
							$("#user-repwd").removeClass('is-valid');
						$("#check-repwd-msg").html("");
						}
						else{
							$("#user-repwd").removeClass('is-invalid');
							$("#user-repwd").addClass('is-valid');
							$("#recheck-msg").html("<p class='text-success'>비밀번호가 일치합니다.</p>");
						}
}

function phoneCheck(){
	 var tel = $("#user-phone").val();
    var telRegExp = /^010[0-9]{8}$/;
	  if(!telRegExp.test(tel)) {
							$("#user-phone").removeClass('is-valid');
							$("#user-phone").addClass('is-invalid');
						$("#check-phone-msg").html("<p class='text-danger'>사용 불가능한 번호입니다.</p>");
						}else{
							$("#user-phone").removeClass('is-invalid');
							$("#user-phone").addClass('is-valid');
							$("#check-phone-msg").html("<p class='text-success'>사용 가능한 번호입니다.</p>");
						}
	
}
function emailCheck(){
	var userEmail = $("#user-email").val();
   var emailRule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;//이메일 정규식
	  if(!emailRule.test(userEmail)) {
							$("#user-email").removeClass('is-valid');
							$("#user-email").addClass('is-invalid');
						$("#check-email-msg").html("<p class='text-danger'>사용 불가능한 이메일입니다.</p>");
						}else{
							$("#user-email").removeClass('is-invalid');
							$("#user-email").addClass('is-valid');
							$("#check-email-msg").html("<p class='text-success'>사용 가능한 이메일입니다.</p>");
						}
	
}

function addressCheck(){
	var roadAddress = $("#sample4_roadAddress").val();
	var detailAddress = $("#sample4_detailAddress").val();
	console.log(detailAddress=="");
	  if(detailAddress=="") {
			$("#sample4_detailAddress").removeClass('is-valid');
							$("#sample4_detailAddress").addClass('is-invalid');
								
						}else{
							$("#sample4_roadAddress").addClass('is-valid');
								$("#sample4_detailAddress").removeClass('is-invalid');
							$("#sample4_detailAddress").addClass('is-valid');
						}
	
}

