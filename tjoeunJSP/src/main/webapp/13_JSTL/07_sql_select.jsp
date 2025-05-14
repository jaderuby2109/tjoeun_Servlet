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
	
	<sql:query var="resultSet" dataSource="${dataSource}">
		SELECT * FROM board
		WHERE no = ?
		<sql:param value="${param.no} }" />
	</sql:query>
	
	<%-- resultSet -> Board 객체로 매핑 (JSTL) --%> 
	<c:set var="row" value="${resultSet.rows[0]}" />
	<jsp:useBean id="board" class="tjoeunJSP.dto.Board2"></jsp:useBean>
	<jsp:setProperty property="no" name="board" value="${row.no}"/>
	<jsp:setProperty property="title" name="board" value="${row.title}"/>
	<jsp:setProperty property="writer" name="board" value="${row.writer}"/>
	<jsp:setProperty property="content" name="board" value="${row.content}"/>
	<jsp:setProperty property="createdAt" name="board" value="${row.created_at}"/>
	<jsp:setProperty property="updatedAt" name="board" value="${row.updated_at}"/>

	<h1>게시글 목록</h1>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>내용</th>
			<th>작성일</th>
			<th>수정일</th>
		</tr>
		<tr>
			<td> <c:out value="${board.getNo()}" /> </td>
			<td> <c:out value="${board.getTitle()}" /> </td>
			<td> <c:out value="${board.getWriter()}" /> </td>
			<td> <c:out value="${board.getContent()}" /> </td>
			<td> <c:out value="${board.getCreatedAt()}" /> </td>
			<td> <c:out value="${board.getCreatedAt()}" /> </td>
		</tr>
	</table>
</body>
</html>