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
	<h1>게시글 수정</h1>
	<form action="09_sql_update_pro.jsp" method="post">
	<div>
		<label for="no">번호</label>
		<input type="text" name="no" id="no" />
	</div>
	<div>
		<label for="title">제목</label>
		<input type="text" name="title" id="title" />
	</div>
	<div>
		<label for="writer">작성자</label>
		<input type="text" name="writer" id="writer" />
	</div>
	<div>
		<label for="content">내용</label>
		<textarea rows="4" cols="20" name="content" id="content" ></textarea>
	</div>
	<input type="submit" value="수정" />
	</form>
</body>
</html>