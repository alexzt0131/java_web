package demo;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servletContextDemo extends HttpServlet {
	
	/*
	 * 
	 * ServletContext的作用
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//(1) 获得web应用全局的初始化参数
		//获得context对象
		ServletContext context = this.getServletContext();
		//获得参数
		String driverAttr = (String) context.getInitParameter("driver");
		response.getWriter().println(driverAttr);
		//获得所有参数的名字
		Enumeration<String> e = context.getInitParameterNames();
		while(e.hasMoreElements()) {
			response.getWriter().println("attr:"+e.nextElement());
		}
		
		//(2) 获得web应用中任何资源的绝对路径工程根目录就是/ 或者不加符号，并且只能填写webcontent目录下的地址
		//通过类加载器获得src目录下的配置文件（发布后在发布目录的WEB-INF/classes目录）
		String realPath = context.getRealPath(servletContextDemo.class.getClassLoader().getResource("c3p0-config.xml").getPath());
		response.getWriter().println(realPath);
		
		//(3) ServletContext是一个域对象（重要 重要 重要）
		//ServletContext域对象的作用范围：整个web应（所有的web资源都可以随意向    servletcontext域中存取数据，数据可以共享）
		//		域对象的通用的方法：
		//		setAtrribute(String name,Object obj);
		//		getAttribute(String name); 如果没有该数据返回null
		//		removeAttribute(String name) 
		//这里只用一个servlet模拟，实质上在一个servlet设置一个参数所有的servletcontext域中都可访问该参数
		context.setAttribute("testContent", "testText");
		//知道什么类型就直接强转了
		response.getWriter().println(context.getAttribute("testContent")); 
		context.removeAttribute("testContent");
		response.getWriter().println(context.getAttribute("testContent")); 
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
