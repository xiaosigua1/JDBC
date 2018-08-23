package com.xdf.test;

import java.util.List;
import java.util.Scanner;

import com.xdf.bean.Easybuy_News;
import com.xdf.service.NewsService;
import com.xdf.service.UserService;
import com.xdf.service.impl.NewsServiceImpl;
import com.xdf.service.impl.UserServiceImpl;

/**
 * 
 * 失去一日甚易,欲得回已无途！
 *  
 * @author 小葱拌豆腐
 * 2017-10-24上午9:38:15
 * 
 *  模拟我们的前端页面    UI  视图层
 */
public class NewsTest {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("请输入您的登录名称：");
		String name = input.next();
		System.out.println("请输入您的登录密码：");
		String pwd = input.next();

		// 现在是在UI层 依赖于 service层(业务逻辑层)
		UserService userDemo = new UserServiceImpl();// 用户
		NewsService newsDao = new NewsServiceImpl();// 新闻 耦合的方式
		// 用户的登录
		userDemo.loginUser(name, pwd);
		System.out.print("1：查询所有新闻信息\t\t");
		System.out.print("2：增加新闻信息\t\t");
		System.out.print("3：删除新闻信息\t\t");
		System.out.print("4：修改新闻信息\t\n");
		System.out.println("请输入您的选择：");
		int choose = input.nextInt();
		switch (choose) {
		case 1:// 查询所有新闻信息
			List<Easybuy_News> news = newsDao.selectNews();
			for (Easybuy_News easybuy_new : news) {
				System.out.println(easybuy_new);
			}
			break;
		case 2:// 增加新闻信息
				// 创建一个新闻对象 保存 用户输入的信息
			Easybuy_News news1 = new Easybuy_News();
			// 获取用户的输入
			System.out.println("请您输入新闻标题：");
			news1.setTitle(input.next());
			System.out.println("请您输入新闻内容：");
			news1.setContent(input.next());
			newsDao.addNews(news1); // 把对象作为方法的参数传递
			break;
		case 3:// 删除新闻信息
				// 获取用户的输入
			System.out.println("请您输入需要删除的新闻编号：");
			int id = input.nextInt();
			newsDao.deleteNewsById(id);
			break;
		case 4:// 修改新闻信息
				// 创建一个新闻对象 保存 用户输入的信息
			Easybuy_News updateNews = new Easybuy_News();
			// 获取用户的输入
			System.out.println("请您输入新闻编号：");
			updateNews.setId(input.nextInt());
			System.out.println("请您输入新闻标题：");
			updateNews.setTitle(input.next());
			System.out.println("请您输入新闻内容：");
			updateNews.setContent(input.next());
			newsDao.updateNews(updateNews);
			break;
		}

	}

}
