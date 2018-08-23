package com.xdf.service.impl;

import java.io.Serializable;
import java.util.List;

import com.xdf.bean.Easybuy_News;
import com.xdf.dao.NewsDao;
import com.xdf.dao.impl.NewsDaoImpl;
import com.xdf.service.NewsService;

/**
 * 
 * ʧȥһ������,���û�����;��
 *  
 * @author С�а趹��
 * 2017-10-24����12:13:08
 * 
 * 
 * service���Ŀ�ģ�  ����ҵ���߼���
 *  �ڲ��ı�dao������ǰ���£��Է�����ǿ��
 *  
 *  ��ô�ܱ�֤���ı�dao�����??
 */
public class NewsServiceImpl implements NewsService {

	// ����dao��Ķ���
	NewsDao newsDao = new NewsDaoImpl();

	@Override
	public void addNews(Easybuy_News news) {
		System.out.println("������"); // ϵͳ��ҵ��
		int rownum = newsDao.add(news); // ��ҵ��
		System.out.println("�ӻ���");// ϵͳ��ҵ��
		if (rownum > 0) {
			System.out.println("�����ɹ���");
		} else {
			System.out.println("����ʧ�ܣ�");
		}
	}

	@Override
	public void deleteNewsById(Serializable id) {
		int rownum = newsDao.delete(id);
		if (rownum > 0) {
			System.out.println("ɾ���ɹ���");
		} else {
			System.out.println("ɾ��ʧ�ܣ�");
		}
	}

	@Override
	public void updateNews(Easybuy_News news) {
		int rownum = newsDao.update(news);
		if (rownum > 0) {
			System.out.println("�޸ĳɹ���");
		} else {
			System.out.println("�޸�ʧ�ܣ�");
		}
	}

	@Override
	public List<Easybuy_News> selectNews() {
		return newsDao.findAll();
	}

}
