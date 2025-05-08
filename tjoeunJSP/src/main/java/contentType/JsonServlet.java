package contentType;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// JSON 사용용 외부 라이브러리
	// Jackson or Gson
	// 2. Gson
	// Gson gson = new Gson();
	//
	// // 객체 -> JSON
	// User user = new User("Alice", 25);
	// String json = gson.toJson(user);
	// System.out.println(json);
	//
	// // JSON -> 객체
	// String input = "{\"name\":\"Bob\",\"age\":30}";
	// User user2 = gson.fromJson(input, User.class);
	// System.out.println(user2.getName());
	//
	// 3. org.json

	// curl -X GET http://localhost:8080/tjoeunJSP/JsonServlet ^
	// -H "Content-Type: application/json" ^
	// -d
	// "{\"name\":\"ALOHA\",\"age\":\"20\",\"roles\":[\"ROLE_USER\",\"ROLE_ADMIN\",\"ROLE_MGR\"]}"
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GET");

		// JSON -> MAP
		ServletInputStream sis = request.getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = mapper.readValue(sis, new TypeReference<Map<String, Object>>() {
		});

		String name = (String) map.get("name");
		int age = Integer.parseInt((String) map.get("age"));
		List<String> roles = (List<String>) map.get("roles");
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		System.out.println("roles : " + roles);

		// 응답
		// MAP -> JSON
		String jsonString = mapper.writeValueAsString(map);
		PrintWriter writer = response.getWriter();
		writer.println(jsonString);

	}

	// curl -X POST http://localhost:8080/tjoeunJSP/JsonServlet ^
	// -H "Content-Type: application/json" ^
	// -d
	// "{\"name\":\"ALOHA\",\"age\":\"20\",\"roles\":[\"ROLE_USER\",\"ROLE_ADMIN\",\"ROLE_MGR\"]}"
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("POST");

		// JSON -> MAP
		ServletInputStream sis = request.getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = mapper.readValue(sis, new TypeReference<Map<String, Object>>() {
		});

		String name = (String) map.get("name");
		int age = Integer.parseInt((String) map.get("age"));
		List<String> roles = (List<String>) map.get("roles");
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		System.out.println("roles : " + roles);

		// 응답
		// MAP -> JSON
		String jsonString = mapper.writeValueAsString(map);
		PrintWriter writer = response.getWriter();
		writer.println(jsonString);
	}

	// curl -X PUT http://localhost:8080/tjoeunJSP/JsonServlet ^
	// -H "Content-Type: application/json" ^
	// -d
	// "{\"name\":\"ALOHA\",\"age\":\"20\",\"roles\":[\"ROLE_USER\",\"ROLE_ADMIN\",\"ROLE_MGR\"]}"
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("PUT");

		// JSON -> 객체
		ServletInputStream sis = request.getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		Users users = mapper.readValue(sis, Users.class);

		String name = users.getName();
		int age = users.getAge();
		List<String> roles = users.getRoles();
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		System.out.println("roles : " + roles);

		// 응답
		// 객체 -> JSON
		String jsonString = mapper.writeValueAsString(users);
		PrintWriter writer = response.getWriter();
		writer.println(jsonString);
	}
}
