package com.xdf.bean;

/**
 * 
 * ʧȥһ������,���û�����;��
 *  
 * @author С�а趹��
 * 2017-10-24����9:59:08
 * 
 * �û���ʵ����
 */
public class Easybuy_User {

	private int id; // ����
	private int sex; // �Ա�(1:�� 0��Ů)
	private String loginName; // ��¼��
	private String password; // ��¼��
	private String userName; // ����
	private String identityCode; // ���֤��
	private String email; // ����
	private String mobile; // �ֻ���
	private int type; // �û�����

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdentityCode() {
		return identityCode;
	}

	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Easybuy_User(int id, int sex, String loginName, String password,
			String userName, String identityCode, String email, String mobile,
			int type) {
		super();
		this.id = id;
		this.sex = sex;
		this.loginName = loginName;
		this.password = password;
		this.userName = userName;
		this.identityCode = identityCode;
		this.email = email;
		this.mobile = mobile;
		this.type = type;
	}

	public Easybuy_User() {
		super();
	}

	@Override
	public String toString() {
		return "Easybuy_User [id=" + id + ", sex=" + sex + ", loginName="
				+ loginName + ", password=" + password + ", userName="
				+ userName + ", identityCode=" + identityCode + ", email="
				+ email + ", mobile=" + mobile + ", type=" + type + "]";
	}

}
