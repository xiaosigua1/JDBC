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
 * ʧȥһ������,���û�����;��
 *  
 * @author С�а趹��
 * 2017-10-24����9:38:15
 * 
 *  ģ�����ǵ�ǰ��ҳ��    UI  ��ͼ��
 */
public class NewsTest {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("���������ĵ�¼���ƣ�");
		String name = input.next();
		System.out.println("���������ĵ�¼���룺");
		String pwd = input.next();

		// ��������UI�� ������ service��(ҵ���߼���)
		UserService userDemo = new UserServiceImpl();// �û�
		NewsService newsDao = new NewsServiceImpl();// ���� ��ϵķ�ʽ
		// �û��ĵ�¼
		userDemo.loginUser(name, pwd);
		System.out.print("1����ѯ����������Ϣ\t\t");
		System.out.print("2������������Ϣ\t\t");
		System.out.print("3��ɾ��������Ϣ\t\t");
		System.out.print("4���޸�������Ϣ\t\n");
		System.out.println("����������ѡ��");
		int choose = input.nextInt();
		switch (choose) {
		case 1:// ��ѯ����������Ϣ
			List<Easybuy_News> news = newsDao.selectNews();
			for (Easybuy_News easybuy_new : news) {
				System.out.println(easybuy_new);
			}
			break;
		case 2:// ����������Ϣ
				// ����һ�����Ŷ��� ���� �û��������Ϣ
			Easybuy_News news1 = new Easybuy_News();
			// ��ȡ�û�������
			System.out.println("�����������ű��⣺");
			news1.setTitle(input.next());
			System.out.println("���������������ݣ�");
			news1.setContent(input.next());
			newsDao.addNews(news1); // �Ѷ�����Ϊ�����Ĳ�������
			break;
		case 3:// ɾ��������Ϣ
				// ��ȡ�û�������
			System.out.println("����������Ҫɾ�������ű�ţ�");
			int id = input.nextInt();
			newsDao.deleteNewsById(id);
			break;
		case 4:// �޸�������Ϣ
				// ����һ�����Ŷ��� ���� �û��������Ϣ
			Easybuy_News updateNews = new Easybuy_News();
			// ��ȡ�û�������
			System.out.println("�����������ű�ţ�");
			updateNews.setId(input.nextInt());
			System.out.println("�����������ű��⣺");
			updateNews.setTitle(input.next());
			System.out.println("���������������ݣ�");
			updateNews.setContent(input.next());
			newsDao.updateNews(updateNews);
			break;
		}

	}

}
