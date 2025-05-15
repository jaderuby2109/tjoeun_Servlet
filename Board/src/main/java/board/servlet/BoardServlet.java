package board.servlet;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import board.DTO.Board;
import board.DTO.Users;
import board.Service.BoardService;
import board.Service.BoardServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/board/*")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardservice = new BoardServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BoardServlet : GET");
		String root = request.getContextPath();
		String path = request.getPathInfo();
		String page = "";

		if (path.equals("/list") || path.equals("/list.jsp")) {
			// 게시글 목록
			List<Board> boardList = boardservice.list();

			request.setAttribute("boardList", boardList);
			page = "/page/board/list.jsp";

		} else if (path.equals("/read") || path.equals("/read.jsp")) {
			// 게시글 조회
			String id = request.getParameter("id");

			Board board = boardservice.selectById(id);
			request.setAttribute("board", board);
			page = "/page/board/read.jsp";

		} else if (path.equals("/create") || path.equals("/create.jsp")) {
			page = "/page/board/create.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BoardServlet : POST");

		String root = request.getContextPath();
		String path = request.getPathInfo();
		String page = "";

		if (path.equals("/create") || path.equals("/create.jsp")) {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			System.out.println(request.getSession().getAttribute("loginUser"));
			int userNo = ((Users) request.getSession().getAttribute("loginUser")).getNo();

			System.out.println(userNo);
			Board board = Board.builder().id(UUID.randomUUID().toString()).title(title).content(content).userNo(userNo)
					.build();
			System.out.println(board.toString());

			Board createdBoard = boardservice.insert(board);

			if (createdBoard != null) {
				response.sendRedirect(root + "/page/board/list");
			}
		} else if (path.equals("/read") || path.equals("/read.jsp")) {

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
}
