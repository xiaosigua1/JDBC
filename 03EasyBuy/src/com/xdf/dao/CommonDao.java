package com.xdf.dao;

import java.io.Serializable;
import java.util.List;

public interface CommonDao<T> {
	/**
	 * @param t  新增的对象
	 * @return   影响的行数
	 */
	public int add(T t);

	/**
	 * 
	 * @param s  删除的依据
	 * @return  影响的行数
	 */
	public int delete(Serializable s);

	/**
	 * @param t  修改的对象
	 * @return   影响的行数
	 */
	public int update(T t);

	/**
	 * @param objects  查询的条件
	 * @return    对象的集合
	 */
	public List<T> findAll(Object... objects);

	/**
	 * @param objects 查询的条件
	 * @return  指定的对象
	 */
	public T findOne(Object... objects);
}
