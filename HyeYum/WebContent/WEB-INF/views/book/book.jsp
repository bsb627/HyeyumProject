<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 글쓰기</title>
</head>
<body>
	<h3>도서 글쓰기 폼</h3>
	<form action="/book/write" method="get">
		<input type="hidden" name="file-type" value="book">
		<input type="submit" value="등록">
	</form>
</body>
</html>