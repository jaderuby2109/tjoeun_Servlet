<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action Tag - forward A 화면</title>
</head>
<body>
	<h2>forward A 화면</h2>
	<jsp:forward page="01_forward_B.jsp" >
		<jsp:param name="name" value="박조은" />
		<jsp:param name="age" value='<%= request.getParameter("age") %>' />
	</jsp:forward>
	<p>-------------------------------</p>
</body>
</html>