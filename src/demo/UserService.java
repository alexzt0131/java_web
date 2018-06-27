package demo;

import DBUtils.UserDAO;
import domain.User;

public class UserService {
	
	private DAO dao = new DAO();
	
	public User login(User user) {
		//调用DAO中的登录函数
		return dao.lgoin(user);
	}
	
	
	public static User isExist(User user) {
		return UserDAO.isExist(user);
	}

	public static User register(User user) {
		
		return UserDAO.register(user);

	}
}
