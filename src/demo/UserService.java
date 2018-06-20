package demo;

import domain.User;

public class UserService {
	
	private DAO dao = new DAO();
	
	public User login(User user) {
		//调用DAO中的登录函数
		return dao.lgoin(user);
	}
}
