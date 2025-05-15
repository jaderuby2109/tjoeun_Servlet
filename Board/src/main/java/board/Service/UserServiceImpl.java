package board.Service;

import java.util.HashMap;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;

import board.DAO.UserDAO;
import board.DTO.Users;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO = new UserDAO();

	/**
	 * 회원가입
	 */
	@Override
	public int join(Users user) {

		try {
			// 비밀번호 암호화
			String password = user.getPassword();
			System.out.println("password : " + password);
			String encodedPw = BCrypt.hashpw(password, BCrypt.gensalt());
			System.out.println("password : " + encodedPw);
			user.setPassword(encodedPw);

			int result = userDAO.insert(user);
			return result; // 등록 성공
		} catch (Exception e) {
			e.printStackTrace();
			return 0; // 등록 실패
		}
	}

	/**
	 * 아이디 중복 확인
	 */
	@Override
	public boolean idCheck(String username) {
		System.out.println("UserServiceImpl idCheck : " + username);

		Map<Object, Object> map = new HashMap<>();
		map.put("username", username);
		Users user = null;

		try {
			user = userDAO.selectBy(map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (user == null) {
			return false;
		}
		return true;
	}

	// 로그인
	@Override
	public boolean login(Users user) {
		String username = user.getUsername();
		String password = user.getPassword();

		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("username", username);

		Users joinedUser = null;
		
		try {
			joinedUser = userDAO.selectBy(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 아이디가 존대하지 않는 경우
		if (joinedUser == null) {
			System.out.println("아이디가 존재하지 않습니다.");
			return false;
		
		} else {
			
			System.out.println("아이디 존재");
			
			System.out.println("password : " + password);
			System.out.println("password : " + BCrypt.hashpw(password, BCrypt.gensalt()));

			// 비밀번호 일치 여부 확인
			String joinedpw = joinedUser.getPassword();
			System.out.println("joinedpw : " + joinedpw);
			boolean checkpw = BCrypt.checkpw(password, joinedpw);
			
			System.out.println("비밀번호 일치 여부 : " + checkpw);
			return checkpw;
		}
	}

	@Override
	public Users selectByUsername(String username) {

		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("username", username);

		Users user = null;
		try {
			user = userDAO.selectBy(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return user ;
	}
}





















