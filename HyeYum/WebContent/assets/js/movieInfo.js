$(document).ready(function() {
	$("#write-btn").on("click",function(){
				contentForm();
				checkMovieTicket();
			});
			
	$("#modify-btn").on("click",function(){
		modifyForm();
			});

	
});

	
function contentForm(){
	console.log($('#summernote').val());
	if($('#summernote').val()==""){
		alert("내용을 입력해주세요");
		event.preventDefault();
	}
}

function modifyForm(){
	console.log($('#summernote-modify').val());
	if($('#summernote-modify').val()==""){
		alert("내용을 입력해주세요");
		event.preventDefault();
	}
}

function checkMovieTicket(){
		console.log($('#ticket-number').val());
		var pattern = /^M[0-9][A-Z][A-Z][0-9][0-9][0-9][0-9]$/;  //M으로 시작하면서, 두번째는 숫자 0~9 까지의 세번쨰 네번쨰는 A-Z 나머지 4개는 0-9 [S1AZ1234]
		console.log(pattern.test($("#ticket-number").val()));
		if(pattern.test($("#ticket-number").val())==false){
			alert('유효하지 않는 티켓번호입니다.');
			event.preventDefault();
		} 
		
}