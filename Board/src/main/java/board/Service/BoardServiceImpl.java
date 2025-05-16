package board.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.DAO.BoardDAO;
import board.DTO.Board;

public class BoardServiceImpl implements BoardService {
	private BoardDAO boardDAO = new BoardDAO();

	@Override
	public List<Board> list() {
		List<Board> list = null;

		try {
			list = boardDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Board select(int no) {
		Board board = null;

		try {
			board = boardDAO.select(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}

	@Override
	public Board selectById(String id) {
		Board board = null;

		try {
			Map<String, Object> map = new HashMap<>();
			map.put("id", id);
			board = boardDAO.selectBy(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}

	@Override
	public Board insert(Board board) {
		System.out.println("등록");
		int result = 0;
		try {
			result = boardDAO.insert(board);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result > 0) {
			return board;
		}
		return null;
	}

	@Override
	public boolean update(Board board) {
		int result = 0;
		try {
			result = boardDAO.update(board);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Board board) {
		int result = 0;
		String id = board.getId();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);

		try {
			result = boardDAO.deleteBy(map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateById(Board board) {
		int result = 0;
		String id = board.getId();
		Board originBoard = selectById(id);
		int no = originBoard.getNo();
		board.setNo(no);

		try {
			result = boardDAO.update(board);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result > 0) {
			return true;
		}
		return false;
	}
}
