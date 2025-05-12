<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");		

	// 1. id, passwd 파라미터 가져오기
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	
	// String root = request.getContextPath() + "/05_응답요청처리/";

	// 2. 아이디 비밀번호 일치 여부 확인
	if ( "aloha".equals(id) && "123456".equals(passwd)) {
		// 3-1 로그인 성공
		// - /index.jsp로 이동
		response.sendRedirect("index.jsp");
	} else {
		// 3-2 로그인 실패
		// - /login.jsp?error=true 로 이동
		response.sendRedirect("login.jsp?error=true");
	}
%>
