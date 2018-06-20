package demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获得request传来的参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//封装到User类
		User user = new User();
		user.setName(username);
		user.setPassword(password);
		//查询用户是否存在
		UserService us = new UserService();
		User userFlag = us.login(user);
		//response反馈
		if(userFlag != null) {
			response.getWriter().println("User:" + username + "登录成功!");
		}else {
			response.getWriter().println("用户不存在或密码错误!");
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
