<%@page import="tjoeunJSP.dto.Board2"%>
<%@page import="org.eclipse.tags.shaded.org.apache.xpath.XPathContext.XPathExpressionContext"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.SortedMap"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.LocalDateTime"%>

<%@page import="org.apache.taglibs.standard.tag.common.sql.ResultImpl"%>

<%@page import="tjoeunJSP.dto.Board"%>

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
	</sql:query>
	
	<%-- resultSet -> Board 객체로 매핑 (JSTL) --%> 
	<jsp:useBean id="boardList" class="java.util.ArrayList"></jsp:useBean>
	
	<c:forEach var="row" items="${resultSet.rows}">
		<% 
			Board board = new Board(); 
			pageContext.setAttribute("board",board) ;
		%>
<%-- 		<jsp:useBean id="board" class="tjoeunJSP.dto.Board"></jsp:useBean> --%>
		<jsp:setProperty property="no" name="board" value="${row.no}"/>
		<jsp:setProperty property="title" name="board" value="${row.title}"/>
		<jsp:setProperty property="writer" name="board" value="${row.writer}"/>
		<jsp:setProperty property="content" name="board" value="${row.content}"/>
<%-- 		<jsp:setProperty property="createdAt" name="board" value="${row.created_at}"/> --%>
<%-- 		<jsp:setProperty property="updatedAt" name="board" value="${row.updated_at}"/> --%>
		<% boardList.add(board) ;%>
	</c:forEach>

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
		<c:forEach var="board" items="${boardList}">
			<tr>
				<td> <c:out value="${board.getNo()}" /> </td>
				<td> <c:out value="${board.getTitle()}" /> </td>
				<td> <c:out value="${board.getWriter()}" /> </td>
				<td> <c:out value="${board.getContent()}" /> </td>
				<td></td><td></td>
<%-- 				<td> <fmt:formatDate value="${board.getCreatedAt()}" --%>
<%-- 					pattern="yyyy-MM-dd HH:mm:ss.sss" /> </td> --%>
<%-- 				<td> <fmt:formatDate value="${board.getCreatedAt()}" --%>
<%-- 					pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" /> </td> --%>
			</tr>
		</c:forEach>
	</table>
	
	
	
	<c:forEach var="row" items="${resultSet.rows}">
		<% 
			Board2 board2 = new Board2(); 
			pageContext.setAttribute("board2",board2) ;
		%>
		<jsp:setProperty property="no" name="board2" value="${row.no}"/>
		<jsp:setProperty property="title" name="board2" value="${row.title}"/>
		<jsp:setProperty property="writer" name="board2" value="${row.writer}"/>
		<jsp:setProperty property="content" name="board2" value="${row.content}"/>
		<jsp:setProperty property="createdAt" name="board2" value="${row.created_at}"/>
		<jsp:setProperty property="updatedAt" name="board2" value="${row.updated_at}"/>
		<% boardList.add(board2) ;%>
	</c:forEach>

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
		<c:forEach var="board" items="${boardList}">
			<tr>
				<td> <c:out value="${board.getNo()}" /> </td>
				<td> <c:out value="${board.getTitle()}" /> </td>
				<td> <c:out value="${board.getWriter()}" /> </td>
				<td> <c:out value="${board.getContent()}" /> </td>
				<td> <c:out value="${board.getCreatedAt()}" /> </td>
				<td> <c:out value="${board.getCreatedAt()}" /> </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>