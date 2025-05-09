package contentType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.StaticString;

@WebServlet("/TextServlet")
public class TextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GET 요청");
	}

	// curl -X POST http://localhost:8080/Servlet/TextServlet ^
	// -H "Content-Type: text/plain" ^
	// -d "Content Type - Text Type Test"
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 문자 입력 스트림 가져오기
		BufferedReader reader = request.getReader();

		// 2. 텍스트 데이터 읽기
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String requestText = sb.toString();

		// 3. 요청 텍스트 확인
		System.out.println("텍스트 : " + requestText);

		// 4. 응답 텍스트 작성
		String responseText = "응답할 텍스트";
		response.setContentType(StaticString.TEXT_PLAIN);
		PrintWriter writer = response.getWriter();
		writer.println(responseText);
	}
}
