<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 유효시간 설정</title>
</head>
<body>
	<div><h4>----- 세션 유효 시간 변경 전 -----</h4></div>
	<%
		// 세션의 유효시간을 반환하는 메소드(초 단위)
		int time = session.getMaxInactiveInterval() / 60 ;
		out.println("세션 유효 시간 : " + time + "분 <br>");
	
	%>
	<div><h4>----- 세션 유효 시간 변경 후 -----</h4></div>
	<%
		int interval = 60 * 60 ;  // 60(초) x 60(분) = 1시간
		session.setMaxInactiveInterval( interval );
	
		// 세션의 유효시간을 반환하는 메소드(초 단위)
		time = session.getMaxInactiveInterval() / 60 ;
		out.println("세션 유효 시간 : " + time + "분 <br>");
	
	%>
	<br>
	<div>
		<a href="07_getAccessTime.jsp">세션 경과 시간</a>
	</div>
</body>
</html>