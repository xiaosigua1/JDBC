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
 * ʧȥһ������,���û�����;��
 *  
 * @author С�а趹��
 * 2017-10-24����11:57:25
 * 
 * ���ŵ�ʵ����  �����������ݿ�
 */
public class NewsDaoImpl extends BaseDao implements NewsDao {

	/**
	 * ���ŵ�����
	 * @param user   �û�ǰ�˴��ݹ����Ķ���
	 */
	@Override
	public int add(Easybuy_News news) {
		String sql = "INSERT INTO easybuy_news(title,content,createTime) VALUES (?,?,?)";
		Object[] params = { news.getTitle(), news.getContent(), new Date() };
		// ���ø���ķ���
		int rownum = executeUpdate(sql, params);
		return rownum;
	}

	/**
	 * ������������ɾ��ָ��������
	 * @param id  �û�ǰ�˴��ݹ������û���
	 */
	@Override
	public int delete(Serializable id) {
		String sql = "delete  from easybuy_news where id=?";
		Object[] params = { id };
		// ���ø���ķ���
		int rownum = executeUpdate(sql, params);
		return rownum;
	}

	/**
	 * �޸�ָ��������
	 * @param news �û�ǰ�˴��ݹ����Ķ���
	 */
	@Override
	public int update(Easybuy_News news) {
		String sql = "update   easybuy_news set title=?,content=?  where id=?";
		Object[] params = { news.getTitle(), news.getContent(), news.getId() };
		// ���ø���ķ���
		int rownum = executeUpdate(sql, params);
		return rownum;
	}

	/**
	 * ��ѯ��������
	 * @return ���ż���
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
