package com.ssm.entity;

public class SystemAdmin extends BaseEntity<SystemAdmin>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String loginName;
	
	private String password;
	
	private String encrypt;

	public String getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(String encrypt) {
		this.encrypt = encrypt;
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
}
