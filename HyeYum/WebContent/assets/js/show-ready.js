$(document).ready(function() {
	$("#write-btn").on("click",function(){
				checkForm();
				checkTicket();
			});

	
});

function checkForm(){
	
	if($("#summernote").val()==""){
		alert("내용을 입력해주세요");
		event.preventDefault();
	}
}

function checkTicket(){
		console.log($('#ticket-number').val());
		var pattern = /^S[0-9][A_Z][A-Z][0-9][0-9][0-9][0-9]$/;  //S로 시작하면서, 두번째는 숫자 0~9 까지의 세번쨰 네번쨰는 A-Z 나머지 4개는 0-9 [S1AZ1234]
		console.log(pattern.test($("#ticket-number").val()));
		if(pattern.test($("#ticket-number").val())==false){
			alert('유효하지 않는 티켓번호입니다.');
			event.preventDefault();
		} 
		
}