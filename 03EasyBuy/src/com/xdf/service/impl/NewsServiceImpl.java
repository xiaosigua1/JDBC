package com.xdf.service.impl;

import java.io.Serializable;
import java.util.List;

import com.xdf.bean.Easybuy_News;
import com.xdf.dao.NewsDao;
import com.xdf.dao.impl.NewsDaoImpl;
import com.xdf.service.NewsService;

/**
 * 
 * 失去一日甚易,欲得回已无途！
 *  
 * @author 小葱拌豆腐
 * 2017-10-24下午12:13:08
 * 
 * 
 * service层的目的：  处理业务逻辑！
 *  在不改变dao层代码的前提下！对方法增强！
 *  
 *  怎么能保证不改变dao层代码??
 */
public class NewsServiceImpl implements NewsService {

	// 创建dao层的对象
	NewsDao newsDao = new NewsDaoImpl();

	@Override
	public void addNews(Easybuy_News news) {
		System.out.println("握握手"); // 系统级业务
		int rownum = newsDao.add(news); // 主业务
		System.out.println("挥挥手");// 系统级业务
		if (rownum > 0) {
			System.out.println("新增成功！");
		} else {
			System.out.println("新增失败！");
		}
	}

	@Override
	public void deleteNewsById(Serializable id) {
		int rownum = newsDao.delete(id);
		if (rownum > 0) {
			System.out.println("删除成功！");
		} else {
			System.out.println("删除失败！");
		}
	}

	@Override
	public void updateNews(Easybuy_News news) {
		int rownum = newsDao.update(news);
		if (rownum > 0) {
			System.out.println("修改成功！");
		} else {
			System.out.println("修改失败！");
		}
	}

	@Override
	public List<Easybuy_News> selectNews() {
		return newsDao.findAll();
	}

}
