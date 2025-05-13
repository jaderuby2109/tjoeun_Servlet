<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션의 모든 속성 값 확인</title>
</head>
<body>
	<h1>세션의 모든 속성 값 확인</h1>
	<%
		String name ; 
		String value ;
		//모든 세션 속성 이름을 반환
		Enumeration<String> en = session.getAttributeNames();
		while (en.hasMoreElements()) {
			name = en.nextElement().toString();
			value = session.getAttribute(name).toString();
			
			out.println("세션 속성 이름 : " + name + "<br>");
			out.println("세션 속성 값 : " + value + "<br>");
			out.println("--------------------------------- <br>");
		}
	%>
	<div>
		<%-- <a href="<%= request.getContextPath() %>/session03.jsp">session03.jsp</a> --%>
		<a href="04_removeSession.jsp">세션 정보 삭제</a>
	</div>
	<div>
		<a href="05_deleteSession.jsp">세션 삭제</a>
	</div>
	<div>
		<a href="06_setSessionTime.jsp">세션 설정 시간 변경</a>
	</div>
	<div>
		<a href="07_getAccessTime.jsp">세션 경과 시간</a>
	</div>
</body>
</html>