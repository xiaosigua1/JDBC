package com.xdf.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xdf.bean.Easybuy_News;
import com.xdf.dao.NewsDao;
import com.xdf.util.BaseDao;
import com.xdf.util.ResultSetUtil;

/**
 * 
 * 失去一日甚易,欲得回已无途！
 *  
 * @author 小葱拌豆腐
 * 2017-10-24上午11:57:25
 * 
 * 新闻的实现类  真正访问数据库
 */
public class NewsDaoImpl extends BaseDao implements NewsDao {

	/**
	 * 新闻的新增
	 * @param user   用户前端传递过来的对象
	 */
	@Override
	public int add(Easybuy_News news) {
		String sql = "INSERT INTO easybuy_news(title,content,createTime) VALUES (?,?,?)";
		Object[] params = { news.getTitle(), news.getContent(), new Date() };
		// 调用父类的方法
		int rownum = executeUpdate(sql, params);
		return rownum;
	}

	/**
	 * 根据新闻名称删除指定的新闻
	 * @param id  用户前端传递过来的用户名
	 */
	@Override
	public int delete(Serializable id) {
		String sql = "delete  from easybuy_news where id=?";
		Object[] params = { id };
		// 调用父类的方法
		int rownum = executeUpdate(sql, params);
		return rownum;
	}

	/**
	 * 修改指定的新闻
	 * @param news 用户前端传递过来的对象
	 */
	@Override
	public int update(Easybuy_News news) {
		String sql = "update   easybuy_news set title=?,content=?  where id=?";
		Object[] params = { news.getTitle(), news.getContent(), news.getId() };
		// 调用父类的方法
		int rownum = executeUpdate(sql, params);
		return rownum;
	}

	/**
	 * 查询所有新闻
	 * @return 新闻集合
	 */

	@Override
	public List<Easybuy_News> findAll(Object... objects) {
		List<Easybuy_News> lists = new ArrayList<>();

		String sql = "select * from easybuy_news";
		rs = executeQuery(sql);
		lists = ResultSetUtil.eachResultSet(rs, Easybuy_News.class);
		closeConnection();
		return lists;
	}

	@Override
	public Easybuy_News findOne(Object... objects) {
		// TODO Auto-generated method stub
		return null;
	}

}
