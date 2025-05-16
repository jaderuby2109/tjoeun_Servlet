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
		<h2 class="mb-4">게시글 수정</h2>
		<form id="form" action="<%= root%>/board/update" method="post">
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
				<button type="submit" class="btn btn-primary me-2">수정</button> 
				<button type="button"  id="btn-delete" class="btn btn-danger">삭제</button> 
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
	<script type="text/javascript">
		const form = document.getElementById("form");
		
		// 삭제 버튼 클릭
		$('#btn-delete').on('click', function() {
			const check = confirm("정말로 삭제하시겠습니까?");
			if(!check) return ;
			form.action = "/Board/board/delete" ;
			// form.attr("action", "/Board/board/delete") ;
			// alert(form.action) ;
			form.submit();
		});
	</script>
</body>
</html>