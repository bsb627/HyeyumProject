$(document).ready(function(){
	// 체크박스 전체 선택
		$("#check_all").on("click", function () {
		  var checked = $(this).is(":checked");
		
		  if(checked){
		  	$(".checkbox_group").prop("checked", true);
		  } else {
		  	$(".checkbox_group").prop("checked", false);
		  }
		});
	 $("form").on("submit", function() {
		if($('.checkbox_group').is(":checked") == false){
			 alert('체크된 값이 없습니다.');
			return false;
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

function getSelected(shippingState){
		$("#selectShipping option").each(function(){

	    if($(this).val()==shippingState){
	      $(this).prop("selected","selected"); // attr적용안될경우 prop으로 
	    }
 	 });
	
}

function chageShipping(orderNo,optionVal) {
	
	  // json 형식으로 데이터 set
            var params = {
                     no       : orderNo
					,shipping     : optionVal

            };
                console.log(params);
            // ajax 통신
            $.ajax({
                type : "GET",            // HTTP method type(GET, POST) 형식이다.
                url : "/shipping/update",      // 컨트롤러에서 대기중인 URL 주소이다.
                data : params,            // Json 형식의 데이터이다.
                success : function(result){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
                    // 응답코드 > 0000
                   
					
					location.href='/admin/order/list';
					
                },
                error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                    alert("통신 실패.")
                }
            });

}