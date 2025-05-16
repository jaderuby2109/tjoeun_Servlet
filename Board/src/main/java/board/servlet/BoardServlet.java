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
		
		String root = request.getContextPath();
		String path = request.getPathInfo();
		String page = "";
		
		System.out.println("BoardServlet : GET : " + path);

		if (path.isEmpty() || path == null || path.equals("/list") || path.equals("/list.jsp")) {
			// 게시글 목록 화면

			List<Board> boardList = boardservice.list();

			request.setAttribute("boardList", boardList);
			page = "/page/board/list.jsp";

		} else if (path.equals("/read") || path.equals("/read.jsp")) {
			// 게시글 조회 화면

			String id = request.getParameter("id");

			Board board = boardservice.selectById(id);
			request.setAttribute("board", board);
			page = "/page/board/read.jsp";

		} else if (path.equals("/create") || path.equals("/create.jsp")) {
			// 게시글 등록 화면

			page = "/page/board/create.jsp";

		} else if (path.equals("/update") || path.equals("/update.jsp")) {
			// 게시글 수정 화면 

			String id = request.getParameter("id");

			Board board = boardservice.selectById(id);
			request.setAttribute("board", board);
			page = "/page/board/update.jsp";

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String root = request.getContextPath();
		String path = request.getPathInfo();
		String page = "";
		
		System.out.println("BoardServlet : POST : " + path);

		if (path.equals("/create") || path.equals("/create.jsp")) {
			// 게시글 등록 처리 

			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int userNo = ((Users) request.getSession().getAttribute("loginUser")).getNo();
			System.out.println("userNo : " + userNo); 
			Board board = Board.builder().id(UUID.randomUUID().toString()) //
					.title(title).content(content).userNo(userNo).build();

			Board createdBoard = boardservice.insert(board);

			if (createdBoard != null) {
				// 등록 성공
				response.sendRedirect(root + "/board/list");
			} else {
				// 등록 실패
				response.sendRedirect(root + "/board/list");
			}

		} else if (path.equals("/update") || path.equals("/update.jsp")) {
			// 게시글 수정 처리

			String id = request.getParameter("id");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int userNo = ((Users) request.getSession().getAttribute("loginUser")).getNo();

			Board board = Board.builder().id(id).title(title).content(content).userNo(userNo).build();

			boolean result = boardservice.updateById(board);

			if (result) {
				System.out.println("수정 성공");
				response.sendRedirect(root + "/board/list");
				return;
			} else {
				System.out.println("수정 실패");
				response.sendRedirect(root + "/board/update.jsp?error=true");
			}

		} else if (path.equals("/delete") || path.equals("/update.jsp")) {
			// 게시글 삭제 처리

			String id = request.getParameter("id");
			
			Board board = Board.builder().id(id).build();
			
			boolean result = boardservice.delete(board);
			if (result) {
				System.out.println("삭제 성공");
				response.sendRedirect(root + "/board/list");
			} else {
				System.out.println("삭제 실패");
				response.sendRedirect(root + "/board/update.jsp?error=true");
			}
		}
	}
}
