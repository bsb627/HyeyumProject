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
		var table = $('#dataTable').DataTable();
	
		 $('#dataTable tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
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


