package com.xdf.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * ʧȥһ������,���û�����;��
 *  
 * @author С�а趹��
 * 2017-10-29����8:42:28
 * 
 * 
 * 01.���Ǵ����ݿ��в�ѯ���� ����һ��ResultSet
 * 02.��ͬ������ ��ѯ������ResultSet ��һ�£����û������ţ�
 * 03.ȷ�����ݿ��е��ֶ����ƺ����е�������һ��!!!
 * 04.�ڳ��������ڼ�����ͨ������Ļ��� ��ȡ����࣬Ȼ��
 *    ��ResultSet�е����ݸ�ֵ������֮࣬��Ž������У�
 * 
 */

public class ResultSetUtil {

	/**
	 * @param rs    ����sql��� �����ݿ��з��صĽ����
	 * @param clazz  ����������ݵ�����
	 */
	public static <T> List<T> eachResultSet(ResultSet rs, Class<T> clazz) {
		List<T> list = new ArrayList<T>(); // �����������ڱ������ж���
		try {
			T object = null; // ��������
			while (rs.next()) {
				// ����ʵ����
				object = clazz.newInstance();
				// ��ȡ���ݹ����������������
				Field[] fields = clazz.getDeclaredFields();
				for (Field f : fields) {
					f.setAccessible(true); // ��������˽������
					f.set(object, rs.getObject(f.getName()));
				}
				list.add(object); // ���еĶ���ֵ֮�� �Ž�������
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * @param rs    ����sql��� �����ݿ��з��صĽ����
	 * @param clazz  ����������ݵ�����
	 */
	public static <T> T findOne(ResultSet rs, Class<T> clazz) {
		T object = null; // ��������
		try {
			if (rs.next()) {
				// ����ʵ����
				object = clazz.newInstance();
				// ��ȡ���ݹ����������������
				Field[] fields = clazz.getDeclaredFields();
				for (Field f : fields) {
					f.setAccessible(true); // ��������˽������
					f.set(object, rs.getObject(f.getName()));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return object;
	}

}
