<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디렉티브 태그 - index</title>
</head>
<body>
	<%
		int a = 10 ;
		String menu1 = "Home" ;
		String menu2 = "Board" ;
		String menu3 = "Gallery" ;
	%>
	<%@ include file="02_header.jsp" %>
	
	<main>
		<div class="container">
			<h1>메인 컨텐츠</h1>
			<%= a %>
		</div>
	</main>
	
	<%@ include file="02_footer.jsp" %>
</body>
</html>