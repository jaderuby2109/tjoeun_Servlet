package lifecycle;

import java.io.IOException;

import org.apache.catalina.authenticator.Constants;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.StaticString;

@WebServlet("/lifecycle") // 경로 매핑
public class LifecycleServlet extends HttpServlet{

	/**
	 * 서블릿이 최초로 생성될 때 한 번만 호출되는 초기화 메소드
	 * - 초기화 작업
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("서블릿 초기화");
		System.out.println("ServletConfig : " + config);
	}

	/**
	 * 클라이언트로부터 요청이 올 때마다 호출되는 메소드
	 * - 요청 메소드에 따라서, doGet, doPost 등을 자동으로 호출
	 * - 각 요청 메소드에 따른 작업 전 공통으로 처리 할 작업
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service 메소드 호출");
		super.service(request, response); // 메소드에 따라서 doGet, doPost 자동 호출
	}

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding(StaticString.UTF_8);
		response.setContentType(StaticString.TEXT_PLAIN);
		response.getWriter().println("화면 출력!");
		System.out.println("doGet 메소드 호출");
	}

	/**
	 * 서블릿이 종료될 때 호출되는 메소드
	 * - 자원을 해제할 때 사용
	 */
	@Override
	public void destroy() {
		System.out.println("서블릿 종료!");
	}
}
