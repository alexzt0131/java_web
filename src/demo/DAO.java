package demo;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import DBUtils.C3P0Utils;
import domain.User;

public class DAO {
	
	
	private static QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());;
	
	
	public User lgoin(User user) {
		/*
		 * 检测传入用户的帐号密码是否存在与数据库
		 * 存在返回该用户的bean
		 * 不存在返回null
		 */
		String sql = "select * from user where username=? and password=?";
		
		try {
			return qr.query(sql, new BeanHandler<domain.User>(domain.User.class), user.getName(),user.getPassword());
		} catch (SQLException e) {
			return null;
		}
		
	}

}
