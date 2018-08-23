package com.xdf.service;

import java.util.List;

import com.xdf.bean.Easybuy_User;

public interface UserService {
	/**
	 * �û���¼�ķ���
	 * @param name   �û���
	 * @param password   ����
	 * @return
	 */
	public void loginUser(String name, String password);

	/**
	 * �û�������
	 * @param user   �û�ǰ�˴��ݹ����Ķ���
	 */
	public void addUser(Easybuy_User user);

	/**
	 * �����û�����ɾ��ָ�����û�
	 * @param name  �û�ǰ�˴��ݹ������û���
	 */
	public void deleteUser(String name);

	/**
	 * �޸�ָ�����û�
	 * @param user�û�ǰ�˴��ݹ����Ķ���
	 */
	public void updateUser(Easybuy_User user);

	/**
	 * ��ѯ�����û�
	 * @return �û�����
	 */
	public List<Easybuy_User> selectUsers();
}
