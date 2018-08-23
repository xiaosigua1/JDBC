package com.xdf.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 
 * 失去一日甚易,欲得回已无途！
 *  
 * @author 小葱拌豆腐
 * 2017-10-22下午12:18:04
 * 
 * 所有用户，账单，宠物，商店.....一些列类中公共的方法
 */
public class BaseDao {

	/**
	 * 所有dao中公共的属性
	 */
	protected static Scanner input = new Scanner(System.in);
	protected static Connection con = null; // 连接对象
	protected static PreparedStatement stmt = null; // 执行sql语句的对象
	protected static ResultSet rs = null; // 返回的结果集

	/**
	 * 所有dao中公共的连接数据库的方法
	 */
	protected static boolean getConnection() {
		try {
			// 1.使用反射机制加载驱动包
			Class.forName(ConfigManager.getInstance().getValue("jdbc.driver"));
			// 2.创建与数据库的连接
			con = DriverManager.getConnection(ConfigManager.getInstance()
					.getValue("jdbc.url"), ConfigManager.getInstance()
					.getValue("jdbc.userName"), ConfigManager.getInstance()
					.getValue("jdbc.password"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
