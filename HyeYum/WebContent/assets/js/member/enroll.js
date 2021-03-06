$(document).ready(function() {
		$("#user-id").on("change keyup paste", function() {
	  	 	idCheck();
        });

		$("#user-name").on("change keyup paste", function() {
	  	 	nameCheck();
        });

		$("#user-pwd").on("change keyup paste", function() {
	  	 	pwdCheck();
			pwdConfirmCheck();
        });
		$("#user-repwd").on("change keyup paste", function() {
	  	 	pwdConfirmCheck();
        });
		$("#user-nick").on("change keyup paste", function() {
	  	 	nickCheck();
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
regCheck();
});

function idCheck(){
	    var userId = $("#user-id").val();
var regExp = /^[a-z][a-z0-9]{3,11}$/;
	  // json 형식으로 데이터 set
            var params = {
                    inputId : $("#user-id").val()
            };
                console.log(params);
            // ajax 통신
            $.ajax({
                type : "POST",            // HTTP method type(GET, POST) 형식이다.
                url : "/member/checkId",      // 컨트롤러에서 대기중인 URL 주소이다.
                data : params,            // Json 형식의 데이터이다.
                success : function(result){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
                    // 응답코드 > 0000
                   
					console.log(result);
					  if(!regExp.test(userId)) {
						$("#user-id").removeClass('is-valid');
						$("#user-id").addClass('is-invalid');
						$("#check-id-msg").html("<p class='text-danger' >ID는 영소문자+숫자 4~12자리이며 영소문자로 시작해야합니다.</p>");
						}else{
							
						
						if(result > 0){
							$("#user-id").removeClass('is-valid');
							$("#user-id").addClass('is-invalid');
							$("#check-id-msg").html("<p class='text-danger'>중복된 아이디 입니다.</p>");
						}else{
							$("#user-id").removeClass('is-invalid');
							$("#user-id").addClass('is-valid');
							$("#check-id-msg").html("<p class='text-success'>사용 가능한 아이디 입니다.</p>");
						}
					}
                },
                error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                    alert("통신 실패.")
                }
            });
        
}
function nameCheck(){
	var userName = $("#user-name").val();
    var nameExp = /^[가-힣]{2,6}$/;
	  if(!nameExp.test(userName)) {
						$("#user-name").removeClass('is-valid');
						$("#user-name").addClass('is-invalid');
						$("#check-name-msg").html("<p class='text-danger'>이름은 한글, 최소 2글자에서 6글자를 입력해야합니다.</p>");
						
						}else{
							$("#user-name").removeClass('is-invalid');
							$("#user-name").addClass('is-valid');
							$("#check-name-msg").html("");
						}
	
}
function pwdCheck(){
	var userPw = $("#user-pwd").val();
     var pwExp = /^[a-zA-Z0-9]{8,12}$/;
	  if(!pwExp.test(userPw)) {
						$("#user-pwd").removeClass('is-valid');
						$("#user-pwd").addClass('is-invalid');
						$("#check-pwd-msg").html("<p class='text-danger'>비밀번호는 최소 8글자 이상, 최대 12글자 이고 영문자, 숫자만 허용됩니다.</p>");
						}else{
							$("#user-pwd").removeClass('is-invalid');
							$("#user-pwd").addClass('is-valid');
							$("#check-pwd-msg").html("<p class='text-success'>사용 가능한 비밀번호 입니다.</p>");
						}
	
}
function pwdConfirmCheck(){
	var userPw = $("#user-pwd").val();
     var userPwRe = $("#user-repwd").val();
                if(userPw != userPwRe) {
	  					$("#user-repwd").removeClass('is-valid');
						$("#user-repwd").addClass('is-invalid');
						$("#check-repwd-msg").html("<p class='text-danger'>비밀번호가 일치하지 않습니다.</p>");
						}else if(userPw==""){
							$("#user-repwd").removeClass('is-invalid');
							$("#user-repwd").removeClass('is-valid');
						$("#check-repwd-msg").html("");
						}
						else{
							$("#user-repwd").removeClass('is-invalid');
							$("#user-repwd").addClass('is-valid');
							$("#check-repwd-msg").html("<p class='text-success'>비밀번호가 일치합니다.</p>");
						}
	

}
function nickCheck(){
	  var nick = $("#user-nick").val();
var regExp = /^[a-zA-Z0-9ㄱ-ㅎ가-힣]{2,10}$/;
	  // json 형식으로 데이터 set
            var params = {
                    inputNick : $("#user-nick").val()
            };
                console.log(params);
            // ajax 통신
            $.ajax({
                type : "POST",            // HTTP method type(GET, POST) 형식이다.
                url : "/member/checkNick",      // 컨트롤러에서 대기중인 URL 주소이다.
                data : params,            // Json 형식의 데이터이다.
                success : function(result){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
                    // 응답코드 > 0000
                   
					console.log(result);
					  if(!regExp.test(nick)) {
						$("#user-nick").removeClass('is-valid');
						$("#user-nick").addClass('is-invalid');
						$("#check-nick-msg").html("<p class='text-danger'>닉네임은 한글,영문,숫자 조합 최소2자 ~ 최대 10자 입니다.</p>");
						}else{
							
						
						if(result > 0){
							$("#user-nick").removeClass('is-valid');
							$("#user-nick").addClass('is-invalid');
							$("#check-nick-msg").html("<p class='text-danger'>닉네임 중복</p>");
						}else{
							$("#user-nick").removeClass('is-invalid');
							$("#user-nick").addClass('is-valid');
							$("#check-nick-msg").html("<p class='text-success'>사용 가능한 닉네임입니다.</p>");
							
						}
					}
                },
                error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                    alert("통신 실패.")
                }
            });
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
function regCheck(){
	
            $("#register-form").on("submit",function () {
                // ID를 입력해주세요 출력
                // 영소문자+숫자 4~12자리이며 영소문자로 시작
                // 영소문자로 시작하고 나머지는 모두 숫자인데 4~12자리가 되도록 해라.
                var userId = $("#user-id").val();
                if(userId == "" ) {
                    alert("ID를 입력해주세요!");
                    return false;
                }
                // 4 ~ 12 자리 표현 : 영소문자 + 3~11자리
                var regExp = /^[a-z][a-z0-9]{3,11}$/;
                if(!regExp.test(userId)) {
                    alert("ID는 영소문자+숫자 4~12자리이며 영소문자로 시작해야합니다.");
                    return false;
                }
                // 이름 입력
                // 이름은 한글, 최소 2글자에서 4글자를 입력해야합니다.
                var userName = $("#user-name").val();
                var nameExp = /^[가-힣]{2,6}$/;
                if(!nameExp.test(userName)) {
                    alert("이름은 한글, 최소 2글자에서 6글자를 입력해야합니다.");
                    return false;
                }
                // PW 입력
                // 비밀번호 길이 검사 (8글자 이상, 12자 이하 및 영문자, 숫자
                // 비밀번호는 최소 8글자 이상, 최대 12글자 이고 영문자, 숫자만 허용됩니다. 출력
                var userPw = $("#user-pwd").val();
                var pwExp = /^[a-zA-Z0-9]{8,12}$/;
                if(!pwExp.test(userPw)) {
                    alert("비밀번호는 최소 8글자 이상, 최대 12글자 이고 영문자, 숫자만 허용됩니다.");
                    return false;
                }
                // 비밀번호 재확인
                var userPwRe = $("#user-repwd").val();
                if(userPw != userPwRe) {
                    alert("비밀번호 재확인 바랍니다.");
                    return false;
                }

	  			var nick = $("#user-nick").val();
				var nickExp = /^[a-zA-Z0-9ㄱ-ㅎ가-힣]{2,10}$/;
                 if(!nickExp.test(nick)) {
	                alert("닉네임은 한글,영문,숫자 조합 최소2자 ~ 최대 10자 입니다.");
                    return false;
					}
                //전화번호 입력
                var tel = $("#user-phone").val();
                var telRegExp = /^010[0-9]{8}$/;
                if(!telRegExp.test(tel)) {
                    alert("사용 불가능한 번호입니다.");
                    return false;
                }
				var userEmail = $("#user-email").val();
				var emailRule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;//이메일 정규식
 
				if(!emailRule.test(userEmail)) {            
            //경고
				alert('사용 불가능한 이메일입니다.')
            	return false;
}
              
            });
}