	

 $(document).ready(function(){



$("#show-select option").each(function(){

    if($(this).val()==$("#infoNo").val()){

      $(this).prop("selected","selected"); // attr적용안될경우 prop으로 

    }

  });

});

