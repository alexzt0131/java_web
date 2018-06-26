package demo;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.Arrays;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import DBUtils.C3P0Utils;
import domain.User;

public class Test {

	
	public static void main(String[] args) {
		Object[] params = {"1","2"};
		System.out.println(Arrays.toString(params));
	}
}
