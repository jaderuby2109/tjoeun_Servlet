<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="/tjoeunJSP/login" method="post">
		<div>
			<label for="username">아이디 : </label> 
			<input type="text" name="username" id="username" />
		</div>
		<div>
			<label for="username">비밀번호 : </label>
			<input type="password" name="password" id="password" />
		</div>
		<p>
			<input type="submit" value="로그인" />
		</p>
	</form>
</body>
</html>