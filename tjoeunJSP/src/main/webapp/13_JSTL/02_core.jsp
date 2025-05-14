<%@page import="java.util.ArrayList"%>
<%@page import="tjoeunJSP.dto.Board"%>
<%@page import="java.util.List"%>
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
<title>JSTL - 게시글 목록</title>
</head>
<body>
<%
	List<Board> boardList = new ArrayList<Board>() ;
	boardList.add(new Board(1, "제목1", "작성자1", "내용1")) ;
	boardList.add(new Board(2, "제목2", "작성자2", "내용2")) ;
	boardList.add(new Board(3, "제목3", "작성자3", "내용3")) ;
%>
<h1>게시글 목록</h1>
<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>내용</th>
		<th>작성일</th>
	</tr>
	
	<%-- 표현언어(EL)로 boardList 가져오기 --%>
	<c:set var="boardList" value="<%= boardList %>" />
	<c:forEach var="board" items="${boardList}">
	<tr>
		<td> <c:out value="${board.getNo()}" /> </td>
		<td> <c:out value="${board.getTitle()}" /> </td>
		<td> <c:out value="${board.getWriter()}" /> </td>
		<td> <c:out value="${board.getContent()}" /> </td>
		<td> <c:out value="${board.getCreatedAt()}" /> </td>

	</tr>
	</c:forEach>
</table><br><br>
<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>내용</th>
		<th>작성일</th>
		<th>수정일</th>
	</tr>
	<%-- 표현문으로로 boardList 가져오기 --%>
	<c:forEach var="board" items="<%= boardList %>">
	<tr>
		<td> <c:out value="${board.getNo()}" /> </td>
		<td> <c:out value="${board.getTitle()}" /> </td>
		<td> <c:out value="${board.getWriter()}" /> </td>
		<td> <c:out value="${board.getContent()}" /> </td>
		<td> <fmt:formatDate value="${board.getCreatedAt()}"
			pattern="yyyy-MM-dd HH:mm:ss.sss" /> </td>
		<td> <fmt:formatDate value="${board.getCreatedAt()}"
			pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" /> </td>
	</tr>
	</c:forEach>

</table>
</body>
</html>

























