<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL - session</title>
</head>
<body>
	<h2>sessionScope EL 내장 객체</h2>
	<%
		session.setAttribute("username", "joeun") ;
	%>
	
	<h2>로그인 된 아이디 : ${ sessionScope.username }</h2>
	<a href="03_EL_1.jsp">03_EL_1.jsp</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="03_EL_2.jsp">03_EL_2.jsp</a>
</body>
</html>