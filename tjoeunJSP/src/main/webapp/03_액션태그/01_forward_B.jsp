<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action Tag - forward B 화면</title>
</head>
<body>
	<h2>forward B 화면</h2>
	<p>name : <%= request.getParameter("name") %></p>
	<p>age : <%= request.getParameter("age") %></p>
	<p>title : <%= request.getParameter("title") %></p>
</body>
</html>