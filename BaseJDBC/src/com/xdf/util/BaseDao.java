package com.xdf.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

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
	protected static Scanner input = new Scanner(System.in);
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

}
