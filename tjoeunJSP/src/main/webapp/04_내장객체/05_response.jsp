<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response 내장 객체</title>
</head>
<body>
	<h1>5초마다 새로고침</h1>
	<% response.setIntHeader("Refresh", 5) ; %>
	<h3><%= new Date() %></h3>
</body>
</html>