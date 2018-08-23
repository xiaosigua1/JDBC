package com.xdf.bean;

/**
 * 
 * 失去一日甚易,欲得回已无途！
 *  
 * @author 小葱拌豆腐
 * 2017-10-24上午9:59:08
 * 
 * 用户的实体类
 */
public class Easybuy_User {

	private int id; // 主键
	private int sex; // 性别(1:男 0：女)
	private String loginName; // 登录名
	private String password; // 登录名
	private String userName; // 密码
	private String identityCode; // 身份证号
	private String email; // 邮箱
	private String mobile; // 手机号
	private int type; // 用户类型

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
