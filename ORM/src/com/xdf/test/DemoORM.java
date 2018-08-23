package com.xdf.test;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;

/**
 * 
 * 失去一日甚易,欲得回已无途！
 *  
 * @author 小葱拌豆腐
 * 2017-10-29上午9:46:15
 * 
 * 
 * 使用反射的机制 动态的给 news 对象赋值
 */
public class DemoORM {

	public static void main(String[] args) {
		// 数据库的四要素
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/easybuy";
		String userName = "root";
		String password = "";

		// 创建连接数据库需要的API
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 创建一个需要映射的实体类
		Object news = null;
		try {
			// forName中的参数 是运行期间用户传递过来的！
			news = Class.forName("com.xdf.bean.Easybuy_News").newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		try {
			// 加载驱动
			Class.forName(driver);
			// 获取链接
			con = DriverManager.getConnection(url, userName, password);
			// 书写sql语句
			String sql = "select * from Easybuy_News where id=?";
			ps = con.prepareStatement(sql);
			// 给占位符赋值
			ps.setInt(1, 678);
			// 执行sql语句
			rs = ps.executeQuery();
			// 循环遍历rs
			if (rs.next()) {
				// 获取结果集中的元数据
				ResultSetMetaData metaData = rs.getMetaData();
				// metaData 是一个集合
				System.out.println(metaData.getColumnCount());
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					String name = metaData.getColumnName(i); // 获取数据库中的字段名称
					// 必须获取当前字段的数据类型名称
					String typeName = metaData.getColumnTypeName(i);

					// 获取给实体类中的属性赋值的方法
					String method = getMethodByField(name);
					if (typeName.equalsIgnoreCase("INT")) {
						news.getClass().getMethod(method, int.class)
								.invoke(news, rs.getInt(name));
					} else if (typeName.equalsIgnoreCase("VARCHAR")) {
						news.getClass().getMethod(method, String.class)
								.invoke(news, rs.getString(name));
					} else if (typeName.equalsIgnoreCase("TIMESTAMP")) {
						news.getClass().getMethod(method, Date.class)
								.invoke(news, rs.getTimestamp(name));
					}
				}
				System.out.println(news);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 01.给我从rs中获取元数据的每一个元素名称
	 * 02.去实体类中找到对应的set（）
	 * id      setId
	 * name    setName
	 * title   setTitle
	 */
	private static String getMethodByField(String name) {
		return "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
	}

}
