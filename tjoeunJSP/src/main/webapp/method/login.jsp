<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="/tjoeunJSP/method" method="post">
		<label for="username">아이디</label>
		<input type="text" name="username" id="username" placeholder="아이디를 입력하세요." /><br>
		<label for="password">비밀번호</label>
		<input type="password" name="password" id="password" /><br>
		<input type="submit" value="로그인" />
	</form>
</body>
</html>