package com.qhit.lh.gr3.powell.t6.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Roles entity. @author MyEclipse Persistence Tools
 */

public class Roles implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private String roleName;
	private String memo;
	
	private Set<UserInfo> userinfo = new HashSet<>();

	// Constructors

	/** default constructor */
	public Roles() {
	}

	/** full constructor */
	public Roles(String roleName, String memo) {
		this.roleName = roleName;
		this.memo = memo;
	}

	// Property accessors

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Set<UserInfo> getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Set<UserInfo> userinfo) {
		this.userinfo = userinfo;
	}

}