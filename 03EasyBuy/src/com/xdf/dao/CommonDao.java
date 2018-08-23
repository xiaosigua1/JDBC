package com.xdf.dao;

import java.io.Serializable;
import java.util.List;

public interface CommonDao<T> {
	/**
	 * @param t  �����Ķ���
	 * @return   Ӱ�������
	 */
	public int add(T t);

	/**
	 * 
	 * @param s  ɾ��������
	 * @return  Ӱ�������
	 */
	public int delete(Serializable s);

	/**
	 * @param t  �޸ĵĶ���
	 * @return   Ӱ�������
	 */
	public int update(T t);

	/**
	 * @param objects  ��ѯ������
	 * @return    ����ļ���
	 */
	public List<T> findAll(Object... objects);

	/**
	 * @param objects ��ѯ������
	 * @return  ָ���Ķ���
	 */
	public T findOne(Object... objects);
}
