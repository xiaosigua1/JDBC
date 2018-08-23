package com.xdf.service;

import java.io.Serializable;
import java.util.List;

import com.xdf.bean.Easybuy_News;

public interface NewsService {
	/**
	 * 新闻的新增
	 * @param user   用户前端传递过来的对象
	 */
	public void addNews(Easybuy_News news);

	/**
	 * 根据新闻名称删除指定的新闻
	 * @param id  用户前端传递过来的用户名
	 */
	public void deleteNewsById(Serializable id);

	/**
	 * 修改指定的新闻
	 * @param news 用户前端传递过来的对象
	 */
	public void updateNews(Easybuy_News news);

	/**
	 * 查询所有新闻
	 * @return 新闻集合
	 */
	public List<Easybuy_News> selectNews();

}
