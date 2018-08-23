package com.xdf.basejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 
 * 失去一日甚易,欲得回已无途！
 *  
 * @author 小葱拌豆腐
 * 2017-10-19上午11:54:03
 * 
 * 
 * 
 * 
 * 第一次使用JDBC访问我们的mysql数据库
 * 01.把mysql数据库需要的驱动包引入到我们的项目中===》使用反射机制加载驱动包
 *     因为反射是在程序运行期间，动态的加载我们需要的类！
 *     程序在编译期间，这个类可以不在！
 * 02.创建与数据库的连接   需要四要素   ，返回一个连接对象
 * 03.书写sql语句，通过Connection获取Statement
 * 04.Statement执行sql语句（查询）返回结果集
 * 05.处理ResultSet
 * 06.释放资源
 * 
 */
public class JdbcDemo {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		boolean flag = loginUser();
		if (flag) {
			System.out.print("1：查询所有用户信息\t\t");
			System.out.print("2：增加用户信息\t\t");
			System.out.print("3：删除用户信息\t\t");
			System.out.print("4：修改用户信息\t\n");
			System.out.println("请输入您的选择：");
			int choose = input.nextInt();
			switch (choose) {
			case 1:
				selectAllUsers();// 查询所有用户信息
				break;
			case 2:
				insertUser();// 增加用户信息
				break;
			case 3:
				deleteUser();// 删除用户信息
				break;
			case 4:
				updateUser();// 修改用户信息
				break;
			}
		} else {
			System.out.println("登录失败！");
		}

	}

	/**
	 * 用户登录的方法
	 */
	private static boolean loginUser() {
		System.out.println("请输入您的登录名称：");
		String loginName = input.next();
		System.out.println("请输入您的登录密码：");
		String password = input.next();
		// 定义一个标记 记录用户是否登录成功
		boolean flag = false;
		Connection con = null; // 连接对象
		Statement stmt = null; // 执行sql语句的对象
		ResultSet rs = null; // 返回的结果集
		try {
			// 1.使用反射机制加载驱动包
			Class.forName("com.mysql.jdbc.Driver");
			// 2.创建与数据库的连接
			con = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/easybuy?useUnicode=true&characterEncoding=utf8",
							"root", "");
			// 3.1 书写sql 先在dbms中运行一次
			String sql = "SELECT loginName,password FROM easybuy_user where loginName='"
					+ loginName + "' and password='" + password + "'";
			// 3.2 执行sql
			stmt = con.createStatement();
			// 4.1 得到结果集
			rs = stmt.executeQuery(sql);
			// 4.2 处理结果集
			if (rs.next()) { // 证明有用户
				flag = true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.释放资源
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return flag;

	}

	/**
	 * 删除用户信息
	 */
	private static void deleteUser() {
		// 获取用户的输入
		System.out.println("请您输入真实姓名：");
		String userName = input.next();

		Connection con = null; // 连接对象
		Statement stmt = null; // 执行sql语句的对象
		ResultSet rs = null; // 返回结果集
		try {
			// 1.使用反射机制加载驱动包
			Class.forName("com.mysql.jdbc.Driver");
			// 2.创建与数据库的连接
			con = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/easybuy?useUnicode=true&characterEncoding=utf8",
							"root", "");
			// 3.1 书写sql 先在dbms中运行一次
			String sql = "DELETE FROM easybuy_user WHERE userName='" + userName
					+ "'";
			// 3.2通过连接获取Statement对象
			stmt = con.createStatement();
			// 3.3Statement执行sql
			int rowNum = stmt.executeUpdate(sql); // rowNum===》sql语句对数据库中数据的影响行数
			if (rowNum > 0) { // 证明删除成功
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.释放资源
			try {
				if (rs != null) {
					rs.close();
				}
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 *  修改用户信息
	 *    根据 真实姓名  修改对应的  登录名和密码
	 */
	private static void updateUser() {
		// 获取用户的输入
		System.out.println("请您输入真实姓名：");
		String userName = input.next();
		System.out.println("请您输入新昵称（登录名）：");
		String loginName = input.next();
		System.out.println("请您输入新密码：");
		String password = input.next();

		Connection con = null; // 连接对象
		Statement stmt = null; // 执行sql语句的对象
		ResultSet rs = null; // 返回结果集
		try {
			// 1.使用反射机制加载驱动包
			Class.forName("com.mysql.jdbc.Driver");
			// 2.创建与数据库的连接
			con = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/easybuy?useUnicode=true&characterEncoding=utf8",
							"root", "");
			// 3.1 书写sql 先在dbms中运行一次
			String sql = "UPDATE  easybuy_user SET loginName='" + loginName
					+ "',`password`='" + password + "' WHERE userName='"
					+ userName + "'";
			// 3.2通过连接获取Statement对象
			stmt = con.createStatement();
			// 3.3Statement执行sql
			int rowNum = stmt.executeUpdate(sql); // rowNum===》sql语句对数据库中数据的影响行数
			if (rowNum > 0) { // 证明修改成功
				System.out.println("修改成功");
			} else {
				System.out.println("修改失败");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.释放资源
			try {
				if (rs != null) {
					rs.close();
				}
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 新增用户
	 */
	private static void insertUser() {
		// 获取用户的输入
		System.out.println("请您输入登录名称：");
		String loginName = input.next();
		System.out.println("请您输入登录密码：");
		String password = input.next();
		System.out.println("请您输入真实姓名：");
		String userName = input.next();
		System.out.println("请您输入性别：(1/男   0/女)");
		int sex = input.nextInt();

		Connection con = null; // 连接对象
		Statement stmt = null; // 执行sql语句的对象
		try {
			// 1.使用反射机制加载驱动包
			Class.forName("com.mysql.jdbc.Driver");
			// 2.创建与数据库的连接
			con = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/easybuy?useUnicode=true&characterEncoding=utf8",
							"root", "");
			// 3.1 书写sql 先在dbms中运行一次
			String sql = "INSERT  INTO easybuy_user(loginname,userName,`password`,sex)"
					+ " VALUES('"
					+ loginName
					+ "','"
					+ userName
					+ "','"
					+ password + "'," + sex + ")";
			// 3.2通过连接获取Statement对象
			stmt = con.createStatement();
			// 3.3Statement执行sql
			int rowNum = stmt.executeUpdate(sql); // rowNum===》sql语句对数据库中数据的影响行数
			if (rowNum > 0) { // 证明新增成功
				System.out.println("新增成功");
			} else {
				System.out.println("新增失败");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.释放资源
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 查询所有的用户信息
	 */
	public static void selectAllUsers() {
		Connection con = null; // 连接对象
		Statement stmt = null; // 执行sql语句的对象
		ResultSet rs = null; // 返回的结果集
		try {
			// 1.使用反射机制加载驱动包
			Class.forName("com.mysql.jdbc.Driver");
			// 2.创建与数据库的连接
			con = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/easybuy?useUnicode=true&characterEncoding=utf8",
							"root", "");
			// 3.1 书写sql 先在dbms中运行一次
			String sql = "SELECT * FROM easybuy_user";
			// 3.2 执行sql
			stmt = con.createStatement();
			// 4.1 得到结果集
			rs = stmt.executeQuery(sql);
			// 4.2 处理结果集
			while (rs.next()) {
				int id = rs.getInt("id");
				String loginName = rs.getString("loginName");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				int sex = rs.getInt("sex");
				String identityCode = rs.getString("identityCode");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				int type = rs.getInt("type");
				System.out.println("编号：" + id);
				System.out.println("登录名：" + loginName);
				System.out.println("真实姓名：" + userName);
				System.out.println("密码：" + password);
				System.out.println("性别：" + sex);
				System.out.println("身份证：" + identityCode);
				System.out.println("邮箱：" + email);
				System.out.println("手机号：" + mobile);
				System.out.println("用户类型：" + type);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.释放资源
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
