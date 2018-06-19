package demo;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ParamServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获得一个参数的值
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(name);
		System.out.println(password);
		System.out.println("-----------------------");
		//获得一组参数
		String[] values = request.getParameterValues("hobby");
		for (String string : values) {
			System.out.println(string);
		}
		System.out.println("-----------------------");
		//获得所有数据,返回的值的String[]的要注意
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (String key : parameterMap.keySet()) {
			System.out.println("key="+key + "__" + "value="+Arrays.toString(parameterMap.get(key)));
		}
		System.out.println("-----------------------");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
