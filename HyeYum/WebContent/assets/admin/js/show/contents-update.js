$(document).ready(function(){

	$(":radio[name='type']").each(function() {
		var $this = $(this);		
		if($this.val() == $("#typeVal").val())
		$this.attr('checked', true);
	});
	
	$("#selectRegion option").each(function(){

	    if($(this).val()==$("#regionVal").val()){
	      $(this).prop("selected","selected"); // attr적용안될경우 prop으로 
	    }
 	 });

	$("#selectAge option").each(function(){
	    if($(this).val()==$("#ageVal").val()){
	      $(this).prop("selected","selected"); // attr적용안될경우 prop으로 
	    }
  	});

});