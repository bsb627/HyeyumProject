<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = (String)session.getAttribute("userId");
	out.write("로그인 ID는 : "+userId+"입니다");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 리뷰 리스트</title>
</head>
<body>
<table class="table table-hover" width="100%" cellpadding="0" cellspacing="0" border="1">
	<thread>
	<tr>
		<td>
			<form action="/bookReview/enroll" method="post">
				<button type="submit" class="button" value="글쓰기"></button>
			</form>
		</td>
		<td>
		
		</td>	
	</tr>
	
	
</table>

</table>
</body>
</html>