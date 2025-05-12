<%@page import="tjoeunJSP.Common"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request 내장 객체</title>
</head>
<body>
<%
	request.setCharacterEncoding(Common.UTF_8);
	// * 첫 번째 값만 가져온다.
	String hobby = request.getParameter("hobby") ;
	
	// * 하나의 파라미터에 여러 값을 가져오는 경우
	String[] hobbies = request.getParameterValues("hobby") ;
%>
<h1><%= hobby %></h1>
<hr>
<h1> 취미 : <% for(int i = 0 ; i < hobbies.length ; i++ ) { %>
	<%= hobbies[i] %> <%}%></h1>
</body>
</html>