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
<title>EL에서 사용하는 내장 객체</title>
</head>
<body>
	<h2>EL에서 사용하는 내장 객체</h2>
	<h3>requestScope 속성 : ${ requestScope.name }</h3>
	
	<%
		// pname 은 pageContext 에 등록해서 , 현재 페이지에서만 사용 가능
		pageContext.setAttribute("pname", "페이지");
	
		// name 은 request에 등록해서 forward된 화면에서도 사용 가능
		request.setAttribute("name", "김조은") ;
		
		// 포워드 방식으로 페이지 이동
		request.getRequestDispatcher("02_requestScope_pro.jsp").forward(request,	response) ;
	%>
	
	<h2> requestScope 속성 : ${requestScope.name }</h2>
</body>
</html>