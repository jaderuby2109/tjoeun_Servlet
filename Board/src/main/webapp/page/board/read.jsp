<%@ include file="/layout/jstl.jsp" %>
<%@ include file="/layout/common.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>project💻 - ALOHA CLASS🌴</title>
	<jsp:include page="/layout/meta.jsp" />
	<jsp:include page="/layout/link.jsp" />
</head>
<body>
	<!-- header 포함하기 -->
	<jsp:include page="/layout/header.jsp" />
	<%-- [Contents] ######################################################### --%>
	
	<main>
	<div class="container mt-5">
		<h2 class="mb-4">게시글 조회</h2>
		<form action="">
			<input type="hidden" name="id" value="${board.id}" />

			<div class="mb-3">
				<label for="title" class="form-label">제목</label>
				<input type="text" class="form-control" id="title" name="title" value="${board.title}" required>
			</div>

			<div class="mb-3">
				<label for="username" class="form-label">작성자</label>
				<input type="text" class="form-control" id="username" name="username" value="${board.userNo}" readonly>
			</div>

			<div class="mb-3">
				<label for="content" class="form-label">내용</label>
				<textarea class="form-control" id="content" name="content" rows="6" required>${board.content}</textarea>
			</div>

			<div class="d-flex justify-content-end mt-4">
				<a href="<%=root %>/board/update.jsp?id=${ board.id }" class="btn btn-primary me-2">수정</a>
				<a href="<%=root %>/board/list" class="btn btn-secondary">목록</a>
			</div>
		</form>
	</div>
	</main>

	<%-- [Contents] ######################################################### --%>

	<!-- footer 포함하기 -->
	<jsp:include page="/layout/footer.jsp" />

	<!-- script 포함하기 -->
	<jsp:include page="/layout/script.jsp" />

</body>
</html>