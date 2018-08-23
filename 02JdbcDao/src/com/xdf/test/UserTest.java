package com.xdf.test;

import java.util.List;
import java.util.Scanner;

import com.xdf.bean.Easybuy_User;
import com.xdf.jdbc.UserDemo;

/**
 * 
 * ʧȥһ������,���û�����;��
 *  
 * @author С�а趹��
 * 2017-10-24����9:38:15
 * 
 *  ģ�����ǵ�ǰ��ҳ��
 */
public class UserTest {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("���������ĵ�¼���ƣ�");
		String name = input.next();
		System.out.println("���������ĵ�¼���룺");
		String pwd = input.next();

		UserDemo userDemo = new UserDemo();
		// �û��ĵ�¼
		boolean flag = userDemo.loginUser(name, pwd);
		if (flag) {
			System.out.print("1����ѯ�����û���Ϣ\t\t");
			System.out.print("2�������û���Ϣ\t\t");
			System.out.print("3��ɾ���û���Ϣ\t\t");
			System.out.print("4���޸��û���Ϣ\t\n");
			System.out.println("����������ѡ��");
			int choose = input.nextInt();
			switch (choose) {
			case 1:// ��ѯ�����û���Ϣ
				List<Easybuy_User> users = userDemo.selectAllUsers();
				for (Easybuy_User easybuy_User : users) {
					System.out.println(easybuy_User);
				}
				break;
			case 2:// �����û���Ϣ
					// ����һ��user���� ���� �û��������Ϣ
				Easybuy_User user = new Easybuy_User();
				// ��ȡ�û�������
				System.out.println("���������¼���ƣ�");
				user.setLoginName(input.next());
				System.out.println("���������¼���룺");
				user.setPassword(input.next());
				System.out.println("����������ʵ������");
				user.setUserName(input.next());
				System.out.println("���������Ա�(1/��   0/Ů)");
				user.setSex(input.nextInt());
				userDemo.insertUser(user); // �Ѷ�����Ϊ�����Ĳ�������
				break;
			case 3:// ɾ���û���Ϣ
					// ��ȡ�û�������
				System.out.println("����������ʵ������");
				String delName = input.next();
				userDemo.deleteUser(delName);
				break;
			case 4:// �޸��û���Ϣ
					// ����һ��user���� ���� �û��������Ϣ
				Easybuy_User updateUser = new Easybuy_User();
				// ��ȡ�û�������
				System.out.println("����������ʵ������");
				updateUser.setUserName(input.next());
				System.out.println("�����������ǳƣ���¼������");
				updateUser.setLoginName(input.next());
				System.out.println("�������������룺");
				updateUser.setPassword(input.next());
				userDemo.updateUser(updateUser);
				break;
			}
		} else {
			System.out.println("��¼ʧ�ܣ�");
		}

	}

}
