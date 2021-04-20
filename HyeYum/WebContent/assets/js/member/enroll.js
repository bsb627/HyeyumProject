$(document).ready(function() {
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
                var userName = $("user-name").val();
                var nameExp = /^[가-힣]{2,6}$/;
                if(!nameExp.test(userName)) {
                    alert("이름은 한글, 최소 2글자에서 6글자를 입력해야합니다.");
                    return false;
                }
                // PW 입력
                // 비밀번호 길이 검사 (8글자 이상, 12자 이하 및 영문자, 숫자
                // 비밀번호는 최소 8글자 이상, 최대 12글자 이고 영문자, 숫자만 허용됩니다. 출력
                var userPw = $("#user-pw").val();
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
                
                //전화번호 입력
                var tel = $("#user-phone").val();
                var telRegExp = /^010[0-9]{8}$/;
                if(!telRegExp.test(tel)) {
                    alert("010부터 입력해주세요");
                    return false;
                }
              
            });

        });