package com.xdf.service;

import java.io.Serializable;
import java.util.List;

import com.xdf.bean.Easybuy_News;

public interface NewsService {
	/**
	 * ���ŵ�����
	 * @param user   �û�ǰ�˴��ݹ����Ķ���
	 */
	public void addNews(Easybuy_News news);

	/**
	 * ������������ɾ��ָ��������
	 * @param id  �û�ǰ�˴��ݹ������û���
	 */
	public void deleteNewsById(Serializable id);

	/**
	 * �޸�ָ��������
	 * @param news �û�ǰ�˴��ݹ����Ķ���
	 */
	public void updateNews(Easybuy_News news);

	/**
	 * ��ѯ��������
	 * @return ���ż���
	 */
	public List<Easybuy_News> selectNews();

}
