<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 유효 여부 확인 및 무효화</title>
</head>
<body>
	<div><h4>----- 세션 무효화 전 -----</h4></div>
	<%
		String username;
		String password;
	
		// 해당 요청이 속한 session이 유효한지 여부를 반환하는 메소드
		if (request.isRequestedSessionIdValid()) {
			out.println("세션이 유효합니다.<br>");
			username = (String) session.getAttribute("username");
			password = (String) session.getAttribute("password");
				
			out.println("username : " + username + "<br>");
			out.println("password : " + password + "<br>");
			out.println("--------------------------------- <br>");
		} else {
			out.println("세션이 유효하지 않습니다.<br>");
		}
	
	%>
	<div><h4>----- 세션 무효화 후 -----</h4></div>
	<%
		// 세션 무효화 - 세션의 모든 속성들을 제거
		session.invalidate();
	
		// 해당 요청이 속한 session이 유효한지 여부를 반환하는 메소드
		if (request.isRequestedSessionIdValid()) {
			out.println("세션이 유효합니다.<br>");
			username = (String) session.getAttribute("username");
			password = (String) session.getAttribute("password");
				
			out.println("username : " + username + "<br>");
			out.println("password : " + password + "<br>");
			out.println("--------------------------------- <br>");
		} else {
			out.println("세션이 유효하지 않습니다.<br>");
		}
	
	%>
	<div>
		<%-- <a href="<%= request.getContextPath() %>/session03.jsp">session03.jsp</a> --%>
		<a href="06_setSessionTime.jsp">세션 설정 시간 변경</a>
	</div>
</body>
</html>