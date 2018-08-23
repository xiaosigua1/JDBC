package com.xdf.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xdf.bean.Easybuy_User;
import com.xdf.dao.UserDao;
import com.xdf.util.BaseDao;
import com.xdf.util.ResultSetUtil;

/**
 * 
 * 失去一日甚易,欲得回已无途！
 *  
 * @author 小葱拌豆腐
 * 2017-10-19上午11:54:03
 * 
 * 针对于user的增删改查
 */
public class UserDaoImpl extends BaseDao implements UserDao {

	/**
	 * 用户登录的方法
	 * @param loginName   用户名
	 * @param password  密码
	 * @return    是否登录成功
	 */
	@Override
	public boolean loginUser(String name, String password) {

		// 定义一个标记 记录用户是否登录成功
		boolean flag = false;
		try {
			// 书写sql 先在dbms中运行一次
			String sql = "SELECT loginName,password FROM easybuy_user where loginName=? and password=?";
			Object[] params = { name, password };
			// 得到结果集
			rs = executeQuery(sql, params);
			// 处理结果集
			if (rs.next()) { // 证明有用户
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.释放资源
			closeConnection();
		}
		return flag;

	}

	/**
	 * 用户的新增
	 * @param user   用户前端传递过来的对象
	 */
	@Override
	public int add(Easybuy_User user) {
		// 书写sql 先在dbms中运行一次
		String sql = "INSERT  INTO easybuy_user(loginname,userName,`password`,sex)"
				+ " VALUES(?,?,?,?)";
		Object[] params = { user.getLoginName(), user.getPassword(),
				user.getUserName(), user.getSex() };
		// Statement执行sql
		int rowNum = executeUpdate(sql, params); // rowNum===》sql语句对数据库中数据的影响行数
		return rowNum;
	}

	/**
	 * 根据用户姓名删除指定的用户
	 * @param name  用户前端传递过来的用户名
	 */

	@Override
	public int delete(Serializable name) {
		// 书写sql 先在dbms中运行一次
		String sql = "DELETE FROM easybuy_user WHERE userName=?";
		Object[] params = { name };
		// Statement执行sql
		int rowNum = executeUpdate(sql, params); // rowNum===》sql语句对数据库中数据的影响行数

		return rowNum;
	}

	/**
	 * 修改指定的用户
	 * @param user用户前端传递过来的对象
	 */

	@Override
	public int update(Easybuy_User user) {
		// 书写sql 先在dbms中运行一次
		String sql = "UPDATE  easybuy_user SET loginName=?,`password`=?  WHERE userName=?";
		Object[] parmas = { user.getLoginName(), user.getPassword(),
				user.getUserName() };
		// Statement执行sql
		int rowNum = executeUpdate(sql, parmas); // rowNum===》sql语句对数据库中数据的影响行数
		return rowNum;
	}

	/**
	 * 查询所有用户
	 * @return 用户集合
	 */
	@Override
	public List<Easybuy_User> findAll(Object... objects) {
		// 创建集合用于保存所有的用户
		List<Easybuy_User> lists = new ArrayList<>();
		// 书写sql 先在dbms中运行一次
		String sql = "SELECT * FROM easybuy_user";
		// 得到结果集
		rs = executeQuery(sql);
		// 从工具类中获取
		lists = ResultSetUtil.eachResultSet(rs, Easybuy_User.class);
		// 释放资源
		closeConnection();
		return lists;
	}

	@Override
	public Easybuy_User findOne(Object... objects) {
		// TODO Auto-generated method stub
		return null;
	}

}
