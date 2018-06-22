package demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

public class ImageDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文件相对路径
		String filePath = "/image/小猫咪.jpeg";
		//文件名
		String filename = filePath.substring(filePath.lastIndexOf("/")+1, filePath.length());
		//用来设置Content-Disposition的文件名
		String encodedFilename = null;
		
		
		//编码的代码不用记，用时复制就可以了。
		String agent = request.getHeader("User-Agent");
		if (agent.contains("MSIE")) {
	        // IE浏览器
			encodedFilename = URLEncoder.encode(filename, "utf-8");
			encodedFilename = encodedFilename.replace("+", " ");
		} else if (agent.contains("Firefox")) {
		        // 火狐浏览器
		BASE64Encoder base64Encoder = new BASE64Encoder();
		encodedFilename = "=?utf-8?B?"
		                + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
		} else {
		        // 其它浏览器
			encodedFilename = URLEncoder.encode(filename, "utf-8");                
		}
		
		
		//用context对象获得文件的真实地址
		String realPath = this.getServletContext().getRealPath(filePath);
		//用context对象的getMimeType方法获得文件MIME类型
		String mimeType = this.getServletContext().getMimeType(filename);
		//设置Content-Type头
		response.setHeader("Content-Type",mimeType);
		//设置Content-Disposition头 以附件形式解析
		response.setHeader("Content-Disposition", "attchment;filename=" + encodedFilename);
		
		//获得输入流
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(realPath));
		//获得输出流
		ServletOutputStream out = response.getOutputStream();
		//文件拷贝标准代码
		int len = 0;
		byte[] b = new byte[1024];
		while((len = in.read(b))!=-1) {
			out.write(b, 0, len);
		}
		//关闭输入流，输出流会自动关闭。
		in.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
