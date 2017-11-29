package com.powell.t4.bean;

import java.util.Date;

public class UserInfo {
	private String name;
	private String password;
	private Date birthday;
	private int sex;
	private String love;
	private String active;
	private String nativeplace;
	private String memo;
	
	public UserInfo(String name, String password, Date birthday, int sex, String love, String active,
			String nativeplace, String memo) {
		super();
		this.name = name;
		this.password = password;
		this.birthday = birthday;
		this.sex = sex;
		this.love = love;
		this.active = active;
		this.nativeplace = nativeplace;
		this.memo = memo;
	}
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getLove() {
		return love;
	}
	public void setLove(String love) {
		this.love = love;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getNativeplace() {
		return nativeplace;
	}
	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	

}
