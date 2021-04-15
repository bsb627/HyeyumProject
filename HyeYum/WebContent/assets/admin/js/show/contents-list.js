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
    } );
 
   
});