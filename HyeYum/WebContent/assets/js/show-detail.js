	

 $(document).ready(function(){

printReply($("#review-no").val());
printLikes($("#review-no").val());

 $("#heart-btn").on("click",function(){
	updateLikes();
})
	$("#comment-btn").on('click',function(){
		if($("#comment").val() == "" || $("#comment").val() == null){
			alert("내용을 입력해주세요.");
			return;
		}
		registerReply();
	});

});


function registerReply(){
	var reviewNo = $("#review-no").val();
	  // json 형식으로 데이터 set
            var params = {
                     comment       : $("#comment").val()
                    , no       : $("#review-no").val()
					,type     : $("#type").val()

            };
                console.log(params);
            // ajax 통신
            $.ajax({
                type : "GET",            // HTTP method type(GET, POST) 형식이다.
                url : "/reply/show/write",      // 컨트롤러에서 대기중인 URL 주소이다.
                data : params,            // Json 형식의 데이터이다.
                success : function(result){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
                    // 응답코드 > 0000
                   
					printReply(reviewNo);
					$("#comment").val("");
                },
                error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                    alert("통신 실패.")
                }
            });
        
}

function printReply(reviewNo){
	// ajax 통신
	var userId = $("#user-id").val(); 
	 var params = {no : reviewNo };
            $.ajax({
                type : "GET",            // HTTP method type(GET, POST) 형식이다.
                url : "/reply/show/print",      // 컨트롤러에서 대기중인 URL 주소이다.
                data : params,  
				dataType:"json",          // Json 형식의 데이터이다.
                success : function(data){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
                    // 응답코드 > 0000
					var str="";
					console.log(data);
					if(data ==null){
							$("#replyCount").html("<i class='bi bi-chat-square-dots'> 0</i> ")
 							$("#totalCount").html("<strong>댓글 0개</strong><br>");
						$('.show-reply').html('');
					}
					else{
					 for(var i=0; i<data.length; i++) {
	 					if(userId == data[i].userId){
	                    str += "<div class='show-reply'><strong>"+data[i].nick+"</strong> "+data[i].contents+" <span style='cursor:pointer; color:red; float:right' onclick='deleteReply("+data[i].replyNo+")'>삭제</span></div>";
		
						}else{
	                    str += "<div class='show-reply'><strong>"+data[i].nick+"</strong> "+data[i].contents+"</div>";
							
						}
	 
	                }
					$("#replyCount").html("<i class='bi bi-chat-square-dots'> "+data[0].totalCount+"</i> ")
	 				$("#totalCount").html("<strong>댓글 "+data[0].totalCount+"개</strong>");
	                $("#show-contents").html(str); 
					}
	                },
                error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                    alert("reply 통신 실패.")
                }
            });
	
	
}

function deleteReply(replyNo){
	var reviewNo = $("#review-no").val();
	 // json 형식으로 데이터 set
            var params = {
                     no       : replyNo				
            };
                console.log(params);
            // ajax 통신
            $.ajax({
                type : "GET",            // HTTP method type(GET, POST) 형식이다.
                url : "/reply/show/delete",      // 컨트롤러에서 대기중인 URL 주소이다.
                data : params,            // Json 형식의 데이터이다.
                success : function(result){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
                    // 응답코드 > 0000
                   
					printReply(reviewNo);
					$("#comment").val("");
                },
                error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                    alert("통신 실패.")
                }
            });
}

function printLikes(reviewNo){
	// ajax 통신
	 var params = {no : reviewNo };

            $.ajax({
                type : "GET",            // HTTP method type(GET, POST) 형식이다.
                url : "/likes/show/print",      // 컨트롤러에서 대기중인 URL 주소이다.
                data : params,  
				dataType:"json",          // Json 형식의 데이터이다.
                success : function(data){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
                    // 응답코드 > 0000
					
					console.log(data);
					if(data[0].isCheck == 0){
						$("#heart-btn").html("<a herf=''><i class='bi bi-heart show-icon heart-like'></i></a>");
						
					}else{
						$("#heart-btn").html("<a herf=''><i class='bi bi-heart-fill show-icon heart-hate'></i></a>");
					}
					
					if(data[0].likesCount ==0) {
						$("#likesTotalCount").html("<strong><i class='bi bi-heart'></i> "+data[0].likesCount+"명이 좋아합니다.</strong><br>");
						
					}else{
						$("#likesTotalCount").html("<strong><i class='bi bi-heart-fill'></i> "+data[0].likesCount+"명이 좋아합니다.</strong><br>");
						
					}
					$("#likesCount").html(" <i class='bi bi-heart'> "+data[0].likesCount+"</i>");
	                },
                error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                    alert("like 통신 실패.")
                }
            });
	
	
}


function updateLikes(){
	var reviewNo = $("#review-no").val();
	  // json 형식으로 데이터 set
            var params = {
                    
                    no       : $("#review-no").val()
					
            };
                console.log(params);
            // ajax 통신
            $.ajax({
                type : "GET",            // HTTP method type(GET, POST) 형식이다.
                url : "/likes/show/update",      // 컨트롤러에서 대기중인 URL 주소이다.
                data : params,            // Json 형식의 데이터이다.
                success : function(result){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
                    // 응답코드 > 0000
                   console.log(result)
				printLikes(reviewNo);
                },
                error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                    alert("like 통신 실패.")
                }
            });
        
}

function msgPop(receiveId) {
	console.log(receiveId);
	window.open("/message/write/pop?receiveId=" + receiveId , "메시지 보내기", "width=500, height=400"); 
}
