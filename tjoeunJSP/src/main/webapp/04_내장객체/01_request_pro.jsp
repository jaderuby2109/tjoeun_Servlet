<%@page import="tjoeunJSP.Common"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request 내장 객체 : 로그인 요청 처리</title>
</head>
<body>
<%
	request.setCharacterEncoding(Common.UTF_8);
	String id = request.getParameter("id") ;
	String pw = request.getParameter("pw") ;
%>
<h1> 아이디 : <%= id %></h1>
<h1> 비밀번호 : <%= pw %></h1>
</body>
</html>