package com.xdf.dao;

import com.xdf.bean.Easybuy_User;

/**
 * 
 * ʧȥһ������,���û�����;��
 *  
 * @author С�а趹��
 * 2017-10-24����11:43:09
 * 
 * �����User�Ľӿ�
 */
public interface UserDao extends CommonDao<Easybuy_User> {

	/**
	 * �û���¼�ķ���
	 * @param name   �û���
	 * @param password   ����
	 * @return
	 */
	public boolean loginUser(String name, String password);

}
