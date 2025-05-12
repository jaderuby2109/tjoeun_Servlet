<%@page import="java.util.Random"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page import="tjoeunJSP.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력 요청 처리</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");		

		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String sex = request.getParameter("sex");
		// request.getParameterValues()  
		// : 2 개이상의 파라미터 값을 배열로 반환하는 메소드
		String[] hobby = request.getParameterValues("hobby");
		String comment = request.getParameter("comment");
		
		// 요청 정보를 객체로 매핑
		User user = new User();
		user.setId(id);
		user.setPasswd(passwd);
		user.setName(name);
		user.setPhone(phone1+phone2+phone3);
		List<String> hobbyList = Arrays.asList(hobby);
		user.setHobby(hobbyList);
		user.setComment(comment);
		
		// 서비스로 데이터 등록 요청 (회원가입 처리)
		// boardService.insert(user);
		Random random = new Random();
		int result = random.nextInt(2);
		
		String root = request.getContextPath();
		// 회원가입 성공
		if( result > 0 ) {
%>
	<jsp:forward page="join_pro.jsp" >
		<jsp:param name="id" value='<%= request.getParameter("id") %>' />
		<jsp:param name="passwd" value='<%= request.getParameter("passwd") %>' />
		<jsp:param name="name" value='<%= request.getParameter("name") %>' />
		<jsp:param name="phone1" value='<%= request.getParameter("phone1") %>' />
		<jsp:param name="phone2" value='<%= request.getParameter("phone2") %>' />
		<jsp:param name="phone3" value='<%= request.getParameter("phone3") %>' />
		<jsp:param name="sex" value='<%= request.getParameter("sex") %>' />
		<jsp:param name="hobby" value='<%= request.getParameterValues("hobby") %>' />
		<jsp:param name="comment" value='<%= request.getParameter("comment") %>' />
	</jsp:forward>
<%
		}
		// 회원가입 실패
		else {
			// - 회원가입 화면으로 이동
			response.sendRedirect("join.jsp?error=true");
		}
	%>
	
</body>
</html>