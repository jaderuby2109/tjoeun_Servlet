<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="01_fileUpload_pro.jsp" 
	method="post" enctype="multipart/form-data">
		<div>
			<label for="name">이름</label>
			<input type="text" name="name" id="name" />
		</div>
		<div>
			<label for="title">제목</label>
			<input type="text" name="title" id="title" />
		</div>
		<div>
			파일 : <input type="file" name="file1" /><br>
			파일 : <input type="file" name="file2" />
		</div>
		<input type="submit" value="jsp 업로드" />
	</form>
	<br><hr><br>
	<form action="${pageContext.request.contextPath}/fileUpload" 
	method="post" enctype="multipart/form-data">
		<div>
			<label for="name">이름</label>
			<input type="text" name="name" id="name" />
		</div>
		<div>
			<label for="title">제목</label>
			<input type="text" name="title" id="title" />
		</div>
		<div>
			파일 : <input type="file" name="file1" /><br>
			파일 : <input type="file" name="file2" />
		</div>
		<input type="submit" value="servlet 업로드" />
	</form>
</body>
</html>