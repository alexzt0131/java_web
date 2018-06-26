package DBUtils;

import java.sql.SQLException;
import java.util.Arrays;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import domain.User;

public class UserDAO {
	private static QueryRunner qr = null;
	static {
		qr = new QueryRunner(C3P0Utils.getDataSource());
	}
	
	public static User isExist(User user) {
		String sql = "select * from user where username=?";
		try {
			return qr.query(sql, new BeanHandler<User>(User.class), user.getUsername());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static User register(User user) {
//		System.out.println("--------------------------------");
//		Object[] params = {user.getId(), user.getUsername(), user.getPassword(), user.getGander()};
//		System.out.println(params);
//		return null;
		try {
			String sql = "insert into user values(?,?,?,?)";
			Object[] params = {user.getId(), user.getUsername(), user.getPassword(), user.getGander()};
			System.out.println("--------------------------------");
			System.out.println(Arrays.toString(params));			
			int row = qr.update(sql, params);
			if(row > 0) {
				return user;
			}else {
				return null;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
