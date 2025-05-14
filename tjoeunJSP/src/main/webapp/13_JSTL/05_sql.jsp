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
	<%-- ResultImpl -> Board 객체로 매핑 --%> 
	<% 
		ResultImpl result = (ResultImpl) pageContext.getAttribute("resultSet");
		SortedMap[] rows = result.getRows();
		List<Board> boardList = new ArrayList<Board>() ;
		
		for (SortedMap row : rows) {
			LocalDateTime createdAt = (LocalDateTime) row.get("created_at");
			Date create = Date.from(createdAt.atZone(ZoneId.systemDefault()).toInstant());
			LocalDateTime updatedAt = (LocalDateTime) row.get("updated_at");
			Date update = Date.from(updatedAt.atZone(ZoneId.systemDefault()).toInstant());

			Board board = new Board();
			board.setNo( (Integer) row.get("no")) ;
			board.setTitle( (String) row.get("title")) ;
			board.setWriter( (String) row.get("writer")) ;
			board.setContent( (String) row.get("content")) ;
			board.setCreatedAt( create ) ;
			board.setUpdatedAt( update) ;
			boardList.add(board);
		}
		
		pageContext.setAttribute("boardList", boardList);
	%>
	
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
				<td> <fmt:formatDate value="${board.getCreatedAt()}"
					pattern="yyyy-MM-dd HH:mm:ss.sss" /> </td>
				<td> <fmt:formatDate value="${board.getUpdatedAt()}"
					pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" /> </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>