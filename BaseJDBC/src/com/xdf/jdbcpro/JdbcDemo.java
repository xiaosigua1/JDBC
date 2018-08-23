package com.xdf.jdbcpro;

import java.sql.SQLException;

import com.xdf.util.BaseDao;

/**
 * 
 * ʧȥһ������,���û�����;��
 *  
 * @author С�а趹��
 * 2017-10-19����11:54:03
 */
public class JdbcDemo extends BaseDao {

	public static void main(String[] args) {
		boolean flag = loginUser();
		if (flag) {
			System.out.print("1����ѯ�����û���Ϣ\t\t");
			System.out.print("2�������û���Ϣ\t\t");
			System.out.print("3��ɾ���û���Ϣ\t\t");
			System.out.print("4���޸��û���Ϣ\t\n");
			System.out.println("����������ѡ��");
			int choose = input.nextInt();
			switch (choose) {
			case 1:
				selectAllUsers();// ��ѯ�����û���Ϣ
				break;
			case 2:
				insertUser();// �����û���Ϣ
				break;
			case 3:
				deleteUser();// ɾ���û���Ϣ
				break;
			case 4:
				updateUser();// �޸��û���Ϣ
				break;
			}
		} else {
			System.out.println("��¼ʧ�ܣ�");
		}

	}

	/**
	 * �û���¼�ķ���
	 */
	private static boolean loginUser() {
		System.out.println("���������ĵ�¼���ƣ�");
		String loginName = input.next();
		System.out.println("���������ĵ�¼���룺");
		String password = input.next();
		// ����һ����� ��¼�û��Ƿ��¼�ɹ�
		boolean flag = false;
		try {
			getConnection(); // ���ø���Ļ�ȡ���ӵķ��� �Ȳ��Ż���������
			// 3.1 ��дsql ����dbms������һ��
			String sql = "SELECT loginName,password FROM easybuy_user where loginName=? and password=?";
			// 3.2 ִ��sql
			stmt = con.prepareStatement(sql);
			// 3.3 ��ռλ�� ��ֵ
			stmt.setString(1, loginName);
			stmt.setString(2, password);
			// 4.1 �õ������
			rs = stmt.executeQuery();
			// 4.2 ��������
			if (rs.next()) { // ֤�����û�
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.�ͷ���Դ
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return flag;

	}

	/**
	 * ɾ���û���Ϣ
	 */
	private static void deleteUser() {
		// ��ȡ�û�������
		System.out.println("����������ʵ������");
		String userName = input.next();

		try {
			getConnection(); // ���ø���Ļ�ȡ���ӵķ��� �Ȳ��Ż���������
			// 3.1 ��дsql ����dbms������һ��
			String sql = "DELETE FROM easybuy_user WHERE userName=?";
			// 3.2ͨ�����ӻ�ȡStatement����
			stmt = con.prepareStatement(sql);
			// ������ֵ
			stmt.setString(1, userName);
			// 3.3Statementִ��sql
			int rowNum = stmt.executeUpdate(); // rowNum===��sql�������ݿ������ݵ�Ӱ������
			if (rowNum > 0) { // ֤��ɾ���ɹ�
				System.out.println("ɾ���ɹ�");
			} else {
				System.out.println("ɾ��ʧ��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.�ͷ���Դ
			try {
				if (rs != null) {
					rs.close();
				}
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 *  �޸��û���Ϣ
	 *    ���� ��ʵ����  �޸Ķ�Ӧ��  ��¼��������
	 */
	private static void updateUser() {
		// ��ȡ�û�������
		System.out.println("����������ʵ������");
		String userName = input.next();
		System.out.println("�����������ǳƣ���¼������");
		String loginName = input.next();
		System.out.println("�������������룺");
		String password = input.next();

		try {
			getConnection(); // ���ø���Ļ�ȡ���ӵķ��� �Ȳ��Ż���������
			// 3.1 ��дsql ����dbms������һ��
			String sql = "UPDATE  easybuy_user SET loginName=?,`password`=?  WHERE userName=?";
			// 3.2ͨ�����ӻ�ȡStatement����
			stmt = con.prepareStatement(sql);
			// ������ֵ
			stmt.setString(1, loginName);
			stmt.setString(2, password);
			stmt.setString(3, userName);
			// 3.3Statementִ��sql
			int rowNum = stmt.executeUpdate(); // rowNum===��sql�������ݿ������ݵ�Ӱ������
			if (rowNum > 0) { // ֤���޸ĳɹ�
				System.out.println("�޸ĳɹ�");
			} else {
				System.out.println("�޸�ʧ��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.�ͷ���Դ
			try {
				if (rs != null) {
					rs.close();
				}
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * �����û�
	 */
	private static void insertUser() {
		// ��ȡ�û�������
		System.out.println("���������¼���ƣ�");
		String loginName = input.next();
		System.out.println("���������¼���룺");
		String password = input.next();
		System.out.println("����������ʵ������");
		String userName = input.next();
		System.out.println("���������Ա�(1/��   0/Ů)");
		int sex = input.nextInt();

		try {
			getConnection(); // ���ø���Ļ�ȡ���ӵķ��� �Ȳ��Ż���������
			// 3.1 ��дsql ����dbms������һ��
			String sql = "INSERT  INTO easybuy_user(loginname,userName,`password`,sex)"
					+ " VALUES(?,?,?,?)";
			// 3.2ͨ�����ӻ�ȡStatement����
			stmt = con.prepareStatement(sql);
			// ������ֵ
			stmt.setString(1, loginName);
			stmt.setString(2, userName);
			stmt.setString(3, password);
			stmt.setInt(4, sex);
			// 3.3Statementִ��sql
			int rowNum = stmt.executeUpdate(); // rowNum===��sql�������ݿ������ݵ�Ӱ������
			if (rowNum > 0) { // ֤�������ɹ�
				System.out.println("�����ɹ�");
			} else {
				System.out.println("����ʧ��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.�ͷ���Դ
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * ��ѯ���е��û���Ϣ
	 */
	public static void selectAllUsers() {
		try {
			getConnection(); // ���ø���Ļ�ȡ���ӵķ��� �Ȳ��Ż���������
			// 3.1 ��дsql ����dbms������һ��
			String sql = "SELECT * FROM easybuy_user";
			// 3.2 ִ��sql
			stmt = con.prepareStatement(sql);
			// 4.1 �õ������
			rs = stmt.executeQuery();
			// 4.2 ��������
			while (rs.next()) {
				int id = rs.getInt("id");
				String loginName = rs.getString("loginName");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				int sex = rs.getInt("sex");
				String identityCode = rs.getString("identityCode");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				int type = rs.getInt("type");
				System.out.println("��ţ�" + id);
				System.out.println("��¼����" + loginName);
				System.out.println("��ʵ������" + userName);
				System.out.println("���룺" + password);
				System.out.println("�Ա�" + sex);
				System.out.println("���֤��" + identityCode);
				System.out.println("���䣺" + email);
				System.out.println("�ֻ��ţ�" + mobile);
				System.out.println("�û����ͣ�" + type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.�ͷ���Դ
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
