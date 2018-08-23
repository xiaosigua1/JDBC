package com.xdf.test;

import java.util.List;
import java.util.Scanner;

import com.xdf.bean.Easybuy_User;
import com.xdf.service.UserService;
import com.xdf.service.impl.UserServiceImpl;

/**
 * 
 * ʧȥһ������,���û�����;��
 *  
 * @author С�а趹��
 * 2017-10-24����9:38:15
 * 
 *  ģ�����ǵ�ǰ��ҳ��    UI  ��ͼ��
 */
public class UserTest {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("���������ĵ�¼���ƣ�");
		String name = input.next();
		System.out.println("���������ĵ�¼���룺");
		String pwd = input.next();

		UserService userDemo = new UserServiceImpl();
		// �û��ĵ�¼
		userDemo.loginUser(name, pwd);
		System.out.print("1����ѯ�����û���Ϣ\t\t");
		System.out.print("2�������û���Ϣ\t\t");
		System.out.print("3��ɾ���û���Ϣ\t\t");
		System.out.print("4���޸��û���Ϣ\t\n");
		System.out.println("����������ѡ��");
		int choose = input.nextInt();
		switch (choose) {
		case 1:// ��ѯ�����û���Ϣ
			List<Easybuy_User> users = userDemo.selectUsers();
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
			userDemo.addUser(user); // �Ѷ�����Ϊ�����Ĳ�������
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

	}

}
