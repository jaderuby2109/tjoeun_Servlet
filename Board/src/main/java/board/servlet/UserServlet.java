package board.servlet;

import java.io.IOException;
import java.util.UUID;

import board.DTO.Users;
import board.Service.UserService;
import board.Service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();

	/**
	 * [GET]
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("아이디 중복 확인...");

		String uri = request.getRequestURI();		// /Board/join
		String root = request.getContextPath();		// /Board
		String path = request.getPathInfo();

		if (path.equals("/idCheck")) {
			String username = request.getParameter("username");
			boolean check = userService.idCheck(username);
			response.getWriter().print(check);

		} else if (path.equals("/logout")) {

			System.out.println("로그아웃");
			HttpSession session = request.getSession();
			session.invalidate();
			response.encodeRedirectURL(root + "/");
		}
	}

	/**
	 * [POST]
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();		// /Board/join
		String root = request.getContextPath();		// /Board
		String path = request.getPathInfo();

		// /join - 회원 가입
		if (path.equals("/join")) {

			System.out.println("회원가입 요청 처리...");

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			// String password_confirm = request.getParameter("password_confirm") ;
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			Users user = Users.builder().id(UUID.randomUUID().toString()).username(username).password(password)
					// .passwordConfirm(password_confirm)
					.name(name).email(email).build();

			int result = userService.join(user);

			if (result > 0) {

				// 회원 가입 성공
				response.sendRedirect(root + "/");

			} else {

				// 회원 가입 실패
				response.sendRedirect(root + "/join.jsp?error=true");
			}

		} else if (path.equals("/login")) {

			// 회원 조회
			String username = request.getParameter("username");
			String passowrd = request.getParameter("password");
			Users user = Users.builder().username(username).password(passowrd).build();
			boolean result = userService.login(user);

			// 로그인 성공
			if (result) {
				System.out.println("로그인 성공");
				// 회원 조회
				Users loginUser = userService.selectByUsername(username);
				loginUser.setPassword(null);

				// 세션에 사용자 정보 등록
				HttpSession session = request.getSession();
				session.setAttribute("loginId", user.getUsername());
				session.setAttribute("loginUser", loginUser);
				System.out.println("loginUser.getNo() : " + loginUser.getNo());
				response.sendRedirect(root + "/");
			} else {
				System.out.println("로그인 실패");
				response.sendRedirect(root + "/login.jsp?error=true");
			}
		}
	}
}
