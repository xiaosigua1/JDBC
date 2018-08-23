package com.xdf.service.impl;

import java.util.List;

import com.xdf.bean.Easybuy_User;
import com.xdf.dao.UserDao;
import com.xdf.dao.impl.UserDaoImpl;
import com.xdf.service.UserService;

/**
 * 
 * 失去一日甚易,欲得回已无途！
 *  
 * @author 小葱拌豆腐
 * 2017-10-26上午8:58:42
 * 
 */
public class UserServiceImpl implements UserService {

	UserDao dao = new UserDaoImpl(); // 创建dao层对象

	@Override
	public void loginUser(String name, String password) {
		boolean flag = dao.loginUser(name, password);
		if (flag) {
			System.out.println("登录成功");
		} else {
			System.out.println("登录失败");
		}
	}

	@Override
	public void addUser(Easybuy_User user) {
		int rowNum = dao.add(user);
		if (rowNum > 0) { // 证明新增成功
			System.out.println("新增成功");
		} else {
			System.out.println("新增失败");
		}
	}

	@Override
	public void deleteUser(String name) {
		int rowNum = dao.delete(name);
		if (rowNum > 0) { // 证明删除成功
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}

	@Override
	public void updateUser(Easybuy_User user) {
		int rowNum = dao.update(user);
		if (rowNum > 0) { // 证明修改成功
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}
	}

	@Override
	public List<Easybuy_User> selectUsers() {
		return dao.findAll();
	}

}
