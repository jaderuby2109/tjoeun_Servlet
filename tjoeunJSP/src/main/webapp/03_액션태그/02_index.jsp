<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 태그 - include</title>
</head>
<body>
	<%
		int a = 10 ;
		String menu1 = "Home" ;
		String menu2 = "Board" ;
		String menu3 = "Gallery" ;
	%>
	
	<%-- 액션태그 include --%>
	<jsp:include page="02_header.jsp" >
		<jsp:param value="<%= menu1 %>" name="menu1"/>
		<jsp:param value="<%= menu2 %>" name="menu2"/>
		<jsp:param value="<%= menu3 %>" name="menu3"/>
	</jsp:include>
	
	<main>
		<div class="container">
			<h1>메인 컨텐츠</h1>
		</div>
	</main>
	
	<jsp:include page="02_footer.jsp" >
		<jsp:param value="<%= a %>" name="a"/>
	</jsp:include>
</body>
</html>