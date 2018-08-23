package com.xdf.test;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;

/**
 * 
 * ʧȥһ������,���û�����;��
 *  
 * @author С�а趹��
 * 2017-10-29����9:46:15
 * 
 * 
 * ʹ�÷���Ļ��� ��̬�ĸ� news ����ֵ
 */
public class DemoORM {

	public static void main(String[] args) {
		// ���ݿ����Ҫ��
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/easybuy";
		String userName = "root";
		String password = "";

		// �����������ݿ���Ҫ��API
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// ����һ����Ҫӳ���ʵ����
		Object news = null;
		try {
			// forName�еĲ��� �������ڼ��û����ݹ����ģ�
			news = Class.forName("com.xdf.bean.Easybuy_News").newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		try {
			// ��������
			Class.forName(driver);
			// ��ȡ����
			con = DriverManager.getConnection(url, userName, password);
			// ��дsql���
			String sql = "select * from Easybuy_News where id=?";
			ps = con.prepareStatement(sql);
			// ��ռλ����ֵ
			ps.setInt(1, 678);
			// ִ��sql���
			rs = ps.executeQuery();
			// ѭ������rs
			if (rs.next()) {
				// ��ȡ������е�Ԫ����
				ResultSetMetaData metaData = rs.getMetaData();
				// metaData ��һ������
				System.out.println(metaData.getColumnCount());
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					String name = metaData.getColumnName(i); // ��ȡ���ݿ��е��ֶ�����
					// �����ȡ��ǰ�ֶε�������������
					String typeName = metaData.getColumnTypeName(i);

					// ��ȡ��ʵ�����е����Ը�ֵ�ķ���
					String method = getMethodByField(name);
					if (typeName.equalsIgnoreCase("INT")) {
						news.getClass().getMethod(method, int.class)
								.invoke(news, rs.getInt(name));
					} else if (typeName.equalsIgnoreCase("VARCHAR")) {
						news.getClass().getMethod(method, String.class)
								.invoke(news, rs.getString(name));
					} else if (typeName.equalsIgnoreCase("TIMESTAMP")) {
						news.getClass().getMethod(method, Date.class)
								.invoke(news, rs.getTimestamp(name));
					}
				}
				System.out.println(news);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 01.���Ҵ�rs�л�ȡԪ���ݵ�ÿһ��Ԫ������
	 * 02.ȥʵ�������ҵ���Ӧ��set����
	 * id      setId
	 * name    setName
	 * title   setTitle
	 */
	private static String getMethodByField(String name) {
		return "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
	}

}
