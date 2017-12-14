package com.qhit.lh.gr3.powell.t3.bean;

/**
 * Dept entity. @author MyEclipse Persistence Tools
 */

public class Dept implements java.io.Serializable {

	// Fields

	private Integer deptId;
	private String deptName;
	private String address;

	// Constructors

	/** default constructor */
	public Dept() {
	}

	/** full constructor */
	public Dept(String deptName, String address) {
		this.deptName = deptName;
		this.address = address;
	}

	// Property accessors

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}