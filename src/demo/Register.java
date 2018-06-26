package demo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.User;




public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置POST方式request编码，
		request.setCharacterEncoding("UTF-8");
		//用户实例
		User user = new User();
		//设置userID（因为form中无此参数）
		user.setId(UUID.randomUUID().toString());
		//获得post参数map
		Map<String, String[]> properties = request.getParameterMap();
		//使用BeanUtils.populate来封装post参数到User类
		try {
			BeanUtils.populate(user, properties);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
//		System.out.println(user);
		
		//对比用户是否存在
		User userFlag = User.isExist(user);
		User registeredUser = null;
		//判断用户是否存在
		if(userFlag == null) {
			
			//开始注册
			registeredUser = User.register(user);
			if(registeredUser != null) {
				System.out.println("注册成功");
				response.sendRedirect(request.getContextPath()+"/request/login.html");
			}else {
				System.out.println("注册异常");
			}

		}else {
			System.out.println(user.getUsername() + "该用户已存在");
		}
		
		
		//反馈浏览器
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
