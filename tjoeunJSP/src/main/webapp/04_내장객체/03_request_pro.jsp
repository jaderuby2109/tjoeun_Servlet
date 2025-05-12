<%@page import="java.util.Enumeration"%>
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
	response.setCharacterEncoding(Common.UTF_8);
	Enumeration<String> params = request.getParameterNames() ;
	while (params.hasMoreElements()) {
		String paramName = params.nextElement() ;
		String paramValue = request.getParameter(paramName);
%>
	<h3> <%= paramName %> : <%= paramValue %></h3>
<%
	}
%>
</body>
</html>