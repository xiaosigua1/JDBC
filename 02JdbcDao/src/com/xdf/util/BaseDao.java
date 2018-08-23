package com.xdf.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * ʧȥһ������,���û�����;��
 *  
 * @author С�а趹��
 * 2017-10-22����12:18:04
 * 
 * �����û����˵�������̵�.....һЩ�����й����ķ���
 */
public class BaseDao {

	/**
	 * ����dao�й���������
	 */
	protected static Connection con = null; // ���Ӷ���
	protected static PreparedStatement stmt = null; // ִ��sql���Ķ���
	protected static ResultSet rs = null; // ���صĽ����

	/**
	 * ����dao�й������������ݿ�ķ���
	 */
	protected static boolean getConnection() {
		try {
			// 1.ʹ�÷�����Ƽ���������
			Class.forName(ConfigManager.getInstance().getValue("jdbc.driver"));
			// 2.���������ݿ������
			con = DriverManager.getConnection(ConfigManager.getInstance()
					.getValue("jdbc.url"), ConfigManager.getInstance()
					.getValue("jdbc.userName"), ConfigManager.getInstance()
					.getValue("jdbc.password"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * �ͷ���Դ�Ĺ�������
	 */
	protected static boolean closeConnection() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	/**
	 * ������ɾ�ĵķ���
	 * 01.��֪����û�в���
	 * 02.��֪������������
	 * 
	 * �û����ݸ�����һ��sql��䣡����sql���Ƿ��в������и�ֵ��
	 * 
	 */
	protected static int executeUpdate(String sql, Object... params) {
		// ����Ӱ�������
		int rowNum = 0;
		if (getConnection()) {// ��ȡ����
			try {
				stmt = con.prepareStatement(sql);
				// ѭ�������ǵĲ�����ֵ
				for (int i = 0; i < params.length; i++) {
					stmt.setObject(i + 1, params[i]);
				}
				rowNum = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// �ͷ���Դ
				closeConnection();
			}
		}
		return rowNum;
	}

	/**
	 * ���еĲ�ѯ����
	 * @param sql   �û����ݵ�sql
	 * @param params  ���ܳ��ֵĲ���
	 * @return   �����
	 */
	protected static ResultSet executeQuery(String sql, Object... params) {
		if (getConnection()) {// ��ȡ����
			try {
				stmt = con.prepareStatement(sql);
				// ѭ�������ǵĲ�����ֵ
				for (int i = 0; i < params.length; i++) {
					stmt.setObject(i + 1, params[i]);
				}
				rs = stmt.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}

}
