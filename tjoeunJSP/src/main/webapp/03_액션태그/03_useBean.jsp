<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 태그 - 자바빈즈</title>
</head>
<body>
	
	<%-- pserson이란 이름으로 Person 객체 생성  --%>
	<%-- Person person = new Person(); --%>
	<jsp:useBean id="person" class="tjoeunJSP.beans.Person" />
	
	<h3>이름 : <%= person.getName() %></h3>
	<h3>나이 : <%= person.getAge() %></h3>
	<hr>
	
	<h3>이름 : <jsp:getProperty property="name" name="person" /></h3>
	<h3>나이 : <jsp:getProperty property="age" name="person" /></h3>
	<hr>
	
	<jsp:setProperty property="name" name="person" value="참조은"/>
	<jsp:setProperty property="age" name="person" value="25"/>
	
	<h3>이름 : <jsp:getProperty property="name" name="person" /></h3>
	<h3>나이 : <jsp:getProperty property="age" name="person" /></h3>
	<hr>
	
	<%
		person.setName("더조은");
		person.setAge(30);
	%>
	<h3>이름 : <jsp:getProperty property="name" name="person" /></h3>
	<h3>나이 : <jsp:getProperty property="age" name="person" /></h3>
	<hr>
</body>
</html>