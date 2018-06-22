package demo;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import DBUtils.C3P0Utils;
import domain.User;

public class Test {

	
	public static void main(String[] args) {
		//文件相对路径
		String filePath = "/image/小猫咪.jpeg";
		//文件名
		String filename = filePath.substring(filePath.lastIndexOf("/")+1, filePath.length());
		System.out.println(filename);
	}
}
