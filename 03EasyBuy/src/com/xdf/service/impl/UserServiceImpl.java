package com.xdf.service.impl;

import java.util.List;

import com.xdf.bean.Easybuy_User;
import com.xdf.dao.UserDao;
import com.xdf.dao.impl.UserDaoImpl;
import com.xdf.service.UserService;

/**
 * 
 * ʧȥһ������,���û�����;��
 *  
 * @author С�а趹��
 * 2017-10-26����8:58:42
 * 
 */
public class UserServiceImpl implements UserService {

	UserDao dao = new UserDaoImpl(); // ����dao�����

	@Override
	public void loginUser(String name, String password) {
		boolean flag = dao.loginUser(name, password);
		if (flag) {
			System.out.println("��¼�ɹ�");
		} else {
			System.out.println("��¼ʧ��");
		}
	}

	@Override
	public void addUser(Easybuy_User user) {
		int rowNum = dao.add(user);
		if (rowNum > 0) { // ֤�������ɹ�
			System.out.println("�����ɹ�");
		} else {
			System.out.println("����ʧ��");
		}
	}

	@Override
	public void deleteUser(String name) {
		int rowNum = dao.delete(name);
		if (rowNum > 0) { // ֤��ɾ���ɹ�
			System.out.println("ɾ���ɹ�");
		} else {
			System.out.println("ɾ��ʧ��");
		}
	}

	@Override
	public void updateUser(Easybuy_User user) {
		int rowNum = dao.update(user);
		if (rowNum > 0) { // ֤���޸ĳɹ�
			System.out.println("�޸ĳɹ�");
		} else {
			System.out.println("�޸�ʧ��");
		}
	}

	@Override
	public List<Easybuy_User> selectUsers() {
		return dao.findAll();
	}

}
