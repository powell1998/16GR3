/**
 * 
 */
package com.qhit.lh.gr3.powell.t3;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.powell.t3.service.BaseService;
import com.qhit.lh.gr3.powell.t3.service.impl.BaseServiceImpl;
import com.qhit.lh.gr3.powell.t3.bean.Dept;
import com.qhit.lh.gr3.powell.t3.bean.Emp;
import com.qhit.lh.gr3.powell.t3.bean.UserInfo;

/**
 * @author 裴志博 TODO 2017年12月14日下午12:02:28
 */
public class EmpTest {
	private BaseService baseService = new BaseServiceImpl();

	@Test
	public void add() {
		// 声明员工对象
		Emp emp = new Emp();
		emp.setEmpName("张三");
		emp.setEmpSex("男");
		emp.setBirthday("1999-03-03");
		// 分配一个账户
		UserInfo userinfo = new UserInfo();
		userinfo.setUserName("jack");
		userinfo.setPassword("123456");
		// 建立一对一关系
		emp.setUserinfo(userinfo);
		userinfo.setEmp(emp);
		// 分配所属的部门
		Dept dept = new Dept();
		dept = (Dept) baseService.getobjectById(dept, 2);
		// 建立多对一的关联
		emp.setDept(dept);
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
		// 分配一个账户
		UserInfo userinfo = new UserInfo();
		userinfo.setUserId(3);
		userinfo.setUserName("tom");
		userinfo.setPassword("123456");
		// 建立一对一关系
		emp.setUserinfo(userinfo);
		userinfo.setEmp(emp);
		// 修改所属的部门：并不是修改部门本身的信息
		Dept dept = new Dept();
		dept = (Dept) baseService.getobjectById(dept, 2);
		// 建立多对一关联
		emp.setDept(dept);
		// 级联操作
		baseService.update(emp);
	}

	@Test
	public void query() {
		List<Object> list = baseService.getAll("from Emp");
		for (Object object : list) {
			Emp emp = (Emp) object;
			System.out.println(emp.toString());
		}

	}

}
