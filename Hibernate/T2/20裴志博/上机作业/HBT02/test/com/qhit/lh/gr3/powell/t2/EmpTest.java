package com.qhit.lh.gr3.powell.t2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.powell.t2.bean.Emp;
import com.qhit.lh.gr3.powell.t2.bean.UserInfo;
import com.qhit.lh.gr3.powell.t2.service.BaseService;
import com.qhit.lh.gr3.powell.t2.service.impl.BaseServiceImpl;

public class EmpTest {
	private BaseService baseService = new BaseServiceImpl();

	/**
	 * 添加员工，并分配账户
	 */
	@Test
	public void add() {
		// 声明员工对象
		Emp emp = new Emp();
		emp.setEmpName("jack");
		emp.setEmpSex("男");
		emp.setBirthday("1999-03-03");
		emp.setDeptId(1);
		// 分配一个账户
		UserInfo userinfo = new UserInfo();
		userinfo.setUserName("jack");
		userinfo.setPassword("123456");
		// 建立一对一关系
		emp.setUserinfo(userinfo);
		userinfo.setEmp(emp);
		// 级联操作
		baseService.add(emp);
	}

	@Test
	public void delete() {
		Emp emp = new Emp();
		emp = (Emp) baseService.getobjectById(emp, 2);
		baseService.delete(emp);
	}

	@Test
	public void update() {
		// 声明员工对象
		Emp emp = new Emp();
		emp.setEid(3);
		emp.setEmpName("汤姆");
		emp.setEmpSex("男");
		emp.setBirthday("1999-03-03");
		emp.setDeptId(1);
		// 分配一个账户
		UserInfo userinfo = new UserInfo();
		userinfo.setUserId(3);
		userinfo.setUserName("tom");
		userinfo.setPassword("123456");
		// 建立一对一关系
		emp.setUserinfo(userinfo);
		userinfo.setEmp(emp);
		// 级联操作
		baseService.update(emp);
	}

	@Test
	public void query() {
		List<Object> list = baseService.getAll("from Emp");
		for(Object object : list){
			Emp emp = (Emp) object;
			System.out.println(emp.toString());
		}

	}

}
