<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 정보 삭제</title>
</head>
<body>
	<div><h4>----- 세션 정보 삭제 전 -----</h4></div>
	<%
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
			
		out.println("username : " + username + "<br>");
		out.println("password : " + password + "<br>");
		out.println("--------------------------------- <br>");
		
	%>
	<div><h4>----- 세션 정보 삭제 후 -----</h4></div>
	<%
		// 세션 속성 제거
		session.removeAttribute("username");
		session.removeAttribute("password");
	
		username = (String) session.getAttribute("username");
		password = (String) session.getAttribute("password");
			
		out.println("username : " + username + "<br>");
		out.println("password : " + password + "<br>");
		out.println("--------------------------------- <br>");
	%>
	<div>
		<%-- <a href="<%= request.getContextPath() %>/session03.jsp">session03.jsp</a> --%>
		<a href="05_deleteSession.jsp">세션 삭제</a>
	</div>
</body>
</html>