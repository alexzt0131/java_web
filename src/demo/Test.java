package demo;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import DBUtils.C3P0Utils;
import domain.User;

public class Test {

	
	public static void main(String[] args) {
		
		QueryRunner queryrunner = new QueryRunner(C3P0Utils.getDataSource());
		User user = null;
		String sql = "select * from user where username=? and password=?";
		Object[] params = {"alex", "1234"}; 
		try {
			user = queryrunner.query(sql, new BeanHandler<domain.User>(User.class), params);
			System.out.println(user);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
