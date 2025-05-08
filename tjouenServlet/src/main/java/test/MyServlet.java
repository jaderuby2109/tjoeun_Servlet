package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, 	// 요청 객체 
    		HttpServletResponse response)				// 응답 객체
            throws ServletException, IOException {
        
    	// HTML 컨텐츠 타입으로 
    	response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
		// "Hello, World!"를 응답한다.
        writer.print("Hello, World!");
        writer.println("<br>");

        // 클라이언트의 요청 메서드를 확인
        String method = request.getMethod();
        writer.println("HTTP 요청 메서드: " + method);
        writer.println("<br>");

        // 요청 파라미터 가져오기
        String paramValue = request.getParameter("paramName");
        writer.println("파라미터 값: " + paramValue);
        writer.println("<br>");

        // 요청 URI와 URL 가져오기
        String requestURI = request.getRequestURI();
        writer.println("요청 URI: " + requestURI);
        writer.println("<br>");

        StringBuffer requestURL = request.getRequestURL();
        writer.println("요청 URL: " + requestURL.toString());
        writer.println("<br>");

        // 특정 HTTP 헤더 값 가져오기
        String userAgent = request.getHeader("User-Agent");
        writer.println("User-Agent 헤더: " + userAgent);
        writer.println("<br>");

        // 클라이언트 IP 주소 확인
        String remoteAddr = request.getRemoteAddr();
        writer.println("클라이언트 IP 주소: " + remoteAddr);
        writer.println("<br>");
    }
}