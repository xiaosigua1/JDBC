package com.xdf.test;

import java.util.List;
import java.util.Scanner;

import com.xdf.bean.Easybuy_User;
import com.xdf.jdbc.UserDemo;

/**
 * 
 * 失去一日甚易,欲得回已无途！
 *  
 * @author 小葱拌豆腐
 * 2017-10-24上午9:38:15
 * 
 *  模拟我们的前端页面
 */
public class UserTest {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("请输入您的登录名称：");
		String name = input.next();
		System.out.println("请输入您的登录密码：");
		String pwd = input.next();

		UserDemo userDemo = new UserDemo();
		// 用户的登录
		boolean flag = userDemo.loginUser(name, pwd);
		if (flag) {
			System.out.print("1：查询所有用户信息\t\t");
			System.out.print("2：增加用户信息\t\t");
			System.out.print("3：删除用户信息\t\t");
			System.out.print("4：修改用户信息\t\n");
			System.out.println("请输入您的选择：");
			int choose = input.nextInt();
			switch (choose) {
			case 1:// 查询所有用户信息
				List<Easybuy_User> users = userDemo.selectAllUsers();
				for (Easybuy_User easybuy_User : users) {
					System.out.println(easybuy_User);
				}
				break;
			case 2:// 增加用户信息
					// 创建一个user对象 保存 用户输入的信息
				Easybuy_User user = new Easybuy_User();
				// 获取用户的输入
				System.out.println("请您输入登录名称：");
				user.setLoginName(input.next());
				System.out.println("请您输入登录密码：");
				user.setPassword(input.next());
				System.out.println("请您输入真实姓名：");
				user.setUserName(input.next());
				System.out.println("请您输入性别：(1/男   0/女)");
				user.setSex(input.nextInt());
				userDemo.insertUser(user); // 把对象作为方法的参数传递
				break;
			case 3:// 删除用户信息
					// 获取用户的输入
				System.out.println("请您输入真实姓名：");
				String delName = input.next();
				userDemo.deleteUser(delName);
				break;
			case 4:// 修改用户信息
					// 创建一个user对象 保存 用户输入的信息
				Easybuy_User updateUser = new Easybuy_User();
				// 获取用户的输入
				System.out.println("请您输入真实姓名：");
				updateUser.setUserName(input.next());
				System.out.println("请您输入新昵称（登录名）：");
				updateUser.setLoginName(input.next());
				System.out.println("请您输入新密码：");
				updateUser.setPassword(input.next());
				userDemo.updateUser(updateUser);
				break;
			}
		} else {
			System.out.println("登录失败！");
		}

	}

}
