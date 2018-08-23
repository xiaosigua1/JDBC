package com.xdf.service;

import java.util.List;

import com.xdf.bean.Easybuy_User;

public interface UserService {
	/**
	 * 用户登录的方法
	 * @param name   用户名
	 * @param password   密码
	 * @return
	 */
	public void loginUser(String name, String password);

	/**
	 * 用户的新增
	 * @param user   用户前端传递过来的对象
	 */
	public void addUser(Easybuy_User user);

	/**
	 * 根据用户姓名删除指定的用户
	 * @param name  用户前端传递过来的用户名
	 */
	public void deleteUser(String name);

	/**
	 * 修改指定的用户
	 * @param user用户前端传递过来的对象
	 */
	public void updateUser(Easybuy_User user);

	/**
	 * 查询所有用户
	 * @return 用户集合
	 */
	public List<Easybuy_User> selectUsers();
}
