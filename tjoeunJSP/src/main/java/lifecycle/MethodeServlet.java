package lifecycle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.StaticString;

@WebServlet("/method")
public class MethodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// GET
	// - /method?name=김조은&age=20
	// - 요청 파라미터 : name, age
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		try {
			// 요청
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			System.out.println("name : " + name);
			System.out.println("age : " + age);

			// 응답
			response.setContentType(StaticString.TEXT_HTML);
			writer.println("<h1>이름 : " + name + "</h1>");
			writer.println("<h1>나이 : " + age + "</h1>");
			writer.flush(); // 출력 바로 내보내기
		} catch (Exception e) {
			System.out.println("파라미터가 올바르지 않습니다.");
		}
	}

	// POST
	// - /method
	// - body : username, password
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("username : " + username);
		System.out.println("password : " + password);

		// 응답
		response.setContentType(StaticString.TEXT_HTML);
		PrintWriter writer = response.getWriter();
		writer.println("<h1>아이디 : " + username + "</h1>");
		writer.println("<h1>비밀번호 : " + password + "</h1>");
	}

	// PUT
	// - /method
	// - 컨텐츠 타입 : JSON
	// - 요청 본문 (body)
	// {"no" : "1", "title" : "제목", "content" :"내용"}
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletInputStream sis = request.getInputStream();

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = mapper.readValue(sis, new TypeReference<Map<String, Object>>() {
		});
		// Map<String, Object> map = mapper.readValue(sis, Map.class );
		Set<String> keySet = map.keySet();
		for (String key: keySet) {
			System.out.println(key);
		}
		
		String no = (String) map.get("no");
		String title = (String) map.get("title");
		String content = (String) map.get("content");
		System.out.println(no);
		System.out.println(title);
		System.out.println(content);

		// 응답
		response.setCharacterEncoding(StaticString.UTF_8);
		response.setContentType(StaticString.TEXT_HTML);
		PrintWriter writer = response.getWriter();
		writer.println("<h1>번호 : " + no + "</h1>");
		writer.println("<h1>제목 : " + title + "</h1>");
		writer.println("<h1>내용 : " + content + "</h1>");
		/*
		 curl -X PUT http://localhost:8080/tjoeunJSP/method ^
		 -H "Content-Type: application/json" ^
		 -d "{\"no\" : \"1\", \"title\" : \"제목\", \"content\" :\"내용\"}"
		*/
		// curl : 커멘드라인 URL
		// curl -X DELETE http://localhost:8080/tjoeunJSP/method?no=10
		// -X : 요청 메소드 지정
		// -H : 헤더 지정
		// -d : 바디 지정
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String noString = request.getParameter("no");
		int no = 0;
		try {
			no = Integer.parseInt(noString);
		} catch (Exception e) {
			System.out.println("유효하지 않은 번호입니다.");
		}
		response.setCharacterEncoding(StaticString.UTF_8);
		response.setContentType(StaticString.TEXT_PLAIN);
		PrintWriter writer = response.getWriter();
		writer.println(no + "번 글을 삭제하였습니다.");
	}

}
