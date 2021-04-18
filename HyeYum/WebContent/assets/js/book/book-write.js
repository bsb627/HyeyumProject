$(document).ready(function() {
	//여기 아래 부분
	$('#summernote').summernote({
		  height: 300,                 // 에디터 높이
		  minHeight: null,             // 최소 높이
		  maxHeight: null,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정		  
		  toolbar: [
		    // [groupName, [list of button]]
		    ['style', ['bold', 'italic', 'underline', 'clear']],
		    ['font', ['strikethrough', 'superscript', 'subscript']],
		    ['fontsize', ['fontsize']],
		    ['color', ['color']],
		    ['para', ['ul', 'ol', 'paragraph']],
		    ['height', ['height']]
		  ]
	});
	
});
/*summer note*/
$(document)
		.ready(
				function() {
					//여기 아래 부분
					$('#summernote')
							.summernote(
									{
										height : 300, // 에디터 높이
										minHeight : null, // 최소 높이
										maxHeight : null, // 최대 높이
										focus : true, // 에디터 로딩후 포커스를 맞출지 여부
										lang : "ko-KR", // 한글 설정
										placeholder : '최대 2048자까지 쓸 수 있습니다', //placeholder 설정		  
										toolbar : [
												// [groupName, [list of button]]
												[
														'style',
														[
																'bold',
																'italic',
																'underline',
																'clear' ] ],
												[
														'font',
														[
																'strikethrough',
																'superscript',
																'subscript' ] ],
												[ 'fontsize',
														[ 'fontsize' ] ],
												[ 'color', [ 'color' ] ],
												[
														'para',
														[ 'ul', 'ol',
																'paragraph' ] ],
												[ 'height',
														[ 'height' ] ] ]
									});
				});

/*
function doChange(srcE, targetId){
    var val = srcE.options[srcE.selectedIndex].value;
    var targetE = document.getElementById(targetId);
/*    alert(val);
    removeAll(targetE);

    if(val == 'info'){
        addOption('게으름도 습관이다', targetE);
        addOption('2. 노르웨이숲', targetE);
        addOption('3. 불안', targetE);
        addOption('4. 여자가 없는 남자들', targetE);
        addOption('5. 유혹의 기술' targetE);,
		
    }
    else if(val == 'genre'){
        addOption('1. 인문/사회', targetE);
        addOption('2. 소설', targetE);
        addOption('3. 에세이', targetE);
        addOption('4. 시', targetE);
        addOption('5. 자기계발', targetE);
        addOption('6. 건강/다이어트', targetE);
        addOption('7. 생활/취미', targetE);
    }
};
*/
$(function(){
    
    chnQnaType(1 , 11);
});

function chnQnaType(type , select) {
/*    var targetE = document.getElementById(targetId)
	removeAll(targetE);
*/
    $('#schQnaType').empty();

	switch(type){
		case 'info':
			if($('#info-no').length > 0){ // info-no이 존재하면
				$("#genre").remove();
		        $('#info-no').append("<option>-- 선택 --</option>'");
		        $('#info-no').append("<option value='11' >게으름도 습관이다</option>'");
		        $('#info-no').append("<option value='12' >노르웨이숲</option>'");
		        $('#info-no').append("<option value='13' >불안</option>'");
		        $('#info-no').append("<option value='14' >여자가 없는 남자들</option>'");
		        $('#info-no').append("<option value='15' >유혹의 기술</option>");
			}else{ // info-no이 존재하지 않으면
				$("#genre").remove();
				$("#info-type").after('<select id="info-no" name="info-no" required><option>-- 선택 --</option><option value="11">게으름도 습관이다</option><option value="12">노르웨이숲</option><option value="13">불안</option><option value="14">여자가 없는 남자들</option><option value="15">유혹의 기술</option></select> <input type="hidden" name="genre" value="null">');
				
			}
		break;
		case 'genre':
			if($('#info-no').length > 0){ //info-no 셀렉트박스가 존재하면
				$('#info-no option').remove();
				$('#info-no').append("<option>-- 선택 --</option>'");
        		$('#info-no').append("<option value='21' >인문/사회</option>'");
		        $('#info-no').append("<option value='22' >소설</option>'");
		        $('#info-no').append("<option value='23' >에세이</option>'");
		        $('#info-no').append("<option value='24' >시</option>'");
		        $('#info-no').append("<option value='25' >자기계발</option>'");
		        $('#info-no').append("<option value='26' >건강/다이어트</option>'");
		        $('#info-no').append("<option value='27' >생활/취미</option>'");
				$("#info-no").remove();
				$("#info-type").after('<select id="genre" name="genre" required><option>-- 선택 --</option><option value="인문/사회">인문/사회</option><option value="소설">소설</option><option value="에세이">에세이</option><option value="시">시</option><option value="자기계발">자기계발</option><option value="건강/다이어트">건강/다이어트</option><option value="생활/취미">생활/취미</option></select><input type="hidden" name="info-no" value="0"> ');
				
				
			}else{ // info-no이 존재하지 않으면
				$("#info-type").after('<select id="genre" name="genre" required><option>-- 선택 --</option><option value="인문/사회">인문/사회</option><option value="소설">소설</option><option value="에세이">에세이</option><option value="시">시</option><option value="자기계발">자기계발</option><option value="건강/다이어트">건강/다이어트</option><option value="생활/취미">생활/취미</option></select> <input type="hidden" name="genre" value="null">');
			}
		break;
		
	}
    document.getElementById("schQnaType").style.display = "";
    
    if ($.trim(select) != "") {
        $('#info-type').val(type);
        $('#info-no').val(select);
    }
}		



