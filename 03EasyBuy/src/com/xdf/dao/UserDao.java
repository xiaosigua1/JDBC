package com.xdf.dao;

import com.xdf.bean.Easybuy_User;

/**
 * 
 * 失去一日甚易,欲得回已无途！
 *  
 * @author 小葱拌豆腐
 * 2017-10-24上午11:43:09
 * 
 * 针对于User的接口
 */
public interface UserDao extends CommonDao<Easybuy_User> {

	/**
	 * 用户登录的方法
	 * @param name   用户名
	 * @param password   密码
	 * @return
	 */
	public boolean loginUser(String name, String password);

}
