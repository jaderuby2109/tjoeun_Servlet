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
<title>JSTL - sql</title>
</head>
<body>
	<sql:setDataSource var="dataSource" 
		url="jdbc:mysql://localhost:3306/aloha?serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true&useSSL=false"
		driver="com.mysql.cj.jdbc.Driver"
		user="aloha"
		password="123456"
	/>
	<%-- 게시글 등록 JSTL 태그 --%>
	<sql:update var="resultSet" dataSource="${dataSource}">
		insert into board(id, title, writer, content)
		values(uuid(), ? , ? , ?) 
		<sql:param value="${param.title}" />
		<sql:param value="${param.writer}" />
		<sql:param value="${param.content}" />
	</sql:update>
	
	<%-- JSTL 이용한 외부 페이지 포함하기 --%>
	<c:import url="05_sql.jsp" var="list" />
	${ list }
</body>
</html>