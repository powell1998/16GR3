package com.qhit.lh.gr3.powell.t3.bean;

/**
 * Emp entity. @author MyEclipse Persistence Tools
 */

public class Emp implements java.io.Serializable {

	// Fields

	private Integer eid;
	private String empName;
	private String empSex;
	private String birthday;
	private Integer deptId;
	
	private UserInfo userinfo;
	private Dept dept;

	// Constructors

	/** default constructor */
	public Emp() {
	}

	/** minimal constructor */
	public Emp(String empName, String empSex) {
		this.empName = empName;
		this.empSex = empSex;
	}

	/** full constructor */
	public Emp(String empName, String empSex, String birthday, Integer deptId) {
		this.empName = empName;
		this.empSex = empSex;
		this.birthday = birthday;
		this.deptId = deptId;
	}
	

	public Emp(Integer eid, String empName, String empSex, String birthday,
			Integer deptId) {
		super();
		this.eid = eid;
		this.empName = empName;
		this.empSex = empSex;
		this.birthday = birthday;
		this.deptId = deptId;
	}

	// Property accessors

	public Integer getEid() {
		return this.eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpSex() {
		return this.empSex;
	}

	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", empName=" + empName + ", empSex="
				+ empSex + ", birthday=" + birthday + ", deptId=" + deptId
				+ ", userinfo=" + userinfo + "]";
	}

}